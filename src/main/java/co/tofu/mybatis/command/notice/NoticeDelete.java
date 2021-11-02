package co.tofu.mybatis.command.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.tofu.mybatis.comm.Command;
import co.tofu.mybatis.service.notice.NoticeService;
import co.tofu.mybatis.service.notice.NoticeVO;
import co.tofu.mybatis.service.notice.Impl.NoticeServiceImpl;

public class NoticeDelete implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeVO vo = new NoticeVO();
		NoticeService dao = new NoticeServiceImpl();
		vo.setNo(Integer.valueOf(request.getParameter("no")));
		dao.noticeDelete(vo);
		return "noticeList.do";
	}

}
