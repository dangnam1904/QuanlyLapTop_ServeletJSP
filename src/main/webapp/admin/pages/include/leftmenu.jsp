<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Left Panel -->

<aside id="left-panel" class="left-panel">
	<nav class="navbar navbar-expand-sm navbar-default">

		<div id="main-menu" class="main-menu collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="../home/index"><i class="menu-icon fa fa-laptop"></i>TRANG
						CHỦ</a></li>
				<li class="menu-title">MENU</li>
				<!-- /.menu-title -->
					<% if(session.getAttribute("admin")!=null){ %>
				<li><a href="../user/list"> <i class="menu-icon fa fa-user"></i>Tài
						khoản
				</a></li>
			
				<li><a href="../loailaptop/list"> <i
						class="menu-icon fa fa-building-o"></i>Loại laptop
				</a></li>
				<% }%>
				<li><a href="../laptop/list"> <i
						class="menu-icon ti-receipt"></i>Laptop
				</a></li>
				<li><a href="../phukien/list"> <i
						class="menu-icon ti-receipt"></i>Phụ kiện
				</a></li>
				<li><a href="../banhang/list"> <i class="menu-icon fa fa-book"></i>Bán hàng
				</a></li>
				<li><a href="../nhaphang/list"> <i
						class="menu-icon fa fa-id-card-o"></i>Nhập hàng
				</a></li>
				<li><a href="../dichvusuachua/listdichvusuachua"> <i
						class="menu-icon fa fa-id-card-o"></i>Dịch vụ sửa chữa
				</a></li>
				<li><a href="../thongke/banhang"> <i
						class="menu-icon fa fa-bar-chart"></i>Thống kê doanh thu
				</a></li>
					<li><a href="../thongke/nhaphang"> <i
						class="menu-icon fa fa-bar-chart"></i>Thống kê nhập hàng
				</a></li>
				<li class="menu-item-has-children">
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
</aside>
<!-- /#left-panel -->

<!-- Left Panel -->