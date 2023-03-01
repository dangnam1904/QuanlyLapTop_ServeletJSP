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

import dao.NhapHangDAO;
import model.ThongKeNhapHang;

/**
 * Servlet implementation class ThongKeNhapHang
 */
@WebServlet("/admin/pages/thongke/nhaphang")
public class ThongKeNH extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThongKeNH() {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("nhaphang.jsp");
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
		ArrayList<ThongKeNhapHang> list = NhapHangDAO.thongkeNhapHang(tungay, denngay);
		System.out.println(list.toString());
		request.setAttribute("list", list);

		String[] dataChart = NhapHangDAO.thongkeNhapHangChart(tungay, denngay);
		System.out.println(dataChart);
		request.setAttribute("valueNgay", dataChart[0]);
		request.setAttribute("valueTongTien", dataChart[1]);

		RequestDispatcher dispatcher = request.getRequestDispatcher("nhaphang.jsp");
		dispatcher.forward(request, response);
	}

}
