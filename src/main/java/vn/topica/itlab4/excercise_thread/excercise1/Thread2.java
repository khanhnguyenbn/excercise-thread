package vn.topica.itlab4.excercise_thread.excercise1;

public class Thread2 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread 2 is runing ...");
		removeLampOff();
	}

	void removeLampOff() {
		
		Trash trash = Trash.getInstance();
		Store store = Store.getInstance();
		while (true) {
			if (!store.isEmpty()) {
				// check lamp in store
				for (int i = 0; i < store.size(); i++) {
					// status lamp is off in store
					if (store.get(i).getStatus() == Status.OFF) {
						Lamp lamp = store.get(i);
						// add this lamp to trash
						trash.add(lamp);
						System.out.println("Thread 2 add to Trash " + lamp.toString());
						//remove lamp in store
						store.remove(i);
						System.out.println("Thread 2 remove from Store " + lamp.toString());
						// update index i, because after removing, list shrink
						if(i != 0) {
							i--;
						}
						
					}

				}
				// show all lamp in store
				System.out.println("LIST LAMP IN STORE: ");
				for (int i = 0; i < store.size(); i++) {
					System.out.println("STORE: " + store.get(i).toString());
				}
				try {
					System.out.println("Thread 2 is SLEEP");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// if store is empty then sleep 100ms
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
