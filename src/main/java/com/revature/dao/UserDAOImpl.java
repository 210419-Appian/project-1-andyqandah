package com.revature.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements  UserDAO {

	

	@Override
	public List<User> findAll() {
		try(Connection con = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM users;";
			
			Statement statement = con.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<User> list = new ArrayList<>();
			
			while(result.next()) {
				
				User u = new User();
		
						u.setUserId(result.getInt("user_id"));
						u.setUsername(result.getString("user_name"));
						u.setPassword(result.getString("user_password"));
						u.setFirstName(result.getString("user_first_name"));
						u.setLastName(result.getString("user_last_name"));				
						u.setEmail(result.getString("user_email"));
						u.setRole(result.getInt("role_id"));
				
				
				list.add(u);
				
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM users WHERE user_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			
			
			while(result.next()) {
				
			User u = new User();
			
				u.setUserId(result.getInt("user_id"));
				u.setUsername(result.getString("user_name"));
				u.setPassword(result.getString("user_password"));
				u.setFirstName(result.getString("user_first_name"));
				u.setLastName(result.getString("user_last_name"));				
				u.setEmail(result.getString("user_email"));
				u.setRole(result.getInt("role_id"));
	
			
			return u;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean registerAccount(double balance, int type, User user ) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			Account a = new Account(balance, 3, type, user.getUserId());
			
			String sql = "INSERT INTO users (user_name, user_password, user_first_name, user_last_name, user_email, role_id)"
					+ "VALUES (?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
		
			int index = 0;
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatus());
			statement.setInt(++index, a.getType());
			statement.setInt(++index, a.getUser());
			statement.execute();
			
statement.execute();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public boolean updateUser(User u, int id ) {
		// TODO Auto-generated method stub
try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE users SET "
					+ "user_name = ?, "
					+ "user_password = ?, "
					+ "user_first_name = ?, "
					+ "use_last_name = ?, "
					+ "user_email = ?, "
					+ "user_role = ? "
					+ "WHERE user_id = " + id + ";";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getEmail());
			statement.setInt(++index, u.getRole());
			
			statement.execute();
			
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findUserByName(String username) {
		
		// TODO Auto-generated method stub
try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM users WHERE user_name = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, username);
			
			ResultSet result = statement.executeQuery();
			User u = new User();
			while(result.next()) {
			
				
				u.setUserId(result.getInt("user_id"));
				u.setUsername(result.getString("user_name"));
				u.setPassword(result.getString("user_password"));
				u.setFirstName(result.getString("user_first_name"));
				u.setLastName(result.getString("user_last_name"));				
				u.setEmail(result.getString("user_email"));
				u.setRole(result.getInt("role_id"));
				
	
	}
			return u;	
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}


	@Override
	public boolean addUser(User u) {
try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO users (user_name, user_password, user_first_name, user_last_name, user_email, role_id)" 
					+ "VALUES(?,?,?,?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			
			
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getEmail());
			statement.setInt(++index, u.getRole());
			
			statement.execute();
			
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	@Override
	public User findByUsername(String username) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM users WHERE user_name = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, username); 
			ResultSet result = statement.executeQuery();
			
			User user = new User();
			
			while(result.next()) {
				
				
				user.setUserId(result.getInt("user_id"));
				user.setUsername(result.getString("user_name"));
				user.setPassword(result.getString("user_password"));
				user.setFirstName(result.getString("user_first_name"));
				user.setLastName(result.getString("user_last_name"));				
				user.setEmail(result.getString("user_email"));
				user.setRole(result.getInt("role_id"));
			}			
			
			return user;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	}