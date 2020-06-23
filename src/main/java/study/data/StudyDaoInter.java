package study.data;

import java.util.List;

public interface StudyDaoInter {
	public void insertStudy(StudyDto dto);
	public List<StudyDto> selectOfStudyList();
	public int selectNumOfNewestStudy();
	public StudyDto selectOfStudyByNum(int study_num);
}
