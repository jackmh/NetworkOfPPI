<%@ page language="java" import="java.util.*, interaction.ElemOfPPI"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<title>PubmedID result (PPI)</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="styles/dataTables.bootstrap.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%
		HttpSession hs = request.getSession();
		String result = request.getParameter("result");
		String GeneA = (String) hs.getAttribute("GeneA");
		String GeneB = (String) hs.getAttribute("GeneB");
		List<ElemOfPPI> pPIResultList = (List<ElemOfPPI>) hs.getAttribute("pPIResultList");
	%>
	<div class="container">
		<div class="page-header">
			<nav>
				<ul class="nav nav-pills pull-right">
					<li role="presentation" class="active"><a href="index.jsp">Home</a></li>
					<li role="presentation"><a href="#">About</a></li>
					<li role="presentation"><a href="#">Contact</a></li>
				</ul>
			</nav>
			<h3 class="text-muted">
				Interaction Between Gene <%=GeneA %> and Gene <%=GeneB %>
			</h3>
		</div>
		<p>An Introduction for Interaction Gene Pairs Result</p>
		<hr>
		<table id="GenesInteractionResult"
			class="table table-hover table-striped table-bordered">
			<thead>
				<tr>
					<th>PubmedID</th>
					<th>ID</th>
					<th>GeneAID</th>
					<th>GeneAName</th>
					<th>GeneA_NER_Entity</th>
					<th>GeneBID</th>
					<th>GeneBName</th>
					<th>GeneB_NER_Entity</th>
					<th>Relation_Word</th>
					<th>PPI_Type</th>
				</tr>
			</thead>
			<tbody>
				<%
					int k = 1;
							for (ElemOfPPI ppi : pPIResultList) {
								String pubmedID = ppi.getPubmedID();
								String GeneAID = ppi.getGeneA().getGeneID();
								String GeneBID = ppi.getGeneB().getGeneID();
				%>
				<tr>
					<th scope="row"><%=k%></th>
					<td><a target="_blank"
						href="http://www.ncbi.nlm.nih.gov/pubmed/?term=<%=pubmedID%>"><%=pubmedID%></a>
					</td>
					<td><a target="_blank"
						href="http://www.ncbi.nlm.nih.gov/gene/?term=<%=GeneAID%>"><%=GeneAID%></a>
					</td>
					<td><%=ppi.getGeneA().getGeneName()%></td>
					<td><%=ppi.getGeneA().getRecognitionProteins()%></td>
					<td><a target="_blank"
						href="http://www.ncbi.nlm.nih.gov/gene/?term=<%=GeneBID%>"><%=GeneBID%></a>
					</td>
					<td><%=ppi.getGeneB().getGeneName()%></td>
					<td><%=ppi.getGeneB().getRecognitionProteins()%></td>
					<td><%=ppi.getRelateionWords()%></td>
					<td><%=ppi.getType()%></td>
				</tr>
				<%
					k += 1;
						}
				%>
			</tbody>
		</table>
	</div>
	<!-- /container -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
	<script type="text/javascript" class="init">
		$(document).ready(function() {
			$('#GenesInteractionResult').dataTable();
		});
	</script>
</body>
</html>