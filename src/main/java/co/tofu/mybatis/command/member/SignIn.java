package co.tofu.mybatis.command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.tofu.mybatis.comm.Command;
import co.tofu.mybatis.service.member.MemberService;
import co.tofu.mybatis.service.member.MemberVO;
import co.tofu.mybatis.service.member.Impl.MemberServiceImpl;

public class SignIn implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		vo.setId(request.getParameter("id"));
		vo.setPwd(request.getParameter("pwd"));
		MemberService memberDao = new MemberServiceImpl();
		vo = memberDao.memberSelect(vo);
		if (vo != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			request.setAttribute("member", vo);
			return "member/memberLoginSuccess";
		} else {
			request.setAttribute("message", "아이디 혹은 비밀번호를 확인해주세요");
			return "member/memberFail";
		}
		//return "member/memberLoginFail";
	}

}
