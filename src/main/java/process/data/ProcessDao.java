package process.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import member.data.MemberDto;

@Repository
public class ProcessDao extends SqlSessionDaoSupport implements ProcessDaoInter{

	@Override
	public List<MemberDto> searchTeacher() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("searchTeacher");
	}

	@Override
	public void insertProcess(ProcessDto processdto) {
		
		getSqlSession().insert("insertProcess",processdto);
		
	}

	@Override
	public int selectProcessMaxnum() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectProcessMaxnum");
	}
}
