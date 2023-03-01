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

import dao.ChiTietBanHangDAO;
import model.HoaDonFullBanHang;

/**
 * Servlet implementation class ChitietBanHang
 */
@WebServlet(urlPatterns = "/admin/pages/banhang/listdetail")
public class ChitietBanHangList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChitietBanHangList() {
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
			session.setAttribute("idBH", request.getParameter("id"));
			request.setAttribute("idBH", request.getParameter("id"));
			String idBH = (String) session.getAttribute("idBH");
			ArrayList<HoaDonFullBanHang> listHoaDon = ChiTietBanHangDAO.getAllFullHoaDonBanHang(Integer.valueOf(idBH));
			request.setAttribute("list", listHoaDon);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listdetail.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
