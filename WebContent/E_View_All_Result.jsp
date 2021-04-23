<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="modal.Employee"%>
<%@page import="java.util.List"%>
<%@page import="service.E_View_All_Result_Service"%>
<%@page import="modal.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>View All Results</title>

<!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>
<body>
	<%
	Employee employee = (Employee)session.getAttribute("employee");
	if(employee!=null)
	{
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
    		<div class="sidebar-brand-text mx-3"><%=employee.getF_name()%></div>
    	</a>
    	 <!-- Divider -->
    	  <hr class="sidebar-divider my-0" >
    	  
    	  <!-- Nav Item - Dashboard -->
    	  <li class="nav-item active">
    	  	<a class="nav-link" href="S_Inbox.jsp">
    	  	 <i class="fas fa-fw fa-tachometer-alt"></i>
          		<span>DashBoard</span>
    	  	</a>
    	  	<a class="nav-link" href="E_Add_Ques.jsp">
          		<i class="fas fa-fw fa-tachometer-alt"></i>
          		<span>Add Question</span>
          	</a>
          	<a class="nav-link" href="E_Delete_Question.jsp">
          		<i class="fas fa-fw fa-tachometer-alt"></i>
          		<span>Delete Question</span>
          	</a>
          	<a class="nav-link" href="E_View_All_Resume.jsp">
          		<i class="fas fa-fw fa-tachometer-alt"></i>
          		<span>View All Resume</span>
          	</a>
          	<a class="nav-link" href="E_View_All_Result.jsp">
          		<i class="fas fa-fw fa-tachometer-alt"></i>
          		<span>View All Results</span>
          	</a>
          	   	<a class="nav-link" href="E_Logout.jsp">
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
            <h1 class="h3 mb-0 text-gray-800">View All Results</h1>
          </div>
          </hr >
 	<!-- View Deatils -->
 	<div class="card shadow mb-4">
 	<div class="card-body">
 		<div class="table-responsive">
 			<form action =" " method ="get">
 			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
 				<thead>
 					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email Id</th>
						<th>Result</th>
 					</tr>
 				</thead>
 				<tbody>
 					<%
						E_View_All_Result_Service ser = new E_View_All_Result_Service();
						List<User> list = ser.fetch();
						for(User user :list)
						{
					%>
 					<tr>
 						<td><%=user.getF_name() %></td>
 						<td><%=user.getL_name() %></td>
 						<td><%=user.getEmail()%></td>
 						<td><%=user.getResult() %></td> 					
 					</tr> 				
 				</tbody>
 				<%} %>
 			</table> 
 			</form>			
 		</div>
 	</div>
 	</div>
 	</div>             
		</div>         
      </div>
    </div>

<%}else{ %>
<jsp:forward page="E_Sign_In.html"></jsp:forward>
<%} %>
  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="E_View_All_Result.jsp">
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