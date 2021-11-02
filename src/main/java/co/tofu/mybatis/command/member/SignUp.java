package co.tofu.mybatis.command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.tofu.mybatis.comm.Command;
import co.tofu.mybatis.service.member.MemberService;
import co.tofu.mybatis.service.member.MemberVO;
import co.tofu.mybatis.service.member.Impl.MemberServiceImpl;

public class SignUp implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberVO vo = new MemberVO();
		MemberService dao = new MemberServiceImpl();
		vo.setId(request.getParameter("id"));
		System.out.println(vo.getId());
		vo = dao.memberSelect(vo);
		String viewpage="";
		if(vo != null) {
			request.setAttribute("message","중복된 ID 입니다.");
			viewpage = "member/memberFail";
		}else{
			vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPwd(request.getParameter("pwd"));	
			vo.setName(request.getParameter("name"));
			vo.setAddr(request.getParameter("addr"));
			vo.setPhone(request.getParameter("phone"));
			vo.setAuthor(request.getParameter("author"));
			dao.memberInsert(vo);
			viewpage = "signIn.do";
		};
		return viewpage;
	}

}
