package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PhuKienDAO;
import model.PhuKien;

@WebServlet(name = "/PhuKienList", urlPatterns = "/admin/pages/phukien/list")
public class PhuKienList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PhuKienList() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			response.sendRedirect("../../../login");
		} else {
			ArrayList<PhuKien> listPhuKien = new ArrayList<>();
			if (request.getParameter("search") != null && request.getParameter("search") != "") {
				listPhuKien = PhuKienDAO.findAllPhuKienByName(request.getParameter("search"));
			} else {
				listPhuKien = PhuKienDAO.getAllPhuKien("select * from phukien order by tenphukien asc");
			}
			request.setAttribute("listPK", listPhuKien);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			dispatcher.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
