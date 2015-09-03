package workshop6.Entity;

public class Agent {
	
	//instance variables
	private int AgentId;
	private String AgtFirstName;
	private String AgtMiddleInitial;
	private String AgtLastName;
	private String AgtBusPhone;
	private String AgtEmail;
	private String AgtPosition;
	private int AgencyId;
	private boolean isActive; 
	
	//constructor
	public Agent(){
	}

	
	//get and set methods for the public variables
	public int getAgentId() {
		return AgentId;
	}
	public void setAgentId(int agentId) {
		AgentId = agentId;
	}
	public String getAgtFirstName() {
		return AgtFirstName;
	}
	public void setAgtFirstName(String agtFirstName) {
		AgtFirstName = agtFirstName;
	}
	public String getAgtMiddleInitial() {
		return AgtMiddleInitial;
	}
	public void setAgtMiddleInitial(String agtMiddleInitial) {
		AgtMiddleInitial = agtMiddleInitial;
	}
	public String getAgtLastName() {
		return AgtLastName;
	}
	public void setAgtLastName(String agtLastName) {
		AgtLastName = agtLastName;
	}
	public String getAgtBusPhone() {
		return AgtBusPhone;
	}
	public void setAgtBusPhone(String agtBusPhone) {
		AgtBusPhone = agtBusPhone;
	}
	public String getAgtEmail() {
		return AgtEmail;
	}
	public void setAgtEmail(String agtEmail) {
		AgtEmail = agtEmail;
	}
	public String getAgtPosition() {
		return AgtPosition;
	}
	public void setAgtPosition(String agtPosition) {
		AgtPosition = agtPosition;
	}
	public int getAgencyId() {
		return AgencyId;
	}
	public void setAgencyId(int agencyId) {
		AgencyId = agencyId;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
