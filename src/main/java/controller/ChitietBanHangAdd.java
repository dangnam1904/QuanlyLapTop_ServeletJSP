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
 * Servlet implementation class ChitietBanHangAdd
 */
@WebServlet(urlPatterns = "/admin/pages/banhang/adddetail")
public class ChitietBanHangAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChitietBanHangAdd() {
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

			RequestDispatcher dispatcher = request.getRequestDispatcher("addDetail.jsp");
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
		Laptop laptop = LaptopDAO.getALaptop(Integer.valueOf(request.getParameter("idlaptop")));
		PhuKien pk = PhuKienDAO.getAPhuKien(Integer.valueOf(request.getParameter("idphukien")));
		System.out.println(ctbh.toString());

		int quantityLaptopAfter = laptop.getSoLuong() - ctbh.getSoLuongLaptop();
		int quantityPhuKienAfter = pk.getSoLuong() - ctbh.getSoLuongPhuKien();

		if (quantityLaptopAfter >= 0 && quantityPhuKienAfter >= 0) {
			if (ChiTietBanHangDAO.insertCTBH(ctbh)) {
				LaptopDAO.updateSoluongLaptop(quantityLaptopAfter, ctbh.getIdLapTop());
				PhuKienDAO.updateSoluongPhuKien(quantityPhuKienAfter, ctbh.getIdPK());
				session.setAttribute("Add", "Success");
				response.sendRedirect("listdetail?id=" + idbh + "");
			} else {

				session.setAttribute("Add", "Faill");
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
