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
<script type="text/javascript" src="${basepath}jsp/dap/larscreen/index5.js"></script>
<script type="text/javascript">
$(function() {
	   $("#prev_btn").click(function () { window.location.href = 'index4' });
       $("#next_btn").click(function () { window.location.href = 'index6' });
       $("#dian img").attr("src", "../../skin/images/larscreen/dian01.png");
       $("#dian img:eq(5)").attr("src", "../../skin/images/larscreen/dian01_d.png"); 
       Chart1();
       Chart2();
       Chart3();
       Chart4();
       Chart5();
       Chart6();
       Chart7();
       chart9();
    
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
            setTimeout(function () {
                setInterval(function () {
                 //  $("#next_btn").click();

                }, 1000 * 60)
            }, 100);


            $("#dian img").click(function () {
                var page = 0;
                var index = parseInt($(this).attr("bz"));
                page =(page+index)==0?"":(page+index);
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
  <div class="row" style="width:100%;height:95%; padding:10px 0px 10px 20px; margin-right:-20px">
    <div class="row" style="height: 80px;margin-left:10px; margin-right:20px;  background: url('../../skin/images/larscreen/title_bg01.png') no-repeat center top; text-align:center;color:#fff;font-size:20px;font-weight:600;line-height:60px">工商投诉举报数据分析</div>
    <div class="row" style="margin-left:10px;margin-right:-15px">
        <div class="col-md-2 box" style="height:520px; " id="chart2">
        </div>
        <div class="col-md-10">
            <div class="row">
                <div class="col-md-5 box" style="height:520px" id="chart1">
                </div>
                <div style="position:absolute;width:220px;height:40px; margin-top:10px;margin-left:10px;">

                    <div style="width:70px;height:45px;padding:5px;text-align:center;margin-left:15px; ">
                        <span style="color:#06F8FF">新增被诉</span>
                        <div class="row"><span style="color:#fff;font-size:18px">0012</span><span style="color:#06F8FF;font-size:16px">起</span></div>
                    </div>
                    <div style="width:70px;height:45px;padding:5px;text-align:center;margin-left:15px; ">
                        <span style="color:#06F8FF">同比增减</span>
                        <div class="row"><span style="color:red;font-size:18px">-</span><span style="color:#fff;font-size:18px">12%</span></div>
                    </div>
                    <div style="width:70px;height:45px;padding:5px;text-align:center;margin-left:15px; ">
                        <span style="color:#06F8FF">环比增减</span>
                        <div class="row"><span style="color:red;font-size:18px">-</span><span style="color:#fff;font-size:18px">3%</span></div>
                    </div>
                </div>

                <div class="col-md-7" style="height:520px">
                    <div class="row" style="height:50%;padding:0px">
                        <div class="col-md-4 box" style="height:100%;" id="chart3">

                        </div>
                        <div style="position:absolute;width:220px;height:40px; margin-top:32%;margin-left:0px;">

                            <div style="background-color:rgba(41,64,94,0.6);width:80px;height:45px;padding:5px;text-align:center;margin-left:15px;float:left">
                                <span style="color:#06F8FF">办结数量</span>
                                <div class="row"><span style="color:#fff;font-size:16px">1016</span><span style="color:#06F8FF;font-size:12px">起</span></div>
                            </div>
                            <div style="background-color:rgba(41,64,94,0.6);width:80px;height:45px;padding:5px;text-align:center;margin-left:15px;float:left">
                                <span style="color:#06F8FF">同比增减</span>
                                <div class="row"><span style="color:red;font-size:16px">+</span><span style="color:#06F8FF;font-size:16px">60%</span></div>
                            </div>
                        </div>
                        <div class="col-md-4 box" style="height:100%;margin-left:15px;width:30%" id="chart4">
                        </div>
                        <div style="position:absolute;width:220px;height:40px; margin-top:32%;margin-left:210px;">

                            <div style="background-color:rgba(41,64,94,0.6);width:70px;height:45px;padding:5px;text-align:center;margin-left:15px;float:left">
                                <span style="color:#06F8FF">满意数量</span>
                                <div class="row"><span style="color:#fff;font-size:16px">998</span><span style="color:#06F8FF;font-size:12px">起</span></div>
                            </div>
                            <div style="background-color:rgba(41,64,94,0.6);width:70px;height:45px;padding:5px;text-align:center;margin-left:15px;float:left">
                                <span style="color:#06F8FF">同比增减</span>
                                <div class="row"><span style="color:red;font-size:16px">+</span><span style="color:#06F8FF;font-size:16px">40%</span></div>
                            </div>
                        </div>
                        <div class="col-md-4 box" style="height:100%;margin-left:15px;width:30%" id="chart5">
                        </div>
                        <div style="position:absolute;width:220px;height:40px; margin-top:32%;margin-left:415px;">

                            <div style="background-color:rgba(41,64,94,0.6);width:70px;height:45px;padding:5px;text-align:center;margin-left:15px;float:left">
                                <span style="color:#06F8FF">三产被诉</span>
                                <div class="row"><span style="color:#fff;font-size:16px">118</span><span style="color:#06F8FF;font-size:12px">起</span></div>
                            </div>
                            <div style="background-color:rgba(41,64,94,0.6);width:70px;height:45px;padding:5px;text-align:center;margin-left:15px;float:left">
                                <span style="color:#06F8FF">同比增减</span>
                                <div class="row"><span style="color:red;font-size:16px">-</span><span style="color:#06F8FF;font-size:16px">6%</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin-top:15px;height:48%">
                        <div class="col-md-4 box" style="height:100%" id="chart6">
                        </div>
                        <div class="col-md-4 box" style="height:100%;margin-left:15px;width:30%" id="chart7">
                        </div>
                        <div class="col-md-4 box" style="height:100%;margin-left:15px;width:30%" id="chart8">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin-left:10px; margin-right:-10px;margin-top:10px">
        <div class="col-md-2" style="height: 100px; border-top: 3px solid #0A3267;color:#fff;font-size:14px; padding:0px ">
            <div class="row" style="padding:0px;height:50px;line-height:50px">
                <div class="col-md-3" style="width:20%; padding:0px;height:50px;line-height:50px;text-align:center;font-weight:600;color:#06F8FF">时段：</div>
                <div class="col-md-9  " style="width:80%; padding:0px;height:50px;line-height:50px">
                    <ul id="ul_time" class="ul_2"> <li><a class="action">本年</a></li><li><a>本季</a></li><li><a>本月</a></li><li><a>当日</a></li></ul>
                </div>
            </div>
            <div class="row" style="padding:0px;height:50px;line-height:40px">
                <div class="col-md-3" style="width:20%; padding:0px;height:50px;line-height:40px;text-align:center;font-weight:600;color:#06F8FF">类型：</div>
                <div class="col-md-9  " style="width:80%; padding:0px;height:50px;line-height:40px">
                    <ul id="ul_type" class="ul_2"> <li><a class="action">全部</a></li><li><a>投诉</a></li><li><a>举报</a></li></ul>
                </div>
            </div>
        </div>
        <div class="col-md-10 " style="height:100px">
            <div class="row" style="">
                <div class="col-md-5  " style="height:100px;border-top:3px solid #0A3267;margin-left:1px" id="chart9">
                </div>
                <div class="col-md-7  " style="height:100px;border-top:3px solid #0A3267;margin-left:18px;margin-right:5px; width:55%">

                    <div class="row">
                        <div class="col-md-4  " style="height:60px;margin-top:15px; border-right:2px solid #0A3267">
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    被诉总数
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    200000
                                </div>
                            </div>
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    办结总数
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    100000
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4  " style="height:60px;margin-top:15px; border-right:2px solid #0A3267">
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    投诉总数
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    100000
                                </div>
                            </div>
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    办结投诉
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    50000
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4  " style="height:60px;margin-top:15px; border-right:2px solid #0A3267">
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    举报数量
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    100000
                                </div>
                            </div>
                            <div class="row" style="height:30px;">
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    办结举报
                                </div>
                                <div class="col-md-6  box" style="line-height:30px;text-align:center;padding:0px">
                                    50000
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
        <img src="${basepath}skin/images/larscreen/dian01_d.png" bz="0" />
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