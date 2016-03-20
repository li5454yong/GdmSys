<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/tag/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link href="${ctx }/css/summernote/summernote.css" rel="stylesheet">
    <link href="${ctx }/css/summernote/summernote-bs3.css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
		<div class="wrapper wrapper-content animated fadeIn">
			<div class="row">
				<div class="col-lg-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title" style="font-size: 15px;">
							课题列表
							 <a style="float: right;" data-toggle="modal" data-target="#myModal" class="btn btn-primary" 
                                    href="javascript:editPw();">添加课题</a>
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
                                  <td><a href="javascript:edit(${item.id });">编辑</a></td>
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
							<h4 class="modal-title" id="myModalLabel">添加课题</h4>
						</div>
						<div class="modal-body">
						<form method="get" class="form-horizontal">
							<div class="form-group">
                              <label class="col-sm-2 control-label">课题名称</label>
                              <div class="col-sm-10">
                                  <input type="text" id="title" class="form-control">
                              </div>
                             </div>
                             <div class="form-group">
                              <label class="col-sm-2 control-label">可选人数</label>
                              <div class="col-sm-10">
                                  <input type="text" id="num" class="form-control">
                              </div>
                             </div>
                             <div class="form-group">
                              <label class="col-sm-2 control-label">课题简介</label>
                              <div class="col-sm-10">
                              	  <textarea rows="" cols="" id="desc" class="form-control"></textarea>
                              </div>
                             </div>
                             <div class="form-group">
                              <label class="col-sm-2 control-label">预期目标</label>
                              <div class="col-sm-10">
                                  <textarea rows="" cols="" id="expected_target" class="form-control"></textarea>
                              </div>
                             </div>
                             <div class="form-group">
                              <label class="col-sm-2 control-label">能力要求</label>
                              <div class="col-sm-10">
                                  <textarea rows="" cols="" id="demand" class="form-control"></textarea>
                              </div>
                             </div>
                             <div class="form-group">
                              <label class="col-sm-2 control-label">所需条件</label>
                              <div class="col-sm-10">
                                  <textarea rows="" cols="" id="condition" class="form-control"></textarea>
                              </div>
                             </div>
                              <div class="form-group">
                              <label class="col-sm-2 control-label">参考条件</label>
                              <div class="col-sm-10">
                                  <textarea rows="" cols="" id="literature" class="form-control"></textarea>
                              </div>
                             </div>
                             <div class="form-group">
                             <a style="float: right; margin-right: 80px;" data-toggle="modal" 
                             class="btn btn-primary"  href="javascript:add();">添加</a>
                             <a style="float: right; margin-right: 50px;" data-dismiss="modal"
                              class="btn btn-primary" href="#">取消</a>
                             </div>
                             <!-- <div class="form-group">
                              <label class="col-sm-2 control-label">旧密码</label>
							<div class="summernote">
                            </div>
                            </div> -->
                            </form>
						</div>
						
					</div>
				</div>
			</div>
			<!-- 添加课题 弹出层  结束-->
	<!-- 添加课题 弹出层  开始 -->
	<div class="modal fade" id="myModal_e" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header" >
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">修改课题</h4>
						</div>
						<div class="modal-body">
						<form method="get" class="form-horizontal">
							<div class="form-group">
                              <label class="col-sm-2 control-label">课题名称</label>
                              <div class="col-sm-10">
                                  <input type="text" id="title_e" class="form-control">
                              </div>
                             </div>
                             <div class="form-group">
                              <label class="col-sm-2 control-label">可选人数</label>
                              <div class="col-sm-10">
                                  <input type="text" id="num_e" class="form-control">
                              </div>
                             </div>
                             <div class="form-group">
                              <label class="col-sm-2 control-label">课题简介</label>
                              <div class="col-sm-10">
                              	  <textarea rows="" cols="" id="desc_e" class="form-control"></textarea>
                              </div>
                             </div>
                             <div class="form-group">
                              <label class="col-sm-2 control-label">预期目标</label>
                              <div class="col-sm-10">
                                  <textarea rows="" cols="" id="expected_target_e" class="form-control"></textarea>
                              </div>
                             </div>
                             <div class="form-group">
                              <label class="col-sm-2 control-label">能力要求</label>
                              <div class="col-sm-10">
                                  <textarea rows="" cols="" id="demand_e" class="form-control"></textarea>
                              </div>
                             </div>
                             <div class="form-group">
                              <label class="col-sm-2 control-label">所需条件</label>
                              <div class="col-sm-10">
                                  <textarea rows="" cols="" id="condition_e" class="form-control"></textarea>
                              </div>
                             </div>
                              <div class="form-group">
                              <label class="col-sm-2 control-label">参考条件</label>
                              <div class="col-sm-10">
                                  <textarea rows="" cols="" id="literature_e" class="form-control"></textarea>
                              </div>
                             </div>
                             <input type="hidden" id="id_e" value="">
                             <div class="form-group">
                             <a style="float: right; margin-right: 80px;" data-toggle="modal" 
                             class="btn btn-primary"  href="javascript:submitEdit();">修改</a>
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
function add(){
	var title = $("#title").val();
	var num = $("#num").val();
	var desc = $("#desc").val();
	var expected_target = $("#expected_target").val();
	var demand = $("#demand").val();
	var condition = $("#condition").val();
	var literature = $("#literature").val();
	
	$.ajax({
		url:'${ctx}/subject/save',
		data:{'title':title,'num':num,'desc':desc,'expected_target':expected_target,
			'demand':demand,'condition':condition,'literature':literature},
		type:'POST',
		success:function(data){
			if(data.message == 0){
				alert("添加成功");
				window.location.href="${ctx}/subject/getListForTeacher";
			}
		}
		
	});
}

function submitEdit(){
	var id = $("#id_e").val();
	var title = $("#title_e").val();
	var num = $("#num_e").val();
	var desc = $("#desc_e").val();
	var expected_target = $("#expected_target_e").val();
	var demand = $("#demand_e").val();
	var condition = $("#condition_e").val();
	var literature = $("#literature_e").val();
	
	$.ajax({
		url:'${ctx}/subject/update',
		data:{'title':title,'num':num,'desc':desc,'expected_target':expected_target,
			'demand':demand,'condition':condition,'literature':literature,'id':id},
		type:'POST',
		success:function(data){
			if(data.message == 0){
				alert("修改成功");
				window.location.href="${ctx}/subject/getListForTeacher";
			}
		}
		
	});
}

function edit(id){
	$("#myModal_e").modal('toggle');
	$("#id_e").val(id);
	$.ajax({
		url:'${ctx}/subject/get',
		data:{'id':id},
		type:'POST',
		success:function(data){
			var subject = data.message;
			
			$("#title_e").val(subject.title);
			$("#num_e").val(subject.num);
			$("#desc_e").val(subject.desc1);
			$("#expected_target_e").val(subject.expected_target);
			$("#demand_e").val(subject.demand);
			$("#condition_e").val(subject.condition1);
			$("#literature_e").val(subject.literature);
		}
	});
}
</script>
</html>