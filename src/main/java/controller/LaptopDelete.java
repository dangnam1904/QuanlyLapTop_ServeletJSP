package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LaptopDAO;

/**
 * Servlet implementation class LaptopDelete
 */
@WebServlet(urlPatterns = "/admin/pages/laptop/delete")
public class LaptopDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LaptopDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			if(session.getAttribute("nhanvien") != null) {
				response.sendRedirect("../home/index");
				session.setAttribute("errorRole", "yes");
			}else {
				response.sendRedirect("../../../login");
			}
		} else {
			if (LaptopDAO.deleteLapTop(id)) {
				
				session.setAttribute("Delete", "Success");
				session.setMaxInactiveInterval(15);
				response.sendRedirect("list");
			} else {
				
				session.setAttribute("Delete", "Faill");
				session.setMaxInactiveInterval(15);
				response.sendRedirect("list");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
