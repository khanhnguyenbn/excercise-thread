package vn.topica.itlab4.excercise_thread.excercise2;

import vn.topica.itlab4.excercise_thread.excercise1.Util;

public class Thread3 extends Thread {

	/*
	 * Check lamp in trash, 
	 * if status of lamp is repair then add to store and remove
	 * from trash 
	 * if status of lamp is off then random number 0 or 1 
	 * if random number is 0 remove lamp from trash, 
	 * 1 then update status lamp is repair and
	 * add to store
	 */
	@Override
	public void run() {
		System.out.println("Thread 3 is running ...");
		Trash trash = Trash.getInstance();
		Store store = Store.getInstance();
		while (true) {
			// check lamp in trash
			for (int i = 0; i < trash.size(); i++) {
				Lamp lamp = trash.get(i);
				// if lamp have status REPAIR
				if (lamp.getStatus() == Status.REPAIR) {
					// then remove this lamp from trash
					trash.remove(i);
					System.out.println("Thread 3 remove from Trash: " + lamp.toString());
					// and add to store
					store.add(lamp);
					System.out.println("Thread 3 add to Store: " + lamp.toString());
					// update index i, because after removing, list shrink
					if (i != 0) {
						i--;
					}
					// if lamp have status OFF
				} else if (lamp.getStatus() == Status.OFF) {
					// generate random number 0 or 1
					int randomNum = Util.randomInt(0, 1);
					System.out.println("Thread 3 random number = " + randomNum);
					if (randomNum == 0) {
						// if random number is 0
						// remove from trash
						trash.remove(i);
						System.out.println("Thread 3 remove from Trash : " + lamp.toString());
						// and update index i
						if (i != 0) {
							i--;
						}
					} else {
						// if random number = 1
						// set status of lamp from OFF to REPAIR
						lamp.setStatus(Status.REPAIR);
						System.out.println("Thread 3 set status to repair: " + lamp.toString());
						// add to store
						store.add(lamp);
						System.out.println("Thread 3 add to Store: " + lamp.toString());
					}
				}
			}
			try {
				System.out.println("Thread 3 SLEEP");
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
