<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Users"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin - Bán hàng</title>
<meta name="description" content="Admin - Bán hàng">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="../include/css.jsp"></jsp:include>
<link rel="stylesheet"
	href="../../lib/bower_components/alertifyjs/css/alertify.css">
<link rel="stylesheet"
	href="../../lib/bower_components/alertifyjs/css/themes/default.css">
</head>
<body>
	<jsp:include page="../include/leftmenu.jsp"></jsp:include>

	<div id="right-panel" class="right-panel">

		<jsp:include page="../include/header.jsp"></jsp:include>

		<div class="breadcrumbs">
			<div class="breadcrumbs-inner">
				<div class="row m-0">
					<div class="col-sm-4">
						<div class="page-header float-left">
							<div class="page-title">
								<h1>
									<b>TÀI KHOẢN</b>
								</h1>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="page-header float-right">
							<div class="page-title">
								<ol class="breadcrumb text-right">
									<li><a href="javascript:void(0)">Trang chủ</a></li>
									<li><a href="javascript:void(0)">Tài khoản</a></li>
									<li class="active">Danh sách</li>
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
								<strong class="card-title">Danh sách</strong> <a
									class="btn btn-primary float-right" href="add"><span><i
										class="fa fa-plus-square"></i></span> Thêm</a>
							</div>
							<div class="card-body">
								<table id="bootstrap-data-table"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>ID</th>
											<th>Tên tài khoản</th>
											<th>Ảnh</th>
											<th>Quyền</th>

											<th>Thao tác</th>
										</tr>
									</thead>
									<tbody>
										<%
										ArrayList<Users> list = (ArrayList<Users>) request.getAttribute("listUser");
										for (Users l : list) {
										%>
										<tr>
											<td><%=l.getIdUser()%></td>
											<td><%=l.getUsername()%></td>
												<td style="min-width: 40px;">
												<%
												if (l.getImage() != "") {
												%> <a href="../../lib/images/<%=l.getImage()%>"> <img
													alt="" src="../../lib/images/<%=l.getImage()%>"
													style="width: 100%">
											</a> <%
 }
 %>
											</td>
											<td><%=l.getIdRole()%></td>


											<td><button class="btn btn-danger"
													onclick="ResetPass(<%=l.getIdUser()%>)">ResetPass</button></td>
											<td><button class="btn btn-secondary"
													onclick="Delete(<%=l.getIdUser()%>)">
													<span><i class="fa fa-trash-o"></i></span> Xóa
												</button></td>
										</tr>
										<%
										}
										%>
									</tbody>
								</table>
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

	<!-- Scripts -->

	<jsp:include page="../include/js.jsp"></jsp:include>

	<script src="../../lib/assets/js/lib/data-table/datatables.min.js"></script>
	<script
		src="../../lib/assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
	<script
		src="../../lib/assets/js/lib/data-table/dataTables.buttons.min.js"></script>
	<script
		src="../../lib/assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
	<script src="../../lib/assets/js/lib/data-table/jszip.min.js"></script>
	<script src="../../lib/assets/js/lib/data-table/vfs_fonts.js"></script>
	<script src="../../lib/assets/js/lib/data-table/buttons.html5.min.js"></script>
	<script src="../../lib/assets/js/lib/data-table/buttons.print.min.js"></script>
	<script src="../../lib/assets/js/lib/data-table/buttons.colVis.min.js"></script>
	<script src="../../lib/assets/js/init/datatables-init.js"></script>

	<script src="../../lib/bower_components/alertifyjs/alertify.js"></script>
	<script>
	$('body').addClass("open");
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#bootstrap-data-table-export').DataTable();
		});
	</script>

	<script>
	function ResetPass(id){
		swal({
			  title: 'Bạn chắc chắn muốn Reset Password?',
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes'
			}).then((result) => {
			  if (result.value) {
				   $.ajax({
					   url: "resetpass",
					   type: "POST",
					   data: {
						   id: id
					   }
				   }).done(function(ketqua){
					   if(ketqua){
						  alertify.success('reset password successfully!');
					   }
				   }).error(function(){
					   console.log("Lỗi");
					   alertify.error('Dữ liệu không thay đổi!');
					   
				   });
			  } else alertify.error('Dữ liệu không thay đổi!');
			})
	}
	</script>


	<%
	if ((String) session.getAttribute("Edit") == "Success") {
	%>
	<script>
		swal('Sửa dữ liệu thành công');
	</script>
	<%
	session.removeAttribute("Edit");
	}
	%>

	<%
	if ((String) session.getAttribute("Add") == "Success") {
	%>
	<script>
		swal('Thêm dữ liệu thành công');
	</script>
	<%
	session.removeAttribute("Add");
	}
	%>
	

	<%
	if ((String) session.getAttribute("Delete") == "Success") {
	%>
	<script>
		swal('Xóa dữ liệu thành công');
	</script>
	<%
	session.removeAttribute("Delete");
	}
	%>

	<script>
    function Delete(id) {
    	swal({
  		  title: "Bạn có chắc chắn muốn xóa dữ liệu?",
  		  text: "Sau khi xóa, bạn sẽ không thể phục hồi dữ liệu này!",
  		  type: 'warning',
  		  showCancelButton: true,
  		  confirmButtonColor: '#3085d6',
  		  cancelButtonColor: '#d33',
  		  confirmButtonText: 'Yes'
  		}).then((result) => {
  		  if (result.value) {
  			  window.location.href = "delete?id=" + id;
  		  } else {
  			  swal("Dữ liệu của bạn không thay đổi!");
  		  }
  		});
    }
  </script>
</body>
</html>
