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
<script type="text/javascript" src="${basepath}jsp/dap/larscreen/index4.js"></script>
<script type="text/javascript">

$(function() {
	   $("#prev_btn").click(function () { window.location.href = 'index3' });
       $("#next_btn").click(function () { window.location.href = 'index5' });
       $("#dian img").attr("src", "../../skin/images/larscreen/dian01.png");
       $("#dian img:eq(4)").attr("src", "../../skin/images/larscreen/dian01_d.png"); 
       Chart3();
       Chart4();
       Chart5();
       Chart6();
       Chart7();
       //Chart8();
       Chart9();
       Chart10();
       Chart11();
    
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
        background-image: url(../../skin/images/larscreen/bg03.png);
        /*background-image: url(../../skin/images/larscreen/44.jpg);*/
        background-repeat : repeat-x；
       
    }

    #ul_1 {
        margin-left: -20px;
    }

        #ul_1 li {
            list-style: none;
            margin-top: 10px;
        }

    .box1 {
        border: 1px solid #3F5584;
        margin-bottom: 1em;
        font-size: 12px;
        height: 100%;
        margin-left: 5px;
        width: 22%;
        border-radius: 0 0 30% 0;
        padding: 12px 0px 0px 10px;
    }
 

        #dian img {
            width: 15px;
            height: 15px;
            margin-left: 20px;
        }
   

    .selectpicker {
        margin-top: 10px;
        width: 100px;
        /*color:3fff;*/
        margin-left: 20px;
        background-color: #111C49;
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
   <div class="row" style="width:100%;height:95%; padding:10px 20px 10px 20px; margin:0px auto;">
    <div class="row" style="height: 80px;  margin-left:20px;  text-align:center;color:#fff;font-size:18px;font-weight:600;line-height:65px">工商行政处罚数据分析</div>
    <div class="row" style="height:95%;margin-top:-20px">
        <div class="col-md-4" style="height:100%; ">
            <div class="row" style="height:33%;padding:0px">
                <div class="row" style="font-weight:600; background:url(../../skin/images/larscreen/title_bg05.png) no-repeat 10% 20px;height:23%;padding:25px 10px 10px 10%;color:#fff">
                    案情总览

                </div>
                <div class="row" style="height:30%;padding:0px">
                    <div class="col-md-4 box1">
                        <span style="color:#fff">&nbsp;&nbsp;立案数量</span>
                        <div class="row"><span style="color:#E8F23B;font-size:16px">1,236</span><span style="color:#E8F23B;font-size:15px">件</span></div>
                    </div>
                    <div class="col-md-4 box1">
                        <span style="color:#fff">&nbsp;&nbsp;涉案金额</span>
                        <div class="row"><span style="color:#E8F23B;font-size:16px">311</span><span style="color:#E8F23B;font-size:15px">万元</span></div>
                    </div>
                    <div class="col-md-4 box1">
                        <span style="color:#fff">&nbsp;&nbsp;结案数量</span>
                        <div class="row"><span style="color:#38D1E4;font-size:16px">1,108</span><span style="color:#38D1E4;font-size:15px">件</span></div>
                    </div>
                    <div class="col-md-4 box1">
                        <span style="color:#fff">&nbsp;&nbsp;罚没金额</span>
                        <div class="row"><span style="color:#38D1E4;font-size:16px">289</span><span style="color:#38D1E4;font-size:15px">万元</span></div>
                    </div>
                </div>
                <div class="row" style="height:30%;padding:0px">
                    <div class="col-md-4 box1">
                        <span style="color:#fff">&nbsp;&nbsp;重大案件</span>
                        <div class="row"><span style="color:#E8F23B;font-size:16px">0,012</span><span style="color:#E8F23B;font-size:15px">件</span></div>
                    </div>
                    <div class="col-md-4 box1">
                        <span style="color:#fff">&nbsp;&nbsp;涉案金额</span>
                        <div class="row"><span style="color:#E8F23B;font-size:16px">186</span><span style="color:#E8F23B;font-size:15px">万元</span></div>
                    </div>
                    <div class="col-md-4 box1">
                        <span style="color:#fff">&nbsp;&nbsp;结案数量</span>
                        <div class="row"><span style="color:#38D1E4;font-size:16px">0,011</span><span style="color:#38D1E4;font-size:15px">件</span></div>
                    </div>
                    <div class="col-md-4 box1">
                        <span style="color:#fff">&nbsp;&nbsp;罚没金额</span>
                        <div class="row"><span style="color:#38D1E4;font-size:16px">1,162</span><span style="color:#38D1E4;font-size:15px">万元</span></div>
                    </div>
                </div>
            </div>
            <div class="row" style="height:33%">

                <div class="row" style="background:url(../../skin/images/larscreen/title_bg05.png) no-repeat 10px 0;height:30px;padding:3px 10px 10px 10%;color:#fff">
                    案件、案值比例

                </div>
                <div class="row" style="height:90%" id="chart7">
                </div>

            </div>
            <div class="row" style="height:33%">
                <div class="row" style="background:url(../../skin/images/larscreen/title_bg05.png) no-repeat 10px 0;height:30px;padding:3px 10px 10px 10%;color:#fff">
                    案件走势分析

                </div>
                <div class="row" style="height:90%;" id="chart9">
                </div>
            </div>

        </div>
        <div class="col-md-4" style="height:100%; ">
            <div style="position:absolute;width:120px;height:40px; margin-top:200px;margin-left:-50px;z-index:1000">
                <div class="col-md-6">
                    <div style="width:70px;height:45px;padding:5px;text-align:center;margin-left:15px; ">
                        <span style="color:#06F8FF">一般案件</span>
                        <div class="row"><span style="color:#fff;font-size:18px">824</span><span style="color:#06F8FF;font-size:16px">件</span></div>
                    </div>
                    <div style="width:70px;height:45px;padding:5px;text-align:center;margin-left:15px; ">
                        <span style="color:#06F8FF">同比增减</span>
                        <div class="row"><span style="color:red;font-size:18px">-</span><span style="color:#fff;font-size:18px">10%</span></div>
                    </div>
                    <div style="width:70px;height:45px;padding:5px;text-align:center;margin-left:15px; ">
                        <span style="color:#06F8FF">环比增减</span>
                        <div class="row"><span style="color:red;font-size:18px">-</span><span style="color:#fff;font-size:18px">3%</span></div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div style="width:70px;height:45px;padding:5px;text-align:center;margin-left:15px; ">
                        <span style="color:#06F8FF">简易案件</span>
                        <div class="row"><span style="color:#fff;font-size:18px">312</span><span style="color:#06F8FF;font-size:16px">件</span></div>
                    </div>
                    <div style="width:70px;height:45px;padding:5px;text-align:center;margin-left:15px; ">
                        <span style="color:#06F8FF">同比增减</span>
                        <div class="row"><span style="color:red;font-size:18px">-</span><span style="color:#fff;font-size:18px">12%</span></div>
                    </div>
                    <div style="width:70px;height:45px;padding:5px;text-align:center;margin-left:15px; ">
                        <span style="color:#06F8FF">环比增减</span>
                        <div class="row"><span style="color:red;font-size:18px">-</span><span style="color:#fff;font-size:18px">5%</span></div>
                    </div>
                </div>
            </div>
            <div class="row" style="height:30%; ">


                <div class="col-md-6" id="chart10" style="height:100%">




                </div>

                <div class="col-md-6" id="chart11" style="height:100%">



                </div>
            </div>
            <div class="row" style="height:70%;bottom:30px " id="chart3">


            </div>

        </div>
        <div class="col-md-4" style="height:100%; ">
            <div class="row" style="height:33%">

                <div class="row" style="margin-top:40px; background:url(../../skin/images/larscreen/title_bg05.png) no-repeat 0px 0;height:30px;padding:3px 10px 10px 10%;color:#fff">
                    超期未办结

                </div>
                <div class="row" style="margin-top:-30px; height:100%" id="chart4">
                </div>
            </div>
            <div class="row" style="height:33%">
                <div class="row" style="background:url(../../skin/images/larscreen/title_bg05.png) no-repeat 0px 0;height:30px;padding:3px 10px 10px 10%;color:#fff">
                    案件高发违法行为（件数 top8）

                </div>
                <div class="row" style="height:90%" id="chart5">
                </div>
            </div>
            <div class="row" style="height:33%">
                <div class="row" style="margin-top:10px; background:url(../../skin/images/larscreen/title_bg05.png) no-repeat 0px 0;height:30px;padding:3px 10px 10px 10%;color:#fff">
                    案件高发违法行为（金额 top8）

                </div>
                <div class="row" style="height:90%" id="chart6">
                </div>
            </div>
        </div>
    </div>
</div>
  <div id="dian" style="position:absolute;bottom:12px;left:45%;z-index:1000">
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="0" />
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="1" />
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="2" />
        <img src="${basepath}skin/images/larscreen/dian01_d.png" bz="3" />
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="4" />
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="5" />
        <img src="${basepath}skin/images/larscreen/dian01.png" bz="6" />
    </div>
</body>
</html>
	
</body>
</html>