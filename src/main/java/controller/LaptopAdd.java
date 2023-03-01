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

import dao.LaptopDAO;
import model.Laptop;


@WebServlet(urlPatterns = "/admin/pages/laptop/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class LaptopAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LaptopAdd() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			response.sendRedirect("../../../login");
		} else {
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("add.jsp");
		dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
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
			// System.out.println(file.getPath());

			try {
				Files.copy(fileContent, file.toPath());
				System.out.println( "sucess");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Laptop laptop= new Laptop();
		laptop.setTenLaptop(request.getParameter("ten"));
		laptop.setGiaBan(Integer.valueOf(request.getParameter("giaban")));
		laptop.setGiaNhap(Integer.valueOf(request.getParameter("gianhap")));
		laptop.setSoLuong(Integer.valueOf(request.getParameter("soluong")));
		laptop.setThongSo(request.getParameter("cauhinh"));
		laptop.setAnh(fileName);
		laptop.setIdLoai(Integer.valueOf(request.getParameter("loailaptop")));
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		System.out.println(sqlDate);
		laptop.setNgayTao(sqlDate);
		laptop.setNgaySua(sqlDate);
		System.out.println(laptop.toString());
		HttpSession session= request.getSession();
		if(LaptopDAO.checkTonTaiLaptop(request.getParameter("ten"))) {
			session.setAttribute("error", "error");
			response.sendRedirect("list");
			
		}else {
			if(LaptopDAO.insertLapTop(laptop)) {
				session.setAttribute("Add", "Success");
				response.sendRedirect("list");
			}
		}
	}

}
