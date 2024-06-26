package in.co.pro4.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * User JavaBean encapsulates User attributes
 * @author Yash kumbhkar
 *
 */
public class UserBean extends BaseBean {

	 /**
     * Lock Active constant for User
     */
	
	public static final String ACTIVE = "Active";
	
	 /**
     * Lock Inactive constant for User
     */
	public static final String INACTIVE = "Inactive";

	/**
     * First Name of User
     */
	private String firstName;
	
	/**
     * Last Name of User
     */
	private String lastName;
	
    /**
     * Login of User
     */
	private String logIn;
	
	/**
     * Password of User
     */
	private String password;
	
	/**
     * Confirm Password of User
     */
	private String ConfirmPassword;
	
	/**
     * Date of Birth of User
     */
	private Date dob;
	
	/**
     * Mobile No of User
     */
	private String mobileNo;
	
	/**
     * Role of User
     */
	private long roleId;
	
	  /**
     * Number of unsuccessful login attempt
     */
	private int unSuccessfullLogin;
	
	 /**
     * Gender of User
     */
	private String gender;
	
	/**
     * Last login timestamp
     */
	private Timestamp lastLogin;
	
	 /**
     * User Lock
     */
	private String lock = INACTIVE;
	
	 /**
     * IP Address of User from where User was registred.
     */
	private String registeredIP;
	
	/**
     * IP Address of User of his last login
     */
	private String lastloginIP;

	
	 /**
     * accessor
     */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogIn() {
		return logIn;
	}

	public void setLogIn(String logIn) {
		this.logIn = logIn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public int getUnSuccessfullLogin() {
		return unSuccessfullLogin;
	}

	public void setUnSuccessfullLogin(int unSuccessfullLogin) {
		this.unSuccessfullLogin = unSuccessfullLogin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLock() {
		return lock;
	}

	public void setLock(String lock) {
		this.lock = lock;
	}

	public String getRegisteredIP() {
		return registeredIP;
	}

	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	public String getLastloginIP() {
		return lastloginIP;
	}

	public void setLastloginIP(String lastloginIP) {
		this.lastloginIP = lastloginIP;
	}

	public static String getActive() {
		return ACTIVE;
	}

	public static String getInactive() {
		return INACTIVE;
	}

	@Override
	public String getKey() {
		return lastName;
	}

	@Override
	public String getValue() {
		return lastName;
	}
	@Override
	public String toString() {
		System.out.println("firstname='"+firstName+"'lastname='"+lastName+"'loginid='"+logIn+"'password='"+password+ "'dob="+dob);
		return super.toString();
	}

}
