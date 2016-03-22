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
                             <input type="radio" value="option1" name="a"> <i></i>有毕业设计</label>
                           <input type="radio" checked="" value="option2" name="a"> <i></i>无毕业设计</label>
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

$(function(){
	alert(1);
});

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