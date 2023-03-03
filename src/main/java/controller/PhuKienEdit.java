package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.PhuKienDAO;
import model.PhuKien;

/**
 * Servlet implementation class PhuKienEdit
 */
@WebServlet("/admin/pages/phukien/edit")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class PhuKienEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhuKienEdit() {
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
			if(session.getAttribute("nhanvien") != null) {
				response.sendRedirect("../home/index");
				session.setAttribute("errorRole", "yes");
			}else {
				response.sendRedirect("../../../login");
			}
		} else {
		request.setAttribute("pk", PhuKienDAO.getAPhuKien(Integer.valueOf(request.getParameter("id"))));
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		dispatcher.forward(request, response);
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PhuKien pk1 =PhuKienDAO.getAPhuKien(Integer.valueOf(request.getParameter("idPK")));
		System.out.println(pk1.toString());
		String oldImg= PhuKienDAO.getAPhuKien(Integer.valueOf(request.getParameter("idPK"))).getAnh();
		if(oldImg==null) {
			oldImg="";
		}
		String empty = new String();
		Part filePart = request.getPart("anh");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString().trim();
		InputStream fileContent = filePart.getInputStream();
		if (!fileName.equals(empty)) {
			fileName = new Date().getTime() + fileName;

			// Đường dẫn tuyệt đối tới thư mục gốc của web app.
			String appPath = request.getServletContext().getRealPath("");
			appPath = appPath.replace('\\', '/');

			// Thư mục để save file tải lên.
			String fullSavePath = null;
			if (appPath.endsWith("/")) {
				fullSavePath = appPath + "admin/lib/images/";
			} else {
				fullSavePath = appPath + "/" + "admin/lib/images/";
			}

			File file = new File(fullSavePath, fileName);
			
			if(!oldImg.trim().equals(empty)) {
				File oldFile = new File(fullSavePath, oldImg);
				if(oldFile.delete()) {
//					System.out.println("da xoa file cu");
				} else {
//					System.out.println("ko xoa dc file cu");
				}
			}
			// System.out.println(file.getPath());

			try {
				 Files.copy(fileContent, file.toPath());
			} catch (Exception e) {

			}
		} else {
			fileName = oldImg;
		}
		
		PhuKien pk= new PhuKien();
		pk.setTenPK(request.getParameter("name_phukien"));
		pk.setGiaNhap(Integer.valueOf(request.getParameter("gianhap")));
		pk.setGiaBan(Integer.valueOf(request.getParameter("giaban")));
		pk.setSoLuong(Integer.valueOf(request.getParameter("soluong")));
		pk.setIdPhuKien(Integer.valueOf(request.getParameter("idPK")));
		pk.setAnh(fileName);
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		System.out.println(sqlDate);
		pk.setNgaySua(sqlDate);
		HttpSession session = request.getSession();
		System.out.println(pk.toString());
		if(PhuKienDAO.updatePhuKien(pk)) {
			
			session.setAttribute("Edit", "Success");
			response.sendRedirect("list");
		}
		else {
			session.setAttribute("Edit", "Faill");
			response.sendRedirect("list");
		}
	}

}
