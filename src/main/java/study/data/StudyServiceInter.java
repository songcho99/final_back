package study.data;

import java.util.List;

public interface StudyServiceInter {
	public void insertStudy(StudyDto dto);
	public List<StudyDto> selectOfStudyList();
}
