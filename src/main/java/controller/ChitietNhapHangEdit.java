package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ChitietNhapHangEdit
 */
@WebServlet("/admin/pages/nhaphang/editdetail")
public class ChitietNhapHangEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChitietNhapHangEdit() {
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
		request.setAttribute("listctnh", ChitietNhapHangDAO.getACTNH(Integer.valueOf(request.getParameter("id"))));
		RequestDispatcher dispatcher = request.getRequestDispatcher("editdetail.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idnh = (String) session.getAttribute("idNH");
		ChitietNhapHang ctnh = new ChitietNhapHang();

		ChitietNhapHang ctnh_old = ChitietNhapHangDAO.getACTNH(Integer.valueOf(request.getParameter("idctnh")));

		System.out.println(ctnh_old.toString());
		System.out.println("--------------");
		ctnh.setIdNhapHang(Integer.valueOf(idnh));
		ctnh.setIdLapTop(Integer.valueOf(request.getParameter("idlaptop")));
		ctnh.setIdPK(Integer.valueOf(request.getParameter("idphukien")));
		ctnh.setGiaLaptop(Integer.valueOf(request.getParameter("gialaptop")));
		ctnh.setGiaPhuKien(Integer.valueOf(request.getParameter("giaphukien")));
		ctnh.setSoLuongLaptop(Integer.valueOf(request.getParameter("soluonglaptop")));
		ctnh.setSoLuongPhuKien(Integer.valueOf(request.getParameter("solgphukien")));

		int tongtien = Integer.valueOf(request.getParameter("gialaptop"))
				* Integer.valueOf(request.getParameter("soluonglaptop"))
				+ Integer.valueOf(request.getParameter("solgphukien"))
						* Integer.valueOf(request.getParameter("giaphukien"));
		ctnh.setTongtien(tongtien);
		ctnh.setIdCTNH(Integer.valueOf(request.getParameter("idctnh")));

		System.out.println(ctnh.toString());

		Laptop laptop = LaptopDAO.getALaptop(ctnh.getIdLapTop());
		PhuKien pk = PhuKienDAO.getAPhuKien(ctnh.getIdPK());
		int quantityLaptopUpdate = 0;
		int quantityPhuKienUpdate = 0;
		if (ctnh_old.getSoLuongLaptop() > ctnh.getSoLuongLaptop()) {
			quantityLaptopUpdate = laptop.getSoLuong() - (ctnh_old.getSoLuongLaptop() - ctnh.getSoLuongLaptop());
		} else {
			quantityLaptopUpdate = laptop.getSoLuong() + (ctnh.getSoLuongLaptop() - ctnh_old.getSoLuongLaptop());
		}

		if (ctnh_old.getSoLuongPhuKien() > ctnh.getSoLuongPhuKien()) {
			quantityPhuKienUpdate = pk.getSoLuong() - (ctnh_old.getSoLuongPhuKien() - ctnh.getSoLuongPhuKien());
		} else {
			quantityPhuKienUpdate = pk.getSoLuong() + (ctnh.getSoLuongPhuKien() - ctnh_old.getSoLuongPhuKien());
		}

		if (ChitietNhapHangDAO.updateCTNH(ctnh)) {
			LaptopDAO.updateSoluongLaptop(quantityLaptopUpdate, ctnh.getIdLapTop());
			PhuKienDAO.updateSoluongPhuKien(quantityPhuKienUpdate, ctnh.getIdPK());
			session.setAttribute("Edit", "Success");
			response.sendRedirect("listdetail?id=" + idnh + "");
		} else {

			session.setAttribute("Edit", "Faill");
			response.sendRedirect("listdetail?id=" + idnh + "");
		}
	}

}
