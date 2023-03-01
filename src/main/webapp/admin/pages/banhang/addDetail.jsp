<%@page import="dao.LaptopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="model.LoaiLaptop, dao.LoaiLaptopDAO, model.Laptop, dao.LaptopDAO, model.PhuKien, dao.PhuKienDAO, java.util.ArrayList"%>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin - Thêm hóa đơn</title>
<meta name="description" content="Admin - Thêm phụ kiện">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="../include/css.jsp"></jsp:include>
<script src='../../lib/bower_components/tinymce/tinymce.min.js'></script>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">

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
									<b>Hóa đơn bán hàng</b>
								</h1>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="page-header float-right">
							<div class="page-title">
								<ol class="breadcrumb text-right">
									<li><a href="javascript:void(0)">Trang chủ</a></li>
									<li><a href="javascript:void(0)">Hóa đơn bán bàng</a></li>
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
								<form action="adddetail" method="post" id="form-action"
									class="form-horizontal">
									<div class="row">
										<input type="hidden" class="form-control"
											value="<%=(String) session.getAttribute("idBH")%>" name="idHoaDon">
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Chọn Laptop</label>
												<div class="search-select-box">
													<select data-live-search="true" id="ten" name="idlaptop"
														onchange="laptop(this.value)" class="w-100">
														<%
														ArrayList<Laptop> list = LaptopDAO.getAlLLaptop("select * from Laptop order by TenLapTop asc");
														for (Laptop l : list) {
														%>
														<option value="<%=l.getIdLaptop()%>"><%=l.getTenLaptop()%></option>
														<%
														}
														%>
													</select> <small></small>
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Chọn Phụ kiện</label>
												<div class="search-select-box">
													<select data-live-search="true" id="phukien"
														name="idphukien" onchange="wft(this.value)" class="w-100">

														<%
														ArrayList<PhuKien> listPK = PhuKienDAO.getAllPhuKien("select * from PhuKien order by TenPhuKien asc ");
														for (PhuKien l : listPK) {
														%>
														<option value="<%=l.getIdPhuKien()%>"><%=l.getTenPK()%></option>
														<%
														}
														%>
													</select> <small></small>
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group ">
												<label class="form-control-label">Giá laptop</label> <input
													type="text" placeholder="" class="form-control"
													name="gialaptop" id="gialaptop" onchange="tinhtien()">
												<small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Giá phụ kiện</label> <input
													type="text" placeholder="" class="form-control"
													name="giaphukien" id="giaphukien" onchange="tinhtien()">
												<small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Số lượng laptop </label> <input
													type="text" placeholder="Số lượng laptop "
													class="form-control" name="soluonglaptop"
													onchange="tinhtien()" id="soluonglaptop" value="0">
												<small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Số lượng phụ kiện</label>
												<input type="text" placeholder="" class="form-control"
													onchange="tinhtien()" name="solgphukien"
													id="soluongphukien" value="0"> <small></small>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label">Tổng tiền</label> <input
													type="text" placeholder="" readonly="readonly"
													class="form-control" name="tongtien" id="tongtien"
													value="0"> <small></small>
											</div>
										</div>
										<div class="col-md-12">
											<hr>
											<div class="form-actions form-group">
												<button type="submit" class="btn btn-success">Lưu
													lại</button>
												<a class="btn btn-danger" href="listdetail?id=<%=(String) session.getAttribute("idBH")%>">Hủy bỏ</a>
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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>

	<script>
		function laptop(idlaptop){
			$.ajax({
				url: "getlaptop",
				data: {
					idlaptop: idlaptop
				},
				type: "POST"
			}).done(function(ketqua){
				var array =  JSON.parse(ketqua);
				$('#gialaptop').val(array[0]);
				
			})
		}
	</script>

	<script>
	function wft(idphukien){
		
		$.ajax({
			url: "getphukien",
			data: {
				idphukien: idphukien
			},
			type: "POST"
		}).done(function(ketqua){
			var array =  JSON.parse(ketqua);
			$('#giaphukien').val(array[0]);
			
		})
		}
	</script>
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
		$(document).ready(function(){
			$('.search-select-box select').selectpicker();
			})
	</script>

	<style type="text/css">
.form-group.error small {
	color: #e74c3c;
}

.form-group {
	margin-right: 0px !important
}

.search-select-box {
	margin-right: 0px
}

.search-select-box select {
	width: 100%
}

.search-select-box button {
	width: 100%
}
</style>


	<script>
	var form = document.getElementById('form-action');
	var gialaptop = document.getElementById('gialaptop');
	var giaphukien = document.getElementById('giaphukien');
	var soluonglaptop = document.getElementById('soluonglaptop');
	var soluongphukien = document.getElementById('soluongphukien');

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
	

    function tinhtien(){
    	var tongtien= gialaptop.value*soluonglaptop.value + giaphukien.value*soluongphukien.value;
    	document.getElementById('tongtien').value= tongtien
		
        }
	 form.addEventListener('submit', function(e) {
	        e.preventDefault()
	    	
	        var checkEmpty= checkEmptyError([gialaptop,soluonglaptop,giaphukien,soluongphukien]);
	        var isNumber1= checkNumber(gialaptop);
	        var isNumber2= checkNumber(soluonglaptop);
	        var isNumber3= checkNumber(giaphukien);
	        var isNumber4= checkNumber(soluongphukien);   
	        if(checkEmpty  && isNumber1 && isNumber2 && isNumber3 && isNumber4){
				 form.submit();
		        }
	        
	    });
		
	</script>

</body>
</html>