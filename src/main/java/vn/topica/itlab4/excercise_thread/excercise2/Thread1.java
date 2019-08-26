package vn.topica.itlab4.excercise_thread.excercise2;

import java.util.Random;

import vn.topica.itlab4.excercise_thread.excercise1.Util;

public class Thread1 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread 1 is running ...");
		createLamp();
	}

	public void createLamp() {
		Random random = new Random();
		Store store = Store.getInstance();
		while (true) {
			// generate random number from 1 to 20
			int lampNumber = Util.randomInt(1, 20);
			for (int i = 0; i < lampNumber; i++) {
				// random number from 0 to 2
				int randomStatus = Util.randomInt(0, Status.values().length - 1);
				// create lamp with status randomStatus: 0 = OFF, 1 = ON, 2 = REPAIR
				Lamp lamp = new Lamp(Status.values()[randomStatus]);
				// add this lamp to store
				store.add(lamp);
				System.out.println("Thread 1 add to Store: " + lamp.toString());
				try {
					System.out.println("Thread 1 SLEEP");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
