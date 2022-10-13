package builder;

import java.util.Date;

public class TaskBuilder {

	private final long id;
	private String summary = "";
	private String description = "";
	private boolean done = false;
	private Date dueDate;
	
	/*
	public TaskBuilder(long id, String summary, String description, boolean done, Date dueDate) {
		super();
		this.id = id;
		this.summary = summary;
		this.description = description;
		this.done = done;
		this.dueDate = dueDate;
	}
	*/
	
	public TaskBuilder(long id) {
		this.id = id;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Task build() {
		return new Task(id, summary, description, done, dueDate);
	}
	
}