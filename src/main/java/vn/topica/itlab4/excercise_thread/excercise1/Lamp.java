package vn.topica.itlab4.excercise_thread.excercise1;

enum Status {
	OFF, ON
}

public class Lamp {
	
	private Status status;
	private int index;
	private static int count;
	
	public Lamp(Status status) {
		this.status = status;
		count = count + 1;
		index = count;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "lamp - INDEX: " + index + " STATUS: " + status;
	}
	
	
	
}
