package vn.jamek.baseweb.dto.response;

import vn.jamek.baseweb.domain.User;

public class C001Response extends Response{

	private boolean isSuccess;
	
	private String message;
	
	private User user;
	
	public C001Response() {
		
	}
	
	public C001Response(boolean isSuccess, String message, User user) {
		super();
		this.isSuccess = isSuccess;
		this.message = message;
		this.user = user;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
