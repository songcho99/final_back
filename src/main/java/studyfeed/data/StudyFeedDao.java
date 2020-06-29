package studyfeed.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class StudyFeedDao extends SqlSessionDaoSupport implements StudyFeedDaoInter {
	@Override
	public void insertOfStudyFeed(StudyFeedDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfStudyFeed", dto);
	}
	@Override
	public int maxNumOfStudyFeed() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("maxNumOfStudyFeed");
	}
	@Override
	public List<StudyFeedDto> selectOfStudyFeedList(int studyfeed_studygroup_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfStudyFeedList", studyfeed_studygroup_num);
	}
}
