package com.revature.models;

import java.io.Serializable;

public class RequestToTransfer implements Serializable{

	/**
	 * 
	 */
	
		private static final long serialVersionUID = 1L;
		private int sourceAccountId;
		public int getSourceAccountId() {
			
			return sourceAccountId;
		}
		public void setSourceAccountId(int sourceAccountId) {
			this.sourceAccountId = sourceAccountId;
		}
		public int getTargetAccountId() {
			return targetAccountId;
		}
		public void setTargetAccountId(int targetAccountId) {
			this.targetAccountId = targetAccountId;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		private int targetAccountId;
		private double amount;
		
		public RequestToTransfer() {
			super();
		
		}
		public RequestToTransfer(int sourceAccountId, int targetAccountId, double amount) {
			super();
			this.sourceAccountId = sourceAccountId;
			this.targetAccountId = targetAccountId;
			this.amount = amount;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(amount);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + sourceAccountId;
			result = prime * result + targetAccountId;
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
			RequestToTransfer other = (RequestToTransfer) obj;
			if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
				return false;
			if (sourceAccountId != other.sourceAccountId)
				return false;
			if (targetAccountId != other.targetAccountId)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "RequestToTransfer [sourceAccountId=" + sourceAccountId + ", targetAccountId=" + targetAccountId
					+ ", amount=" + amount + "]";
		}}