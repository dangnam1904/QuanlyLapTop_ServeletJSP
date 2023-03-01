<%@page import="model.ThongKeNhapHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.ThongKeDoanhThu"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin - Thống kê nhập hàng</title>
<meta name="description" content="Admin - Bán hàng">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="../include/css.jsp"></jsp:include>
	<script src="../../lib/bower_components/jquery/dist/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.js"></script>
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
									<b>THỐNG KÊ NHẬP HÀNG</b>
								</h1>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="page-header float-right">
							<div class="page-title">
								<ol class="breadcrumb text-right">
									<li><a href="javascript:void(0)">Trang chủ</a></li>
									<li><a href="javascript:void(0)">Thống kê</a></li>
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
								<strong>KHOẢNG THỜI GIAN</strong>
							</div>
							<div class="card-body card-block">
								<form action="nhaphang" method="post"
									enctype="application/x-www-form-urlencoded"
									class="form-horizontal">
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-3">
											<div class="form-group">
												<label class="form-control-label">Từ ngày</label> <input
													type="date" placeholder="Chọn ngày" class="form-control"
													name="tungay" required="required" id="tungay" value="">
											</div>
										</div>

										<div class="col-md-3">
											<div class="form-group">
												<label class="form-control-label">Đến ngày</label> <input
													type="date" placeholder="Chọn ngày" class="form-control"
													name="denngay" required="required" id="denngay" value="">
											</div>
										</div>
										<div class="col-md-2">
											<div class="form-actions form-group">
												<button type="submit"
													class="btn btn-success form-control mt-4" onclick="ThongKe()">Thống kê</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>

					<div class="col-md-12" id="danhsach" >
						<div class="card">
							<div class="card-header">
								<strong>DANH SÁCH</strong>
							</div>
							<div class="card-body card-block" id="showajax">
								<table id="bootstrap-data-table"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>STT</th>
											<th>Người gửi</th>
											<th>SĐT</th>
											<th>Địa chỉ</th>
											<th>Ghi chú</th>
											<th>Ngày Bán</th>
										
											<th>Tổng tiền</th>
										</tr>
									</thead>
									<tbody>
										<%
									 	
											ArrayList<ThongKeNhapHang> list = (ArrayList<ThongKeNhapHang>) request.getAttribute("list");
										if(list!=null){

											int stt=0;
											for (int i=0; i<list.size();i++) {
												stt=stt+1;
										%>
										<tr>
											<td><%=stt%></td>
											<td><%=list.get(i).getTenNguoiGui()%></td>
											<td><%=list.get(i).getSdtNguoiGui()%></td>
											<td><%=list.get(i).getDiaChi()%></td>
											<td><%=list.get(i).getGhiChu()%></td>
											<td><%=list.get(i).getNgayNhap()%></td>
											<td><%=list.get(i).getTongTien()%></td>
										</tr>
										<%
											}
										}
										%>
									</tbody>
								</table>
							</div>
							<div class="card-footer">
									<div class="float-right"
									style="color: red; margin-right: 10px; font-size: 18px">
									<hr style="border-top: 2px solid red;">
									<h5 id="tongtien"></h5>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-body">
								<h4 class="box-title"></h4>
								<div class="row">
									<div class="col-md-1"></div>
									<div class="col-md-10">
										<canvas id="myChart"></canvas>
									</div>
									<div class="col-md-1"></div>
								</div>
							</div>
						</div>
					</div>
					<!-- /# column -->
				</div>
				<!-- /Thanh toan -->
			</div>
			<!-- .animated -->
		</div>
		<form>
			<input type="hidden" value="<%=request.getAttribute("valueNgay")%>"
				id="valueNgay"> <input type="hidden"
				value="<%=request.getAttribute("valueTongTien")%>"
				id="valueTongTien">
		</form>
		<!-- .content -->
		<div class="clearfix"></div>
	</div>
	<!-- /#right-panel -->
<
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

	<script type="text/javascript">
  $(document).ready(function() {
	 
		let a=0;
		let sum= parseInt('0');
		var rowCount = $('#bootstrap-data-table tr').length;
		
		for( let i= 1; i<rowCount; i++){
			a= document.getElementById("bootstrap-data-table").rows[1].cells[6].innerText;
			a= parseInt(a);
			sum=sum+a;
			}
		
		document.getElementById('tongtien').innerText= "Tổng tiền: "+ sum.toLocaleString('en-US') +" vnđ";
		});
</script>
	
	<script type="text/javascript">
		$(document).ready(function($) {
			var valueNgay = $('#valueNgay').val();
			valueNgay = valueNgay.replace(/'/g, '"');
			valueNgay = JSON.parse(valueNgay);
			var valueTongTien = $('#valueTongTien').val();
			valueTongTien = JSON.parse(valueTongTien);
			
			var canvas = document.getElementById('myChart');
			canvas.height = 110;
			var data = {
				labels : valueNgay,
				datasets : [ {
					label : "Tổng tiền",
					backgroundColor : "rgba(255,99,132,0.2)",
					borderColor : "rgba(255,99,132,1)",
					borderWidth : 2,
					hoverBackgroundColor : "rgba(255,99,132,0.4)",
					hoverBorderColor : "rgba(255,99,132,1)",
					data : valueTongTien
				} ]
			};
			var option = {
				scales : {
					yAxes : [ {
						stacked : true,
						gridLines : {
							display : true,
							color : "rgba(255,99,132,0.2)"
						}
					} ],
					xAxes : [ {
						gridLines : {
							display : false
						}
					} ]
				}
			};

			var myBarChart = new Chart(canvas, {
				type : 'bar',
				data : data,
				options : option
			});
		});
	</script>
</body>
</html>