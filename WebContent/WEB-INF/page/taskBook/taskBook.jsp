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
							任务书
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
                                  <a href="javascript:get(${item.sid });">查看任务书</a>
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
					<form method="get" class="form-horizontal">
					
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
                      <label class="col-sm-2 control-label">研究意义及目的</label>
                      <div class="col-sm-10">
                          <textarea id="objective" rows="5" cols="50"></textarea>
                      </div>
                  </div>
                  <div class="hr-line-dashed"></div>
                  <div class="form-group">
                      <label class="col-sm-2 control-label">主要内容及技术要求</label>
                      <div class="col-sm-10">
                          <textarea rows="5" cols="50" id="content"></textarea>
                      </div>
                  </div>
                  <div class="hr-line-dashed"></div>
                  
                  <div class="form-group">
                      <label class="col-sm-2 control-label">原始数据与资料</label>
                      <div class="col-sm-10">
                          <textarea rows="5" cols="50" id="olddata"></textarea>
                      </div>
                  </div>
                  <div class="hr-line-dashed"></div>
                  
                  <div class="form-group">
                      <label class="col-sm-2 control-label">进度安排</label>
                      <div class="col-sm-10">
                          <textarea rows="5" cols="50" id="schedule"></textarea>
                      </div>
                  </div>
                  <div class="hr-line-dashed"></div>
                  
                  <div class="form-group">
                      <label class="col-sm-2 control-label">主要参考资料</label>
                      <div class="col-sm-10">
                          <textarea rows="5" cols="50" id="literature"></textarea>
                      </div>
                  </div>
                  <div class="hr-line-dashed"></div>
                  
                  <div class="form-group">
                      <label class="col-sm-2 control-label">英文资料翻译及其它要求</label>
                      <div class="col-sm-10">
                          <textarea rows="5" cols="50" id="eliterature"></textarea>
                      </div>
                  </div>
                  <div class="hr-line-dashed"></div>
                  
                  <div class="form-group">
                      <label class="col-sm-2 control-label">发布日期</label>
                      <div class="col-sm-10">
                          <input placeholder="请输入日期" class="laydate-icon" id="init_date" value=""
                          onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                      </div>
                  </div>
                  <div class="hr-line-dashed"></div>
                  
                  <div class="form-group">
                  	<label class="col-sm-2 control-label">审核状态</label>
                  	<div class="col-sm-10">
                	<select id="status" class="form-control m-b">
                        <option value="">是否合格</option>
                        <option value="0">未审核</option>
                    	<option value="1">合格</option>
                    	<option value="2">不合格</option>
                    </select>
                    </div>
                </div>
               <input type="hidden" id="taskBookId" value="">
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
	var taskBookId = $("#taskBookId").val();
	var status = $("#status").val();
	$.ajax({
		url:'${ctx}/updateTaskBookStatus',
		data:{'id':taskBookId,'status':status},
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
		url:'${ctx}/getTaskBookTea',
		data:{'sid':sid},
		type:'POST',
		success:function(data){
			var result = data.message.split("@LXG");
			var book = JSON.parse(result[0]);
			var subject = JSON.parse(result[1]);
			
			$("#num").val(subject.num);
			$("#desc").val(subject.desc1);
			$("#title").val(book.title); //任务名称
			$("#objective").val(book.objective); //研究意义及目的
			$("#content").val(book.content); //主要内容及技术
			$("#olddata").val(book.olddata); //原始数据及资料
			$("#schedule").val(book.schedule); //进度安排
			$("#literature").val(book.literature); //参考文献
			$("#eliterature").val(book.eliterature); //英文参考文献
			$("#init_date").val(fromatDate(new Date(book.init_date))); //发布日期
			$('#status  option[value='+book.status+']').attr("selected",true);
			$("#taskBookId").val(book.id);
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