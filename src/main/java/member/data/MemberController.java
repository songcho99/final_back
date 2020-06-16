package member.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import upload.util.ManageFileClass;

import sms.data.ExampleSend;

@RestController
@CrossOrigin
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private JavaMailSender mailsender;
	
	//로그인
	@PostMapping("/login/loginck")
	public Map<String,String> loginck(@RequestParam String member_id, @RequestParam String member_password
			,@RequestParam(required=false) String idsave,HttpSession session)
	{
		Map<String, String> map = new HashMap<String, String>();
		if(service.isCheckPass(member_id, member_password))
		{
		
		System.out.println("id:"+member_id+",pw:"+member_password);
		System.out.println("react>>login ");
		
		map.put("member_name",service.selectNameMember(member_id).getMember_name());
		map.put("success","success");
		return map;
		}
		else
		{
			System.out.println("react>>login fail");
			map.put("fail","fail");
			return map;
		}
	}
	
	//아이디 중복확인
	@GetMapping("/member/idcheck")
	public int idcheck(@RequestParam String id)
	{
		System.out.println("react >> idcheck"+","+id);
		
		int idcheck = service.checkId2(id);
		System.out.println("idcheck:"+idcheck);
		
		return idcheck;
	}
	
	//회원가입 -회원 추가
	@PostMapping("/member/insert")
	public void insertMember(@RequestParam String member_name,
			@RequestParam String member_id,
			@RequestParam String member_password,
			@RequestParam String member_phone,
			@RequestParam String member_email,
			@RequestParam String member_address,
			@RequestParam String member_detailaddr
			)
	{
		MemberDto memberdto = new MemberDto();
		
		memberdto.setMember_name(member_name);
		memberdto.setMember_id(member_id);
		memberdto.setMember_password(member_password);
		memberdto.setMember_phone(member_phone);
		memberdto.setMember_email(member_email);
		memberdto.setMember_address(member_address);
		memberdto.setMember_detailaddr(member_detailaddr);
		
		System.out.println("react >> insert, "+ memberdto.getMember_id());
		
		service.insertMember(memberdto);
	}
	
	//아이디 찾기 위한 정보 확인
	@PostMapping("/check/checkId")
	public int checkId(@RequestParam String member_name, String member_email, String member_phone)
	{
		int cnt=0;
		System.out.println("react>>checkId");
		System.out.println(member_name);
		System.out.println(member_email);
		System.out.println(member_phone);
		cnt=service.selectCountId(member_name, member_email, member_phone);
		System.out.println(cnt);
		return cnt;
	}
	
	//비밀번호 재설정을 위한 정보 확인
	@PostMapping("/check/checklogin")
	public int checklogin(@RequestParam String member_name, String member_id, String member_phone)
	{
		int cnt=0;
		System.out.println("react>>checklogin");
		System.out.println(member_name);
		System.out.println(member_id);
		System.out.println(member_phone);
		cnt=service.selectCount(member_name, member_id, member_phone);
		System.out.println(cnt);
		return cnt;
	}
	
	//비밀번호 재설정
	@PostMapping("/check/updatepassword")
	public void updatePassword(@RequestParam String member_id, String member_password)
	{
		System.out.println("react>>updatepassword");
		service.updatePassword(member_id, member_password);
	}
	
	//인증번호 문자 발송
	@PostMapping("/check/checknum")
	public String checknum(@RequestParam String member_phone)
	{
		System.out.println("react>>checknum");
		String randomsu="";
		MemberDto cdto=service.admin();
		String adminhp=cdto.getMember_phone();
		
		for(int i=0;i<6;i++)
		{
			int nansu=(int)(Math.random()*10);
			randomsu+=Integer.toString(nansu);
		}
		System.out.println(member_phone);
		
		ExampleSend send=new ExampleSend();
		send.sendSms(randomsu, member_phone, adminhp);
		
		return randomsu;
	}
	
	//아이디 메일 발송
	@PostMapping("/check/emailId")
	public void emailId(@RequestParam String member_email)
	{
		System.out.println("react>>emailId");
		System.out.println(member_email);
		String member_id=service.selectId(member_email);
		String email_content=member_id.substring(0, member_id.length()-2)+"**";
		String content="회원님의 Id는 "+email_content+"입니다.";
		
		MimeMessage message=mailsender.createMimeMessage();
		try {
		
			message.setSubject("IT Campus 아이디 확인");//메일제목
			message.setText(content);//메일본문
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(member_email));//보낼 메일주소
			mailsender.send(message);//메일전송

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("mail error="+e.getMessage());
		}

	}
	
}