package co.jin.bootstraptest.Notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.jin.bootstraptest.Notice.service.NoticeService;
import co.jin.bootstraptest.Notice.serviceImpl.NoticeServiceImpl;
import co.jin.bootstraptest.Notice.vo.NoticeVO;
import co.jin.bootstraptest.comm.Command;

public class AjaxSearchList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 검색
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		ObjectMapper mapper = new ObjectMapper();
		
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		list = dao.noticeSearchList(key, val);
		String jsonData="";
		
			try {
				jsonData=mapper.writeValueAsString(list);   // 리스트를 json String으로
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
		return "ajax:" + jsonData;
	}

}
