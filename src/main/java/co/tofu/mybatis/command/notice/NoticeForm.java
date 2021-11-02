package co.tofu.mybatis.command.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.tofu.mybatis.comm.Command;
import co.tofu.mybatis.service.member.MemberVO;

public class NoticeForm implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		HttpSession se = request.getSession();
		MemberVO vo = new MemberVO();
		vo.setId(String.valueOf(se.getAttribute("id")));
		vo.setName(String.valueOf(se.getAttribute("name")));
		request.setAttribute("member", vo);
		return "notice/noticeForm";
	}

}
