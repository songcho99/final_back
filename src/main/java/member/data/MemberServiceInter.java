package member.data;

public interface MemberServiceInter {
	public void insertMember(MemberDto dto);
	public void updateMember(MemberDto dto);
	public void deleteMember(MemberDto dto);
	
	public MemberDto selectOneMember(int membernum);
	public MemberDto searchMember(String field, String searchtxt);
	public MemberDto selectNameMember(String member_id);
	
	public boolean checkId(String member_id);
	public boolean isCheckPass(String member_id,String member_password);

}
