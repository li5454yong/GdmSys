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
							毕业设计
						</div>
						<div class="ibox-content">
						 <form method="post" id="graduationProjectForm" enctype="multipart/form-data" class="form-horizontal" action="${ctx }/graduationProjectSave">
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
                            <label class="col-sm-2 control-label">有无毕业设计</label>
                             <input type="radio" value="0" name="isHave"> <i></i>有毕业设计</label>
                           <input type="radio"  value="1" name="isHave"> <i></i>无毕业设计</label>
                           </div>
                           <c:if test="${data.dataPath == null }">
                            <div class="form-group">
                            <label class="col-sm-2 control-label">上传毕业设计</label>
                             <input type="file" name="files"></label>
                           </div>
                           </c:if>
                           <c:if test="${data.dataPath != null }">
                            <div class="form-group">
                            <label class="col-sm-2 control-label">上传毕业设计</label>
                             <a href="${ctx }/GraduationProjectDownload?dataPath=${data.dataPath}&fileName=${data.fileName }">${data.fileName }</a>
                           </div>
                           </c:if>
                           
                           <div class="form-group">
		                  	<label class="col-sm-2 control-label">审核状态</label>
		                  	<div class="col-sm-6">
		                	<select id="status" class="form-control m-b" disabled="disabled">
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
	$("#graduationProjectForm").submit();
}
</script>
</html>