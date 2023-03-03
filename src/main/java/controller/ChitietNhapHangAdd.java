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
 * Servlet implementation class ChitietNhapHangAdd
 */
@WebServlet("/admin/pages/nhaphang/adddetail")
public class ChitietNhapHangAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChitietNhapHangAdd() {
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

			RequestDispatcher dispatcher = request.getRequestDispatcher("adddetail.jsp");
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
		Laptop laptop = LaptopDAO.getALaptop(Integer.valueOf(request.getParameter("idlaptop")));
		PhuKien pk = PhuKienDAO.getAPhuKien(Integer.valueOf(request.getParameter("idphukien")));
		System.out.println(ctnh.toString());

		int quantityLaptopAfter = laptop.getSoLuong() + ctnh.getSoLuongLaptop();
		int quantityPhuKienAfter = pk.getSoLuong() + ctnh.getSoLuongPhuKien();

		if (ChitietNhapHangDAO.insertCTNH(ctnh)) {
			LaptopDAO.updateSoluongLaptop(quantityLaptopAfter, ctnh.getIdLapTop());
			PhuKienDAO.updateSoluongPhuKien(quantityPhuKienAfter, ctnh.getIdPK());
			session.setAttribute("Add", "Success");
			response.sendRedirect("listdetail?id=" + idnh + "");
		} else {

			session.setAttribute("Add", "Faill");
			response.sendRedirect("listdetail?id=" + idnh + "");
		}
	}
}
