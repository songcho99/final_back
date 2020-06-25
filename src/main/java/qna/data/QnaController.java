package qna.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import member.data.MemberDaoInter;

@RestController
@CrossOrigin
public class QnaController {
	
	@Autowired
	private QnaDaoInter qdao;
	
	@Autowired
	private MemberDaoInter mdao;
	
	//list
	@GetMapping("/qna/qnalist")
	public Map<String, Object> getlist()
	{
		System.out.println("react>>QnA list");
		Map<String, Object> map=new HashMap<String, Object>();
		List<QnaDto> qlist=qdao.getAlllist();
		map.put("qdto",qlist);
		
		List<String> mlist=new Vector<String>();
		for(int i=0;i<qlist.size();i++)
		{
			mlist.add(mdao.selectOneMember(qlist.get(i).getQna_member_num()).getMember_name());
		}
		map.put("member_name",mlist);
		return map;
	}
	
	//add
	@PostMapping("/qna/qnaadd")
	public void insertQna(@ModelAttribute QnaDto dto)
	{
		System.out.println("react>>QnA add");
		qdao.insertQna(dto);
	}
	
	//detail
	@GetMapping("/qna/qnadetail")
	public QnaDto detailQna(@RequestParam int qna_num)
	{
		System.out.println("react>>QnA detail");
		qdao.updateReadCount(qna_num);
		QnaDto qdto=qdao.getData(qna_num);
		String member_name=mdao.selectOneMember(qdto.getQna_member_num()).getMember_name();
		qdto.setQna_member_name(member_name);
		return qdto;
	}
	
	//delete
	@GetMapping("/qna/qnadelete")
	public void deleteQna(@RequestParam int qna_num)
	{
		System.out.println("react>>QnA delete");
		qdao.deleteQna(qna_num);
	}
	
	//update
	@PostMapping("/qna/qnaupdate")
	public void updateQna(@ModelAttribute QnaDto dto)
	{
		System.out.println("react>>QnA update");
		System.out.println(dto);
		qdao.updateQna(dto);
	}
}
