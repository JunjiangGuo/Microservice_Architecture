package fr.insa.ms.FeedbackManagementMS.model;

public class Feedback {
	private int id;
	private int userId;
	private int requestId;
	private String comment;
	
	public Feedback(int id, int userId, int requestId, String comment) {
		
	}
	
	public Feedback() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
