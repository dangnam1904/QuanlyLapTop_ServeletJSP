<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Role, dao.RoldDAO"%>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin - Thêm Người dùng</title>
<meta name="description" content="Admin - Bán hàng">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="../include/css.jsp"></jsp:include>
<script src='../../lib/bower_components/tinymce/tinymce.min.js'></script>
</head>
<body>

	<jsp:include page="../include/leftmenu.jsp"></jsp:include>

	<!-- Right Panel -->

	<div id="right-panel" class="right-panel">

		<jsp:include page="../include/header.jsp"></jsp:include>

		<div class="breadcrumbs">
			<div class="breadcrumbs-inner">
				<div class="row m-0">
					<div class="col-sm-4">
						<div class="page-header float-left">
							<div class="page-title">
								<h1>
									<b>User</b>
								</h1>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="page-header float-right">
							<div class="page-title">
								<ol class="breadcrumb text-right">
									<li><a href="javascript:void(0)">Trang chủ</a></li>
									<li><a href="javascript:void(0)">User</a></li>
									<li class="active">Thêm</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="content">
			<div class="animated fadeIn">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<strong>Thêm</strong>
							</div>
							<div class="card-body card-block">
								<form action="add" method="post" enctype="multipart/form-data"
									class="form-horizontal">
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label class="form-control-label">Tên tài khoản</label> <input
													type="text" placeholder="Nhập username"
													class="form-control" name="username">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Mật khẩu</label> <input
													type="password" placeholder="Nhập mật khẩu"
													class="form-control" name="password">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Chọn ảnh</label>
												<div>
													<input type="file" name="file" id="profile-img"> <img
														src="" id="profile-img-tag" width="500px"
														style="display: block; margin-left: auto; margin-right: auto;" />
												</div>
											</div>
										</div>
										<div class="col-md-12">
											<hr>
											<label class="form-control-label">Loại tài khoản</label>
											<div class="form-actions form-group">
												<select id="quyen" name="quyen">
													<%
													ArrayList<Role> list = RoldDAO.getAllRole("select * from roles");

													for (Role r : list) {
													%>
													<option value="<%=r.getIdRole()%>"><%=r.getNameRole()%></option>
													<%
													}
													%>

												</select>
											</div>
											<div class="form-actions form-group">
												<button type="submit" class="btn btn-success">Lưu
													lại</button>
												<a class="btn btn-danger" href="list">Hủy bỏ</a>
											</div>
											<%
											if (session.getAttribute("Add") != null) {
											%>
											<div class="alert alert-danger">
												<center><%=session.getAttribute("Add")%></center>
											</div>
											<%
											session.removeAttribute("Add");
											}
											%>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- .animated -->
		</div>
		<!-- .content -->
		<div class="clearfix"></div>
	</div>
	<!-- /#right-panel -->

	<!-- Right Panel -->

	<style type="text/css">
#quyen {
	margin: auto;
	padding: 5px 10px;
	border: 1px solid black;
	width: 30%;
	border-radius: 4px;
}
</style>
	<!-- Scripts -->
	<jsp:include page="../include/js.jsp"></jsp:include>

	<script src="../../lib/bower_components/jquery/dist/jquery.min.js"></script>
	<script>
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#profile-img-tag').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
		$("#profile-img").change(function() {
			readURL(this);
		});
	</script>

</body>
</html>