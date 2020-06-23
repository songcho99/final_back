package processclass.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessClassService implements ProcessClassServiceInter{

	@Autowired
	private ProcessClassDaoInter dao;
	
	@Override
	public void insertProcessClass(ProcessClassDto processclassdto) {
		// TODO Auto-generated method stub
		dao.insertProcessClass(processclassdto);
	}

	@Override
	public void updateTeacherNum(ProcessClassDto processclassdto) {
		// TODO Auto-generated method stub
		dao.updateTeacherNum(processclassdto);
	}

	

}
