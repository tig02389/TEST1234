package co.tofu.mybatis.command.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.tofu.mybatis.comm.Command;
import co.tofu.mybatis.service.notice.NoticeService;
import co.tofu.mybatis.service.notice.NoticeVO;
import co.tofu.mybatis.service.notice.Impl.NoticeServiceImpl;

public class NoticeInsert implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeVO vo = new NoticeVO();
		NoticeService dao = new NoticeServiceImpl();
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setContent(request.getParameter("content"));
		vo.setTitle(request.getParameter("title"));
		vo.setWriteDate(request.getParameter("writeDate"));
		dao.noticeInsert(vo);
//		return "noticeList.do";
		return "notice/noticeInsertSuccess";
	}

}
