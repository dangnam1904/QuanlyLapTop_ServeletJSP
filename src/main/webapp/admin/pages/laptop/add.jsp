<%@page import="dao.LaptopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="model.LoaiLaptop, dao.LoaiLaptopDAO, java.util.ArrayList"%>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin - Thêm laptop</title>
<meta name="description" content="Admin - Thêm phụ kiện">
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
									<b>Laptop</b>
								</h1>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="page-header float-right">
							<div class="page-title">
								<ol class="breadcrumb text-right">
									<li><a href="javascript:void(0)">Trang chủ</a></li>
									<li><a href="javascript:void(0)">Laptop</a></li>
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
									id="form-action" class="form-horizontal">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Tên laptop</label> <input
													type="text" placeholder="Nhập tên laptop"
													class="form-control" name="ten" id="ten"> <small></small>
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Giá nhập</label> <input
													type="text" placeholder="Nhập giá nhập"
													class="form-control" name="gianhap" id="gianhap"> <small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Giá bán</label> <input
													type="text" placeholder="Nhập giá bán" class="form-control"
													name="giaban" id="giaban"> <small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Số lượng</label> <input
													type="text" placeholder="Nhập số lượng"
													class="form-control" name="soluong" id="soluong"> <small></small>

											</div>
										</div>
										<div class="col-md-12">
											<div class="form-group">
												<label class="form-control-label">Thông số</label> <input
													type="text" placeholder="Nhập cấu hình máy"
													class="form-control" name="cauhinh" id="thongso"> <small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Chọn ảnh</label>
												<div>
													<input type="file" name="anh" id="profile-img"> <img
														src="" id="profile-img-tag" width="500px"
														style="display: block; margin-left: auto; margin-right: auto;" />
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Loại laptop</label> <select
													name="loailaptop"
													style="border: 1px solid #ced4da; border-radius: 0.25rem; padding: 4px; padding-left: 20px;">
													<%
													for (LoaiLaptop l : LoaiLaptopDAO.getAllLoaiLaptop("select *from loailaptop")) {
													%>
													<option value="<%=l.getIdLoai()%>"><%=l.getTenLoai()%></option>
													<%
													}
													%>
												</select>
											</div>
										</div>
										<div class="col-md-12">
											<hr>
											<div class="form-actions form-group">
												<button type="submit" class="btn btn-success">Lưu
													lại</button>
												<a class="btn btn-danger" href="list">Hủy bỏ</a>
											</div>
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
	<style type="text/css">
.form-group.error small {
	color: #e74c3c;
}
</style>


	<script>
	var form = document.getElementById('form-action');
	var ten = document.getElementById('ten');
	var soluong = document.getElementById('soluong');
	var gianhap = document.getElementById('gianhap');
	var giaban = document.getElementById('giaban');
	var thongso = document.getElementById('thongso');
	

	function showError(input, message) {
	    //  console.log(input.parentElement.querySelector('small'));
	        let parent = input.parentElement;
	        let small = parent.querySelector('small');
	        parent.classList.add('error');
	        small.innerText = message;
	    }

	  function showSuccess(input, message) {
	        let parent = input.parentElement;
	        let small = parent.querySelector('small');
	        parent.classList.remove('error');
	        small.innerText = '';
	    }
	    
	function checkEmptyError(listInput) {
        let isEmptyError = false;
        listInput.forEach(input => {
            input.value = input.value.trim();
            if (!input.value) {
              
                showError(input, 'Không được để trống');
            } else {
                showSuccess(input);
                isEmptyError = true;
            }
        });
        return isEmptyError;
    }
    
    function checkSdt(input){
        var check=false;
    	var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;
    	if(vnf_regex.test(input)){
        	check= true;
        	}
    	return check;	
     }

    function checkNumber(input){
        var check= false;
        if(/^[0-9]+$/.test(input.value)){
            check= true;
        	 showSuccess(input);
            }else{
            	showError(input, 'Chỉ được nhập số');
            	check= false;
            }
        return check;
        }
 
	 form.addEventListener('submit', function(e) {
	        e.preventDefault()
	    	
	        var check= checkEmptyError([ten, soluong, gianhap, giaban]);
	       
	        if(check  && checkNumber(gianhap) && checkNumber(giaban) && checkNumber(soluong)){
				 form.submit();
		        }
	    });
		
	</script>

</body>
</html>