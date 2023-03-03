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

import dao.LaptopDAO;
import model.Laptop;

@WebServlet(urlPatterns = "/admin/pages/laptop/list")
public class LaptopList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LaptopList() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null && session.getAttribute("nhanvien") ==null) {
			response.sendRedirect("../../../login");
		} else {
			ArrayList<Laptop> listLapTop = new ArrayList<>();
			if (request.getParameter("search") != null && request.getParameter("search") != "") {
				listLapTop = LaptopDAO.getLaptopByName(request.getParameter("search"));
			} else {
				listLapTop = LaptopDAO.getAlLLaptop("select * from laptop order by tenlaptop");
			}
			request.setAttribute("list", listLapTop);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
