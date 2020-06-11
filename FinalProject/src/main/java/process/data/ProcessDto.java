package process.data;

import java.sql.Timestamp;

public class ProcessDto {
	private int process_num;
	private String process_type;
	private int process_member_num;
	private String process_subject;
	private String process_intr;
	private int process_peoples;
	private String process_startdate;
	private String process_enddate;
	private String process_boardtype;
	private int process_status;
	private String process_teacher;
	private Timestamp process_writeday;
	
	public int getProcess_num() {
		return process_num;
	}
	public void setProcess_num(int process_num) {
		this.process_num = process_num;
	}
	public String getProcess_type() {
		return process_type;
	}
	public void setProcess_type(String process_type) {
		this.process_type = process_type;
	}
	public int getProcess_member_num() {
		return process_member_num;
	}
	public void setProcess_member_num(int process_member_num) {
		this.process_member_num = process_member_num;
	}
	public String getProcess_subject() {
		return process_subject;
	}
	public void setProcess_subject(String process_subject) {
		this.process_subject = process_subject;
	}
	public String getProcess_intr() {
		return process_intr;
	}
	public void setProcess_intr(String process_intr) {
		this.process_intr = process_intr;
	}
	public int getProcess_peoples() {
		return process_peoples;
	}
	public void setProcess_peoples(int process_peoples) {
		this.process_peoples = process_peoples;
	}
	public String getProcess_startdate() {
		return process_startdate;
	}
	public void setProcess_startdate(String process_startdate) {
		this.process_startdate = process_startdate;
	}
	public String getProcess_enddate() {
		return process_enddate;
	}
	public void setProcess_enddate(String process_enddate) {
		this.process_enddate = process_enddate;
	}
	public String getProcess_boardtype() {
		return process_boardtype;
	}
	public void setProcess_boardtype(String process_boardtype) {
		this.process_boardtype = process_boardtype;
	}
	public int getProcess_status() {
		return process_status;
	}
	public void setProcess_status(int process_status) {
		this.process_status = process_status;
	}
	public String getProcess_teacher() {
		return process_teacher;
	}
	public void setProcess_teacher(String process_teacher) {
		this.process_teacher = process_teacher;
	}
	public Timestamp getProcess_writeday() {
		return process_writeday;
	}
	public void setProcess_writeday(Timestamp process_writeday) {
		this.process_writeday = process_writeday;
	}
	
	@Override
	public String toString() {
		return "ProcessDto [process_num=" + process_num + ", process_type=" + process_type + ", process_member_num="
				+ process_member_num + ", process_subject=" + process_subject + ", process_intr=" + process_intr
				+ ", process_peoples=" + process_peoples + ", process_startdate=" + process_startdate
				+ ", process_enddate=" + process_enddate + ", process_boardtype=" + process_boardtype
				+ ", process_status=" + process_status + ", process_teacher=" + process_teacher + ", process_writeday="
				+ process_writeday + "]";
	}
	
}
