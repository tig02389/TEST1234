package co.tofu.mybatis.service.member;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList();

	MemberVO memberSelect(MemberVO vo);

	int memberInsert(MemberVO vo);

	int memberUpdate(MemberVO vo);

	int memberDlelte(MemberVO vo);
}
