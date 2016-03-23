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
							毕业论文
						</div>
						<div class="ibox-content">
						 <form method="post" id="graduationProjectForm" enctype="multipart/form-data" class="form-horizontal" action="${ctx }/ThesisSave">
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
                                    <textarea rows="5" cols="88" readonly="readonly">${subject.desc1 }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                           <div class="form-group">
                                <label class="col-sm-2 control-label">中文题目</label>
                                <div class="col-sm-6">
                                    <input type="text" id="Thesis" name="title" value="${data.title }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">英文题目</label>
                                <div class="col-sm-6">
                                    <input type="text" id="etitle" name="etitle" value="${data.etitle }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">中文关键字</label>
                                <div class="col-sm-6">
                                    <input type="text" id="gjz" name="gjz" value="${data.gjz }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">英文关键字</label>
                                <div class="col-sm-6">
                                    <input type="text" id="egjz" name="egjz" value="${data.egjz }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                             <div class="form-group">
                                <label class="col-sm-2 control-label">中文摘要</label>
                                <div class="col-sm-6">
                                    <textarea rows="5" cols="88" name="zy" id="zy">${data.zy }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                             <div class="form-group">
                                <label class="col-sm-2 control-label">英文摘要</label>
                                <div class="col-sm-6">
                                    <textarea rows="5" cols="88" name="ezy" id="ezy">${data.ezy }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
		                	
		                	<div class="form-group">
                                <label class="col-sm-2 control-label">英文摘要</label>
                                <div class="col-sm-6">
                                    <input type="file" name="file">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
		                	
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