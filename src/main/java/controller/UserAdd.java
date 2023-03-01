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

import dao.EncryptionPassword;
import dao.UserDAO;
import model.Users;



@WebServlet(name="addUser", urlPatterns = "/admin/pages/user/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserAdd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("admin") == null) {
			response.sendRedirect("../../../login");
		} else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
		dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session= request.getSession();
		Users u= new Users();
		u.setUsername(request.getParameter("username"));
		u.setPassword(EncryptionPassword.encryption(request.getParameter("password")));
		u.setIdRole(Integer.valueOf(request.getParameter("quyen")));
		System.out.println(EncryptionPassword.encryption(request.getParameter("password")));
		// xử lý lưu ảnh
		String empty = new String();

		Part filePart = request.getPart("file");
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		u.setImage(fileName);
		System.out.println(u.toString());
		if(UserDAO.checkUserEXISTS(request.getParameter("username"))==null) {
			if(UserDAO.insertUsers(u)) {
				session.setAttribute("Add", "Success");
				response.sendRedirect("list");
			}else {
				
			}
		}else {
			session.setAttribute("Add", "Username đã tồn tại");
			doGet(request, response);
		}
		
	}

}
