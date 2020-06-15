package member.data;

public interface MemberServiceInter {
	public void insertMember(MemberDto dto);
	public void updateMember(MemberDto dto);
	public void deleteMember(MemberDto dto);
	
	public MemberDto selectOneMember(int membernum);
	public MemberDto searchMember(String field, String searchtxt);

	public int idCheckMember(String member_id);
}
