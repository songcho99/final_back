package memo.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDao extends SqlSessionDaoSupport implements MemoDaoInter{

	@Override
	public List<MemoDto> getMemoList(int member_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("getMemoList",member_num);
	}

	@Override
	public void insertMemo(MemoDto memodto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertMemo",memodto);
	}

}
