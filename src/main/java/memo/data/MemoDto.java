package memo.data;

import java.sql.Timestamp;

public class MemoDto {
	private int memo_num;
	private int memo_member_num;
	private String memo_content;
	private Timestamp memo_writeday;
	
	public int getMemo_num() {
		return memo_num;
	}
	public void setMemo_num(int memo_num) {
		this.memo_num = memo_num;
	}
	public int getMemo_member_num() {
		return memo_member_num;
	}
	public void setMemo_member_num(int memo_member_num) {
		this.memo_member_num = memo_member_num;
	}
	public String getMemo_content() {
		return memo_content;
	}
	public void setMemo_content(String memo_content) {
		this.memo_content = memo_content;
	}
	public Timestamp getMemo_writeday() {
		return memo_writeday;
	}
	public void setMemo_writeday(Timestamp memo_writeday) {
		this.memo_writeday = memo_writeday;
	}
	
	@Override
	public String toString() {
		return "MemoDto [memo_num=" + memo_num + ", memo_member_num=" + memo_member_num + ", memo_content="
				+ memo_content + ", memo_writeday=" + memo_writeday + "]";
	}
	
}
