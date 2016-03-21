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
							开题报告
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
                                  <a href="javascript:get(${item.sid });">查看开题报告</a>
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
<!-- 添加课题 弹出层  开始 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header" >
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">审核任务书</h4>
					</div>
					<div class="modal-body">
					<form class="form-horizontal">
					<div class="form-group">
					
                                <label class="col-sm-2 control-label">课题名称</label>
                                <div class="col-sm-6">
                                    <input type="text" readonly="readonly" id="title" value="" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">可选人数</label>
                                <div class="col-sm-6">
                                    <input type="text" readonly="readonly" id="num" value="" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课题简介</label>
                                <div class="col-sm-6">
                                    <textarea rows="5" cols="50" id="desc" readonly="readonly"></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">本课题所涉及的问题在国内（外）的研究现状综述</label>
                                <div class="col-sm-10">
                                    <textarea id="yjxz" rows="5" cols="50" id="yjxz"></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">本人对课题任务书提出的任务要求及实现预期目标的可行性分析</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="50" id="kxx"></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">本课题需要重点研究的、关键的问题及解决的思路</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="50" id="jjsl"></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">完成本课题所必须的工作条件（如工具书、实验设备或实验环境条件、某类市场调研、计算机辅助设计条件等等）及解决的办法</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="50" id="hj"></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">完成本课题的工作方案及进度计划</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="50" id="schedule"></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">发布日期</label>
                                <div class="col-sm-10">
                                    <input placeholder="请输入日期" class="laydate-icon" id="init_date" value="${data.init_date }"
                                    onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">导师意见</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="50" id="suggestion"></textarea>
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
               		<input type="hidden" id="OpeningReportId" value="">
					<div class="form-group">
                    <a style="float: right; margin-right: 80px;" data-toggle="modal" 
                     class="btn btn-primary"  href="javascript:update();">修改</a>
                    <a style="float: right; margin-right: 50px;" data-dismiss="modal"
                    class="btn btn-primary" href="#">取消</a>
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
	var OpeningReportId = $("#OpeningReportId").val();
	var status = $("#status").val();
	var suggestion = $("#suggestion").val();
	alert(suggestion);
	$.ajax({
		url:'${ctx}/openingreport/updateOpeningReportStatus',
		data:{'id':OpeningReportId,'status':status,'suggestion':suggestion},
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
		url:'${ctx}/openingreport/getOpeningReportAjax',
		data:{'sid':sid},
		type:'POST',
		success:function(data){
			var result = data.message.split("@LXG");
			var openingReport = JSON.parse(result[0]);
			var subject = JSON.parse(result[1]);
			
			$("#num").val(subject.num);
			$("#desc").val(subject.desc1);
			$("#title").val(subject.title); //任务名称
			$("#yjxz").val(openingReport.yjxz); //研究现状
			$("#kxx").val(openingReport.kxx); //可行性分析
			$("#jjsl").val(openingReport.jjsl); //解决思路
			$("#hj").val(openingReport.hj); //开发环境
			$("#schedule").val(openingReport.schedule); //进度安排
			
			$("#OpeningReportId").val(openingReport.id);
			
			$("#suggestion").val(openingReport.suggestion);
			$("#init_date").val(fromatDate(new Date(openingReport.init_date))); //发布日期
			$('#status  option[value='+openingReport.checkstatus+']').attr("selected",true);
			//$("#taskBookId").val(book.id);
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