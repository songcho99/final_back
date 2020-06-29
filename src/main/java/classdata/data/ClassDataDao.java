package classdata.data;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

	@Repository
	public class ClassDataDao extends SqlSessionDaoSupport implements ClassDataDaoInter{

		@Override
		public void insertClassData(ClassDataDto dto) {
			getSqlSession().insert("insertOfClassData",dto);
			
		}

		@Override
		public int selectMaxNum() {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("selectClassDataMaxnum");
		}


}
