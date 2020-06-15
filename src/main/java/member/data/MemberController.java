package member.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MemberController {
	
	@Autowired
	private MemberServiceInter service;
	
	@GetMapping("/member/idcheck")
	public int idcheck(@RequestParam String id)
	{
		System.out.println("react >> idcheck"+","+id);
		
		int idcheck = service.idCheckMember(id);
		System.out.println("idcheck:"+idcheck);
		
		return idcheck;
	}
	
	@PostMapping("/member/insert")
	public void insertMember(@RequestBody MemberDto memberdto)
	{
		System.out.println("react >> insert, "+ memberdto.getMember_id());
		
		service.insertMember(memberdto);
	}
	
	
	
}