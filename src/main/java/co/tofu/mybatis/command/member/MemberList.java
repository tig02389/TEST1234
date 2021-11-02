package co.tofu.mybatis.command.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.tofu.mybatis.comm.Command;
import co.tofu.mybatis.service.member.MemberService;
import co.tofu.mybatis.service.member.MemberVO;
import co.tofu.mybatis.service.member.Impl.MemberServiceImpl;

public class MemberList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberService memberDao = new MemberServiceImpl();
		list = memberDao.memberSelectList();
		request.setAttribute("members", list);
		return "member/memberlist";
	}
}
