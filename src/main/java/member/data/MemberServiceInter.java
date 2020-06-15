package member.data;

public interface MemberServiceInter {
	//회원 가입(회원 추가)
	public void insertMember(MemberDto dto);
	//회원 정보 수정
	public void updateMember(MemberDto dto);
	//회원 삭제
	public void deleteMember(MemberDto dto);
	//회원 num으로 회원 조회
	public MemberDto selectOneMember(int membernum);
	//회원 id로 회원 조회
	public MemberDto selectNameMember(String member_id);
	//회원 검색
	public MemberDto searchMember(String field, String searchtxt);
	//회원 id있는지 조회
	public boolean checkId(String member_id); //성현
	public int checkId2(String member_id); //용우
	//로그인- id, password로 확인
	public boolean isCheckPass(String member_id,String member_password);

}
