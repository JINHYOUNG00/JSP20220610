package co.jin.bootstraptest.Notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jin.bootstraptest.Notice.service.NoticeService;
import co.jin.bootstraptest.Notice.serviceImpl.NoticeServiceImpl;
import co.jin.bootstraptest.Notice.vo.NoticeVO;
import co.jin.bootstraptest.comm.Command;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 목록 가져오기
		
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>(); // 결과를 받을 목록 생성
		
		list = dao.noticeSelectList();
		request.setAttribute("list", list);
		
		
		
		return "notice/noticeList";
	}

}
