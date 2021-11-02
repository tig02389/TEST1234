package co.tofu.mybatis.command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.tofu.mybatis.comm.Command;
import co.tofu.mybatis.service.member.MemberService;
import co.tofu.mybatis.service.member.MemberVO;
import co.tofu.mybatis.service.member.Impl.MemberServiceImpl;

public class MyPage implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		HttpSession se = request.getSession();
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(String.valueOf(se.getAttribute("id")));
		vo=dao.memberSelect(vo);
		request.setAttribute("member", vo);
		return "member/mydata";
	}

}
