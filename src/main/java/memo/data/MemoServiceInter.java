package memo.data;

import java.util.List;

public interface MemoServiceInter {

	public List<MemoDto> getMemoList(int member_num);
	public void insertMemo(MemoDto memodto);
}
