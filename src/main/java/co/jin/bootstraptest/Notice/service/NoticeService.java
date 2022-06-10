package co.jin.bootstraptest.Notice.service;

import java.util.List;

import co.jin.bootstraptest.Notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(); // 전체조회
	List<NoticeVO> noticeSearchList(String key, String val); // 검색?
	NoticeVO noticeSelect(NoticeVO vo); // 상세조회
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);

	int noticeHitUpdate(int id); // 조회수 증가
}
