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

import dao.DichVuSuaChuaDAO;
import model.DichVuSuaChua;

/**
 * Servlet implementation class DichVuSuaChuaList
 */
@WebServlet(name = "DichVuSuaChuaList", urlPatterns = "/admin/pages/dichvusuachua/listdichvusuachua")
public class DichVuSuaChuaList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DichVuSuaChuaList() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null && session.getAttribute("nhanvien") ==null) {
			response.sendRedirect("../../../login");
		} else {
			System.out.println(request.getParameter("search"));
			ArrayList<DichVuSuaChua> listDV = null;
			if (request.getParameter("search") != null && request.getParameter("search") != "") {

				listDV = DichVuSuaChuaDAO.getDVByName(request.getParameter("search"));
				System.out.println("ds");
				System.out.println(listDV.toString());
			} else {
				listDV = DichVuSuaChuaDAO.getAllDV("select * from dichvusuachua");
				System.out.println("tim kiem");
				System.out.println(listDV.toString());
			}
			System.out.println(listDV.toString());
			request.setAttribute("listDV", listDV);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listdichvusuachua.jsp");
			dispatcher.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
