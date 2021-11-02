package co.tofu.mybatis.command.notice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.tofu.mybatis.comm.Command;
import co.tofu.mybatis.service.notice.NoticeService;
import co.tofu.mybatis.service.notice.NoticeVO;
import co.tofu.mybatis.service.notice.Impl.NoticeServiceImpl;

public class NoticeSelectSearch implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeVO vo = new NoticeVO();
		NoticeService noticeDao = new NoticeServiceImpl();
		List<NoticeVO> lists = new ArrayList<NoticeVO>();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		System.out.println(request.getParameter("what"));
		if (request.getParameter("what") != null) {
			request.setAttribute("what", request.getParameter("what"));
			request.setAttribute("sea", request.getParameter("sea"));
			if (request.getParameter("what").equals("number")) {
				vo.setNo(Integer.valueOf(request.getParameter("sea")));
			} else if (request.getParameter("what").equals("title")) {
				vo.setTitle(request.getParameter("sea"));
			} else if (request.getParameter("what").equals("author")) {
				vo.setName(request.getParameter("sea"));
			}
		}
		lists = noticeDao.noticeSelectList(vo);
		int rno;
		if (request.getParameter("rno") == null) {
			rno = 1;
		} else {
			rno = Integer.valueOf(request.getParameter("rno"));
		}
		vo.setRno(rno);
		list = noticeDao.noticeSelectList(vo);

		request.setAttribute("notices", list);
		request.setAttribute("noticess", lists);

		return "notice/noticeSearchList";
	}

}
