package vn.topica.itlab4.excercise_thread.excercise1;

import java.util.Random;

public class Thread1 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread 1 is running ...");
		createLamp();
	}

	public void createLamp() {
		Random random = new Random();
		Store store = Store.getInstance();

		// add number of lamp above to store with random status (0 or 1)
		while (true) {
			// generate random number from 1 to 20
			int lampNumber = Util.randomInt(1, 20);
			// create lamp with number is lampNumber
			for (int i = 0; i < lampNumber; i++) {
				// random status 0 or 1
				int randomNum = Util.randomInt(0, Status.values().length - 1);
				// create lamp with random status 0 is OFF, 1 is ON
				Lamp lamp = new Lamp(Status.values()[randomNum]);
				// add to store
				store.add(lamp);
				System.out.println("Thread 1 add to Store: " + lamp.toString());
				try {
					System.out.println("Thread 1 is SLEEP");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
