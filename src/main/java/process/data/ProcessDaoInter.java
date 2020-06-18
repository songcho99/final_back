package process.data;

import java.util.List;

import member.data.MemberDto;

public interface ProcessDaoInter {
	public List<MemberDto> searchTeacher();
	public void insertProcess(ProcessDto processdto);
	public int selectProcessMaxnum();
}
