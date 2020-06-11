package member.data;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberService implements MemberServiceInter {

		@Autowired
		private MemberDao dao;
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

}
