<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modal.User"%>
<%@page import="service.S_Beginner_C_Service"%>
<%@page import="java.util.List"%>
<%@page import="modal.Online_Test_Questions"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Test</title>

<!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

<script>
				function check(sel) {
					val = sel.value;
					i = parseInt(document.getElementById("i").value);
					document.getElementsByClassName("ans")[i].value=val;
					val2 = document.getElementsByClassName("a");
					val2 = val2[i].value;
					if (val2 == val) {
						alert('correct');
						document.getElementById("d").value = parseInt(document
								.getElementById("d").value) + 1;
						document.getElementById("i").value = parseInt(i) + 1;
					} else {
						alert('incorrect');
						document.getElementById("i").value = parseInt(i) + 1;
					}
				}
</script>

</head>
<body>
<%
		User user = (User) session.getAttribute("user");
		if (user != null) {
	%>

<!-- Page Wrapper -->
<div id="wrapper">
<!-- Sidebar -->
    <ul class="navbar-nav sidebar sidebar-dark accordion" id="accordionSidebar" style="background:#7b91b2">
    	<!-- Sidebar - Brand -->
    	<a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
    		<div class="sidebar-brand-icon rotate-n-15">
    			<i class="fas fa-laugh-wink"></i>
    		</div>
    		<div class="sidebar-brand-text mx-3"><%=user.getF_name()%></div>
    	</a>
    	 <!-- Divider -->
    	  <hr class="sidebar-divider my-0" >
    	  
    	  <!-- Nav Item - Dashboard -->
    	  <li class="nav-item active">
    	  	<a class="nav-link" href="S_Inbox.jsp">
    	  	 <i class="fas fa-fw fa-tachometer-alt"></i>
          		<span>Dashboard</span>
    	  	</a>
    	  	<a class="nav-link" href="S_Post_Resume.jsp">
          		<i class="fas fa-fw fa-tachometer-alt"></i>
          		<span>Post Resume</span>
          	</a>
          	<a class="nav-link" href="S_Edit_Resume.jsp">
          		<i class="fas fa-fw fa-tachometer-alt"></i>
          		<span>Edit Resume</span>
          	</a>
          	<a class="nav-link" href="S_Online_Test.jsp">
          		<i class="fas fa-fw fa-tachometer-alt"></i>
          		<span>Online Test</span>
          	</a>
          	   	<a class="nav-link" href="S_Online_Test.jsp">
          		<i class="fas fa-fw fa-tachometer-alt"></i>
          		<span>Logout</span>
          	</a>
    	  </li>
    	  <!-- Divider -->
	      <hr class="sidebar-divider">
 </ul>
 
 <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">
      	<!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"> 
         </nav>
		<div class="container-fluid">
	  <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Online Test</h1>
          </div>
          </hr >
      <!-- View Resume -->
      <div class="card shadow mb-4">
      <div class="card-body">
      		<div class="pagination">
      		<input type="hidden" name="iterator" id="i" value="0" />
 				<form id="f1" name="f1" action="S_Beginner_C_Servlet" method="get">
      			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
      				<thead>
      					<tr>
      						<th>Question</th>
							<th>Option A</th>
							<th>Option B</th>
							<th>Option C</th>
							<th>Option D</th>
							<th>Selected Option</th>
      					</tr>
      					</thead>
						<tbody>
						<%
							S_Beginner_C_Service bcs = new S_Beginner_C_Service();
							List<Online_Test_Questions> list = bcs.fetch();
							for (int i = 0; i < list.size(); i++) {
						%>
							<tr>
								<td><%=list.get(i).getQuestion()%></td>
								<td><input type="radio" name="option" onclick="check(this)"
									value="<%=list.get(i).getOption_a()%>"><%=list.get(i).getOption_a()%></td>
							
								<td><input type="radio" name="option" onclick="check(this)"
									value="<%=list.get(i).getOption_b()%>"><%=list.get(i).getOption_b()%></td>
								
								<td><input type="radio" name="option" onclick="check(this)"
									value="<%=list.get(i).getOption_c()%>"><%=list.get(i).getOption_c()%></td>
								
								<td><input type="radio" name="option" onclick="check(this)"
									value="<%=list.get(i).getOption_d()%>"><%=list.get(i).getOption_d()%></td>
								
								<td><input type="text" name="ans" class="ans"/></td>
							
								 <input type="hidden" name="correct" class="a"
									value="<%=list.get(i).getCorrect_answer()%>">  
							</tr>
							<%} %>
						</tbody>
						<tfoot>
								<tr>
									<td colspan="2"></td><td colspan="3">SCORE <input type="text" name="ac" id="d" value="0" /></td><td></td>
								</tr>
						</tfoot>
      			</table>
      			</form>
      			<button type="submit" form="f1" value="Submit" class="signupbtn">Submit</button>    
      		</div>
      	</div>
      </div>             
		</div>         
      </div>
    </div>
</div>
 	<%
		}else{
	%> 
	<jsp:forward page="index.html"></jsp:forward>
	<%} %>
  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="index.html">
    <i class="fas fa-angle-up"></i>
  </a>
  


<!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>
 

</body>
</html>