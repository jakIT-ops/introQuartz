### Relevant articles:
- [A Guide to the Spring Task Scheduler](https://www.baeldung.com/spring-task-scheduler)
- [The @Scheduled Annotation in Spring](https://www.baeldung.com/spring-scheduled-tasks)
- [Guide to Spring Retry](https://www.baeldung.com/spring-retry)
- [How To Do @Async in Spring](https://www.baeldung.com/spring-async)
- [Conditionally Enable Scheduled Jobs in Spring](https://www.baeldung.com/spring-scheduled-enabled-conditionally)
- [Remote Debugging with IntelliJ IDEA](https://www.baeldung.com/intellij-remote-debugging)

# The @Scheduled Annotation in Spring

## 1. Overview

In this tutorial, we'll illustrate how the Spring @Scheduled annotation can be used to configure and schedule tasks.

The simple rules that we need to follow to annotate a method with @Scheduled are:

* the method should typically have a void return type (if not, the returned value will be ignored)

* the method should not expect any parameters

## 2. Enable Support for Scheduling

To enable support for scheduling tasks and the @Scheduled annotation in Spring,

## 3. Schedule a Task at Fixed Delay

In this case, the duration between the end of the last execution and the start of the next execution is fixed. The task always waits until the previous one is finished.

## 4. Schedule a Task at a Fixed Rate

Note that scheduled tasks don't run in parallel by default. So even if we used fixedRate, the next task won't be invoked until the previous one is done.

## 5. Fixed Rate vs Fixed Delay

We can run a scheduled task using Spring's @Scheduled annotation, but based on the properties fixedDelay and fixedRate, the nature of execution changes.

`The fixedDelay property makes sure that there is a delay of n millisecond between the finish time of an execution of a task and the start time of the next execution of the task.`

This property is specifically useful when we need to make sure that only one instance of the task runs all the time. For dependent jobs, it is quite helpful.

`The fixedRate property runs the scheduled task at every n millisecond.` It doesn't check for any previous executions of the task.

This is useful when all executions of the task are independent. If we don't expect to exceed the size of the memory and the thread pool, fixedRate should be quite handy.

Although, if the incoming tasks do not finish quickly, it's possible they end up with “Out of Memory exception”.

## 6. Schedule a Task With Initial Delay 

Note how we're using both fixedDelay as well as initialDelay in this example. The task will be executed the first time after the initialDelay value, and it will continue to be executed according to the fixedDelay.

This option is convenient when the task has a setup that needs to be completed.

