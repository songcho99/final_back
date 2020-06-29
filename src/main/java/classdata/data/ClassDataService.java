package classdata.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class ClassDataService implements ClassDataServiceInter {
	
	@Autowired
	private ClassDataDao dao;

	@Override
	public void insertClassData(ClassDataDto dto) {
		dao.insertClassData(dto);
		
	}

	@Override
	public int selectMaxNum() {
		// TODO Auto-generated method stub
		return dao.selectMaxNum();
	}

}