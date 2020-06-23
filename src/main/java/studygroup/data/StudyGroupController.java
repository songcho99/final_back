package studygroup.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudyGroupController {
	@Autowired
	private StudyGroupServiceInter service;
	
	@PostMapping("/studygroup/add")
	public void insertOfStudyGroup(@ModelAttribute StudyGroupDto dto) {
		StudyGroupDto sdto = new StudyGroupDto();
		
		sdto.setStudygroup_study_num(dto.getStudygroup_study_num());
		sdto.setStudygroup_member_num(dto.getStudygroup_member_num());
		
		service.insertOfStudyGroupByDto(sdto);
		System.out.println("그룹 insert 성공");
	}
}
