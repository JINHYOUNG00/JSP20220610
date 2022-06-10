package co.jin.bootstraptest.Notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jin.bootstraptest.Notice.service.NoticeMapper;
import co.jin.bootstraptest.Notice.service.NoticeService;
import co.jin.bootstraptest.Notice.vo.NoticeVO;
import co.jin.bootstraptest.comm.DataSource;

public class NoticeServiceImpl implements NoticeService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public List<NoticeVO> noticeSearchList(String key, String val) {
		// TODO Auto-generated method stub
		return map.noticeSearchList(key, val);
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeDelete(vo);
	}

	@Override
	public int noticeHitUpdate(int id) {
		// TODO Auto-generated method stub
		return map.noticeHitUpdate(id);
	}

}
