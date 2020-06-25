package memo.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoService implements MemoServiceInter{

	@Autowired
	private MemoDaoInter dao;
	
	@Override
	public List<MemoDto> getMemoList(int member_num) {
		// TODO Auto-generated method stub
		return dao.getMemoList(member_num);
	}

	@Override
	public void insertMemo(MemoDto memodto) {
		// TODO Auto-generated method stub
		dao.insertMemo(memodto);
	}

}
