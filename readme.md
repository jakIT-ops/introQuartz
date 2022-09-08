# Overview

`Quartz` is an open source job-scheduling framework written entirely in Java and designed for use in both J2SE and J2EE applications.

> You can create complex schedules for executing any job Examples are e.g tasks that run daily. every other Friday at 7:30 p.m or only on the last day of every month

# The Quartz API

To ensure scalability, Quartz is based on a multi-threaded architecture. `When started, the framework initializes a set of worker threads` that are used by the Scheduler to execute Jobs.

This is how the frame work can run many jobs cuncurrently It also relies on a loosely coupled set of ThreadPool management components for managing the thread environment.

`The key interfaces of the API are:`

* Scheduler - the primary API for interacting with the scheduler of the framework 

* Job - an  interface to be implemented by components that we wish to have executed

* JobDetail - used to define instances of Jobs

* Trigger - a component that determines the schedule upon which a given Job will be performed

* JobBuilder - used to build JobDetail instances, which define instances of Jobs

* TriggerBuilder - used to build Trigger instances.



