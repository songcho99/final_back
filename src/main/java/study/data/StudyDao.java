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
	@Override
	public int selectNumOfNewestStudy() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectNumOfNewestStudy");
	}
	@Override
	public StudyDto selectOfStudyByNum(int study_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOfStudyByNum", study_num);
	}
	@Override
	public List<StudyDto> selectOfStudyFounder(int study_member_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfStudyFounder", study_member_num);
	}
	@Override
	public void deleteOfStudy(int study_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfStudy", study_num);
	}
}
