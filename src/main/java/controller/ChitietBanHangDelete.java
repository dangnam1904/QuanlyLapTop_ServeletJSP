package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChiTietBanHangDAO;
import dao.LaptopDAO;
import dao.PhuKienDAO;
import model.ChitietBanHang;
import model.Laptop;
import model.PhuKien;

/**
 * Servlet implementation class ChitietBanHangDelete
 */
@WebServlet("/admin/pages/banhang/deleteDetail")
public class ChitietBanHangDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChitietBanHangDelete() {
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

			String idbh = (String) session.getAttribute("idBH");

			if (request.getParameter("id") != null && request.getParameter("id") != "") {
				ChitietBanHang ctbh = ChiTietBanHangDAO.getACTBH(Integer.valueOf(request.getParameter("id")));
				PhuKien pk = PhuKienDAO.getAPhuKien(ctbh.getIdPK());
				Laptop laptop = LaptopDAO.getALaptop(ctbh.getIdLapTop());

				if (ChiTietBanHangDAO.deleteCTBH((Integer.valueOf(request.getParameter("id"))))) {
					LaptopDAO.updateSoluongLaptop(laptop.getSoLuong() + ctbh.getSoLuongLaptop(), ctbh.getIdPK());
					PhuKienDAO.updateSoluongPhuKien(pk.getSoLuong() + ctbh.getSoLuongPhuKien(), ctbh.getIdPK());
					session.setAttribute("Delete", "Success");
					session.setMaxInactiveInterval(15);
					response.sendRedirect("listdetail?id=" + idbh + "");
				}

			} else {
				session.setAttribute("Delete", "Faill");
				session.setMaxInactiveInterval(15);
				response.sendRedirect("listdetail?id=" + idbh + "");
			}
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
