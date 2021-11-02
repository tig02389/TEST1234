package co.tofu.mybatis.service.member.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.tofu.mybatis.comm.DataSource;
import co.tofu.mybatis.service.member.MemberMapper;
import co.tofu.mybatis.service.member.MemberService;
import co.tofu.mybatis.service.member.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); // 디비 연결,오토커밋
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);		// 매퍼 활용
	@Override
	public List<MemberVO> memberSelectList() {
//		return sqlSession.selectList("memberSelectList"); // 매핑 안했을때
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDlelte(MemberVO vo) {
		return map.memberDlelte(vo);
	}

}
