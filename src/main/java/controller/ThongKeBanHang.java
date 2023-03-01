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

import dao.BanHangDAO;
import model.ThongKeDoanhThu;

/**
 * Servlet implementation class ThongKeBanHang
 */
@WebServlet("/admin/pages/thongke/banhang")
public class ThongKeBanHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThongKeBanHang() {
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
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			RequestDispatcher dispatcher = request.getRequestDispatcher("banhang.jsp");
			dispatcher.forward(request, response);
		}
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

		String tungay = request.getParameter("tungay");
		String denngay = request.getParameter("denngay");
		ArrayList<ThongKeDoanhThu> list = BanHangDAO.thongkeDoanhThu(tungay, denngay);
		System.out.println(list.toString());
		request.setAttribute("list", BanHangDAO.thongkeDoanhThu(tungay, denngay));

		String[] dataChart = BanHangDAO.thongkeDoanhThu30NgayGanNhat(tungay, denngay);
		System.out.println(dataChart);
		request.setAttribute("valueNgay", dataChart[0]);
		request.setAttribute("valueTongTien", dataChart[1]);

		RequestDispatcher dispatcher = request.getRequestDispatcher("banhang.jsp");
		dispatcher.forward(request, response);

	}

}
