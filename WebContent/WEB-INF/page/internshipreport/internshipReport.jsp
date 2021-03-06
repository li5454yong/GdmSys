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
							实习报告
						</div>
						<div class="ibox-content">
						 <table class="table">
						 	<thead>
                              <tr>
                                  <th>任务名称</th>
                                  <th>开始时间</th>
                                  <th>结束时间</th>
                                  <th>修改</th>
                              </tr>
                            </thead>
                            
                            <tbody>
	                           	<tr>
	                           		<td>
	                           		<div class="col-sm-6">
                                     <input type="text" class="form-control" value="${task.tname }">
                                    </div>
                                    </td>
                                    <ul class="inline">
                                    <td>
    								<li class="inline laydate-icon" id="start" 
    								style="width:200px; margin-right:10px;">${task.stime }</li></td>
									<td><li class="inline laydate-icon" id="end" 
									style="width:200px;">${task.etime }</li></td>
									  </ul>
									 <td><a data-toggle="modal" class="btn btn-primary" 
                                    href="javascript:edit(${task.id });">修改</a></td>
	                            </tr>
                            </tbody>
                            </table>
						</div>
					</div>
					
					<div class="ibox float-e-margins">
						<div class="ibox-title" style="font-size: 15px;">
							课题列表
						</div>
						<div class="ibox-content">
							<table class="table">
						 <c:if test="${list != null }">
						 	<thead>
                              <tr>
                                  <th>#</th>
                                  <th>课题名称</th>
                                  <th>学生姓名</th>
                                  <th>导师姓名</th>
                                  <th>可选人数</th>
                                  <th>发布日期</th>
                                  <th>操作</th>
                              </tr>
                            </thead>
						 </c:if>
                            
                            <tbody>
                            <c:forEach items="${list }" var="item" varStatus="num">
                            	<tr>
                                  <td><c:out value="${num.index+1 }"></c:out>  </td>
                                  <td>${item.title }</td>
                                  <td>${item.sname }</td>
                                  <td>${item.tname }</td>
                                  <td>${item.num }</td>
                                  <td><fmt:formatDate value="${item.init_date }" pattern="yyyy-MM-dd HH:mm:ss"/>  </td>
                                  <td>
                                  <a href="javascript:get(${item.sid });">查看实习报告</a>
                                  </td>
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
<!-- 查看实习报告 弹出层  开始 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header" >
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">审核实习报告</h4>
					</div>
					<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
                                <label class="col-sm-2 control-label">企业导师姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" id="qyds" value="" class="form-control">
                                </div>
                                <label class="col-sm-2 control-label">企业导师职务</label>
                                <div class="col-sm-4">
                                    <input type="text" id="zw" value="" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">企业导师学历</label>
                                <div class="col-sm-4">
                                    <input type="text" id="xl" value="" class="form-control">
                                </div>
                                <label class="col-sm-2 control-label">导师专业</label>
                                <div class="col-sm-4">
                                    <input type="text" id="dszy" value="" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">电子邮箱</label>
                                <div class="col-sm-4">
                                    <input type="text" id="email" value="" class="form-control">
                                </div>
                                <label class="col-sm-2 control-label">手机号码</label>
                                <div class="col-sm-4">
                                    <input type="text" id="phonenum" value="" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">单位邮箱</label>
                                <div class="col-sm-4">
                                    <input type="text" id="dwemail" value="" class="form-control">
                                </div>
                                <label class="col-sm-2 control-label">单位电话</label>
                                <div class="col-sm-4">
                                    <input type="text" id="dwphone" value="" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">单位省份</label>
                                <div class="col-sm-4">
                                    <input type="text" id="dwsf" value="" class="form-control">
                                </div>
                                <label class="col-sm-2 control-label">单位名称</label>
                                <div class="col-sm-4">
                                    <input type="text" id="dwmc" value="" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">单位地址</label>
                                <div class="col-sm-10">
                                    <input type="text" id="dwdz" value="" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">实习内容</label>
                                <div class="col-sm-6">
                                    <textarea rows="5" cols="50" id="sxnr"></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">实习总结</label>
                                <div class="col-sm-10">
                                    <textarea id="sxzj" rows="5" cols="50"></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
		                  	<label class="col-sm-2 control-label">审核状态</label>
		                  	<div class="col-sm-6">
		                	<select id="status" class="form-control m-b" >
	                        	<option value="0" selected="selected">未审核</option>
	                    		<option value="1">合格</option>
	                    		<option value="2">不合格</option>
		                    </select>
		                    </div>
		                	</div>
               		<input type="hidden" id="ReportId" value="">
               		<div class="modal-footer">
					<div class="form-group">
                    <a style="float: right; margin-right: 80px;" data-toggle="modal" 
                     class="btn btn-primary"  href="javascript:update();">修改</a>
                    <a style="float: right; margin-right: 50px;" data-dismiss="modal"
                    class="btn btn-primary" href="#">取消</a>
                    </div>
                    </div>
                    </form>
			</div>
			
		</div>
	</div>
</div>
<!-- 添加课题 弹出层  结束-->
</body>
   
<script type="text/javascript">

function edit(tid){
	var start = $("#start").html();
	var end = $("#end").html();
	$.ajax({
		url:'${ctx}/updateTask',
		data:{'id':tid,'stime':start,'etime':end},
		type:'POST',
		success:function(data){
			if(data.message == 0){
				alert("成功");
				window.location.reload();
			}
		}
	});
}

/**
 * 修改审核状态
 */
function update(){
	var ReportId = $("#ReportId").val();
	var status = $("#status").val();
	$.ajax({
		url:'${ctx}/updateStatus',
		data:{'id':ReportId,'status':status},
		type:'POST',
		success:function(data){
			if(data.message == 0){
				alert("审核成功");
				$("#myModal").modal('hide');
				window.location.reload();
			}
		}
	});
	
}


function get(sid){
	
	$.ajax({
		url:'${ctx}/getIrByStuForAjax',
		data:{'sid':sid},
		type:'POST',
		success:function(data){
			var result = data.message
			var internshipReport = JSON.parse(result);
			
			$("#qyds").val(internshipReport.qyds); //企业导师
			$("#zw").val(internshipReport.zw); //导师职务
			$("#xl").val(internshipReport.xl); //学历
			$("#dszy").val(internshipReport.dszy); //导师专业
			$("#email").val(internshipReport.email); //导师邮箱
			$("#phonenum").val(internshipReport.phonenum); //导师电话
			$("#dwemail").val(internshipReport.dwemail); //企业邮箱
			$("#dwphone").val(internshipReport.dwphone);//单位电话
			$("#dwsf").val(internshipReport.dwsf);//单位省份
			$("#dwmc").val(internshipReport.dwmc); //单位名称
			$("#dwdz").val(internshipReport.dwdz); //单位地址
			$("#sxnr").val(internshipReport.sxnr);//实习内容
			$("#sxzj").val(internshipReport.sxzj); //实习总结
			$("#ReportId").val(internshipReport.id);
			
			$('#status  option[value='+internshipReport.status+']').attr("selected",true);
			
			$("#myModal").modal('toggle');
		}
	});
}

function fromatDate(date){
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	var hour = date.getHours();
	var minutes = date.getMinutes();
	var seconds = date.getSeconds();
	return year+"-"+month+"-"+day+" "+hour+":"+minutes+":"+seconds;
}

</script>
</html>