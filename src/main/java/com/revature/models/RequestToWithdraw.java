package com.revature.models;

import java.io.Serializable;

public class RequestToWithdraw implements Serializable{

	/**
	 * beans
	 */
	private static final long serialVersionUID = 1L;
		private int accountId;
		private double amount;
		private String username;
		private String password;
		
		public RequestToWithdraw() {
			super();
			// TODO Auto-generated constructor stub
		}
		public RequestToWithdraw(int accountId, double amount, String username, String password) {
			super();
			this.accountId = accountId;
			this.amount = amount;
			this.username = username;
			this.password = password;
		}
		public int getAccountId() {
			return accountId;
		}
		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + accountId;
			long temp;
			temp = Double.doubleToLongBits(amount);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RequestToWithdraw other = (RequestToWithdraw) obj;
			if (accountId != other.accountId)
				return false;
			if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "RequestToWithdraw [accountId=" + accountId + ", amount=" + amount + ", username=" + username
					+ ", password=" + password + "]";
		}
	
		}
	

