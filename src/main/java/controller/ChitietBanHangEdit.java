package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ChitietBanHangEdit
 */
@WebServlet(urlPatterns = "/admin/pages/banhang/editdetail")
public class ChitietBanHangEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChitietBanHangEdit() {
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
			request.setAttribute("listctbh", ChiTietBanHangDAO.getACTBH(Integer.valueOf(request.getParameter("id"))));
			RequestDispatcher dispatcher = request.getRequestDispatcher("editDetail.jsp");
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
		String idbh = (String) session.getAttribute("idBH");
		ChitietBanHang ctbh = new ChitietBanHang();

		ChitietBanHang ctbh_old = ChiTietBanHangDAO.getACTBH(Integer.valueOf(request.getParameter("idctbh")));

		System.out.println(ctbh_old.toString());
		System.out.println("--------------");
		ctbh.setIdBH(Integer.valueOf(idbh));
		ctbh.setIdLapTop(Integer.valueOf(request.getParameter("idlaptop")));
		ctbh.setIdPK(Integer.valueOf(request.getParameter("idphukien")));
		ctbh.setGiaLaptop(Integer.valueOf(request.getParameter("gialaptop")));
		ctbh.setGiaPhuKien(Integer.valueOf(request.getParameter("giaphukien")));
		ctbh.setSoLuongLaptop(Integer.valueOf(request.getParameter("soluonglaptop")));
		ctbh.setSoLuongPhuKien(Integer.valueOf(request.getParameter("solgphukien")));

		int tongtien = Integer.valueOf(request.getParameter("gialaptop"))
				* Integer.valueOf(request.getParameter("soluonglaptop"))
				+ Integer.valueOf(request.getParameter("solgphukien"))
						* Integer.valueOf(request.getParameter("giaphukien"));
		ctbh.setTongtien(tongtien);
		ctbh.setIdCTBH(Integer.valueOf(request.getParameter("idctbh")));

		System.out.println(ctbh.toString());

		Laptop laptop = LaptopDAO.getALaptop(ctbh.getIdLapTop());
		PhuKien pk = PhuKienDAO.getAPhuKien(ctbh.getIdPK());
		int quantityLaptopUpdate = 0;
		int quantityPhuKienUpdate = 0;
		if (ctbh_old.getSoLuongLaptop() > ctbh.getSoLuongLaptop()) {
			quantityLaptopUpdate = laptop.getSoLuong() + (ctbh_old.getSoLuongLaptop() - ctbh.getSoLuongLaptop());
		} else {
			quantityLaptopUpdate = laptop.getSoLuong() - (ctbh.getSoLuongLaptop() - ctbh_old.getSoLuongLaptop());
		}

		if (ctbh_old.getSoLuongPhuKien() > ctbh.getSoLuongPhuKien()) {
			quantityPhuKienUpdate = pk.getSoLuong() + (ctbh_old.getSoLuongPhuKien() - ctbh.getSoLuongPhuKien());
		} else {
			quantityPhuKienUpdate = pk.getSoLuong() - (ctbh.getSoLuongPhuKien() - ctbh_old.getSoLuongPhuKien());
		}

		int quantityLaptopAfter = laptop.getSoLuong() - ctbh.getSoLuongLaptop();
		int quantityPhuKienAfter = pk.getSoLuong() - ctbh.getSoLuongPhuKien();

		if (quantityLaptopAfter >= 0 && quantityPhuKienAfter >= 0) {
			if (ChiTietBanHangDAO.updateCTBH(ctbh)) {
				LaptopDAO.updateSoluongLaptop(quantityLaptopUpdate, ctbh.getIdLapTop());
				PhuKienDAO.updateSoluongPhuKien(quantityPhuKienUpdate, ctbh.getIdPK());
				session.setAttribute("Edit", "Success");
				response.sendRedirect("listdetail?id=" + idbh + "");
			} else {

				session.setAttribute("Edit", "Faill");
				response.sendRedirect("listdetail?id=" + idbh + "");
			}
		} else {
			if (quantityLaptopAfter < 0) {
				session.setAttribute("ErrorQuantityLapTop", "Faill");
			}

			if (quantityPhuKienAfter < 0) {
				session.setAttribute("ErrorQuantityPhuKien", "Faill");
			}
			response.sendRedirect("listdetail?id=" + idbh + "");
		}

	}

}
