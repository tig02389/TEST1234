package co.tofu.mybatis.service.notice.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.tofu.mybatis.comm.DataSource;
import co.tofu.mybatis.service.notice.NoticeMapper;
import co.tofu.mybatis.service.notice.NoticeService;
import co.tofu.mybatis.service.notice.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); // 디비 연결,오토커밋
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);		// 매퍼 활용

	
	@Override
	public List<NoticeVO> noticeSelectList(NoticeVO vo) {
		return map.noticeSelectList(vo);
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int hitUpdate(NoticeVO vo) {
		return map.hitUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}
	@Override
	public int noticeSelectDelete(String[] list) {
		return map.noticeSelectDelete(list);
	}

}
