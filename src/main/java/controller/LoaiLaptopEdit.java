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
 * Servlet implementation class LoaiLaptopEdit
 */
@WebServlet(urlPatterns = "/admin/pages/loailaptop/edit")
public class LoaiLaptopEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoaiLaptopEdit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			response.sendRedirect("../../../login");
		} else {
			request.setAttribute("list", LoaiLaptopDAO.getALoaiLaptop(Integer.valueOf(request.getParameter("id"))));
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoaiLaptop loaiLaptop = new LoaiLaptop(Integer.valueOf(request.getParameter("id")),
				request.getParameter("ten"));
		System.out.println(loaiLaptop.toString());
		HttpSession session = request.getSession();
		if (LoaiLaptopDAO.getALoaiLaptopByName(request.getParameter("ten")) == null) {
			if (LoaiLaptopDAO.updateLoaiLapTop(loaiLaptop)) {
				session.setAttribute("Edit", "Success");
				response.sendRedirect("list");
			}
		} else {
			session.setAttribute("Edit", "Faill");
			response.sendRedirect("list");
		}
	}

}
