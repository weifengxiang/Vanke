<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:url value="/" var="basepath"></c:url>
<head>
<script type="text/javascript">
var basepath = '${basepath}'; 
</script>
<link rel="stylesheet" href="${basepath}skin/plugins/bootstrapcss/bootstrap.css" />
<link rel="stylesheet" href="${basepath}skin/plugins/bootstrapcss/font-awesome.css" />  
<script type="text/javascript" src="${basepath}skin/jquery/jquery-1.12.4.min.js"></script>

<script type="text/javascript" src="${basepath}skin/plugins/bootstrapjs/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="${basepath}skin/plugins/bootstrapjs/common/Common.js"></script>
<script type="text/javascript" src="${basepath}skin/plugins/js/map.js"></script>
<script type="text/javascript" src='${basepath}skin/plugins/js/utils.js'></script>
<script src="${basepath}skin/plugins/echarts/echarts.js"></script>
<script src="${basepath}skin/plugins/echarts/walden.js"></script>
<script src="${basepath}skin/plugins/echarts/world.CN.js"></script>
<script type="text/javascript" src="${basepath}jsp/bigscreen/index.js"></script>
<script type="text/javascript">
$(function() {
	   $("#prev_btn").click(function () { window.location.href = 'index8' });
       $("#next_btn").click(function () { window.location.href = 'index1' });
       $("#dian img").attr("src", ${basepath}+"skin/images/larscreen/dian01.png");
       $("#dian img:eq(0)").attr("src", ${basepath}+"skin/images/larscreen/dian01_d.png"); 
       
 
       Chart1();
       Chart2();
       Chart3();
       Chart4();
       //Chart5();
      // Chart6();
       Chart7();
       chart9();
      chart10();
    
});	 

</script>
<security:csrfMetaTags />
<title>泰安工商系统数据分析平台大屏</title>
</head>
<body >


    <style>
        html {
            height: 100%;
            width: 100%;
        } 
        body {
            margin: 0px;
            margin-bottom: 0px;
            overflow-x: hidden;
            overflow-y: hidden;
            /*background-color:#13277D;*/
            background-image: url(../skin/images/larscreen/bg01.png);
            /*background-image: url(../../Content/images/test/44.jpg);*/
            height: 100%;
            width: 100%;
            
        }

        .logo {
            height: 120px;
            /*background-color:#fff;*/
            background-image: url(../skin/images/larscreen/top.png);
        }

        #menus {
            float: left;
            width: 800px;
            margin-top: 38px;
            padding-left: 10px;
        }

            #menus li {
                float: left;
                width: auto;
                list-style: none;
                margin-left: 50px;
            }

            #menus a {
                font-size: 17px;
                font-family: "微软雅黑";
                color: black;
            }

        #dian img {
            width: 15px;
            height: 15px;
            margin-left: 20px;
        }
   .box {
        
        font-size: 14px;
        font-weight: 600;
        color: #00D7D7; 
	    
    }

    .selectpicker {
        margin-top: 10px;
        width: 100px;
        /*color:3fff;*/
        margin-left: 20px;
        background-color: #111C49;
    }

    .ul_2 {
        margin-left: -40px;
    }

        .ul_2 li {
            margin-left: 10px;
            color: #fff;
            float: left;
            list-style: none;
            cursor: pointer;
        }

            .ul_2 li a {
                color: #fff;
                list-style: none;
                text-decoration-style: none;
                padding: 0px 2px 1px 2px;
                line-height: 20px;
            }

                .ul_2 li a:hover {
                    background-color: rgba(251,65,26,1);
                    text-decoration: none;
                   
                }

                .ul_2 li a.action {
                    background-color: rgba(41,64,94,0.9);
                    text-decoration: none;
                }
           .title{
            
                     color: #fff;  
                     font-weight:600;
                     font-size:14px;          
                list-style: none;
           }
       
    </style>
    <script>
        $(function () {
            setTimeout(function () {
                setInterval(function () {
                 //  $("#next_btn").click();

                }, 1000 * 60)
            }, 100);

            $("#dian img").click(function () {
                var page = 0;
                var index = parseInt($(this).attr("bz"));
                page =page+index;
                window.location.href = 'index' + page;
            })
        })
        function next(index) {

        }
        function isFullscreen() {
            var explorer = window.navigator.userAgent.toLowerCase();
            if (explorer.indexOf('chrome') > 0) {//chrome
                if (document.body.scrollHeight == window.screen.height && document.body.scrollWidth == window.screen.width) {
                    return true;
                } else {
                    return false;
                }
            } else {//IE 9+  fireFox
                if (window.outerHeight == screen.height && window.outerWidth == screen.width) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        function requestFullScreen(element) {
            // 判断各种浏览器，找到正确的方法
            var requestMethod = element.requestFullScreen || //W3C
            element.webkitRequestFullScreen ||    //Chrome等
            element.mozRequestFullScreen || //FireFox
            element.msRequestFullScreen; //IE11
            if (requestMethod) {
                requestMethod.call(element);
            }
            else if (typeof window.ActiveXObject !== "undefined") {//for Internet Explorer
                var wscript = new ActiveXObject("WScript.Shell");
                if (wscript !== null) {
                    wscript.SendKeys("{F11}");
                }
            }
        }

    </script>
</head>
<body>
    <div style="position:absolute;top:335px;right:0px;margin-right:0px; cursor:pointer;z-index:1000">
        <img style="width:25px;height:25px;" src="${basepath}skin/images/larscreen/055.png" id="prev_btn" /></br>
        <img style="width:25px;height:25px;" src="${basepath}skin/images/larscreen/056.png"  id="next_btn" />
    </div> 
  <div style="height:100%;width:100%">
 <div class="row" style="width:100%;height:98%; padding:10px 0px 10px 20px; margin-right:-20px">
    <div class="row" style="height: 80px;margin-left:10px; margin-right:10px;  background: url('../../skin/images/larscreen/title_bg01.png') no-repeat center top; text-align:center;color:#06f8ff;font-size:22px;font-weight:600;line-height:60px">泰安市工商局数据分析平台</div>
    <div class="row" style="margin-left:10px;margin-right:-15px">
        <div class="col-md-3 box" style="height:520px;width:23%; margin-right:9px;"  id="chart2">
        </div>
        <div class="col-md-9">
            <div class="row">
                <div class="col-md-7 box" style="height:520px;width:57%;margin-right:9px;" id="chart1">
                </div>
                <div class="col-md-5" style="height:520px">
                 
                    <div class="row" style="height:50%;padding:0px">
                       <div class="box" style="background-color:rgba(41,64,94,0.6);position:absolute;width:100%;height:46px; margin-top:0%;margin-left:0px;">
                            <div style="width:100px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                                            
                            </div>
                            <div style="width:100px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                 
                            </div>
                            <div style="width:100px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                
                            </div>
                            
                        </div>
                    <div class="box" style="background-color:rgba(41,64,94,0.6);position:absolute;width:100%;height:50px; margin-top:10%;margin-bottom:5px;margin-left:0px;">
                            <div style="width:100px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">年报率</span>                                
                            </div>
                            <div style="width:100px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">已报量</span> 
                            </div>
                            <div style="width:100px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">应报量</span> 
                            </div>
                            
                        </div>
                          <div class="box" style="background-color:rgba(41,64,94,0.6);position:absolute;width:100%;height:50px; margin-top:21%;margin-bottom:5px;margin-left:0px;">
                            <div style="width:100px;height:50px;padding:0px;margin-right:15px;float:right" id="chart4">
                                                           
                            </div>
                           <div style="width:100px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">54747</span>                                
                            </div>
                            <div style="width:100px;height:45px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">59107</span> 
                            </div>
                             <div style="width:100px;height:45px;padding:1px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span class="glyphicon glyphicon-globe" aria-hidden="true" style="font-size:20px;"></span> <span style="color:#06f8ff;font-size:18;font-weight:600;">企业：</span> 
                            </div>
                        </div>
                        <div class="box" style="background-color:rgba(41,64,94,0.6);position:absolute;width:100%;height:50px; margin-top:32%;margin-bottom:5px;margin-left:0px;">
                             <div style="width:100px;height:50px;padding:0px;margin-right:15px;float:right" id="chart5">
                                                          
                            </div>
                            <div style="width:100px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:5px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">9529</span> 
                            </div>
                            <div style="width:100px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:5px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">7594</span> 
                            </div>
                          <div style="width:100px;height:45px;padding:1px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span class="glyphicon glyphicon-grain" aria-hidden="true" style="font-size:20px;"></span> <span style="color:#06f8ff;font-size:18;font-weight:600;">农合：</span> 
                            </div>
                        </div>
                        <div class="box" style="background-color:rgba(41,64,94,0.6);position:absolute;width:100%;height:50px; margin-top:43%;margin-bottom:5px;margin-left:0px;">
                             <div style="width:100px;height:50px;padding:0px;margin-right:15px;float:right" id="chart6">
                                                          
                            </div>
                            <div style="width:100px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:5px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">215905</span> 
                            </div>
                            <div style="width:100px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:5px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">217905</span> 
                            </div>
                          <div style="width:100px;height:45px;padding:1px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span class="glyphicon glyphicon-user  text-primary" aria-hidden="true" style="font-size:20px;"></span> <span style="color:#06f8ff;font-size:18;font-weight:600;">个体：</span> 
                            </div>
                        </div>
                        <div class="box" style="height:100%;width:100%" id="chart3">
                        </div> 
                       
                    </div>
                    <div class="row" style="margin-top:9px;height:48%">
                        <div class="box" style="height:100%;width:100%" id="chart7">
                        </div>
                         
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin-left:10px; margin-right:-10px;margin-top:10px">    
        <div class="col-md-3" style="height: 200px; width:23%;margin-right:9px;border-top: 3px solid #0A3267;color:#fff;font-size:14px; padding:0px " id="chart10">
            
        </div>
        <div class="col-md-9 " style="height:200px">
            <div class="row" >             
                <div class="col-md-7  " style="height:170px;width:57%;margin-right:9px;border-top:3px solid #0A3267;margin-left:1px" id="chart9">
                </div>
                <div class="col-md-5  " style="height:150px;border-top:3px solid #0A3267;" >
                    <div class="row">
                    <div class="col-md-12  title " style="line-height:30px;text-align:center;padding:0px"  >
                   数据动态
                    </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4  " style="height:90px;margin-top:15px; border-right:2px solid #0A3267">
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                                                                         新设立
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    389户                                </div>
                            </div>
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                                                                      变更备案
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    897户                                </div>
                            </div>
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                                                                     注销
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    74户                                </div>
                            </div>
                        </div>
                        <div class="col-md-4  " style="height:90px;margin-top:15px; border-right:2px solid #0A3267">
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    企业年报
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    358户
                                </div>
                            </div>
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    个体年报
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    127户
                                </div>
                            </div>
                             <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    农合年报
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    233户
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4  " style="height:90px;margin-top:15px; border-right:2px solid #0A3267">
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                   立案数
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    3件
                                </div>
                            </div>
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    结案数
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    8件
                                </div>
                            </div>
                             <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    罚没款
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    3.78万元
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    </div>
    <div id="dian" style="position:absolute;bottom:12px;left:45%;z-index:1000">
        <img src="skin/images/larscreen/dian01_d.png" bz="0" />
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="1" />
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="2" />
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="3" />
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="4" />
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="5" />
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="6" />
    </div>
</body>
</html>
	
</body>
</html>