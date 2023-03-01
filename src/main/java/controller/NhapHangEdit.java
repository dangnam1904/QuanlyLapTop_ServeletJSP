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
 * Servlet implementation class NhapHangEdit
 */
@WebServlet("/admin/pages/nhaphang/edit")
public class NhapHangEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhapHangEdit() {
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
			request.setAttribute("nhaphang", NhapHangDAO.getANhapHang(Integer.valueOf(request.getParameter("id"))));
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		NhapHang nh = new NhapHang();
		nh.setTenNguoiGui(request.getParameter("ten"));
		nh.setSdt(request.getParameter("sodienthoai"));
		nh.setDiaChi(request.getParameter("diachi"));
		nh.setGhiChu(request.getParameter("ghichu"));
		nh.setIdNhapHang(Integer.valueOf(request.getParameter("idnhaphang")));

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

		nh.setNgaySua(sqlDate);
		System.out.println(nh.toString());
		HttpSession session = request.getSession();
		if (NhapHangDAO.updateNhapHang(nh)) {

			session.setAttribute("Edit", "Success");
			response.sendRedirect("list");
		} else {

			session.setAttribute("Edit", "Faill");
			response.sendRedirect("list");
		}
	}

}
