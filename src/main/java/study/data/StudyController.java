package study.data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import member.data.MemberServiceInter;
import studygroup.data.StudyGroupServiceInter;
import upload.util.SpringFileWrite;

@RestController
@CrossOrigin
public class StudyController {
	@Autowired
	private StudyServiceInter service;
	
	@Autowired
	private MemberServiceInter memberservice;
	
	@Autowired
	private StudyGroupServiceInter studygroupservice;
	
	@RequestMapping(value = "/study/add", method = RequestMethod.POST)
	public void insertStudy(
				@ModelAttribute StudyDto dto, HttpServletRequest request
			) {
		StudyDto sdto = new StudyDto();
		String gather = "";
		
		sdto.setStudy_type(dto.getStudy_type());
		sdto.setStudy_subject(dto.getStudy_subject());
		sdto.setStudy_member_num(dto.getStudy_member_num());
		sdto.setStudy_startdate(dto.getStudy_startdate());
		sdto.setStudy_enddate(dto.getStudy_enddate());
		for(String s:dto.getStudy_gatherdayname())
			gather += s + ", ";
		gather = gather.substring(0, gather.length()-2);
		sdto.setStudy_gatherday(gather);
		sdto.setStudy_peoples(dto.getStudy_peoples());
		sdto.setStudy_level(dto.getStudy_level());
		sdto.setStudy_intr(dto.getStudy_intr());
		sdto.setStudy_goal(dto.getStudy_goal());
		sdto.setStudy_progress(dto.getStudy_progress());
		sdto.setStudy_address(dto.getStudy_address());
		sdto.setStudy_detailaddr(dto.getStudy_detailaddr());
		sdto.setStudy_writer(dto.getStudy_writer());
		
		SpringFileWrite sfw = new SpringFileWrite();
		MultipartFile file = dto.getUploadfile();
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		System.out.println("path="+path);
		String filename = sfw.writeFile(file, path);
		System.out.println("filename="+filename);
		sdto.setStudy_mainimage(filename);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		service.insertStudy(sdto);
		map.put("studygroup_study_num", service.selectNumOfNewestStudy());
		map.put("studygroup_member_num", dto.getStudy_writer_num());
		studygroupservice.insertStudyGroup(map);
	}
	
	@GetMapping("/study/list")
	public Map<String, Object> selectOfStudyList() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<StudyDto> list = service.selectOfStudyList();
		List<String> profilelist = new ArrayList<String>();
		List<Integer> countlist = new ArrayList<Integer>();
		map.put("listdata", list);
		for(int i = 0; i < list.size(); i++) {
			profilelist.add(i,memberservice.selectOneMember(list.get(i).getStudy_member_num()).getMember_profile());
			countlist.add(i, studygroupservice.selectCountOfStudyGroupPeoples(list.get(i).getStudy_num()));
		}
		map.put("profilelist", profilelist);
		map.put("countlist", countlist);
		
		return map;
	}
	
	@GetMapping("/study/detail")
	public Map<String, Object> selectOfStudyDtail(@RequestParam int study_num) {
		StudyDto dto = service.selectOfStudyByNum(study_num);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("studydata", dto);
		map.put("study_writer_num", dto.getStudy_member_num());
		
		service.updateOfStudyReadCount(study_num);
		
		return map;
	}
	
	@GetMapping("/study/founder")
	public List<StudyDto> selectOfStudyFounder(@RequestParam int study_member_num) {
		List<StudyDto> list = service.selectOfStudyFounder(study_member_num);
		
		return list;
	}
	
	@DeleteMapping("/study/delete")
	public void deleteOfStudy(@RequestParam int study_num, HttpServletRequest request) {
		service.deleteOfStudy(study_num);
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		String filename = service.selectOfStudyByNum(study_num).getStudy_mainimage();
		File file = new File(path + "\\" + filename);
		if(file.exists())
			file.delete();
		System.out.println("스터디 삭제");
	}
	
	@PostMapping("/study/update")
	public void updateOfStudy(@ModelAttribute StudyDto dto, HttpServletRequest request) {
		StudyDto sdto = new StudyDto();
		String gather = "";
		
		sdto.setStudy_num(dto.getStudy_num());
		sdto.setStudy_type(dto.getStudy_type());
		sdto.setStudy_subject(dto.getStudy_subject());
		sdto.setStudy_startdate(dto.getStudy_startdate());
		sdto.setStudy_enddate(dto.getStudy_enddate());
		for(String s:dto.getStudy_gatherdayname())
			gather += s + ", ";
		gather = gather.substring(0, gather.length()-2);
		sdto.setStudy_gatherday(gather);
		sdto.setStudy_peoples(dto.getStudy_peoples());
		sdto.setStudy_level(dto.getStudy_level());
		sdto.setStudy_intr(dto.getStudy_intr());
		sdto.setStudy_goal(dto.getStudy_goal());
		sdto.setStudy_progress(dto.getStudy_progress());
		sdto.setStudy_address(dto.getStudy_address());
		sdto.setStudy_detailaddr(dto.getStudy_detailaddr());
		
		SpringFileWrite sfw = new SpringFileWrite();
		if(dto.getUploadfile() != null) {
			MultipartFile file = dto.getUploadfile();
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
			System.out.println("path="+path);
			String filename = sfw.writeFile(file, path);
			if(dto.getStudy_oldmainimage() != filename) {
				File oldfile = new File(path + "\\" + dto.getStudy_oldmainimage());
				if(oldfile.exists())
					oldfile.delete();
				System.out.println("기존 이미지 제거");
			}
			System.out.println("filename="+filename);
			sdto.setStudy_mainimage(filename);
		} else {
			sdto.setStudy_mainimage(dto.getStudy_mainimage());
		}
		
		service.updateOfStudy(sdto);
		
		System.out.println("데이터 수정 성공");
	}
}