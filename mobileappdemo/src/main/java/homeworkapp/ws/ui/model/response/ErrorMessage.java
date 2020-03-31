package homeworkapp.ws.ui.model.response;

import java.sql.Date;

public class ErrorMessage {
	private Date timestamp;
	private String message;
	
	public ErrorMessage(Date timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}
	 public ErrorMessage() {
		 
	 }
	

	

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
