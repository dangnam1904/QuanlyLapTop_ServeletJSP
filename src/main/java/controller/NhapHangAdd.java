package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NhapHangDAO;
import model.NhapHang;

/**
 * Servlet implementation class NhapHangAdd
 */
@WebServlet("/admin/pages/nhaphang/add")
public class NhapHangAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhapHangAdd() {
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

		if (session.getAttribute("admin") == null && session.getAttribute("nhanvien") ==null) {
			response.sendRedirect("../../../login");
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		NhapHang nh = new NhapHang();
		nh.setTenNguoiGui(request.getParameter("ten"));
		nh.setSdt(request.getParameter("sodienthoai"));
		nh.setDiaChi(request.getParameter("diachi"));
		nh.setGhiChu(request.getParameter("ghichu"));

		String date_bh = request.getParameter("ngaynhap");
		System.out.println(date_bh);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed1 = null;

		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		try {
			if (request.getParameter("ngaynhap") == "") {
				parsed1 = new java.util.Date();
			}
			parsed1 = format.parse(request.getParameter("ngaynhap"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate1 = new java.sql.Date(parsed1.getTime());
		nh.setNgayNhap(sqlDate1);
		nh.setNgayTao(sqlDate);
		nh.setNgaySua(sqlDate);
		System.out.println(nh.toString());
		HttpSession session = request.getSession();
		if (NhapHangDAO.insertNhapHang(nh)) {

			session.setAttribute("Add", "Success");
			response.sendRedirect("list");
		} else {

			session.setAttribute("Add", "Faill");
			response.sendRedirect("list");
		}
	}
}
