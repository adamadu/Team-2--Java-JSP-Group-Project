/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6.Entity;

/**
 *
 * @author 689508 - Darya O.
 */
public class Customer {
	
	//instance variables
	private int CustomerId;
	private String CustFirstName;
	private String CustLastName;
	private String CustAddress;
	private String CustCity;
	private String CustProv;
	private String CustPostal;
	private String CustCountry;
	private String CustHomePhone;
	private String CustBusPhone;
	private String CustEmail;
	private int AgentId;
	private String UserName;
	private String Password;
	
	public Customer() {
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public String getCustFirstName() {
		return CustFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		CustFirstName = custFirstName;
	}

	public String getCustLastName() {
		return CustLastName;
	}

	public void setCustLastName(String custLastName) {
		CustLastName = custLastName;
	}

	public String getCustAddress() {
		return CustAddress;
	}

	public void setCustAddress(String custAddress) {
		CustAddress = custAddress;
	}

	public String getCustCity() {
		return CustCity;
	}

	public void setCustCity(String custCity) {
		CustCity = custCity;
	}

	public String getCustProv() {
		return CustProv;
	}

	public void setCustProv(String custProv) {
		CustProv = custProv;
	}

	public String getCustPostal() {
		return CustPostal;
	}

	public void setCustPostal(String custPostal) {
		CustPostal = custPostal;
	}

	public String getCustCountry() {
		return CustCountry;
	}

	public void setCustCountry(String custCountry) {
		CustCountry = custCountry;
	}

	public String getCustHomePhone() {
		return CustHomePhone;
	}

	public void setCustHomePhone(String custHomePhone) {
		CustHomePhone = custHomePhone;
	}

	public String getCustBusPhone() {
		return CustBusPhone;
	}

	public void setCustBusPhone(String custBusPhone) {
		CustBusPhone = custBusPhone;
	}

	public String getCustEmail() {
		return CustEmail;
	}

	public void setCustEmail(String custEmail) {
		CustEmail = custEmail;
	}

	public int getAgentId() {
		return AgentId;
	}

	public void setAgentId(int agentId) {
		AgentId = agentId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	} 
	
}
