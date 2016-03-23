<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/WEB-INF/page/tag/tag.jsp"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>毕业设计过程管理系统</title>

    <link href="${ctx }/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${ctx }/css/font-awesome.css?v=4.3.0" rel="stylesheet">
    <link href="${ctx }/css/style.css?v=2.2.0" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/Huploadify.css"/>
</head>

<body>
    <div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">

                        <div class="dropdown profile-element" style="text-align: center;" > <span>
                            <c:if test="${user.pic != null}">
                            	<c:if test="${user.pic != ''}">
                            	<img alt="image"  height="100px" width="100px" class="img-circle" src="${user.pic }" />
                            	</c:if>
                            </c:if>
                            
                            
                            <c:if test="${user.pic == null}">
                            <img alt="image" height="100px" width="100px" class="img-circle" src="${ctx }/img/user.png" />
                            </c:if>
                            <c:if test="${user.pic == ''}">
                            <img alt="image" height="100px" width="100px" class="img-circle" src="${ctx }/img/user.png" />
                            </c:if>
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <br><br>
                                <span class="text-muted text-xs block">${user.name } <b class="caret"></b></span> </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="${ctx }/toUploadImg">修改头像</a>
                                </li>
                                <li><a href="${ctx }/toUserInfo">修改密码</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="${ctx }/toLogin">安全退出</a>
                                </li>
                            </ul>
                        </div>

                    </li>
                    <c:if test="${user.power == 0 }">
                    	<li>
                        <a href="#"><i class="fa fa-th-large"></i> 
                        <span class="nav-label">学生管理</span> <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="${ctx }/admin/toImport">初始化学生信息</a>
                            </li>
                            <li><a href="${ctx }/admin/toImport">初始化教师信息</a>
                            </li>
                            <li><a href="${ctx }/admin/getStuList">学生列表</a>
                            </li>
                            <li><a href="${ctx }/admin/getTeaList">教师列表</a>
                            </li>
                        </ul>
                    </li>
                    </c:if>
                    <c:if test="${user.power == 1 }">
                    <li>
                        <a href="${ctx }/initTask">
                        <i class="fa fa-columns"></i> 
                        <span class="nav-label">初始化任务</span>
                        </a>
                    </li>
                    <li>
                        <a href="${ctx }/subject/getListForTeacher">
                        <i class="fa fa-columns"></i> 
                        <span class="nav-label">毕业设计课题</span>
                        </a>
                    </li>
                     <li>
                        <a href="${ctx }/getTaskBook">
                        <i class="fa fa-bar-chart-o"></i> 
                        <span class="nav-label">任务书</span>
                        </a>
                    </li>
                    <li>
                        <a href="${ctx }/openingreport/getOpeningReportList">
                        <i class="fa fa-bar-chart-o"></i> 
                        <span class="nav-label">开题报告</span>
                        </a>
                    </li>
                    <li>
                        <a href="${ctx }/getInternshipReportList">
                        <i class="fa fa-bar-chart-o"></i> 
                        <span class="nav-label">实习报告</span>
                        </a>
                    </li>
                    <li>
                        <a href="${ctx }/getGraduationProjectList">
                        <i class="fa fa-bar-chart-o"></i> 
                        <span class="nav-label">毕业设计</span>
                        </a>
                    </li>
                    </c:if>
                    <c:if test="${user.power == 2 }">
                    <li>
                        <a href="${ctx }/subject/getListForStu">
                        <i class="fa fa fa-globe"></i> 
                        <span class="nav-label">选择课题</span>
                        </a>
                    </li>
                    <li>
                        <a href="${ctx }/getTaskBookStu">
                        <i class="fa fa-bar-chart-o"></i> 
                        <span class="nav-label">任务书</span>
                        </a>
                    </li>
                    <li>
                        <a href="${ctx }/openingreport/getOpeningReportStu">
                        <i class="fa fa-bar-chart-o"></i> 
                        <span class="nav-label">开题报告</span>
                        </a>
                    </li>
                    <li>
                        <a href="${ctx }/getIrByStu">
                        <i class="fa fa-bar-chart-o"></i> 
                        <span class="nav-label">实习报告</span>
                        </a>
                    </li>
                    <li>
                        <a href="${ctx }/getGraduationProjectStu">
                        <i class="fa fa-bar-chart-o"></i> 
                        <span class="nav-label">毕业设计</span>
                        </a>
                    </li>
                   </c:if>
                     
                     <li>
                        <a href="${ctx }/getThesisByStu">
                        <i class="fa fa-bar-chart-o"></i> 
                        <span class="nav-label">毕业论文</span>
                        </a>
                    </li>
                     <li>
                        <a href="index.html#">
                        <i class="fa fa-bar-chart-o"></i> 
                        <span class="nav-label">工作日志</span>
                        </a>
                    </li>
                     <li>
                        <a href="index.html#">
                        <i class="fa fa-bar-chart-o"></i> 
                        <span class="nav-label">答辩成绩</span>
                        </a>
                    </li>
                    
                </ul>

            </div>
        </nav>

        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <ul class="nav navbar-top-links navbar-right">
                        <li>
                            <span class="m-r-sm text-muted welcome-message">
                            <a href="index.html" title="返回首页"><i class="fa fa-home"></i></a>
                            	欢迎使用毕业设计过程管理系统</span>
                        </li>
                        <li>
                            <a href="${ctx }/toLogin">
                                <i class="fa fa-sign-out"></i> 退出
                            </a>
                        </li>
                    </ul>

                </nav>
            </div>
            <div class="row  border-bottom white-bg dashboard-header">
                <div class="col-sm-12">
                    <blockquote class="text-warning" style="font-size:14px">您是否需要自己做一款后台、会员中心等等的，但是又缺乏html等前端知识…
                        <br>您是否一直在苦苦寻找一款适合自己的后台主题…
                        <br>您是否想做一款自己的web应用程序…
                        <br>…………
                        <h4 class="text-danger">那么，现在H+来了</h4>
                    </blockquote>

                    <hr>
                </div>
                
                <div class="col-sm-12">
                
                </div>
                <div id="upload"></div>
            </div>
            
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="${ctx }/js/jquery-2.1.1.min.js"></script>
    <script src="${ctx }/js/bootstrap.min.js?v=3.4.0"></script>
    <script src="${ctx }/js/jquery.metisMenu.js"></script>
    <script src="${ctx }/js/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="${ctx }/js/hplus.js?v=2.2.0"></script>
    <script src="${ctx }/js/pace.min.js"></script>

</body>

</html>