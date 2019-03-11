package com.cg.fra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.fra.dto.FlatRegistrationDTO;

public class FlatRegistrationDaoImpl implements IFlatRegistrationDao {
	static FlatRegistrationDTO flat1 = new FlatRegistrationDTO();

	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO flat) {

		flat1 = flat;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into flat_registration(owner_id,flat_type,flat_area,rent_amount,deposit_amount) values(?,?,?,?,?)");
			preparedStatement.setInt(1, flat1.getOwnerId());
			preparedStatement.setInt(2, flat1.getFlatType());
			preparedStatement.setInt(3, flat1.getFlatArea());
			preparedStatement.setInt(4, flat1.getRentAmount());
			preparedStatement.setInt(5, flat1.getDepositAmount());
			preparedStatement.executeUpdate();
			PreparedStatement preparedStatement1 = connection.prepareStatement("select flat_reg_no from flat_registration where owner_id=?");
			preparedStatement1.setInt(1, flat1.getOwnerId());

			ResultSet resultset = preparedStatement1.executeQuery();
			while ((resultset).next())

				flat.setFlatRegNo(resultset.getInt(1));

		 

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flat;
	}

	public ArrayList<Integer> getAllOwnersIds() {

		ArrayList<Integer> a = new ArrayList<Integer>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			Statement statement = connection.createStatement();

			ResultSet resultset = statement.executeQuery("select owner_id from flat_owners ");
			while (resultset.next()) {
				a.add(resultset.getInt(1));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;

	}

}
