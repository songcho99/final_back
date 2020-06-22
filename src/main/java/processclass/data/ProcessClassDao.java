package processclass.data;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ProcessClassDao extends SqlSessionDaoSupport implements ProcessClassDaoInter{

	@Override
	public void insertProcessClass(ProcessClassDto processclassdto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertProcessClass",processclassdto);
	}

}
