package classdatafiles.data;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ClassDataFilesDao extends SqlSessionDaoSupport implements ClassDataFilesDaoInter {

	@Override
	public void insertClassDataFiles(ClassDataFilesDto cfdto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfClassDataFiles",cfdto);
		
		
	}
	

}
