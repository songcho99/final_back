package reply.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ReplyController {
	@Autowired
	private ReplyServiceInter service;
	
	@PostMapping("/reply/add")
	public void insertOfReply(@RequestBody ReplyDto dto) {
		int regroup, restep, relevel;
		if(dto.getReply_num() == 0)
		{
			regroup = service.selectOfReplyMaxnum()+1;
			restep = 0;
			relevel = 0;
		}else {
			regroup = dto.getReply_regroup();
			if(dto.getReply_restep() != 0)
				service.updateRestepOfReply(regroup, dto.getReply_restep());
			restep = dto.getReply_restep()+1;
			relevel = dto.getReply_relevel()+1;
		}
		
		dto.setReply_regroup(regroup);
		dto.setReply_restep(restep);
		dto.setReply_relevel(relevel);
		
		service.insertOfReply(dto);
	}
	
	@GetMapping("/reply/list")
	public List<ReplyDto> selectOfReply() {
		List<ReplyDto> list = service.selectOfReply();
		for(ReplyDto dto:list)
			System.out.println(dto);
		
		return list;
	}
}
