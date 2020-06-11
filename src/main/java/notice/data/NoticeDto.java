package notice.data;

import java.sql.Timestamp;

public class NoticeDto {
	private int notice_num;
	private int notice_member_num;
	private String notice_subject;
	private String notice_content;
	private int notice_boardtype;
	private Timestamp writeday;
	
	public int getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}
	public int getNotice_member_num() {
		return notice_member_num;
	}
	public void setNotice_member_num(int notice_member_num) {
		this.notice_member_num = notice_member_num;
	}
	public String getNotice_subject() {
		return notice_subject;
	}
	public void setNotice_subject(String notice_subject) {
		this.notice_subject = notice_subject;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public int getNotice_boardtype() {
		return notice_boardtype;
	}
	public void setNotice_boardtype(int notice_boardtype) {
		this.notice_boardtype = notice_boardtype;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
	@Override
	public String toString() {
		return "NoticeDto [notice_num=" + notice_num + ", notice_member_num=" + notice_member_num + ", notice_subject="
				+ notice_subject + ", notice_content=" + notice_content + ", notice_boardtype=" + notice_boardtype
				+ ", writeday=" + writeday + "]";
	}
	
}
