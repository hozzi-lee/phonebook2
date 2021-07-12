package com.javaex.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PhoneVo;

@WebServlet("/pbc")
public class PhoneController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		PhoneDao pDao = new PhoneDao();

		// 파라미터 action 값을 읽어온다
		String action = request.getParameter("action");

		if ("list".equals(action)) {
			// 데이터 넣기 --> request.어트리뷰트에 담는다
			request.setAttribute("pList", pDao.getList());

			// html --> .jsp == forward
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(request, response);

		} else if ("wForm".equals(action)) {
			// forward
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/writeForm.jsp");
			rd.forward(request, response);

		} else if ("insert".equals(action)) {
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String cp = request.getParameter("cp");

			pDao.insert(new PhoneVo(name, hp, cp));

			response.sendRedirect("/phonebook2/pbc?action=list");

		} else if ("uForm".equals(action)) {
			// forward
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/updateForm.jsp");
			rd.forward(request, response);

		} else if ("update".equals(action)) {
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String cp = request.getParameter("cp");
			int id = Integer.parseInt(request.getParameter("id"));

			pDao.update(new PhoneVo(id, name, hp, cp));

			response.sendRedirect("/phonebook2/pbc?action=list");

		} else if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));

			pDao.delete(new PhoneVo(id));

			response.sendRedirect("/phonebook2/pbc?action=list");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
