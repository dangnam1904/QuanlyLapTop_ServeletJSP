<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin - Thêm dịch vu sửa chữa</title>
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
									<b>Dịch vụ sửa chữa</b>
								</h1>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="page-header float-right">
							<div class="page-title">
								<ol class="breadcrumb text-right">
									<li><a href="javascript:void(0)">Trang chủ</a></li>
									<li><a href="javascript:void(0)">Dịch vụ sửa chữa</a></li>
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
								<form action="add" method="post" id="form_action"
									class="form-horizontal">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Tên Khách hàng</label> <input
													type="text" placeholder="Nhập tên khách hàng"
													class="form-control" name="tenkhachhang" id="tenkhach">
												<small></small>
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Số điện thoại
													khách</label> <input type="text" placeholder="Nhập số điện thoại"
													class="form-control" name="sodienthoai" id="sdt"> <small></small>
											</div>
										</div>
										<div class="col-md-12">
											<div class="form-group">
												<label class="form-control-label">Nội dung sửa chữa</label>
												<input type="text" placeholder="Nhập nội dung sửa"
													class="form-control" name="noidung" id="noidung"> <small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Giá sửa chữa</label> <input
													type="text" placeholder="Nhập giá sửa" class="form-control"
													name="giasua" id="gia"> <small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Ngày nhận</label> <input
													type="date" class="form-control" name="ngaynhan">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Ngày trả</label> <input
													type="date" class="form-control" name="ngaytra">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Ghi chú</label> <input
													type="text" class="form-control" name="ghichu">
											</div>
										</div>
										<div class="col-md-12">
											<hr>
											<div class="form-actions form-group">
												<button type="submit" class="btn btn-success">Lưu
													lại</button>
												<a class="btn btn-danger" href="listdichvusuachua">Hủy
													bỏ</a>
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
<style type="text/css">
.form-group.error small {
	color: #e74c3c;
}
</style>
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

	<script>
	var form = document.getElementById('form_action');
	var tenkh = document.getElementById('tenkhach');
	var sdt = document.getElementById('sdt');
	var gia = document.getElementById('gia');
	var noidung = document.getElementById('noidung');

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
	    	
	        var check= checkEmptyError([tenkh, gia, noidung]);
	        
	        if(check && checkNumber(gia)){
				 form.submit();
		        }
	    });
		
	</script>
</body>
</html>