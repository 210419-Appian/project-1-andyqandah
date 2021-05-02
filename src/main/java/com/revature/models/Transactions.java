package com.revature.models;

import java.io.Serializable;
import java.time.LocalDateTime;


public abstract class Transactions implements Serializable {
	
	/**
	 * beans 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private LocalDateTime TransTime;
	private long amount;
	private AccountType type;
	private Account accountId;
	
	public Transactions() {
		super();
	
	} 
	
	
	public Transactions(LocalDateTime transTime, long amount, AccountType type, Account accountId) {
		super();
		TransTime = transTime;
		this.amount = amount;
		this.type = type;
		this.accountId = accountId;
	}

	public LocalDateTime getTransTime() {
		return TransTime;
	}

	public void setTransTime(LocalDateTime transTime) {
		TransTime = transTime;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public Account getAccountId() {
		return accountId;
	}

	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TransTime == null) ? 0 : TransTime.hashCode());
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Transactions other = (Transactions) obj;
		if (TransTime == null) {
			if (other.TransTime != null)
				return false;
		} else if (!TransTime.equals(other.TransTime))
			return false;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (amount != other.amount)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transactions [TransTime=" + TransTime + ", amount=" + amount + ", type=" + type + ", accountId="
				+ accountId + "]";
	}

	
	
	
	

}
