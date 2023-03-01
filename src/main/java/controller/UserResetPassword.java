package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

/**
 * Servlet implementation class UserResetPassword
 */
@WebServlet(name = "/UserResetPassword", urlPatterns = "/admin/pages/user/resetpass")
public class UserResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserResetPassword() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			response.sendRedirect("../../../login");
		} else {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			int id = Integer.valueOf(request.getParameter("id"));
			UserDAO.ressetPassword(id);
		}
	}

}
