package studygroup.data;

import java.util.HashMap;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class StudyGroupDao extends SqlSessionDaoSupport implements StudyGroupDaoInter {
	@Override
	public void insertStudyGroup(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfStudyGroup", map);
	}
	@Override
	public int selectCountOfStudyGroupPeoples(int studygroup_study_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCountOfStudyGroupPeoples", studygroup_study_num);
	}
}
