<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modal.User"%>
<%@page import="service.S_View_Resume_Service"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>DashBoard</title>

<!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

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
            <h1 class="h3 mb-0 text-gray-800">Welcome <%=user.getF_name() + " "+ user.getL_name() %></h1>
          </div>
          </hr >
      <!-- View Resume -->
      <div class="card shadow mb-4">
      <% S_View_Resume_Service service = new S_View_Resume_Service();
			ResultSet rs = service.get_resume_id(user.getUser_id());
			if(rs!=null)
			{
						%>
      	<div class="card-body">
      		<div class="table-responsive">
      			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
      				<thead>
      					<tr>
      						<th>Name</th>
      						<th>Address</th>
      						<th>Email Id</th>
      						<th>Work Experience</th>
      						<th>10th Marks</th>
      						<th>12th Marks</th>
      						<th>Graduation</th>
      						<th>Post Graduation</th>
      						<th>Skills</th>
      						<th>Project 1</th>
      						<th>Project 2</th>
      						<th>References</th>
      						<th>User Id</th>
      					</tr>
      					</thead>
						<tbody>
						<%
							if(rs.next())
							{
							%>
							<tr>
								<td><%=rs.getString(1)%></td>
								<td><%=rs.getString(2)%></td>
								<td><%=rs.getString(3)%></td>
								<td><%=rs.getString(4)%></td>
								<td><%=rs.getInt(5)%></td>
								<td><%=rs.getInt(6)%></td>
								<td><%=rs.getInt(7)%></td>
								<td><%=rs.getInt(8)%></td>
								<td><%=rs.getString(9)%></td>
								<td><%=rs.getString(10)%></td>
								<td><%=rs.getString(11)%></td>
								<td><%=rs.getString(12)%></td>
								<td><%=rs.getString(13)%></td>
							</tr>
							<%} %>
						</tbody>
      			</table>
      		</div>
      	</div>
      	<%}else
      		{%>
      		<center><h4>Want to Post your resume?</h4><a href="S_Post_Resume.jsp">Click Me</a></center>
      		<%} %>
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
  <a class="scroll-to-top rounded" href="S_Inbox.jsp">
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