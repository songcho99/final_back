package study.data;

import java.sql.Timestamp;

public class StudyDto {
	private int study_num;
	private String study_type;
	private String study_subject;
	private int study_member_num;
	private String study_startdate;
	private String study_enddate;
	private String study_gatherday;
	private int study_peoples;
	private String study_level;
	private String study_intr;
	private String study_goal;
	private String study_process;
	private String study_address;
	private String study_detailddr;
	private int study_boardtype;
	private Timestamp study_writeday;
	
	public int getStudy_num() {
		return study_num;
	}
	public void setStudy_num(int study_num) {
		this.study_num = study_num;
	}
	public String getStudy_type() {
		return study_type;
	}
	public void setStudy_type(String study_type) {
		this.study_type = study_type;
	}
	public String getStudy_subject() {
		return study_subject;
	}
	public void setStudy_subject(String study_subject) {
		this.study_subject = study_subject;
	}
	public int getStudy_member_num() {
		return study_member_num;
	}
	public void setStudy_member_num(int study_member_num) {
		this.study_member_num = study_member_num;
	}
	public String getStudy_startdate() {
		return study_startdate;
	}
	public void setStudy_startdate(String study_startdate) {
		this.study_startdate = study_startdate;
	}
	public String getStudy_enddate() {
		return study_enddate;
	}
	public void setStudy_enddate(String study_enddate) {
		this.study_enddate = study_enddate;
	}
	public String getStudy_gatherday() {
		return study_gatherday;
	}
	public void setStudy_gatherday(String study_gatherday) {
		this.study_gatherday = study_gatherday;
	}
	public int getStudy_peoples() {
		return study_peoples;
	}
	public void setStudy_peoples(int study_peoples) {
		this.study_peoples = study_peoples;
	}
	public String getStudy_level() {
		return study_level;
	}
	public void setStudy_level(String study_level) {
		this.study_level = study_level;
	}
	public String getStudy_intr() {
		return study_intr;
	}
	public void setStudy_intr(String study_intr) {
		this.study_intr = study_intr;
	}
	public String getStudy_goal() {
		return study_goal;
	}
	public void setStudy_goal(String study_goal) {
		this.study_goal = study_goal;
	}
	public String getStudy_process() {
		return study_process;
	}
	public void setStudy_process(String study_process) {
		this.study_process = study_process;
	}
	public String getStudy_address() {
		return study_address;
	}
	public void setStudy_address(String study_address) {
		this.study_address = study_address;
	}
	public String getStudy_detailddr() {
		return study_detailddr;
	}
	public void setStudy_detailddr(String study_detailddr) {
		this.study_detailddr = study_detailddr;
	}
	public int getStudy_boardtype() {
		return study_boardtype;
	}
	public void setStudy_boardtype(int study_boardtype) {
		this.study_boardtype = study_boardtype;
	}
	public Timestamp getStudy_writeday() {
		return study_writeday;
	}
	public void setStudy_writeday(Timestamp study_writeday) {
		this.study_writeday = study_writeday;
	}
	
	@Override
	public String toString() {
		return "StudyDto [study_num=" + study_num + ", study_type=" + study_type + ", study_subject=" + study_subject
				+ ", study_member_num=" + study_member_num + ", study_startdate=" + study_startdate + ", study_enddate="
				+ study_enddate + ", study_gatherday=" + study_gatherday + ", study_peoples=" + study_peoples
				+ ", study_level=" + study_level + ", study_intr=" + study_intr + ", study_goal=" + study_goal
				+ ", study_process=" + study_process + ", study_address=" + study_address + ", study_detailddr="
				+ study_detailddr + ", study_boardtype=" + study_boardtype + ", study_writeday=" + study_writeday + "]";
	}
	
}
