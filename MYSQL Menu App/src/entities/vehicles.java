package entities;

public class vehicles {

	private int vehicle_id;
	private int year;
	private String make;
	private String model;
	
    // Constructor
	public vehicles(int vehicle_id, int year, String make, String model) {
		this.setVehicle_id(vehicle_id);
		this.setYear(year);
		this.setMake(make);
		this.setModel(model);
	}
	
	//getters & setters
	
	//vehicle_id
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	
	//Year
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	//Make
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	//Model
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	//End of getters & setters
	
	
}//Class Body
