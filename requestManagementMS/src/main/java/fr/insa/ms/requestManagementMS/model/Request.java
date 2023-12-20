package fr.insa.ms.requestManagementMS.model;

public class Request {
    public enum State {
        WAITING, VALIDATED, REJECTED, CHOSEN, REALIZED
    }

    private int requestId;
    private String title;
    private int userId; 
    private State state;

    public Request() {
        this.state = State.WAITING;
    }

    public Request(int requestId, String title, int userId) {
        this.requestId = requestId;
        this.title = title;
        this.userId = userId;
        this.state = State.WAITING;
    }

    public boolean isValidState(String state) {
        try {
            State.valueOf(state.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}


}

