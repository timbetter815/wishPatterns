package head.adapter;

public class BikeAdapter extends Car {
	
	Bike bike;
	
	BikeAdapter(Bike bike){
		this.bike = bike;
	}
	
	public void driver(){
		bike.go();
	}
}
