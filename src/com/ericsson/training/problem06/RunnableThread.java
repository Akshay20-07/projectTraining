package com.ericsson.training.problem06;


public class RunnableThread implements Runnable {
	
	
	@Override
	public void run() {
		for(int i=51;i>10;i--) {
			
			System.out.println("running");
			
		}
		
	}

}
