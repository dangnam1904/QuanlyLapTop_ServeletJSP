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

import dao.UserDAO;
import model.Users;

@WebServlet(name = "/UserList", urlPatterns = "/admin/pages/user/list")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserList() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			response.sendRedirect("../../../login");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			ArrayList<Users> listUser = UserDAO.getAllUser("Select * from Users");
			request.setAttribute("listUser", listUser);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
