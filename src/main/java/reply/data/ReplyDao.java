package reply.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDao extends SqlSessionDaoSupport implements ReplyDaoInter {
	@Override
	public void insertOfReply(ReplyDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfReply", dto);
	}
	
	@Override
	public int selectOfReplyMaxnum() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOfReplyMaxnum");
	}
	
	@Override
	public void updateRestepOfReply(int reply_regroup, int reply_restep) {
		// TODO Auto-generated method stub
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("reply_regroup", reply_regroup);
		map.put("reply_restep", reply_restep);
		getSqlSession().update("updateRestepOfReply", map);
	}
	
	@Override
	public List<ReplyDto> selectOfReply() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfReply");
	}
	
//	@Override
//	public int totalCountOfReply() {
//		// TODO Auto-generated method stub
//		return getSqlSession().sele;
//	}
}
