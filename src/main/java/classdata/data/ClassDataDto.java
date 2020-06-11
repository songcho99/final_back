package classdata.data;

import java.sql.Timestamp;

public class ClassDataDto {
	private int classdata_num;
	private int classdata_processclass_num;
	private int classdata_member_num;
	private String classdata_subject;
	private String classdata_content;
	private int classdata_boardtype;
	private Timestamp classdata_writeday;
	
	public int getClassdata_num() {
		return classdata_num;
	}
	public void setClassdata_num(int classdata_num) {
		this.classdata_num = classdata_num;
	}
	public int getClassdata_processclass_num() {
		return classdata_processclass_num;
	}
	public void setClassdata_processclass_num(int classdata_processclass_num) {
		this.classdata_processclass_num = classdata_processclass_num;
	}
	public int getClassdata_member_num() {
		return classdata_member_num;
	}
	public void setClassdata_member_num(int classdata_member_num) {
		this.classdata_member_num = classdata_member_num;
	}
	public String getClassdata_subject() {
		return classdata_subject;
	}
	public void setClassdata_subject(String classdata_subject) {
		this.classdata_subject = classdata_subject;
	}
	public String getClassdata_content() {
		return classdata_content;
	}
	public void setClassdata_content(String classdata_content) {
		this.classdata_content = classdata_content;
	}
	public int getClassdata_boardtype() {
		return classdata_boardtype;
	}
	public void setClassdata_boardtype(int classdata_boardtype) {
		this.classdata_boardtype = classdata_boardtype;
	}
	public Timestamp getClassdata_writeday() {
		return classdata_writeday;
	}
	public void setClassdata_writeday(Timestamp classdata_writeday) {
		this.classdata_writeday = classdata_writeday;
	}
	
	@Override
	public String toString() {
		return "ClassDataDto [classdata_num=" + classdata_num + ", classdata_processclass_num="
				+ classdata_processclass_num + ", classdata_member_num=" + classdata_member_num + ", classdata_subject="
				+ classdata_subject + ", classdata_content=" + classdata_content + ", classdata_boardtype="
				+ classdata_boardtype + ", classdata_writeday=" + classdata_writeday + "]";
	}
	
}
