package member.data;

import java.util.HashMap;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao extends SqlSessionDaoSupport implements MemberDaoInter{

	@Override
	public void insertMember(MemberDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfMember",dto);
		
	}

	@Override
	public void updateMember(MemberDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfMember", dto);
		
	}

	@Override
	public void deleteMember(MemberDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfMember",dto);
	}
	//아이디 값 가져오기
	@Override
	public MemberDto selectOneMember(int membernum) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("SelectOneOfMember", membernum);
	}

	@Override
	public MemberDto searchMember(String field, String searchtxt) {
		// TODO Auto-generated method stub
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("field",field);
		map.put("searchtxt",searchtxt);
		return getSqlSession().selectOne("SearchOfMember",map);
	}
	
	@Override
	public int checkid(String member_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("checkIdOfMember",member_id);
	}

	@Override
	public int isCheckPass(String member_id, String member_password) {
		// TODO Auto-generated method stub
		HashMap<String, String> map =new HashMap<String, String>();
		map.put("member_id", member_id);
		map.put("member_password",member_password);
		return getSqlSession().selectOne("checkPassOfMember",map);
	}

	@Override
	public MemberDto selectNameMember(String member_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("SelectNameofMemeber",member_id);
	}

	@Override
	public int idCheckMember(String member_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("idCheckMember",member_id);
	}
	
	

}
