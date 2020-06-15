package member.data;

public interface MemberDaoInter {
	
	public void insertMember(MemberDto dto);
	public void updateMember(MemberDto dto);
	public void deleteMember(MemberDto dto);
	
	public MemberDto selectOneMember(int membernum);
	public MemberDto selectNameMember(String member_id);
	
	public MemberDto searchMember(String field, String searchtxt);
	
	
	public int checkid(String member_id);
	public int isCheckPass(String member_id,String member_password);
	

}
