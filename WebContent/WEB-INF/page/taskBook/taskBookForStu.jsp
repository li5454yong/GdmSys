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
						 <form method="get" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课题名称</label>
                                <div class="col-sm-6">
                                    <input type="text" readonly="readonly" id="title" value="${subject.title }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">可选人数</label>
                                <div class="col-sm-6">
                                    <input type="text" readonly="readonly" id="" value="${subject.num }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课题简介</label>
                                <div class="col-sm-6">
                                    <textarea rows="5" cols="55" readonly="readonly">${subject.desc1 }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">研究意义及目的</label>
                                <div class="col-sm-10">
                                    <textarea id="objective" rows="5" cols="55">${data.objective }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">主要内容及技术要求</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="55" id="content">${data.content }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">原始数据与资料</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="55" id="olddata">${data.olddata }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">进度安排</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="55" id="schedule">${data.schedule }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">主要参考资料</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="55" id="literature">${data.literature }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">英文资料翻译及其它要求</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="55" id="eliterature">${data.eliterature }</textarea>
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
		                  	<label class="col-sm-2 control-label">审核状态</label>
		                  	<div class="col-sm-6">
		                	<select id="status" class="form-control m-b" disabled="disabled">
		                        <option value="">是否合格</option>
		                        <c:if test="${data.status == 0 }">
		                        	<option value="0" selected="selected">未审核</option>
		                    		<option value="1">合格</option>
		                    		<option value="2">不合格</option>
		                        </c:if>
		                        <c:if test="${data.status == 1 }">
		                        	<option value="0" >未审核</option>
		                    		<option value="1" selected="selected">合格</option>
		                    		<option value="2">不合格</option>
		                        </c:if>
		                        <c:if test="${data.status == 2 }">
		                        	<option value="0" >未审核</option>
		                    		<option value="1">合格</option>
		                    		<option value="2" selected="selected">不合格</option>
		                        </c:if>
		                        
		                    </select>
		                    </div>
		                	</div>
                            
                            <div class="text-center">
                            <a data-toggle="modal" class="btn btn-primary" 
                             href="javascript:add();">提交</a>
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

function add(){
	var title = $("#title").val(); //任务名称
	var objective = $("#objective").val(); //研究意义及目的
	var content = $("#content").val(); //主要内容及技术
	var olddata = $("#olddata").val(); //原始数据及资料
	var schedule = $("#schedule").val(); //进度安排
	var literature = $("#literature").val(); //参考文献
	var eliterature = $("#eliterature").val(); //英文参考文献
	var init_date = $("#init_date").val(); //发布日期
	
	$.ajax({
		url:'${ctx}/saveTaskBook',
		data:{'title':title,'objective':objective,
			'content':content,'olddata':olddata,'schedule':schedule,
			'literature':literature,'eliterature':eliterature,'init_date':init_date},
		type:'POST',
		success:function(data){
			if(data.message == 0){
				alert("填写成功");
				window.location.reload();
			}
		}
	});
}
</script>
</html>