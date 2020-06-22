package notice.data;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.runtime.directive.Parse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mysql.jdbc.PreparedStatement.ParseInfo;

import files.data.FilesDto;
import files.data.NoticefilesDao;
import files.data.NoticefilesDaoInter;

@RestController
@CrossOrigin
public class NoticeController {
	
	@Autowired
	private NoticeDaoInter ndao;
	
	@Autowired
	private NoticefilesDaoInter fdao;
	
	
	//����Ʈ ���
	@GetMapping("/notice/noticelist")
	public List<NoticeDto> listNotice()
	{
		List<NoticeDto> list=ndao.AllNotice();
		return list;
	}
	
	//insert
	@RequestMapping(value="/notice/noticeadd", consumes= {"multipart/form-data"},method = RequestMethod.POST)
	public void insertNotice(@ModelAttribute NoticeDto ndto,MultipartHttpServletRequest request)
	{
		System.out.println("react>>noticeadd");
		System.out.println(ndto.toString());
		for(MultipartFile f:ndto.getNotice_file())
		{
			System.out.println(f.getOriginalFilename());
		}
		//notice add
		ndao.insertNotice(ndto);
		int maxNum=ndao.maxNumNotice();
		System.out.println("maxnum="+maxNum);
		//file add
		fdao.insertFile(request, ndto.getNotice_file(), maxNum);
		
	}
	
	//���� ��ȸ-�������� ��
	@GetMapping("/notice/noticedetail")
	public NoticeDto getNotice(@RequestParam int num)
	{
		System.out.println("react>>noticedetail");
		ndao.readCount(num);
		NoticeDto dto=ndao.getNotice(num);
		System.out.println(dto);
		return dto;
	}
	//���� ��ȸ -����
	@GetMapping("/notice/noticefile")
	public List<String> getnoticeFile(@RequestParam int num)
	{
		List<String> list=fdao.selectnoticeFile(num);
		return list;
	}
	
	//����
	@GetMapping("/notice/noticedelete")
	public void deleteNotice(@RequestParam int num, HttpServletRequest request)
	{
		System.out.println("react>>noticedelete");
		//���ε��� ���
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		//���ε��� ���ϸ��� ���ϱ�
		List<String> list=fdao.selectnoticeFile(num);
		System.out.println(list.size());
		//���� ����
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i));
				File file=new File(path+"\\"+list.get(i));
				if(file.exists())
					file.delete();
			}
		}else {
		}
		ndao.deleteNotice(num);
	}
}