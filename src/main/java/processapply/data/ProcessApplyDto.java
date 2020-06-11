package processapply.data;

import java.sql.Timestamp;

public class ProcessApplyDto {
	private int processapply_num;
	private int processapply_member_num;
	private int processapply_process_num;
	private Timestamp processapply_writeday;
	
	public int getProcessapply_num() {
		return processapply_num;
	}
	public void setProcessapply_num(int processapply_num) {
		this.processapply_num = processapply_num;
	}
	public int getProcessapply_member_num() {
		return processapply_member_num;
	}
	public void setProcessapply_member_num(int processapply_member_num) {
		this.processapply_member_num = processapply_member_num;
	}
	public int getProcessapply_process_num() {
		return processapply_process_num;
	}
	public void setProcessapply_process_num(int processapply_process_num) {
		this.processapply_process_num = processapply_process_num;
	}
	public Timestamp getProcessapply_writeday() {
		return processapply_writeday;
	}
	public void setProcessapply_writeday(Timestamp processapply_writeday) {
		this.processapply_writeday = processapply_writeday;
	}
	
	@Override
	public String toString() {
		return "ProcessApplyDto [processapply_num=" + processapply_num + ", processapply_member_num="
				+ processapply_member_num + ", processapply_process_num=" + processapply_process_num
				+ ", processapply_writeday=" + processapply_writeday + "]";
	}
	
}
