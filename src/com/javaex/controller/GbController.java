package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@WebServlet("/gbc")
public class GbController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("controller");

		// 파라미터 action 값을 읽어서
		String action = request.getParameter("action");
		System.out.println(action);
		
		if("addList".equals(action)) {
			System.out.println("리스트 처리");
			
			//리스트 출력 처리
			GuestbookDao guestbookDao = new GuestbookDao();
			List<GuestbookVo> guestbookList = guestbookDao.getgdList();
			
			//데이터 전달
			request.setAttribute("gbList", guestbookList);
			
			//jp에 포워드 시킨다.
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/list.jsp");
			rd.forward(request, response);
			
		} else if("add".equals(action)) {
			System.out.println("정보 저장");
			
			//파라미터 값 4개 + 한글깨짐 방지 
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");
			String reg_date = request.getParameter("reg_date");
			
			//guetbookVo로 묶고
			GuestbookVo guestbookVo = new GuestbookVo(name, password, content, reg_date);
			
			//guestbookDao로 저장
			GuestbookDao guestbookDao = new GuestbookDao();
			
			//저장
			guestbookDao.gbInsert(guestbookVo);
			
			//리스트 화면
			response.sendRedirect("/guestbook2/gbc?action=addList");
			
			
		}else if ("delete".equals(action)) {
			System.out.println("삭제");
			
			
			int no = Integer.parseInt(request.getParameter("no"));
			String password = request.getParameter("password");

			GuestbookDao guestbookDao = new GuestbookDao();

			int ex = guestbookDao.gbDelete(no, password);
			
			//no,비밀번호 일치 작업
			if(ex ==1 ) {
				response.sendRedirect("/guestbook2/gbc?action=addList");
			} else if (ex == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/deleteForm.jsp");
				rd.forward(request, response);
			}
			 
			
			
		}
		else if ("deleteForm".equals(action)) {
			System.out.println("삭제폼 실행");
			
			//no를 int로 바꿈
			int no = Integer.parseInt(request.getParameter("no"));
		
			//어트리뷰트에 데이터 담기
			request.setAttribute("dNo", no);
			
			//좌표찍음
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/deleteForm.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

	}

}
