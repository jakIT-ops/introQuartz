package com.example.introQuartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobA implements Job {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\t\\u001B[31m";

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println(ANSI_RED + "Job A - ees mendchilj baina ");
    }

}
