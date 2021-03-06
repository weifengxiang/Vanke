<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mi" uri="http://mi.org.cn"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:url value="/" var="basepath"></c:url>
<head>
<script type="text/javascript">
var basepath = '${basepath}'; 
</script>
<link rel="stylesheet" href="${basepath}skin/bootstrapcss/bootstrap.css" />
<link rel="stylesheet" href="${basepath}skin/bootstrapcss/font-awesome.css" />  
<script type="text/javascript" src="${basepath}skin/jquery/jquery-1.12.4.min.js"></script>

<script type="text/javascript" src="${basepath}skin/bootstrapjs/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="${basepath}skin/bootstrapjs/common/Common.js"></script>
<script type="text/javascript" src="${basepath}skin/js/map.js"></script>
<script type="text/javascript" src='${basepath}skin/js/utils.js'></script>
<script src="${basepath}skin/echarts/echarts.js"></script>
<script src="${basepath}skin/echarts/walden.js"></script>
<script src="${basepath}skin/echarts/world.CN.js"></script>
<script type="text/javascript" src="${basepath}jsp/dap/larscreen/index3.js"></script>
<script type="text/javascript">
$(function() {
	   $("#prev_btn").click(function () { window.location.href = 'index2' });
       $("#next_btn").click(function () { window.location.href = 'index4' });
       $("#dian img").attr("src", "../../skin/images/larscreen/dian01.png");
       $("#dian img:eq(3)").attr("src", "../../skin/images/larscreen/dian01_d.png"); 
       
 
       Chart1();
       Chart2();
       Chart3();
       chart4() 
    
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
            background-image: url(../../skin/images/larscreen/bg01.png);
            /*background-image: url(../../Content/images/test/44.jpg);*/
            height: 100%;
            width: 100%;
            
        }

        .logo {
            height: 120px;
            /*background-color:#fff;*/
            background-image: url(../../skin/images/larscreen/top.png);
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


            $("#dian img").click(function () {
                var page = 0;
                var index = parseInt($(this).attr("bz"));
                page =(page+index)==0?"":(page+index);
                window.location.href = 'index' + page;
            })
        })
       
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
    <div class="row" style="height: 80px;margin-left:10px; margin-right:10px;  background: url('../../skin/images/larscreen/title_bg01.png') no-repeat center top; text-align:center;color:#fff;font-size:22px;font-weight:600;line-height:60px">泰安主体年报分析</div>
    <div class="row" style="margin-left:10px;margin-right:-15px">
        <div class="col-md-5 box" style="height:50%;width:30%; margin-right:9px;"  id="chart2">
        </div>
        <div class="col-md-7 box"  style="height:50%;width:67%; margin-right:9px;"   id="chart1">
            
        </div>
    </div>
    <div class="row" style="margin-left:10px; margin-right:-10px;margin-top:10px;">    
        <div class="col-md-5 " style="height: 50%; width:30%;margin-right:9px;border-top: 3px solid #0A3267;color:#fff;font-size:14px; padding:0px " >
        <div style="height: 80px;margin-left:10px; margin-right:10px; text-align:center;color:#fff;font-size:20px;font-weight:600;line-height:60px">非公党建情况</div> 
          <div class="row" > 
                    <div class="box" style="position:absolute;width:100%;height:50px; margin-top:-30px;margin-bottom:5px;margin-left:0px;">
                            <div style="width:70px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:18;font-weight:600;">党员数</span>                                
                            </div>
                            <div style="width:80px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:18;font-weight:600;">未成立</span> 
                            </div>
                            <div style="width:80px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:18;font-weight:600;">党员数</span> 
                            </div>
                             <div style="width:80px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:18;font-weight:600;">已成立</span> 
                            </div>
                             <div style="width:70px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:18;font-weight:600;"></span> 
                            </div>
                        </div>
                          <div class="box" style="position:absolute;width:100%;height:50px; margin-top:30px;margin-bottom:5px;margin-left:0px;">
                            <div style="width:70px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">1118</span>                                
                            </div>
                            <div style="width:80px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">28282</span>                                
                            </div>
                           <div style="width:80px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">49252</span>                                
                            </div>
                            <div style="width:80px;height:45px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">8248</span> 
                            </div>
                             <div style="width:70px;height:45px;padding:1px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                               <span style="color:#06f8ff;font-size:18;font-weight:600;">私营：</span> 
                            </div>
                        </div>
                           <div class="box" style="position:absolute;width:100%;height:50px; margin-top:80px;margin-bottom:5px;margin-left:0px;">
                            <div style="width:70px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">1139</span>                                
                            </div>
                            <div style="width:80px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">225622</span>                                
                            </div>
                           <div style="width:80px;height:40px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">60</span>                                
                            </div>
                            <div style="width:80px;height:45px;padding:5px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                                <span style="color:#06f8ff;font-size:16;font-weight:600;">60</span> 
                            </div>
                             <div style="width:70px;height:45px;padding:1px;text-align:center;margin-right:15px;margin-top:10px;float:right">
                               <span style="color:#06f8ff;font-size:18;font-weight:600;">个体：</span> 
                            </div>
                        </div>
                       
          </div>  
        </div>
        
        <div class="col-md-7 " style="height:50%;width:69%">
            <div class="row" >             
                <div class="col-md-7  " style="height:300px;width:58%;margin-right:9px;margin-left:1px;border-top: 3px solid #0A3267;" id="chart3">
                </div> 
                 <div class="col-md-5  " style="height:300px;width:40%;margin-right:9px;margin-left:1px;border-top: 3px solid #0A3267;" id="chart4">
                </div> 
            </div>
        </div>
    </div>
</div>

    </div>
  <div id="dian" style="position:absolute;bottom:12px;left:45%;z-index:1000">
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="0" />
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