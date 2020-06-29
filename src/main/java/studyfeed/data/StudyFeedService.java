package studyfeed.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class StudyFeedService implements StudyFeedServiceInter {
	@Autowired
	private StudyFeedDaoInter dao;
	
	@Override
	public void insertOfStudyFeed(StudyFeedDto dto) {
		// TODO Auto-generated method stub
		dao.insertOfStudyFeed(dto);
	}
	@Override
	public int maxNumOfStudyFeed() {
		// TODO Auto-generated method stub
		return dao.maxNumOfStudyFeed();
	}
	@Override
	public List<StudyFeedDto> selectOfStudyFeedList(int studyfeed_studygroup_num) {
		// TODO Auto-generated method stub
		return dao.selectOfStudyFeedList(studyfeed_studygroup_num);
	}
}
