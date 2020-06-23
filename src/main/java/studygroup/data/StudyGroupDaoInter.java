package studygroup.data;

import java.util.HashMap;

public interface StudyGroupDaoInter {
	public void insertStudyGroup(HashMap<String, Integer> map);
	public void insertOfStudyGroupByDto(StudyGroupDto dto);
	public int selectCountOfStudyGroupPeoples(int studygroup_study_num);
}
