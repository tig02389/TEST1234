package co.tofu.mybatis.command.notice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.tofu.mybatis.comm.Command;
import co.tofu.mybatis.service.notice.NoticeService;
import co.tofu.mybatis.service.notice.NoticeVO;
import co.tofu.mybatis.service.notice.Impl.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeVO vo = new NoticeVO();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		List<NoticeVO> lists = new ArrayList<NoticeVO>();
		NoticeService noticeDao = new NoticeServiceImpl();
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

		return "notice/noticeList";
	}

}
