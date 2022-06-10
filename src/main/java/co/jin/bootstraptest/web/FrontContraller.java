package co.jin.bootstraptest.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.Printer;

import co.jin.bootstraptest.Notice.command.AjaxSearchList;
import co.jin.bootstraptest.Notice.command.NoticeInput;
import co.jin.bootstraptest.Notice.command.NoticeInputForm;
import co.jin.bootstraptest.Notice.command.NoticeList;
import co.jin.bootstraptest.comm.Command;
import co.jin.bootstraptest.home.Home;

@WebServlet("*.do")
public class FrontContraller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();  //// 1
    public FrontContraller() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		//실행 명령 두는곳
		map.put("/home.do", new Home());  // 처음들어오는 곳 처리     //10    //11홈 커멘드 만들어줘야함
		map.put("/noticeInputForm.do", new NoticeInputForm());  
		map.put("/noticeInput.do", new NoticeInput());  // 게시글 저장     //10    //11홈 커멘드 만들어줘야함
		map.put("/noticeList.do", new NoticeList());  // 게시글 저장     //10    //11홈 커멘드 만들어줘야함
		map.put("/ajaxSearchList.do", new AjaxSearchList());  // 게시글 검색     //10    //11홈 커멘드 만들어줘야함
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청분석, 실행 및 결과를 리턴하는 곳
		request.setCharacterEncoding("utf-8"); // 2 한글깨짐방지
		String uri = request.getRequestURI(); // 3
		String contextPath = request.getContextPath(); //4
		String page = uri.substring(contextPath.length()); //5
		
		Command command = map.get(page); //6
		String viewPage = command.exec(request, response); //7
		
		if (!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				viewPage = viewPage.substring(5);
				response.getWriter().append(viewPage);
				return;
				//ajax처리
			} else {
//				viewPage = viewPage + ".tiles";    //8
				viewPage = "/WEB-INF/views/"+ viewPage + ".jsp";    //8
				
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //8
		dispatcher.forward(request, response);  //9
	}

}
