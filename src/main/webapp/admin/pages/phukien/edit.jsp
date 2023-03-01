<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.PhuKien"%>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin - Thêm phụ kiện</title>
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
									<b>Phụ Kiện</b>
								</h1>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="page-header float-right">
							<div class="page-title">
								<ol class="breadcrumb text-right">
									<li><a href="javascript:void(0)">Trang chủ</a></li>
									<li><a href="javascript:void(0)">Phụ Kiện</a></li>
									<li class="active">Sửa</li>
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
								<strong>Sửa</strong>
							</div>
							<%
							PhuKien pk = (PhuKien) request.getAttribute("pk");
							%>
							<div class="card-body card-block">
								<form action="edit" method="post" enctype="multipart/form-data"
									id="form-action" class="form-horizontal">
									<div class="row">
										<div class="col-md-6">
											<input type="hidden" name="idPK"
												value="<%=pk.getIdPhuKien()%>">
											<div class="form-group">
												<label class="form-control-label">Tên Phụ Kiện</label> <input
													type="text" placeholder="Nhập tên phụ kiện"
													class="form-control" name="name_phukien" id="tenpk"
													value="<%=pk.getTenPK()%>"> <small></small>
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Số lượng</label> <input
													type="text" placeholder="Nhập số lượng"
													class="form-control" name="soluong" id="soluong"
													value="<%=pk.getSoLuong()%>"> <small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Giá bán</label> <input
													type="text" placeholder="Nhập giá bán" class="form-control"
													name="giaban" id="giaban" value="<%=pk.getGiaBan()%>">
												<small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Giá nhập</label> <input
													type="text" placeholder="Nhập giá nhập hàng"
													class="form-control" name="gianhap" id="gianhap"
													value="<%=pk.getGiaBan()%>"> <small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Chọn ảnh</label>
												<div>
													<input type="file" name="anh" id="profile-img">
													<%
													if (pk.getAnh() != "") {
													%>
													<img src="../../../admin/lib/images/<%=pk.getAnh()%>"
														id="profile-img-tag" width="500px"
														style="display: block; margin-left: auto; margin-right: auto;" />
													<%
													} else {
													%>
													<img src="" id="profile-img-tag" width="500px"
														style="display: block; margin-left: auto; margin-right: auto;" />
													<%
													}
													%>
												</div>
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
	var tenpk = document.getElementById('tenpk');
	var soluong = document.getElementById('soluong');
	var gianhap = document.getElementById('gianhap');
	var giaban = document.getElementById('giaban');

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
	    	
	        var check= checkEmptyError([tenpk, soluong, gianhap, giaban]);
	       
	        if(check && checkNumber(soluong) && checkNumber(gianhap) && checkNumber(giaban)){
				 form.submit();
		        }
	    });
		
	</script>

</body>
</html>