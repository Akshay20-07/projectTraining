package com.ericsson.training.problem06;

public class MultiThread extends Thread{
	public String threadName;
	
	MultiThread(String tName){
		threadName = tName;
	}
	
	public void run() {
		try {
			for(int i=0;i<10;i++) {
				System.out.println("Thread" + threadName + " iteration "+ i);
				Thread.sleep(1000);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}

