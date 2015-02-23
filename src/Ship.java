import java.util.ArrayList;


public class Ship {
	private ArrayList<String> location = new ArrayList<>();
	private int size;
	public Ship(int size) {
		super();
		this.size = size;
		
	}

	public ArrayList<String> getLocation() {
		return location;
	}

	public void setLocation(ArrayList<String> location) {
		this.location = location;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isHorizontal() {
		return isHorizontal;
	}

	public void setHorizontal(boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	}

	private boolean isHorizontal;
	
	

	
}
