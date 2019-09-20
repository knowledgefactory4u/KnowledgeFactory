<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Knf|File upload and download</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->

<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

<!-- Theme style -->
<link rel="stylesheet" href="../../dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition layout-top-nav">
	<!-- Site wrapper -->
	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="https://www.knowledgefactory.net/p/donate.html"
					class="nav-link">Home</a></li>

			</ul>

		</nav>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->


			<!-- Main content -->
			<section class="content">
				<div class="container">
					<h2>Spring Boot-File upload and download</h2>
					<hr>
					<!-- File Upload From -->
					<form action="fileUpload" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label>Select File</label> <input class="form-control"
								type="file" name="file">
						</div>
						<div class="form-group">
							<button class="btn btn-primary" type="submit" id="uploadfile">Upload</button>
						</div>
					</form>
					<br />

					<!-- Bootstrap Progress bar -->
					<div class="progress">
						<div id="progressBar" class="progress-bar progress-bar-success"
							role="progressbar" aria-valuenow="0" aria-valuemin="0"
							aria-valuemax="100" style="width: 0%">0%</div>
					</div>

					<!-- Alert -->
					<div id="alertMsg" style="color: red; font-size: 18px;"></div>
				</div>
				<div id="list"></div>
				</br>
				<div id="result">
					
					<div class="row align-items-center justify-content-center" id="download">
						
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b> 1.0.0
			</div>
			<strong>Copyright &copy; 2014-2019 <a
				href="http://www.knowledgefactory.net">Knowledge Factory</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script src="../../plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- overlayScrollbars -->
	

	<script src="../../dist/js/adminlte.min.js"></script>
	<script src="../../dist/js/controller.js"></script>

</body>
</html>
