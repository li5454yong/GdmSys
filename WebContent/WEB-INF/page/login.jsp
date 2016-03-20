<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/tag/tag.jsp"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>毕业设计过程管理系统</title>

    <link href="${ctx }/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${ctx }/css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <link href="${ctx }/css/animate.css" rel="stylesheet">
    <link href="${ctx }/css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name"></h1>

            </div>
            <h3>欢迎使用毕业设计过程管理系统</h3>

            <div class="m-t" role="form">
                <div class="form-group">
                    <input type="text" id="username" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" id="password" class="form-control" placeholder="密码" required="">
                </div>
                
                <div class="form-group">
                	<select id="power" name="account" class="form-control m-b">
                        <option value="">请选择权限</option>
                    	<option value="0">管理员</option>
                    	<option value="1">教师</option>
                    	<option value="2">学生</option>
                    </select>
                </div>
                <button type="submit" onclick="login();" class="btn btn-primary block full-width m-b">登 录</button>
                </p>

            </div>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="${ctx }/js/jquery-2.1.1.min.js"></script>
    <script src="${ctx }/js/bootstrap.min.js?v=3.4.0"></script>
    <script >
    	function login(){
    		var username = $("#username").val();
    		var password = $("#password").val();
    		var power = $("#power").val();
    		$.ajax({
    			url:'${ctx}/login',
    			data:{'username':username,'password':password,'power':power},
    			type:'POST',
    			success:function(data){
    				if(data == 1){
    					alert("用户不存在");
    				}else if(data == 2){
    					alert("密码错误");
    				}else if(data == 0){
    					window.location.href="${ctx}/toIndex";
    				}else if(data == 3){
    					alert("身份错误");
    				}
    			}
    		});
    	}
    </script>
</body>

</html>
