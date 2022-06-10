package co.jin.bootstraptest.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jin.bootstraptest.comm.Command;

public class Home implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		// 홈페이지를 보여줌
		return "home/home";
	}

}
