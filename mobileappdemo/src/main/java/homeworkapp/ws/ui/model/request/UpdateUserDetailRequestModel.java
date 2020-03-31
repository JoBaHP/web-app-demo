package homeworkapp.ws.ui.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUserDetailRequestModel {
	@NotNull(message="type something")
	private String firstName;
	@NotNull(message="type something")
	private String lastName;
	
	
	
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
	

	
	

}
