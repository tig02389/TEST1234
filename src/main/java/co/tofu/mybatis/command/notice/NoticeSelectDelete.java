package co.tofu.mybatis.command.notice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.tofu.mybatis.comm.Command;
import co.tofu.mybatis.service.notice.NoticeService;
import co.tofu.mybatis.service.notice.NoticeVO;
import co.tofu.mybatis.service.notice.Impl.NoticeServiceImpl;

public class NoticeSelectDelete implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeVO vo = new NoticeVO();
		NoticeService noticeDao = new NoticeServiceImpl();

		String[] a = request.getParameterValues("target");
		noticeDao.noticeSelectDelete(a);
		
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		vo = new NoticeVO();
		list = noticeDao.noticeSelectList(vo);
		List<NoticeVO > lists = noticeDao.noticeSelectList(vo);
		request.setAttribute("notices", list);
		request.setAttribute("noticess", lists);
		return "noticeList.do";
	}

}
