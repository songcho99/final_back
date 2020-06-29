package studyfeed.data;

import java.util.List;

public interface StudyFeedServiceInter {
	public void insertOfStudyFeed(StudyFeedDto dto);
	public int maxNumOfStudyFeed();
	public List<StudyFeedDto> selectOfStudyFeedList(int studyfeed_studygroup_num);
}
