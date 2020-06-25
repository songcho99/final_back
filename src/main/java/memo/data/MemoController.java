package memo.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MemoController {

	@Autowired
	private MemoServiceInter service;
	
	@GetMapping("/memo/list")
	public List<MemoDto> getMemoList(int member_num)
	{
		System.out.println("react >> memo/list");
		List<MemoDto> memolist = service.getMemoList(member_num);
		
		return memolist;
	}
	
	@RequestMapping(value="/memo/insert",method=RequestMethod.POST)
	public void insertMemo(@ModelAttribute MemoDto memodto)
	{
		System.out.println("react >> memo/insert");
		
		service.insertMemo(memodto);
	}
	
}
