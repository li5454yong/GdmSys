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
						 <form method="get" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">企业导师姓名</label>
                                <div class="col-sm-2">
                                    <input type="text" id="qyds" value="${data.qyds }" class="form-control">
                                </div>
                                <label class="col-sm-2 control-label">企业导师职务</label>
                                <div class="col-sm-2">
                                    <input type="text" id="zw" value="${data.zw }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">企业导师学历</label>
                                <div class="col-sm-2">
                                    <input type="text" id="xl" value="${data.xl }" class="form-control">
                                </div>
                                <label class="col-sm-2 control-label">导师专业</label>
                                <div class="col-sm-2">
                                    <input type="text" id="dszy" value="${data.dszy }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">电子邮箱</label>
                                <div class="col-sm-2">
                                    <input type="text" id="email" value="${data.email }" class="form-control">
                                </div>
                                <label class="col-sm-2 control-label">手机号码</label>
                                <div class="col-sm-2">
                                    <input type="text" id="phonenum" value="${data.phonenum }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">单位邮箱</label>
                                <div class="col-sm-2">
                                    <input type="text" id="dwemail" value="${data.dwemail }" class="form-control">
                                </div>
                                <label class="col-sm-2 control-label">单位电话</label>
                                <div class="col-sm-2">
                                    <input type="text" id="dwphone" value="${data.dwphone }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">单位省份</label>
                                <div class="col-sm-2">
                                    <input type="text" id="dwsf" value="${data.dwsf }" class="form-control">
                                </div>
                                <label class="col-sm-2 control-label">单位名称</label>
                                <div class="col-sm-2">
                                    <input type="text" id="dwmc" value="${data.dwmc }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">单位地址</label>
                                <div class="col-sm-6">
                                    <input type="text" id="dwdz" value="${data.dwdz }" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">实习内容</label>
                                <div class="col-sm-6">
                                    <textarea rows="5" cols="55" id="sxnr">${data.sxnr }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">实习总结</label>
                                <div class="col-sm-10">
                                    <textarea id="sxzj" rows="5" cols="55">${data.sxzj }</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            
                          <%--   <div class="form-group">
                                <label class="col-sm-2 control-label">发布日期</label>
                                <div class="col-sm-10">
                                    <input placeholder="请输入日期" class="laydate-icon" id="init_date" value="${data.init_date }"
                                    onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div> --%>
                            <%-- <div class="form-group">
                                <label class="col-sm-2 control-label">导师意见</label>
                                <div class="col-sm-10">
                                    <textarea rows="5" cols="55" id="suggestion" readonly="readonly">${data.suggestion}</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div> --%>
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
	var qyds = $("#qyds").val(); //企业导师
	var zw = $("#zw").val(); //导师职务
	var xl = $("#xl").val(); //学历
	var dszy = $("#dszy").val(); //导师专业
	var email = $("#email").val(); //导师邮箱
	var phonenum = $("#phonenum").val(); //导师电话
	var dwemail = $("#dwemail").val(); //企业邮箱
	var dwphone = $("#dwphone").val();//单位电话
	var dwsf = $("#dwsf").val();//单位省份
	var dwmc = $("#dwmc").val(); //单位名称
	var dwdz = $("#dwdz").val(); //单位地址
	var sxnr = $("#sxnr").val();//实习内容
	var sxzj = $("#sxzj").val(); //实习总结
	
	$.ajax({
		url:'${ctx}/internshipReportSave',
		data:{'qyds':qyds,'zw':zw,'dwdz':dwdz,'sxnr':sxnr,'sxzj':sxzj,
			'xl':xl,'dszy':dszy,'email':email,'phonenum':phonenum,
			'dwemail':dwemail,'dwphone':dwphone,'dwsf':dwsf,'dwmc':dwmc},
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