package in.co.pro4.bean;

import java.sql.Date;

public class PaymentBean extends BaseBean  {

	
	private String paymentType ;
	private  int  amount ;
	private  String bankName ;
	 private String customerName;
	 private  int  transactionId ; 
	
	 
	
	
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public  int  getAmount() {
		return amount;
	}

	public  int  setAmount(int amount) {
		return this.amount = amount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public  int  getTransactionId() {
		return transactionId;
	}

	public void setTransactionId( int  transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	 
	 

}
