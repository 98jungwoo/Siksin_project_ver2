package woo.siksin.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import woo.siksin.hander.SiksinHandlerAdapter;

public interface Controller {

	public SiksinHandlerAdapter execute(HttpServletRequest request, HttpServletResponse response);
	
}
