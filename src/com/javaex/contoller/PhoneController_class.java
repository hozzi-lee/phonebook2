package com.javaex.contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PhoneVo;

@WebServlet("/pbc_class")
public class PhoneController_class extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		System.out.println("controller 컨트롤러");

		request.setCharacterEncoding("UTF-8");

		PhoneDao pDao = new PhoneDao();

		// 파라미터 action 값을 읽어온다
		String action = request.getParameter("action");
		System.out.println(action);

		if ("list".equals(action)) {
			// 리스트업무
			System.out.println("[리스트]");

			// 리스트
			List<PhoneVo> pList = pDao.getList();

			System.out.println("======= controller =======");
			System.out.println(pDao.getList());

			// 데이터 넣기 --> request.어트리뷰트에 담는다
			request.setAttribute("pList", pDao.getList());
			/*
			 * request.setAttribute("name", "이호진"); request.setAttribute("age", 29);
			 */

			// html작업 --> jsp에게 시킨다 --> forward 한다
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(request, response);

		} else if ("wForm".equals(action)) {
			System.out.println("[글쓰기폼]");

			// forward
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/writeForm.jsp");
			rd.forward(request, response);

		} else if ("insert".equals(action)) {
			System.out.println("[저장]");

			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String cp = request.getParameter("cp");

			pDao.insert(new PhoneVo(name, hp, cp));

			response.sendRedirect("/phonebook2/pbc?action=list");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
