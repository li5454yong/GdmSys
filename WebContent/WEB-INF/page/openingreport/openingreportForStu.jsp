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
                                <label class="col-sm-2 control-label">本课题所涉及的问题在国内（外）的研究现状综述</label>
                                <div class="col-sm-10">
                                    <textarea id="yjxz" rows="5" cols="55">${data.yjxz }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">本人对课题任务书提出的任务要求及实现预期目标的可行性分析</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="55" id="kxx">${data.kxx }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">本课题需要重点研究的、关键的问题及解决的思路</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="55" id="jjsl">${data.jjsl }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">完成本课题所必须的工作条件（如工具书、实验设备或实验环境条件、某类市场调研、计算机辅助设计条件等等）及解决的办法</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="55" id="hj">${data.hj }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">完成本课题的工作方案及进度计划</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="55" id="schedule">${data.schedule }</textarea>
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
                                    <textarea rows="5" cols="55" id="suggestion" readonly="readonly">${data.suggestion}</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
		                  	<label class="col-sm-2 control-label">审核状态</label>
		                  	<div class="col-sm-6">
		                	<select id="status" class="form-control m-b" disabled="disabled">
		                        <c:if test="${data.checkstatus == 0 }">
		                        	<option value="0" selected="selected">未审核</option>
		                    		<option value="1">合格</option>
		                    		<option value="2">不合格</option>
		                        </c:if>
		                        <c:if test="${data.checkstatus == 1 }">
		                        	<option value="0" >未审核</option>
		                    		<option value="1" selected="selected">合格</option>
		                    		<option value="2">不合格</option>
		                        </c:if>
		                        <c:if test="${data.checkstatus == 2 }">
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
	var yjxz = $("#yjxz").val(); //研究现状
	
	var kxx = $("#kxx").val(); //可行性分析
	
	var jjsl = $("#jjsl").val(); //解决思路
	
	var hj = $("#hj").val(); //开发环境
	
	var schedule = $("#schedule").val(); //进度安排
	
	var init_date = $("#init_date").val(); //进表日期
	
	$.ajax({
		url:'${ctx}/openingreport/save',
		data:{'yjxz':yjxz,'kxx':kxx,
			'jjsl':jjsl,'hj':hj,'schedule':schedule,'init_date':init_date},
		type:'POST',
		success:function(data){
			if(data.message == 0){
				alert("成功");
				window.location.reload();
			}
		}
	});
}
</script>
</html>