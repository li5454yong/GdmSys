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
						<div class="ibox-title" style="font-size: 15px;">
							学生列表
						</div>
						<div class="ibox-content">
						 <table class="table">
                            <thead>
                              <tr>
                                  <th>#</th>
                                  <th>登录名</th>
                                  <th>姓名</th>
                                  <th>导师姓名</th>
                                  <th>编辑</th>
                              </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${data }" var="item" varStatus="num">
                            	<tr>
                                  <td><c:out value="${num.index+1 }"></c:out>  </td>
                                  <td>${item.stu_num }</td>
                                  <td>${item.name }</td>
                                  <td>${item.tname }</td>
                                  <td><a href="javascript:editPw(${item.id });">重置密码</a></td>
                              </tr>
                            </c:forEach>
                              
                                
                            </tbody>
                            </table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function editPw(id){
		$.ajax({
			url:'${ctx}/admin/reSetPw',
			data:{'id':id},
			type:'POST',
			success:function(data){
				if(data.message == 1){
					alert("重置成功");
				}
			}
		});
	}
</script>
</html>