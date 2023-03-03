package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoaiLaptopDAO;
import model.LoaiLaptop;

/**
 * Servlet implementation class LoaiLaptopAdd
 */
@WebServlet(urlPatterns = "/admin/pages/loailaptop/add")
public class LoaiLaptopAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoaiLaptopAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			if(session.getAttribute("nhanvien") != null) {
				response.sendRedirect("../home/index");
				session.setAttribute("errorRole", "yes");
			}else {
				response.sendRedirect("../../../login");
			}
		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			response.sendRedirect("../../../login");
		} else {
			LoaiLaptop loailaptop = new LoaiLaptop(request.getParameter("ten"));

			if (LoaiLaptopDAO.getALoaiLaptopByName(request.getParameter("ten")) == null) {
				if (LoaiLaptopDAO.insertLoaiLapTop(loailaptop)) {
					session.setAttribute("Add", "Success");
					response.sendRedirect("list");
				}

			} else {
				session.setAttribute("Add", "Faill");
				response.sendRedirect("list");
			}
		}
	}
}
