package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhuKienDAO;
import model.PhuKien;

/**
 * Servlet implementation class ChitietBanHangGetPhuKien
 */
@WebServlet(urlPatterns = {"/admin/pages/banhang/getphukien", "/admin/pages/nhaphang/getphukien"})
public class ChitietBanHangGetPhuKien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChitietBanHangGetPhuKien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PhuKien  pk = PhuKienDAO.getAPhuKien(Integer.valueOf(request.getParameter("idphukien")));
		ArrayList<String> result = new ArrayList<>();
		result.add(String.valueOf(pk.getGiaBan()));
		response.getWriter().append(result.toString());
	}

}
