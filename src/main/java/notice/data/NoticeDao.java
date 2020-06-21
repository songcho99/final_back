package notice.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao extends SqlSessionDaoSupport implements NoticeDaoInter{

	@Override
	public List<NoticeDto> AllNotice() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfNotice");
	}

	@Override
	public void insertNotice(NoticeDto ndto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfNotice", ndto);
	}

	@Override
	public NoticeDto getNotice(int notice_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOneOfNotice", notice_num);
	}

	@Override
	public void updateNotice(NoticeDto ndto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfNotice", ndto);
	}

	@Override
	public void deleteNotice(int notice_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfNotice", notice_num);
	}

	@Override
	public int maxNumNotice() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("maxNumOfNotice");
	}

	@Override
	public void readCount(int notice_num) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateReadCount", notice_num);
	}

	

}
