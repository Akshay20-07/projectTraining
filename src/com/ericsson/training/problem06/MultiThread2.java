package com.ericsson.training.problem06;

public class MultiThread2 extends Thread{
	public String threadName;
	
	MultiThread2(String tName){
		threadName = tName;
	}
	
	public  void  run() {
		MultiThread2.printMessage(threadName);
		
	}
	
	public static synchronized  void printMessage(String threadName){
		try {
	
			for(int i=0;i<5;i++) {
				
				System.out.println("Thread" + threadName + " iteration "+ i);
				Thread.sleep(1000);
			}
		} catch(Exception e) {
			System.out.println(e);
		}

	}
}

