package studyfeed.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import files.data.StudyFeedFilesDaoInter;
import member.data.MemberDto;
import reply.data.ReplyServiceInter;
import studygroup.data.StudyGroupServiceInter;

@RestController
@CrossOrigin
public class StudyFeedController {
	@Autowired
	private StudyFeedServiceInter service;
	
	@Autowired
	private StudyFeedFilesDaoInter filesdao;
	
	@Autowired
	private StudyGroupServiceInter groupservice;
	
	@Autowired
	private ReplyServiceInter replyservice;
	
	@GetMapping("/studyfeed/member")
	public Map<String, Object> getStudyMember(@RequestParam int studyfeed_studygroup_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MemberDto> memberlist = new ArrayList<MemberDto>();
		
		int membercount = groupservice.selectCountOfStudyGroupPeoples(studyfeed_studygroup_num);
		memberlist = groupservice.selectOfStudyMember(studyfeed_studygroup_num);
		
		map.put("membercount", membercount);
		map.put("memberlist", memberlist);
		
		return map;
	}
	
	@RequestMapping(value="/studyfeed/add", consumes= {"multipart/form-data"},method = RequestMethod.POST)
	public void insertOfStudyFeed(@ModelAttribute StudyFeedDto dto, MultipartHttpServletRequest request) {
		service.insertOfStudyFeed(dto);
		int maxNum = service.maxNumOfStudyFeed();
		System.out.println("max num=" + maxNum);
		
		//file add
		if(dto.getUploadfile()!=null) {			
			for(MultipartFile f:dto.getUploadfile())
			{
				System.out.println(f.getOriginalFilename());
			}
			filesdao.insertFile(request, dto.getUploadfile(), maxNum);
		}
		System.out.println("피드 추가");
	}
	
	@GetMapping("/studyfeed/feedlist")
	public List<StudyFeedDto> selectOfStudyFeedList(@RequestParam int studyfeed_studygroup_num) {
		List<StudyFeedDto> list = service.selectOfStudyFeedList(studyfeed_studygroup_num);
		
		return list;
	}
	
	@GetMapping("/studyfeed/filelist")
	public List<String> selectOfStudyFileList(@RequestParam int studyfeedfiles_studyfeed_num) {
		List<String> list = filesdao.selectStudyFeedFile(studyfeedfiles_studyfeed_num);
		
		return list;
	}
}
