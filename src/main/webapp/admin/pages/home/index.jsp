<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Users"%>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin - Quản lý cửa hàng</title>
<meta name="description" content="Admin - Bán hàng">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="../include/css.jsp"></jsp:include>
<link rel="stylesheet"
	href="../lib/bower_components/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
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
									<b>TRANG CHỦ</b>
								</h1>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="page-header float-right">
							<div class="page-title">
								<ol class="breadcrumb text-right">
									<li><a href="javascript:void(0)" class="active">Trang
											chủ</a></li>
								</ol>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="content">
			<div class="animated fadeIn">
				<!-- Widgets  -->
				<div class="row">
					<div class="col-lg-3 col-md-6">
						<div class="card text-white bg-warning">
							<div class="card-body">
								<div class="card-left pt-1 float-left">
									<h3 class="mb-0 fw-r">
										<span class="currency float-left mr-1"></span> <span
											class="count"><%=request.getAttribute("banhang")%></span>
									</h3>
									<p class="text-light mt-1 m-0">
										<a href="#" style="color: white">Tổng đơn bán hàng</a>
									</p>
								</div>
								<!-- /.card-left -->

								<div class="card-right float-right text-right">
									<i class="fa fa-cart-plus icon-lg" aria-hidden="true"></i>
								</div>
								<!-- /.card-right -->

							</div>

						</div>
					</div>

					<div class="col-lg-3 col-md-6">
						<div class="card text-white bg-flat-color-3">
							<div class="card-body">
								<div class="card-left pt-1 float-left">
									<h3 class="mb-0 fw-r">
										<span class="currency float-left mr-1"></span> <span
											class="count"><%=request.getAttribute("nhaphang")%></span>
									</h3>
									<p class="text-light mt-1 m-0">Tổng đơn nhập hàng</p>
								</div>
								<!-- /.card-left -->

								<div class="card-right float-right text-right">
									<i class="fa fa-cart-arrow-down icon-lg" aria-hidden="true"></i>
								</div>
								<!-- /.card-right -->

							</div>

						</div>
					</div>

					<div class="col-lg-3 col-md-6">
						<div class="card text-white bg-flat-color-6">
							<div class="card-body">
								<div class="card-left pt-1 float-left">
									<h3 class="mb-0 fw-r">
										<span class="count"><%=request.getAttribute("laptop")%></span>
									</h3>
									<p class="text-light mt-1 m-0">Tổng laptop hiện có</p>
								</div>
								<!-- /.card-left -->

								<div class="card-right float-right text-right">
									<i class="fa fa-laptop icon-lg" aria-hidden="true"></i>
								</div>
								<!-- /.card-right -->

							</div>

						</div>
					</div>

					<div class="col-lg-3 col-md-6">
						<div class="card text-white bg-flat-color-2">
							<div class="card-body">
								<div class="card-left pt-1 float-left">
									<h3 class="mb-0 fw-r">
										<span class="count"><%=request.getAttribute("phukien")%></span>
									</h3>
									<p class="text-light mt-1 m-0">Tổng phụ kiện hiện có</p>
								</div>
								<!-- /.card-left -->

								<div class="card-right float-right text-right">
									<i class="fa fa-dribbble icon-lg" aria-hidden="true"></i>
								</div>
								<!-- /.card-right -->

							</div>

						</div>
					</div>
				</div>
				<!-- /Widgets -->

				<!-- Thanh toan -->
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-body">
								<h4 class="box-title">Thu nhập 30 ngày gần nhất</h4>
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

					<form>
						<input type="hidden"
							value="<%=request.getAttribute("valueNgay")%>" id="valueNgay">
						<input type="hidden"
							value="<%=request.getAttribute("valueTongTien")%>"
							id="valueTongTien">
					</form>
					
					
					<!-- /# column -->
				</div>
				
				<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<h4 class="box-title">Nhập hàng 30 ngày gần nhất</h4>
						<div class="row">
							<div class="col-md-1"></div>
							<div class="col-md-10">
								<canvas id="myChartNhapHang"></canvas>
							</div>
							<div class="col-md-1"></div>
						</div>
					</div>
				</div>
			</div>
			<form>
		<input type="hidden"
			value="<%=request.getAttribute("valueNgayNhap")%>" id="valueNgayNhap">
		<input type="hidden"
			value="<%=request.getAttribute("valueTongTienNhap")%>"
			id="valueTongTienNhap">
	</form>
			<!-- /# column -->
		</div>
				<!-- /Thanh toan -->
			</div>
			<!-- .animated -->
		</div>
		<!-- .content -->


		
		<!-- /Thanh toan -->
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
	<script src="../../lib/bower_components/jquery/dist/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.js"></script>

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

	<script type="text/javascript">
		$(document).ready(function($) {
			var valueNgay = $('#valueNgayNhap').val();
			valueNgay = valueNgay.replace(/'/g, '"');
			valueNgay = JSON.parse(valueNgay);
			var valueTongTien = $('#valueTongTienNhap').val();
			valueTongTien = JSON.parse(valueTongTien);

			var canvas = document.getElementById('myChartNhapHang');
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