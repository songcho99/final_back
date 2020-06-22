package study.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class StudyDao extends SqlSessionDaoSupport implements StudyDaoInter {
	@Override
	public void insertStudy(StudyDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfStudy", dto);
	}
	@Override
	public List<StudyDto> selectOfStudyList() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfStudyList");
	}
}
