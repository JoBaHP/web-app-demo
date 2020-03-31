package homeworkapp.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequestModel {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@NotNull(message="type something")
	private String firstName;
	@NotNull(message="type something")
	private String lastName;
	@NotNull(message="type something")
	@Email
	private String email;
	@NotNull(message="type something")
	@Size(min= 8, max=16, message="password must b between 8 and 16 car")
	private String password;

}
