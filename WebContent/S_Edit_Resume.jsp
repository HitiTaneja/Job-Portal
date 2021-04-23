<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modal.User"%>
<%@page import="service.S_View_Resume_Service"%>
 <%@page import="java.sql.ResultSet"%>
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
<!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  
  <link rel="stylesheet" href="css/S_Post_Resume.css">

<title>Edit Resume</title>
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
          		<span>DashBoard</span>
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
          	   	<a class="nav-link" href="index.html">
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
            <h1 class="h3 mb-0 text-gray-800">Edit Your Resume</h1>
            <hr>
          </div>
          <!-- Edit Resume -->
          <form action="S_Edit_Resume_Servlet" id="nameform" method="get">
          <%
          S_View_Resume_Service service = new S_View_Resume_Service();
      	ResultSet rs = service.get_resume_id(user.getUser_id());
      	if(rs.next())
      	{                
          %>
          
          <label for="user_id" class="lab">User Id : </label>
          <input type="text" name="user_id" id="user_id" class="input-text" value=<%=rs.getString(13) %>><br>
          <label for="name" class="lab">Name : </label>
          <input type="text" name="name" id="name" class="input-text" value=<%=rs.getString(1) %>><br>
          <label for="address" class="lab">Address : </label>
          <input type="text" name="address" id="address" class="input-text" value=<%=rs.getString(2) %>><br>
          <label for="email_id" class="lab">Email Id : </label>
          <input type="text" name="email_id" id="email_id" class="input-text" value=<%=rs.getString(3) %>><br>
          <label for="work_exp" class="lab">Work Experience : </label>
          <input type="text" name="work_exp" id="work_exp" class="input-text" value=<%=rs.getInt(4) %>><br>
          <hr>
          <label for="t_marks" class="lab">10th marks : </label>
          <input type="text" name="t_marks" id="t_marks" class="input-text" value=<%=rs.getInt(5) %>><br>
          <label for="tw_marks" class="lab">12th marks : </label>
          <input type="text" name="tw_marks" id="tw_marks" class="input-text" value=<%=rs.getInt(6) %>><br>
          <label for="g_marks" class="lab">Graduation Marks : </label>
          <input type="text" name="g_marks" id="g_marks" class="input-text" value=<%=rs.getInt(7) %>><br>
          <label for="p_marks" class="lab">Post Graduation Marks : </label>
          <input type="text" name="p_marks" id="p_marks" class="input-text" value=<%=rs.getInt(8)%>><br>
          <hr>
          <label for="skill" class="lab">Skill Set : </label>
          <input type="text" name="skill" id="skill" class="input-text" value=<%=rs.getString(9) %>><br>
          <label for="pro_1" class="lab">Project 1 : </label>
          <input type="text" name="pro1" id="pro1" class="input-text" value=<%=rs.getString(10) %>><br>
          <label for="pro_2" class="lab">Project 2 : </label>
          <input type="text" name="pro2" id="pro2" class="input-text" value=<%=rs.getString(11) %>><br>
          <label for="references" class="lab">References : </label>
          <input type="text" name="references" id="references" class="input-text"value=<%=rs.getString(12) %>><br>
          <br>	
          </form>
          <button type="submit" form="nameform" value="Submit" class="signupbtn">Submit</button>
          <%} %>          
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
  <a class="scroll-to-top rounded" href="S_Edit_Resume.jsp">
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