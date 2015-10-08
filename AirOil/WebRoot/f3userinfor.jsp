@<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.struts.LoginAction" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport"    content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">


    <link rel="shortcut icon" href="assets/images/gt_favicon.png">

    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link href="./assets/css/index.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
    <link rel="stylesheet" href="assets/css/main.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]-->
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <link href="./assets/css/f3userinfor.css" rel="stylesheet" type="text/css">
    <link href="./assets/css/f3editpassword.css" rel="stylesheet" type="text/css">
    <link href="assets/css/index.css" rel="stylesheet" type="text/css">
    <title>飞机油耗分析估算系统</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top headroom " >
    <div class="container">
        <div class="navbar-header">
            <!-- Button for smallest screens -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" style="position: relative; right: 100px; " href="index.html"><img src="assets/images/brand.png" style="  position: relative;bottom:14px;" alt="Progressus HTML5 template"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                <li><a href="login.jsp">主页</a></li>
                <li><a href="123.jsp">油耗预估</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">发动机健康管理</a>

                </li>
                <li class="active"><a href="f3userinfor.jsp">用户管理</a></li>
                <!--<li><a class="btn" href="signin.html">登录</a></li>-->
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div align="left" class="f3selectframe col-md-2">
    <div style="margin-top: 50%"></div>
    <ul class="list-group">
        <li class="f3nav" >
            <a class="f3a" style="text-decoration: none;" href="f3userinfor.jsp" > <span style="font-size: 16px;font-family: Microsoft YaHei, '宋体' , Tahoma, Helvetica, Arial;color: white">个人信息</span> </a>
        </li>
        <li class="f3nav">
         <a class="f3a" href="<%=request.getContextPath()%>/ShowpwdeditAction.do" >   <span style="font-size: 16px;font-family: Microsoft YaHei, '宋体' , Tahoma, Helvetica, Arial;color: white">修改密码</span> </a>
        </li>
        <li class="f3nav">
            <a class="f3a" href="<%=request.getContextPath()%>/ShowlistAction.do" onload="" >  <span style="font-size: 16px;font-family: Microsoft YaHei, '宋体' , Tahoma, Helvetica, Arial;color: white">用户管理</span>  </a>
        </li>
        <li class="f3nav">
            <a class="f3a" href="f3powerset.jsp" > <span style="font-size: 16px;font-family: Microsoft YaHei, '宋体' , Tahoma, Helvetica, Arial;color: white">权限设置</span>  </a>
        </li>

    </ul>
    <img src="./assets/images/lg-logo.png" class="f1logo">

</div>
<br/>


<% 
  Connection conn=null;
  try
  {
     Class.forName("com.mysql.jdbc.Driver");
     conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/airoil","root","079322");
     Statement stmt=conn.createStatement();
     ResultSet ra=stmt.executeQuery("select * from administrator where AdName = '"+LoginAction.ADNAME+"'"); 
     ra.next();
     String adName1 = ra.getString("adName1");
%>
<div  class="f3frame" style="position: relative;top: 7%;">
<div align="left"  >
    <p class="f3userhead">个人信息<a href="<%=request.getContextPath()%>/ShowselfAction.do" onload=""> <img src="./assets/images/f3useredit.png" style="margin-left: 70%"></a> </p>
    <hr/><img src="./assets/images/f3userphoto.jpg" align="right" style="width: 30%;height: 30%;">
    <p class="f3usertext">姓名：<span><%=adName1%></span></p>
    <p class="f3usertext">性别：<span><%=ra.getString("adGender")%></span></p>
    <p class="f3usertext">年龄：<span><%=ra.getString("adAge")%></span></p>
    <p class="f3usertext">电话：<span><%=ra.getString("adPhone")%></span></p>
    <p class="f3usertext">邮箱：<span><%=ra.getString("adEmail")%></span></p>
</div>
</div>





<div  class="f3frame2" style="position: relative;top: 7%;">
    <div align="left"  >
        <p class="f3userhead">工作信息</p>
        <hr/>
        <p class="f3usertext">工号：<span><%=ra.getString("adName")%></span></p>
        <p class="f3usertext">职位：<span><%=ra.getString("adPosition")%></span></p>
        <p class="f3usertext">部门：<span><%=ra.getString("adDepartment")%></span></p>
        <p class="f3usertext">入职时间：<span><%=ra.getString("adEnrolltime")%></span></p>

    </div>

</div>

<%
  ra.close();
  stmt.close();
  conn.close();
  }
  catch(Exception e)
  {
     out.println(e.getMessage());
  }
%>

<div class="f3frame3" >
<div align="left">
<p class="f3userhead" style="margin-left: 5%;">权限信息 </p>
<hr/>
<p class="f3usertext" style="margin-left: 5%;">用户角色：<span>系统管理员</span></p>
<p class="f3usertext" style="margin-left: 5%;">用户权限：<span></span></p>
    <span style="margin-left: 5%"></span><button class="btn btn-default">发动机故障预测</button>
    <span style="margin-left: 2%"></span><button class="btn btn-default">用户管理</button>
    <span style="margin-left: 2%"></span><button class="btn btn-default">油耗预估</button> <!--<button class="f3btn ">燃油估计</button> &nbsp; &nbsp;<button class="btn btn-default" >发动机健康管理</button> &nbsp; &nbsp;<button class="btn btn-default">用户管理  </button>-->
 </div>
    </div>

<script type="text/javascript" src="./assets/js/jquery-2.1.4.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
</body>

</html>