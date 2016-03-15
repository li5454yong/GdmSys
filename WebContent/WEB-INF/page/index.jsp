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

                        <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                                <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">Beaut-zihan</strong>
                             </span> <span class="text-muted text-xs block">超级管理员 <b class="caret"></b></span> </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="#">修改头像</a>
                                </li>
                                <li><a href="#">个人资料</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="login.html">安全退出</a>
                                </li>
                            </ul>
                        </div>

                    </li>
                    <li>
                        <a href="#"><i class="fa fa-th-large"></i> 
                        <span class="nav-label">学生管理</span> <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="#">初始化学生信息</a>
                            </li>
                            <li><a href="#">重置密码</a>
                            </li>
                            <li><a href="#">主页示例三</a>
                            </li>
                            <li><a href="#">主页示例四</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-columns"></i> <span class="nav-label">布局</span><span class="label label-danger pull-right">2.0</span></a>
                    </li>
                    <li>
                        <a href="index.html#"><i class="fa fa fa-globe"></i> <span class="nav-label">v2.0新增</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="#">Toastr通知</a>
                            </li>
                            <li><a href="#">嵌套列表</a>
                            </li>
                            <li><a href="#">时间轴</a>
                            </li>
                            <li><a href="#">论坛</a>
                            </li>
                            <li><a href="#">代码编辑器</a>
                            </li>
                            <li><a href="#">模态窗口</a>
                            </li>
                            <li><a href="#">表单验证</a>
                            </li>
                            <li><a href="#">树形视图</a>
                            </li>
                            <li><a href="#">聊天窗口</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="index.html#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">图表</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="#">百度ECharts</a>
                            </li>
                            <li><a href="#">Flot</a>
                            </li>
                            <li><a href="#">Morris.js</a>
                            </li>
                            <li><a href="#">Rickshaw</a>
                            </li>
                            <li><a href="#">Peity</a>
                            </li>
                            <li><a href="#">Sparkline</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-envelope"></i> <span class="nav-label">信箱 </span><span class="label label-warning pull-right">16</span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="#">收件箱</a>
                            </li>
                            <li><a href="#">查看邮件</a>
                            </li>
                            <li><a href="#">写信</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-flask"></i> <span class="nav-label">小工具</span></a>
                    </li>
                    <li>
                        <a href="index.html#"><i class="fa fa-edit"></i> <span class="nav-label">表单</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="#">基本表单</a>
                            </li>
                            <li><a href="#">表单验证</a>
                            </li>
                            <li><a href="#">高级插件</a>
                            </li>
                            <li><a href="#">步骤条</a>
                            </li>
                            <li><a href="#">百度WebUploader</a>
                            </li>
                            <li><a href="#">文件上传</a>
                            </li>
                            <li><a href="#">富文本编辑器</a>
                            </li>
                            <li><a href="#">simditor</a>
                            </li>
                            <li><a href="#">头像裁剪上传</a>
                            </li>
                            <li><a href="#">日期选择器layerDate</a>
                            </li>
                        </ul>
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
                            <a href="login.html">
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
    
	<script type="text/javascript" src="${ctx }/js/jquery.Huploadify.js"></script>

<script type="text/javascript">
$(function(){
	$('#upload').Huploadify({
		auto:false,
		fileTypeExts:'*.jpg;*.png;*.exe;*.zip;*.rar;*.pdf',
		multi:true,
		formData:{pId:'${pId}'},
		//fileSizeLimit:99999999,
		showUploadedPercent:true,//是否实时显示上传的百分比，如20%
		showUploadedSize:true,
		removeTimeout:99999,
		uploader:'upload',
		onUploadStart:function(){
			//alert('${pId}');
			},
		onInit:function(){
			//alert('初始化');
			},
		onUploadComplete:function(file){
			console.log(file);
			//alert('上传完成');
			},
		onDelete:function(file){
			console.log('删除的文件：'+file);
			console.log(file);
		}
		});
	});
</script>
</body>

</html>