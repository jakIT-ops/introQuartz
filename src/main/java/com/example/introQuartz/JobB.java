package com.example.introQuartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobB implements Job {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\\u001B[32m";

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
       	System.out.println(ANSI_GREEN + "Job B - ees mendchilj baina");
    }

}
