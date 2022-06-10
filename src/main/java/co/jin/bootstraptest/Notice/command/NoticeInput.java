package co.jin.bootstraptest.Notice.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.jin.bootstraptest.Notice.service.NoticeService;
import co.jin.bootstraptest.Notice.serviceImpl.NoticeServiceImpl;
import co.jin.bootstraptest.Notice.vo.NoticeVO;
import co.jin.bootstraptest.comm.Command;

public class NoticeInput implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 저장
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		String saveDir = "c:\\Temp\\";// 실제 저장할 공간
		int size = 1024*1024*1024;  // 파일 최대 사이즈
		String dirFile = "";
		String originalFile  = "";
		try {
			MultipartRequest multi = new MultipartRequest(
															request,
															saveDir,
															size,
															"utf-8",
															new DefaultFileRenamePolicy());
			dirFile = multi.getFilesystemName("file"); // 물리공간에 저장될 파일명
			originalFile = multi.getOriginalFileName("file"); // 실제 파일명
			
			vo.setWriter(multi.getParameter("writer"));
			vo.setWdate(Date.valueOf(multi.getParameter("wdate")));
			vo.setTitle(multi.getParameter("title"));
			vo.setSubject(multi.getParameter("subject"));
			vo.setFileName(originalFile);
			vo.setDirFileName(dirFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = dao.noticeInsert(vo);
		if(n!=0) {
			request.setAttribute("message", "정상입력");
		} else {
			request.setAttribute("message", "입력실패");
		}
		return "notice/noticeMessage";
	}

}
