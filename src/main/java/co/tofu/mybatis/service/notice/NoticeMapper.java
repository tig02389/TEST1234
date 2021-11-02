package co.tofu.mybatis.service.notice;

import java.util.List;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList(NoticeVO vo);
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int hitUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeSelectDelete(String[] list);

}
