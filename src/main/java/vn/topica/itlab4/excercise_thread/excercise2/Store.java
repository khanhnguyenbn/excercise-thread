package vn.topica.itlab4.excercise_thread.excercise2;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Store extends CopyOnWriteArrayList<Lamp>{

	private static Store instanse;
	
	private Store() {
		
	}
	
	public static synchronized Store getInstance(){
		if(instanse == null) {
			instanse = new Store();
		}
		return instanse;
	}
}
