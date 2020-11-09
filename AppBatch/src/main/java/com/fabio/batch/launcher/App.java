package com.fabio.batch.launcher;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	private static ApplicationContext context;
	public static void main(String[] args) {
		String[] argomenti=null;
		try {
			argomenti=new String[2];
			argomenti[0]="classpath:job.xml";
			argomenti[1]="classpath:launch.xml";
			context=new ClassPathXmlApplicationContext(argomenti);
			JobLauncher jobLauncher=(JobLauncher)context.getBean("jobLauncher");
			Job job=(Job)context.getBean("processaFile");
			JobExecution jobExec=jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + jobExec.getStatus()); 
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
