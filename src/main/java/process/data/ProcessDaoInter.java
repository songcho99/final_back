package process.data;

import java.util.List;
import java.util.Map;

import files.data.FilesDto;
import files.data.ProcessFilesDto;
import member.data.MemberDto;

public interface ProcessDaoInter {
	public List<MemberDto> searchTeacher();
	public void insertProcess(ProcessDto processdto);
	public int selectProcessMaxnum();
	public List<ProcessListDto> getAllProcess();
	public MemberDto selectOneTeacher(String teachernum);
	public void insertProcessFiles(ProcessFilesDto processfilesdto);
	public ProcessDto selectOneProcess(int process_num);
	public List<ProcessFilesDto> processFilesList(int processfiles_process_num);
}
