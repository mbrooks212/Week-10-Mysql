package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.vehicles;

public class vehiclesdao {

	private Connection connection; 
	private final String GET_VEHICLES_QUERY = "SELECT * FROM vehicles";
	private final String GET_VEHICLES_BY_ID_QUERY = "SELECT * FROM vehicles WHERE vehicle_id = ?";
	private final String CREATE_VEHICLES_QUERY = "INSERT INTO vehicles(year, make, model) VALUES (?,?,?)";
	private final String UPDATE_VEHICLES_QUERY = "UPDATE vehicles SET year = ?, make = ?, model = ? WHERE vehicle_id = ?";
	private final String DELETE_VEHICLES_QUERY = "DELETE FROM vehicles WHERE vehicle_id = ?";
	
	
	public vehiclesdao() {
		connection = DBconnection.getConnection();
	}
//get all vehicles
	public List<vehicles> getVehicle() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_VEHICLES_QUERY).executeQuery();
		List<vehicles> vehicles = new ArrayList<vehicles>();
		while (rs.next()) {
			vehicles.add(populateVehicle(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
		}
		return vehicles;
	}
	private vehicles populateVehicle(int id, int year, String make, String model) {
		return new vehicles(id, year, make, model);
	}
	
//vehicle by id
	public vehicles getVehicleById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_VEHICLES_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateVehicle(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getString(4));
	}
//create vehicle
	public void createVehicle(int year, String make, String model) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_VEHICLES_QUERY);
		ps.setInt(1, year);
		ps.setString(2, make);
		ps.setString(3, model);
		ps.executeUpdate();
	}
//update vehicle
	public void updateVehicle(int id, int year, String make, String model) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_VEHICLES_QUERY);
		ps.setInt(1, year);
		ps.setString(2, make);
		ps.setString(3, model);
		ps.setInt(4, id);
		ps.executeUpdate();
	}
//delete vehicle
	public void deleteVehicle(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_VEHICLES_QUERY);
		ps.setInt(1,id);
		ps.executeUpdate();
	}
	
}//Class Body