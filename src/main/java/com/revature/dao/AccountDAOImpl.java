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

public class AccountDAOImpl implements AccountDAO{

	private static UserDAOImpl accDAO = new UserDAOImpl();

	@Override
	public List<Account> findAll() {
		try ( Connection conn = ConnectionUtil.getConnection()){ 

			String sql = "SELECT * FROM accounts;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Account> list = new ArrayList<>();

			while(result.next()) {
				Account acc = new Account();

				acc.setAccountId(result.getInt("account_id"));
				acc.setBalance(result.getDouble("account_balance"));
				acc.setStatus(result.getInt("status_id"));
				acc.setType(result.getInt("type_id"));
				acc.setUser(result.getInt("user_id"));

				list.add(acc);
			}
			return list;

		}catch(SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	
	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM accounts WHERE account_Id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			while(result.next()) {
				Account acc = new Account();

				acc.setAccountId(result.getInt("account_Id"));
				acc.setBalance(result.getDouble("account_balance"));
				acc.setStatus(result.getInt("status_id"));
				acc.setType(result.getInt("type_id"));
				acc.setUser(result.getInt("user_id"));

			
			return acc;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	
	@Override
	public boolean updateAccount(Account a, int id) {
		// TODO Auto-generated method stub

		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE accounts SET account_balance = ?, status_id = ?, type_id = ?, user_id = ? WHERE account_Id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);


			int index = 0;
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatus());
			statement.setInt(++index, a.getType());
			statement.setInt(++index, a.getUser());

			statement.execute();

			ResultSet result = statement.getGeneratedKeys();

			result.next();

			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean withdraw(Account a, double amount) {
		try(Connection conn = ConnectionUtil.getConnection()){

			int accountId = a.getAccountId();
			double newBalance = a.getBalance() - amount;

			String sql = "UPDATE accounts SET account_balance = ? WHERE account_Id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setDouble(1, newBalance);
			statement.setInt(2, accountId);

			statement.execute();

			return true;


		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean deposit(Account a, double amount) {

		try(Connection conn = ConnectionUtil.getConnection()){

			int accountId = a.getAccountId();
			double newBalance = a.getBalance() + amount;

			String sql = "UPDATE accounts SET account_= ? WHERE account_Id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setDouble(1, newBalance);
			statement.setInt(2, accountId);

			statement.execute();

			return true;


		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean transfer(Account sourceAccount, Account targetAccount, double amount) {

		try(Connection conn = ConnectionUtil.getConnection()){

			int sourceAccountID = sourceAccount.getAccountId();
			double sourceNewBalance = sourceAccount.getBalance() - amount;
			int targetAccountID = targetAccount.getAccountId();
			double targetNewBalance = targetAccount.getBalance() + amount;

			String sql = "BEGIN;"
					+ "UPDATE accounts SET account_blanace= ? WHERE account_Id = ?;"
					+ "UPDATE accounts SET account_balance = ? WHERE account_Id = ?;"
					+ "COMMIT;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setDouble(1, sourceNewBalance);
			statement.setInt(2, sourceAccountID);
			statement.setDouble(3, targetNewBalance);
			statement.setInt(4, targetAccountID);

			statement.execute();

			return true;


		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Account> findByStatus(int status) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounts WHERE status_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, status);

			ResultSet result = statement.executeQuery();

			List<Account> list = new ArrayList<>();

			while (result.next()) {
				Account account = new Account();

				account.setAccountId(result.getInt("account_Id"));
				account.setBalance(result.getFloat("account_balance"));
				account.setStatus(result.getInt("status_id"));
				account.setType(result.getInt("type_id"));
				account.setUser(result.getInt("user_id"));

				list.add(account);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean addAccount(Account a) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO accounts (account_balance, status_id, type_id, user_id)"
					+ "VALUES(?,?,?,?);";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getStatus());
			statement.setInt(++index, a.getType());
			statement.setInt(++index, a.getUser());

			statement.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<Account> findByUser(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounts WHERE user_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, u.getUserId());

			ResultSet result = statement.executeQuery();

			List<Account> list = new ArrayList<>();

			while (result.next()) {
				Account acc = new Account();

				acc.setAccountId(result.getInt("account_Id"));
				acc.setBalance(result.getFloat("account_balance"));
				acc.setStatus(result.getInt("status_id"));
				acc.setType(result.getInt("type_id"));
				acc.setUser(result.getInt("user_id"));

				list.add(acc);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean deleteAccount(Account a) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "DELETE FROM accounts WHERE account_Id = " + a.getAccountId() + ";";
			
			Statement statement = conn.createStatement();
			
			statement.execute(sql);
			
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
	


