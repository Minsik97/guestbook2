package com.javaex.utill;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtill {

	// 필드

	// 생성자

	// 메소드 g/s

	// 메소드 일반
	// 포워드
	public static void forward(HttpServletRequest request,
												  HttpServletResponse response,
												  String path) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/list.jsp"); // jsp파일 위치
		rd.forward(request, response);
		
	}
	
	
	public static void dforward(HttpServletRequest request,
			  HttpServletResponse response,
			  String path) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/passwordcheck.jsp"); // jsp파일 위치
		rd.forward(request, response);
				  
		
	}
	
	public static void dFforward(HttpServletRequest request,
			  HttpServletResponse response,
			  String path) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/deleteForm.jsp"); // jsp파일 위치
		rd.forward(request, response);		  
		
	}

	// 리다이렉트
	public static void redirect(HttpServletRequest request,
												  HttpServletResponse response,
												  String url) throws IOException {
		
		response.sendRedirect(url);
		
	}
	
	
}
