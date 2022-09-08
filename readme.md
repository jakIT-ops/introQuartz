# Scheduling in Spring with Quartz

## 1.1 Key Components of the Quartz API

Quartz has a modular architecture. It consists of several basic components that we can combine as required. In this tutorial, we'll focus on the ones that are common to every job: Job, JobDetail, Trigger and Scheduler.

Although we'll use Spring to manage the application, each individual component can be configured in two ways: the Quartz way or the Spring way (using its convenience classes).

We'll cover both options as far as possible, for the sake of completeness, but we may adopt either. Now let's start building, one component at a time.


# 2. Job and JobDetail

## 2.1. Job

The API provides a Job interface that has just one method, execute. It must be implemented by the class that contains the actual work to be done, i.e. the task. When a job's trigger fires, the scheduler invokes the execute method, passing it a JobExecutionContext object.

The JobExecutionContext provides the job instance with information about its runtime environment, including a handle to the scheduler, a handle to the trigger, and the job's JobDetail object.

## 2.2. JobDetail

While the job is the workhorse, Quartz doesn't store an actual instance of the job class. Instead, we can define an instance of the Job using the JobDetail class. The job's class must be provided to the JobDetail, so that it knows the type of the job to be executed.

## 2.3. Quartz JobBuilder

The Quartz JobBuilder provides a builder-style API for constructing JobDetail entities

## 2.4. Spring JobDetailFactoryBean

Spring's JobDetailFactoryBean provides bean-style usage for configuring JobDetail instances. It uses the Spring bean name as the job name, if not otherwise specified:

# 3. Trigger

A Trigger is the mechanism to schedule a Job, i.e. a Trigger instance “fires” the execution of a job. There's a clear separation of responsibilities between the Job (notion of task) and Trigger (scheduling mechanism).

In addition to a Job, the trigger also needs a type, which we can choose based on the scheduling requirements.

# 4. Configuring the JobStore

JobStore provides the storage mechanism for the Job and Trigger. It's also responsible for maintaining all the data relevant to the job scheduler. The API supports both in-memory and persistent stores.

## 4.1. In-Memory JobStore

For our example, we'll use the in-memory `RAMJobStore`, which offers blazing-fast performance and simple configuration via quartz.properties:

```
org.quartz.jobStore.class=org.quartz.simpl.RAMJobStore
```


The obvious drawback of the RAMJobStore is that it's volatile in nature. All the scheduling information is lost between shutdowns. If we need to keep job definitions and schedules between shutdowns, we can use the persistent JDBCJobStore instead.

To enable an in-memory JobStore in Spring, we'll set this property in our application.properties:

```
spring.quartz.job-store-type=memory
```

## 4.2 JDBC JobStore

There are two types of JDBCJobStore: `JobStoreTX` and `JobStoreCMT`. They both do the same job of storing scheduling information in a database.

The difference between the two is how they manage the transactions that commit the data. The JobStoreCMT type requires an application transaction to store data, whereas the JobStoreTX type starts and manages its own transactions.

There are several properties to set for a JDBCJobStore. At a minimum, we must specify the type of JDBCJobStore, the data source, and the database driver class. There are driver classes for most databases, but StdJDBCDelegate covers most cases:

```
org.quartz.jobStore.class=org.quartz.impl.jdbcjobstore.JobStoreTX
org.quartz.jobStore.driverDelegateClass=org.quartz.impl.jdbcjobstore.StdJDBCDelegate
org.quartz.jobStore.dataSource=quartzDataSource
```

Setting up a JDBC JobStore in Spring takes a few steps. First, we'll set the store type in our application.properties:

```
spring.quartz.job-store-type=jdbc
```

# 5. Scheduler

The Scheduler interface is the main API for interfacing with the job scheduler.

A Scheduler can be instantiated with a SchedulerFactory. Once created, we can register Jobs and Triggers with it. Initially, the Scheduler is in “stand-by” mode, and we must invoke its `start` method to start the threads that fire the execution of jobs.

