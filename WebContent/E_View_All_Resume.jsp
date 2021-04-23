<%@page import="service.E_View_All_Resume_Service"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="modal.Employee"%>
 <%@page import="java.util.List"%>
<%@page import="service.E_View_All_Result_Service"%>
<%@page import="modal.Post_Resume"%>
<%@page import="service.E_View_All_Result_Service"%>
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

<title>View All Resume</title>

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
    	  	<a class="nav-link" href="E_Add_Question.jsp">
          		<i class="fas fa-fw fa-tachometer-alt"></i>
          		<span>Add Question</span>
          	</a>
          	<a class="nav-link" href="S_Edit_Resume.jsp">
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
            <h1 class="h3 mb-0 text-gray-800">View All Resume</h1>
          </div>
          </hr >
 	<!-- View Deatils -->
 	<div class="card shadow mb-4">
 	<%-- <%
 		E_View_Details service = new E_View_Details();
 		ResultSet rs = service.get_details_by_id(employee.getEmp_id());		
 	%> --%>
 	<div class="card-body">
 		<div class="table-responsive">
 		<form action =" " method ="get">
 			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
 				<thead>
 					<tr>
 						<th>User Id</th>
 						<th>User Name</th>
 						<th>Address</th>
 						<th>Email ID</th>
 						<th>Work Experience</th>
 						<th>10th Marks</th>
 						<th>12th Marks</th>
 						<th>Graduation Marks</th>
 						<th>Post Graduation Marks</th>
 						<th>Skills</th>
 						<th>Project 1</th>
 						<th>Project 2</th>
 						<th>References:</th>
 					</tr>
 				</thead>
 				<tbody>
 				<%
						E_View_All_Resume_Service resume_Service = new E_View_All_Resume_Service();
						List<Post_Resume> list=resume_Service.fetch();
						for(Post_Resume post :list)
						{	
				%>
				<tr>
					<td><%=post.getUser_id() %></td>
					<td><%=post.getName() %></td>
					<td><%=post.getAddress() %></td>
					<td><%=post.getEmail_id() %></td>
					<td><%=post.getWork_exp() %></td>
					<td><%=post.getT_marks() %></td>
					<td><%=post.getTw_marks() %></td>
					<td><%=post.getG_marks() %></td>
					<td><%=post.getP_marks()%></td>
					<td><%=post.getSkill() %></td>
					<td><%=post.getPro_1() %></td>
					<td><%=post.getPro_2() %></td>
					<td><%=post.getReferences() %></td>
				</tr>
				<%} %>
 				</tbody>	
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
  <a class="scroll-to-top rounded" href="E_View_All_Resume.jsp">
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