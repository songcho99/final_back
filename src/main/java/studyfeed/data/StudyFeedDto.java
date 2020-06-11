package studyfeed.data;

import java.sql.Timestamp;

public class StudyFeedDto {
	private int studyfeed_num;
	private int studyfeed_studygroup_num;
	private int studyfeed_member_num;
	private String studyfeed_content;
	private Timestamp studyfeed_writeday;
	private int studyfeed_boardtype;
	
	public int getStudyfeed_num() {
		return studyfeed_num;
	}
	public void setStudyfeed_num(int studyfeed_num) {
		this.studyfeed_num = studyfeed_num;
	}
	public int getStudyfeed_studygroup_num() {
		return studyfeed_studygroup_num;
	}
	public void setStudyfeed_studygroup_num(int studyfeed_studygroup_num) {
		this.studyfeed_studygroup_num = studyfeed_studygroup_num;
	}
	public int getStudyfeed_member_num() {
		return studyfeed_member_num;
	}
	public void setStudyfeed_member_num(int studyfeed_member_num) {
		this.studyfeed_member_num = studyfeed_member_num;
	}
	public String getStudyfeed_content() {
		return studyfeed_content;
	}
	public void setStudyfeed_content(String studyfeed_content) {
		this.studyfeed_content = studyfeed_content;
	}
	public Timestamp getStudyfeed_writeday() {
		return studyfeed_writeday;
	}
	public void setStudyfeed_writeday(Timestamp studyfeed_writeday) {
		this.studyfeed_writeday = studyfeed_writeday;
	}
	public int getStudyfeed_boardtype() {
		return studyfeed_boardtype;
	}
	public void setStudyfeed_boardtype(int studyfeed_boardtype) {
		this.studyfeed_boardtype = studyfeed_boardtype;
	}
	
	@Override
	public String toString() {
		return "StudyFeedDto [studyfeed_num=" + studyfeed_num + ", studyfeed_studygroup_num=" + studyfeed_studygroup_num
				+ ", studyfeed_member_num=" + studyfeed_member_num + ", studyfeed_content=" + studyfeed_content
				+ ", studyfeed_writeday=" + studyfeed_writeday + ", studyfeed_boardtype=" + studyfeed_boardtype + "]";
	}
	
}
