package processclass.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import process.data.ProcessDto;
import process.data.ProcessServiceInter;

@RestController
@CrossOrigin
public class ProcessClassController {

	@Autowired
	ProcessServiceInter processService;
	
	@Autowired
	ProcessClassServiceInter service;
	
	@GetMapping("/processclass/check")
	public int checkProcessClass(@RequestParam int processclass_process_num,
			@RequestParam int processclass_member_num) {
		
		int check = 0;
		
		check = service.checkProcessClass(processclass_process_num,processclass_member_num);
		
	
		return check;
	}
	
	
	@PostMapping("/processclass/insert")
	public void insertProcessClass(@ModelAttribute ProcessClassDto processclassdto) {
		
		System.out.println(processclassdto);
		System.out.println("react >> processclass/insert");
		
		ProcessDto processdto = processService.selectOneProcess(processclassdto.getProcessclass_process_num());
		
		
		service.updateMemberType(processclassdto.getProcessclass_member_num(),processdto.getProcess_subject());
		service.insertProcessClass(processclassdto);
		
	}
}
