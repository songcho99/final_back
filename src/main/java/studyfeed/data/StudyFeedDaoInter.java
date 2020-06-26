package studyfeed.data;

import java.util.List;

public interface StudyFeedDaoInter {
	public void insertOfStudyFeed(StudyFeedDto dto);
	public int maxNumOfStudyFeed();
	public List<StudyFeedDto> selectOfStudyFeedList();
}
