package co.tofu.mybatis.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.tofu.mybatis.comm.Command;
import co.tofu.mybatis.command.homeCommand;
import co.tofu.mybatis.command.member.InfoEdit;
import co.tofu.mybatis.command.member.MemberList;
import co.tofu.mybatis.command.member.MyPage;
import co.tofu.mybatis.command.member.SignIn;
import co.tofu.mybatis.command.member.SignInForm;
import co.tofu.mybatis.command.member.SignOut;
import co.tofu.mybatis.command.member.SignUp;
import co.tofu.mybatis.command.member.SignUpForm;
import co.tofu.mybatis.command.notice.NoticeDelete;
import co.tofu.mybatis.command.notice.NoticeEdit;
import co.tofu.mybatis.command.notice.NoticeForm;
import co.tofu.mybatis.command.notice.NoticeInsert;
import co.tofu.mybatis.command.notice.NoticeList;
import co.tofu.mybatis.command.notice.NoticeSelect;
import co.tofu.mybatis.command.notice.NoticeSelectDelete;
import co.tofu.mybatis.command.notice.NoticeSelectSearch;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new homeCommand());
		map.put("/memberList.do", new MemberList());
		map.put("/signInForm.do", new SignInForm());
		map.put("/signIn.do", new SignIn());
		map.put("/signOut.do", new SignOut());
		map.put("/myPage.do", new MyPage());
		map.put("/signUpForm.do", new SignUpForm());
		map.put("/signUp.do", new SignUp());

		map.put("/infoEdit.do", new InfoEdit());

		map.put("/noticeList.do", new NoticeList());
		map.put("/noticeSelect.do", new NoticeSelect());
		map.put("/noticeSelectSearch.do", new NoticeSelectSearch());
		map.put("/noticeEdit.do", new NoticeEdit());
		map.put("/noticeDelete.do", new NoticeDelete());		
		map.put("/noticeForm.do", new NoticeForm());
		map.put("/noticeInsert.do", new NoticeInsert());
		map.put("/noticeSelectDelete.do", new NoticeSelectDelete());
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String conpath = request.getContextPath();
		String page = uri.substring(conpath.length());
		System.out.println(page);

		Command command = map.get(page);
		String viewPage = command.run(request, response);
		System.out.println(viewPage);
		if (!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		RequestDispatcher redis = request.getRequestDispatcher(viewPage);
		redis.forward(request, response);
	}

}
