package member.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class MemberService implements MemberServiceInter {

	@Autowired
	private MemberDaoInter dao;
	
	
	@Override
	public void insertMember(MemberDto dto) {
		// TODO Auto-generated method stub
		dao.insertMember(dto);
	}

	@Override
	public void updateMember(MemberDto dto) {
		// TODO Auto-generated method stub
		dao.updateMember(dto);
	}

	@Override
	public void deleteMember(MemberDto dto) {
		// TODO Auto-generated method stub
		dao.deleteMember(dto);
	}

	@Override
	public MemberDto selectOneMember(int membernum) {
		// TODO Auto-generated method stub
		return dao.selectOneMember(membernum);
	}

	@Override
	public MemberDto searchMember(String field, String searchtxt) {
		// TODO Auto-generated method stub
		return dao.searchMember(field, searchtxt);
	}
	
	@Override
	public boolean checkId(String member_id) {
		// TODO Auto-generated method stub
		return dao.checkid(member_id)==0?false:true;
	}

	@Override
	public boolean isCheckPass(String member_id, String member_password) {
		// TODO Auto-generated method stub
		return dao.isCheckPass(member_id, member_password)==0?false:true;
	}

	@Override
	public MemberDto selectNameMember(String member_id) {
		// TODO Auto-generated method stub
		return dao.selectNameMember(member_id);
	}

	@Override
	public int idCheckMember(String member_id) {
		// TODO Auto-generated method stub
		return dao.idCheckMember(member_id);
	}

}
