<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ include file="/WEB-INF/page/tag/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div id="wrapper">
			<div class="wrapper wrapper-content animated fadeIn">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                        	<div class="ibox-title">
                                <h5>个人信息</h5>
                                
                            </div>
                            <div class="ibox-content">
                            	<form method="get" class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">旧密码</label>

                                        <div class="col-sm-6">
                                            <input type="password" id="oldPw" class="form-control">
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">新密码</label>

                                        <div class="col-sm-6">
                                            <input type="password" id="newPw1" class="form-control">
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">确认密码</label>

                                        <div class="col-sm-6">
                                            <input type="password" id="newPw2" class="form-control">
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    
                                     <div class="text-center">
                                    <a data-toggle="modal" class="btn btn-primary" 
                                    href="javascript:editPw();">修改</a>
                                </div>
                                 </form>
                            </div>
                        </div>
                    </div>
                 </div>
            </div>
	</div>
</body>
<script type="text/javascript">
	function editPw(){
		var oldPw = $("#oldPw").val();
		var Pw1 = $("#newPw1").val();
		var Pw2 = $("#newPw2").val();
		
		if(Pw1 != Pw2){
			alert("密码不一致！");
			return;
		}
		
		$.ajax({
    			url:'${ctx}/editPw',
    			data:{'passwd':Pw1,'oldPw':oldPw},
    			type:'POST',
    			success:function(data){
    				if(data == 1){
    					alert("原始密码不正确");
    				}else if(data == 0){
    					alert("修改成功");
    					window.location.href="${ctx}/toLogin";
    				}
    			}
		});
	}
</script>
</html>