package study.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class StudyService implements StudyServiceInter {
	@Autowired
	private StudyDaoInter dao;
	
	@Override
	public void insertStudy(StudyDto dto) {
		// TODO Auto-generated method stub
		dao.insertStudy(dto);
	}
	@Override
	public List<StudyDto> selectOfStudyList() {
		// TODO Auto-generated method stub
		return dao.selectOfStudyList();
	}
}
