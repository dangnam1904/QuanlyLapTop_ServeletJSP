package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LaptopDAO;
import model.Laptop;

/**
 * Servlet implementation class ChitietBanHangGetLaptop
 */
@WebServlet(urlPatterns = { "/admin/pages/banhang/getlaptop", "/admin/pages/nhaphang/getlaptop" })
public class ChitietBanHangGetLaptop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChitietBanHangGetLaptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			String idlaptop = request.getParameter("idlaptop");
			Laptop laptop = LaptopDAO.getALaptop(Integer.valueOf(idlaptop));
			ArrayList<String> result = new ArrayList<>();
			result.add(String.valueOf(laptop.getGiaBan()));

			response.getWriter().append(result.toString());
	}

}
