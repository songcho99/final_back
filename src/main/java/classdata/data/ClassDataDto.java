package classdata.data;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ClassDataDto {
	int classdata_num;
	int classdata_processclass_num;
	int classdata_member_num;
	String classdata_subject;
	String classdata_content;
	Timestamp classdata_writeday;
	List<MultipartFile> classdata_files; 
	String classdata_writer;
	
	
	public List<MultipartFile> getClassdata_files() {
		return classdata_files;
	}
	public void setClassdata_files(List<MultipartFile> classdata_files) {
		this.classdata_files = classdata_files;
	}
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
	public Timestamp getClassdata_writeday() {
		return classdata_writeday;
	}
	public void setClassdata_writeday(Timestamp classdata_writeday) {
		this.classdata_writeday = classdata_writeday;
	}
	public String getClassdata_writer() {
		return classdata_writer;
	}
	public void setClassdata_writer(String classdata_writer) {
		this.classdata_writer = classdata_writer;
	}
	@Override
	public String toString() {
		return "ClassDataDto [classdata_num=" + classdata_num + ", classdata_processclass_num="
				+ classdata_processclass_num + ", classdata_member_num=" + classdata_member_num + ", classdata_subject="
				+ classdata_subject + ", classdata_content=" + classdata_content + ", classdata_writeday="
				+ classdata_writeday + ", classdata_files=" + classdata_files + ", classdata_writer=" + classdata_writer
				+ "]";
	}
	
	
	
	
	
	
	
}
