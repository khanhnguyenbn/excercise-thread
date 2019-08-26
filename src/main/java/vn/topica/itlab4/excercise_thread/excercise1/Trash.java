package vn.topica.itlab4.excercise_thread.excercise1;

import java.util.concurrent.CopyOnWriteArrayList;


public class Trash extends CopyOnWriteArrayList<Lamp> {
	private static Trash instanse;

	private Trash() {
		
	}

	public static synchronized Trash getInstance() {
		if (instanse == null) {
			instanse = new Trash();
		}
		
		return instanse;
	}
}
