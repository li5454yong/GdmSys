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
					<c:if test="${user.power == 2 }">
					<div class="ibox float-e-margins">
						<div class="ibox-title" style="font-size: 15px;">
							工作日志
						</div>
						<div class="ibox-content">
						 <form class="form-horizontal" id="dailyLogSave" method="post" action="${ctx }/dailyLogSave">
                           <div class="form-group">
                                <label class="col-sm-2 control-label">内容</label>
                                <div class="col-sm-6">
                                    <textarea rows="5" name="content" cols="88" ></textarea>
                                </div>
                                
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">日期</label>
                                <div class="col-sm-6">
                                    <input placeholder="请输入日期" class="laydate-icon" name="init_date" value=""
                                    onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
		                	
                            <div class="hr-line-dashed"></div>
		                	
                           <div class="text-center">
                            <a data-toggle="modal" class="btn btn-primary" 
                             href="javascript:add();">提交</a>
                            </div>
                         </form>
						</div>
					</div>
					</c:if>
					<c:forEach items="${list }" var="item">
					<div class="ibox float-e-margins">
                       <div class="ibox-title">
                           <h5><fmt:formatDate value="${item.init_date }" pattern="yyyy-MM-dd hh:mm:ss"/> </h5>
                       </div>
                       <div class="ibox-content">
                           <div class="well">
                               ${item.content }
                           </div>
                           
                       </div>
                    </div>
                    </c:forEach>
                    </div>
                    
				</div>
			</div>
		</div>
	</div>
	
</body>
   
<script type="text/javascript">


function add(){
	
$("#dailyLogSave").submit();
	
}
</script>
</html>