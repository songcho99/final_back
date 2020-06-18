package process.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import books.data.BooksDto;
import member.data.MemberDto;
import upload.util.ReadBooksList;

@RestController
@CrossOrigin
public class ProcessController {
	
	@Autowired
	private ProcessServiceInter service;
	
	@GetMapping("/process/searchTeacher")
	public List<MemberDto> searchTeacher()
	{
	
		System.out.println("react >> searchTeacher");
		
		return service.searchTeacher();
	}
	
	@GetMapping("/process/getBooksList")
	public List<BooksDto> getBooksList()
	{
		System.out.println("react >> getBooksList");
		List<List<String>> bookslist = new ReadBooksList().readBooks();
		
		List<BooksDto> list = new ArrayList<BooksDto>();
		
		for(List<String> s : bookslist)
		{
			BooksDto dto = new BooksDto();
			for(int i=0; i<s.size(); i++)
			{
				dto.setBooks_brand(s.get(1));
				dto.setBooks_name(s.get(4));
				dto.setBooks_writer(s.get(5));
				
			}
			list.add(dto);
		}
		
		
		return list;
	}
	
	@PostMapping("/process/insert")
	public int insertProcess(@ModelAttribute ProcessDto processdto)
	{
		System.out.println("react >> processInsert");
		processdto.setProcess_member_num(1);
		
		service.insertProcess(processdto);
		
		int maxnum = service.selectProcessMaxnum();
				
		
		return 0;
	}
	
	
}
