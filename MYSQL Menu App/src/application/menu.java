package application;

import java.sql.SQLException;
import java.util.*;

import dao.vehiclesdao;
import entities.vehicles;

public class menu {

	private vehiclesdao vehiclesDao = new vehiclesdao();
	private Scanner sc = new Scanner(System.in);
	
//list for my menu
	private List<String> options = Arrays.asList(
		"View all vehicles",
		"View vehicle",
		"Create vehicle",
		"Update vehicle",
		"Delete vehicle");
	public void start() {
		String selection = "";
//menu options
		do {
			printMenu();
			selection = sc.nextLine();
			 try {
				if (selection.equals("1")) {
					viewAllVehicles();
				} else if (selection.equals("2")) {
					viewVehicle();
				} else if (selection.equals("3")) {
					createVehicle();
				} else if (selection.equals("4")) {
					updateVehicle();
				} else if ( selection.equals("5")) {
					deleteVehicle();
				}
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }
				System.out.println("Press enter to continue (:");
				sc.nextLine();
		}while (!selection.equals("-1"));		
	}
//menu options backend
	private void printMenu() {
		System.out.println("Please select an option:\n----------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
//view all vehicles
	private void viewAllVehicles() throws SQLException {
		List<vehicles> vehicles = vehiclesDao.getVehicle();
		for (vehicles Vehicles : vehicles) {
			System.out.println(Vehicles.getVehicle_id() + ": " + Vehicles.getYear() + " " + Vehicles.getMake() + " " + Vehicles.getModel());
		}
	}
//view vehicle w/ id
	private void viewVehicle() throws SQLException {
		System.out.println("Enter vehicle id: ");
		int id = Integer.parseInt(sc.nextLine());
		 vehicles vehicle = vehiclesDao.getVehicleById(id);
		 System.out.println(vehicle.getYear() + " "  + vehicle.getMake() + " " + vehicle.getModel());
	}
//create vehicle	
	private void createVehicle() throws SQLException {
		System.out.println("Enter year:");
		int year = Integer.parseInt(sc.nextLine());
		System.out.println("Enter make:");
		String make = sc.nextLine();
		System.out.println("Enter model:");
		String model = sc.nextLine();
		vehiclesDao.createVehicle(year, make, model);
	}
//update vehicle
	private void updateVehicle() throws SQLException {
		System.out.println("Enter the vehicle id you wish to change:");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the new year:");
		int year = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the new make:");
		String make = sc.nextLine();
		System.out.println("Enter the new model:");
		String model = sc.nextLine();
		vehiclesDao.updateVehicle(id, year, make, model);
	}
//delete vehicle
	private void deleteVehicle() throws SQLException {
		System.out.println("Enter the vehicle id you wish to delete:");
		int id = Integer.parseInt(sc.nextLine());
		vehiclesDao.deleteVehicle(id);
	}
	
	
}//Class Body