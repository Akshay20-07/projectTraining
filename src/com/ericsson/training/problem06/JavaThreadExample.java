package com.ericsson.training.problem06;

public class JavaThreadExample {
	public static void main(String args[]) throws InterruptedException {

		
		MultiThread th1 = new MultiThread("1");
		MultiThread th2 = new MultiThread("2");
		MultiThread th3 = new MultiThread("3");
		MultiThread th4 = new MultiThread("4");
		MultiThread th5 = new MultiThread("5");
		MultiThread2 th6 = new MultiThread2("6");
		MultiThread2 th7 = new MultiThread2("7");
		MultiThread2 th8 = new MultiThread2("8");
		MultiThread2 th9 = new MultiThread2("9");
		MultiThread2 th10 = new MultiThread2("10");
			
		
		// Run multiple threads simultaneously

		th1.start();
		th2.start();
		th1.join();
		th2.join();
		th3.start();
		th3.join();
		th4.start();
		th4.join();
		th5.start();


		
		// Run multiple threads one after other
		th6.start();
		th7.start();
		th8.start();
		th9.start();
		th10.start();
				
		System.out.println("Main Program exiting.");
	}
}
