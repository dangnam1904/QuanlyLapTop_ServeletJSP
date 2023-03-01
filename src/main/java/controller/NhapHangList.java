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
import model.NhapHang;

/**
 * Servlet implementation class NhapHangList
 */
@WebServlet("/admin/pages/nhaphang/list")
public class NhapHangList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhapHangList() {
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
			ArrayList<NhapHang> listNhapHang = new ArrayList<>();
			if (request.getParameter("search") != null && request.getParameter("search") != "") {
				listNhapHang = NhapHangDAO.findNhapHangByTenNguoGui(request.getParameter("search"));
				request.setAttribute("list", listNhapHang);
			} else {
				listNhapHang = NhapHangDAO.getAllNhapHang("select * from nhaphang order by ngaynhap");
				request.setAttribute("list", listNhapHang);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
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
