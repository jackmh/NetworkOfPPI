<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>PPI NetWork</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<!-- Custom styles for this template -->
<link href="styles/jumbotron-narrow.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="header clearfix">
			<nav>
			<ul class="nav nav-pills pull-right">
				<li role="presentation" class="active"><a href="#">Home</a></li>
				<li role="presentation"><a href="#">About</a></li>
				<li role="presentation"><a href="#">Contact</a></li>
			</ul>
			</nav>
			<h3 class="text-muted">PPI Network</h3>
		</div>

		<div class="jumbotron">
			<h4>Introduction heading</h4>
			<p class="lead">An introduction to PPI</p>
		</div>
		<hr>
		<div class="row marketing">
			<h4>
			<!-- 17342744 -->
				Input a pubmed ID <small>For Example: <a
						onclick="document.getElementById('pubmedID').value='21114487'">Pubmed
							ID: 21114487</a>
				</small>
			</h4>
			<form class="form-inline" action="PubmedIDServlet" method="POST">
				<input type="text" class="form-control" id="pubmedID"
					name="pubmedID" placeholder="Input a PubmedID">
				<button type="submit" class="btn btn-info">Search</button>
			</form>
			<hr>
			<h4>
				Input Two Gene <small> For Example: <a
						onclick="document.getElementById('GeneA').value='MMP2';
							document.getElementById('GeneB').value='IL6'">Gene:MMP2
							VS Gene:IL6</a>
				</small>
			</h4>
			<form class="form-inline" action="GeneInteractionServlet"
				method="POST">
				<input type="text" class="form-control" id="GeneA"
					name="GeneA" placeholder="Input GeneA"> <input
					type="text" class="form-control" id="GeneB"
					name="GeneB" placeholder="Input GeneB">
				<button type="submit" class="btn btn-info">Search</button>
			</form>
			<hr>
			<h4>
				Input PPI Type <small>(PPI/PIP/IPP/PVIP)</small>
			</h4>
			<form class="form-inline" action="PPITypeServlet" method="POST">
				<select class="form-control" name="PPIType">
					<option value="PPI">PPI</option>
					<option value="PIP" selected>PIP</option>
					<option value="IPP">IPP</option>
					<option value="PVIP">PVIP</option>
				</select>
				<button type="submit" class="btn btn-info">Search</button>
			</form>
		</div>
		<div class="footer">
			<p>Copyright &copy; Bioinformatics Lab of Harbin Institute of
				Technology - All Rights Reserved</p>
		</div>
	</div>
	<!-- /container -->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>