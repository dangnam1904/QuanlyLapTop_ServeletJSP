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

import dao.DichVuSuaChuaDAO;
import model.DichVuSuaChua;

@WebServlet(name = "/DichVuSuaChuaEdit", urlPatterns = "/admin/pages/dichvusuachua/edit")
public class DichVuSuaChuaEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DichVuSuaChuaEdit() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			response.sendRedirect("../../../login");
		} else {
			request.setAttribute("dv", DichVuSuaChuaDAO.getADV(Integer.valueOf(request.getParameter("id"))));
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		DichVuSuaChua dv = new DichVuSuaChua();
		dv.setIdDV(Integer.valueOf(request.getParameter("idDV")));
		dv.setTenKhach(request.getParameter("tenkhachhang"));
		dv.setSdtKhach(request.getParameter("sodienthoai"));
		dv.setNoiDungSuaChua(request.getParameter("noidung"));
		dv.setGhiChu(request.getParameter("ghichu"));
		dv.setGiaTien(Integer.valueOf(request.getParameter("giasua")));

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed1 = null;
		Date parsed2 = null;
		try {
			if (request.getParameter("ngaynhan") == "") {
				parsed1 = new java.util.Date();
			}
			if (request.getParameter("ngaytra") == "") {

				parsed2 = new java.util.Date();
			}

			parsed1 = format.parse(request.getParameter("ngaynhan"));
			parsed2 = format.parse(request.getParameter("ngaytra"));

		} catch (ParseException e) {

			e.printStackTrace();
		}

		java.sql.Date sqlDate1 = new java.sql.Date(parsed1.getTime());
		java.sql.Date sqlDate2 = new java.sql.Date(parsed2.getTime());
		dv.setNgayNhan(sqlDate1);
		dv.setNgayTra(sqlDate2);
		System.out.println(dv.toString());

		if (DichVuSuaChuaDAO.updateDV(dv)) {
			HttpSession session = request.getSession();
			session.setAttribute("Edit", "Success");
			response.sendRedirect("listdichvusuachua");
		} else {

		}
	}

}
