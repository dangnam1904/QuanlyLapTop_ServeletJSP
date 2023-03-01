package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChitietNhapHangDAO;
import dao.LaptopDAO;
import dao.PhuKienDAO;
import model.ChitietNhapHang;
import model.Laptop;
import model.PhuKien;

/**
 * Servlet implementation class ChitietNhapHangDelete
 */
@WebServlet("/admin/pages/nhaphang/deleteDetail")
public class ChitietNhapHangDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChitietNhapHangDelete() {
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
			String idnh = (String) session.getAttribute("idNH");

			if (request.getParameter("id") != null && request.getParameter("id") != "") {
				ChitietNhapHang ctnh = ChitietNhapHangDAO.getACTNH(Integer.valueOf(request.getParameter("id")));
				PhuKien pk = PhuKienDAO.getAPhuKien(ctnh.getIdPK());
				Laptop laptop = LaptopDAO.getALaptop(ctnh.getIdLapTop());

				if (ChitietNhapHangDAO.deleteCTNH((Integer.valueOf(request.getParameter("id"))))) {
					LaptopDAO.updateSoluongLaptop(laptop.getSoLuong() - ctnh.getSoLuongLaptop(), ctnh.getIdPK());
					PhuKienDAO.updateSoluongPhuKien(pk.getSoLuong() - ctnh.getSoLuongPhuKien(), ctnh.getIdPK());
					session.setAttribute("Delete", "Success");
					session.setMaxInactiveInterval(15);
					response.sendRedirect("listdetail?id=" + idnh + "");
				}

			} else {
				session.setAttribute("Delete", "Faill");
				session.setMaxInactiveInterval(15);
				response.sendRedirect("listdetail?id=" + idnh + "");
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
