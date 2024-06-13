package projectdto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Taskdto {
	
	private int taskid;
	private String tasktitle;
	private String taskdescription;
	private String taskpriority;
	private String taskduedate;
	private int userid;
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public String getTaskdescription() {
		return taskdescription;
	}
	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}
	public String getTaskpriority() {
		return taskpriority;
	}
	public void setTaskpriority(String taskpriority) {
		this.taskpriority = taskpriority;
	}
	public String getTaskduedate() {
		return taskduedate;
	}
	public void setTaskduedate(String taskduedate) {
		this.taskduedate = taskduedate;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
		
	}
	public String getTasktitle() {
		return tasktitle;
	}
	public void setTasktitle(String tasktitle) {
		this.tasktitle = tasktitle;
	}
	
	public void calculateAndSetPriority() {
		LocalDate today = LocalDate.now();
		LocalDate dueDate = LocalDate.parse(this.taskduedate);
		long daysBetween = ChronoUnit.DAYS.between(today, dueDate);
		
		if (daysBetween <= 3) { // Example threshold for high priority
			this.taskpriority = "high";
		} else {
			
			this.taskpriority = "low";
		}

	}
}
