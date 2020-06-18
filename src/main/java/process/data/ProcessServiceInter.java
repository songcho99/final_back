package process.data;

import java.util.List;

import member.data.MemberDto;

public interface ProcessServiceInter {
	public List<MemberDto> searchTeacher();
	public void insertProcess(ProcessDto processdto);
	public int selectProcessMaxnum();
}
