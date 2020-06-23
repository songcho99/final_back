package studygroup.data;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class StudyGroupService implements StudyGroupServiceInter {
	@Autowired
	private StudyGroupDaoInter dao;
	
	@Override
	public void insertStudyGroup(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		dao.insertStudyGroup(map);
	}
	@Override
	public int selectCountOfStudyGroupPeoples(int studygroup_study_num) {
		// TODO Auto-generated method stub
		return dao.selectCountOfStudyGroupPeoples(studygroup_study_num);
	}
}
