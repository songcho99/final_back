package process.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.data.MemberDto;

@Service
public class ProcessService implements ProcessServiceInter{

	@Autowired
	private ProcessDaoInter dao;
	
	@Override
	public List<MemberDto> searchTeacher() {
		// TODO Auto-generated method stub
		return dao.searchTeacher();
	}

	@Override
	public void insertProcess(ProcessDto processdto) {
		// TODO Auto-generated method stub
		dao.insertProcess(processdto);
	}

	@Override
	public int selectProcessMaxnum() {
		// TODO Auto-generated method stub
		return dao.selectProcessMaxnum();
	}

}
