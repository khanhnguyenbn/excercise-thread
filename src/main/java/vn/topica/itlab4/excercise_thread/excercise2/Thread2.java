package vn.topica.itlab4.excercise_thread.excercise2;

public class Thread2 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread 2 is runing ...");
		removeLampOffAndRepair();
	}

	void removeLampOffAndRepair() {

		Trash trash = Trash.getInstance();
		Store store = Store.getInstance();
		while (true) {
			if (!store.isEmpty()) {
				for (int i = 0; i < store.size(); i++) {
					// check lamp with status OFF or REPAIR
					if (store.get(i).getStatus() == Status.OFF || store.get(i).getStatus() == Status.REPAIR) {
						Lamp lamp = store.get(i);
						// then add to trash
						trash.add(lamp);
						System.out.println("Thread 2 add to Trash " + lamp.toString());
						// and remove from store
						store.remove(i);
						System.out.println("Thread 2 remove from Store " + lamp.toString());
						// update index i, because after removing, list shrink
						if (i != 0) {
							i--;
						}

					}

				}
				// show lamp in store
				System.out.println("LIST LAMP IN STORE: ");
				for (int i = 0; i < store.size(); i++) {
					System.out.println("STORE: " + store.get(i).toString());
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
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
