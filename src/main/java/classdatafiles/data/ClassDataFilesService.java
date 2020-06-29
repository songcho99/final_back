package classdatafiles.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassDataFilesService implements ClassDataFilesServiceInter {

	@Autowired
	private ClassDataFilesDao dao;
	
	@Override
	public void insertClassDataFiles(ClassDataFilesDto cfdto) {
		// TODO Auto-generated method stub
		dao.insertClassDataFiles(cfdto);
		
	}

	
}
