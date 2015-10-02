<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
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
            <a class="f3a" href="f3userinfor.jsp" > <span style="font-size: 16px;font-family: Microsoft YaHei, '宋体' , Tahoma, Helvetica, Arial;color: white">个人信息</span> </a>
        </li>
        <li class="f3nav">
            <a class="f3a"  href="<%=request.getContextPath()%>/ShowpwdeditAction.do" >   <span style="font-size: 16px;font-family: Microsoft YaHei, '宋体' , Tahoma, Helvetica, Arial;color: white">修改密码</span> </a>
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
<div class="f3frame3" style="position: relative;top: 7%;">
    <div align="left">
        <p class="f3userhead " style="margin-left: 5%;margin-top: 5%;">用户管理</p>
        <hr/>
        <div style="float: left" class="col-md-4">
       <button style="margin-left: 10%;" class="btn btn-default" onclick="window.location='f3useradd.jsp'">添 加</button>
       
        </div>
        <div class="col-md-8">
            <button type="submit" class="btn btn-success " style="float: right" >Submit</button>
        <div class="form-group" style="float: right; " >
             <input type="text" class="form-control" placeholder="Search">

        </div>
        </div>

        <table class="table"  align="center" style="margin-left: 2%;">
            <thead>
            <tr>
                <th>编号</th>
                <th>工号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>电话</th>
                <th>邮箱</th>
                <th>职位</th>
                <th>部门</th>
                <th>入职时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <logic:present name="administrators">
 			<logic:iterate id="administrator" name="administrators">
            <tr>
                <td><bean:write name="administrator" property="adId"/></td>
                <td><bean:write name="administrator" property="adName"/></td>
                <td><bean:write name="administrator" property="adName1"/></td>
                <td><bean:write name="administrator" property="adGender"/></td>
                <td><bean:write name="administrator" property="adAge"/></td>
                <td><bean:write name="administrator" property="adPhone"/></td>
                <td><bean:write name="administrator" property="adEmail"/></td>
                <td><bean:write name="administrator" property="adposition"/></td>
                <td><bean:write name="administrator" property="adDepartment"/></td>
                <td><bean:write name="administrator" property="adEnrolltime"/></td>
                <td align="center">
 					<form >
						<a href ="DeleteAction.do?metDelete=exscute&ids=<bean:write name="administrator"  property="adId"/>">删除</a>
					</form>
 				</td>
            </tr>
            </logic:iterate>
            </logic:present>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript" src="./assets/js/jquery-2.1.4.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
</body>

</html>