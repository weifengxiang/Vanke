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
<script src="${basepath}skin/echarts/worldcloud.js"></script>
<script type="text/javascript" src="${basepath}jsp/dap/larscreen/index1.js"></script>
<script type="text/javascript">
$(function() {
	   $("#prev_btn").click(function () { window.location.href = 'index' });
       $("#next_btn").click(function () { window.location.href = 'index2' });
       $("#dian img").attr("src", "../../skin/images/larscreen/dian01.png");
       $("#dian img:eq(1)").attr("src", "../../skin/images/larscreen/dian01_d.png"); 
       Chart1();
       Chart2();
       Chart3();
       Chart4();
       Chart5();
       Chart6();
      
      
});	 

</script>
<security:csrfMetaTags />
<title>泰安工商系统数据分析平台</title>
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
            background-image: url(../../skin/images/larscreen/bg.png);
            /*background-image: url(../../Content/images/test/44.jpg);*/
            background-size:cover;
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
    

    .selectpicker {
        margin-top: 10px;
        width: 100px;
        /*color:3fff;*/
        margin-left: 20px;
        background-color: #111C49;
    }

      #ul_1 {
        margin-left: -20px;
    }

        #ul_1 li {
            list-style: none;
            margin-top: 10px;
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
    <div style="position:absolute;top:305px;right:0px;margin-right:0px; cursor:pointer;z-index:1000">
        <img style="width:25px;height:25px;" src="${basepath}skin/images/larscreen/055.png" id="prev_btn" /></br>
        <img style="width:25px;height:25px;" src="${basepath}skin/images/larscreen/056.png"  id="next_btn" />
    </div> 
   <div class="row" style="width:100%;height:100%; padding:10px 20px 10px 20px; margin:0px auto;bottom:25px">
    <div class="row" style="height: 80px;   text-align:center;color:#fff;font-size:20px;font-weight:600;line-height:60px">市场主体发展总体情况</div>
    <div class="row" style="height:96%;margin-top:-20px">
        <div class="col-md-3" style="height:100%; ">
            <div class="row " style="height:50%;padding:3px;margin:0px 3px 0px 0px;border-right:3px dashed rgba(41,64,94,0.6);border-left:3px dashed rgba(41,64,94,0.6)" id="chart1"></div>
            <div class="row" style="height:50%" id="chart2"></div>  
        </div>
        <div class="col-md-6" style="height:100%; ">
            <div class="row" style="height:50%; " id="chart3">   </div>  
            <div class="row" style="height:45%;" id="chart6"></div>
        </div>
        <div class="col-md-3" style="height:100%; ">
            <div class="row" style="height:50%" id="chart4"></div>
            <div class="row" style="height:45%" id="chart5"></div> 
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