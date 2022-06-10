package co.jin.bootstraptest.Notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jin.bootstraptest.Notice.vo.NoticeVO;

public interface NoticeMapper {
	
	List<NoticeVO> noticeSelectList(); // 전체조회
	// 매퍼인터페이스에서 두개이상의 인자를 전달할때 어노테이션 파람을 써야함.
	List<NoticeVO> noticeSearchList(@Param("key") String key,@Param("val") String val); // 검색?
	NoticeVO noticeSelect(NoticeVO vo); // 상세조회
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);

	int noticeHitUpdate(int id); // 조회수 증가

}
