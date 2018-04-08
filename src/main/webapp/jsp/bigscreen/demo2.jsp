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
<script type="text/javascript" src="${basepath}skin/js/map.js"></script>
<script type="text/javascript" src='${basepath}skin/js/utils.js'></script>
<script src="${basepath}skin/plugins/echarts/echarts.min.js"></script>
<script src="${basepath}skin/plugins/echarts/walden.js"></script>
<script type="text/javascript" src="${basepath}jsp/bigscreen/demo2.js"></script>
<script type="text/javascript">
$(function() {
       
       initSalerRankingChart();
       initSaleTeamRankingChart();
       initSaleReportMap();
       initSaleReportBar();
       initSaleLine();
       initSalePie();
    
});	 

</script>
<security:csrfMetaTags />
<title>重庆万科地产项目数据分析平台</title>
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
<div style="height:100%;width:100%">
 <div class="row" style="width:100%;height:98%; padding:10px 0px 10px 20px; margin-right:-20px">
    <div class="row" style="height: 60px;margin-left:10px; margin-right:10px;  background: url('../../skin/images/larscreen/title_bg01.png') no-repeat center top; text-align:center;color:#06f8ff;font-size:22px;font-weight:600;line-height:60px">重庆万科地产项目数据分析平台</div>
    <div class="row" style="margin-left:10px;margin-right:-15px">
        <div class="col-md-3 box" style="height:90%;width:30%; margin-right:9px;"  >
        	<div id="salerRanking" class='box' style='width:100%;height:60%;margin-bottom: 10px'>
        	</div>
        	<div id="saleTeamRanking" class='box' style='width:100%;height:40%;margin-bottom: 10px'>
        	</div>
        </div>
        <div class="col-md-3 box" style="height:90%;width:35%; margin-right:9px;"  >
        	<div id="saleReportMap" class='box' style='width:100%;height:60%;margin-bottom: 10px'>
        	</div>
        	<div id="saleReportBar" class='box' style='width:100%;height:40%;margin-bottom: 10px'>
        	</div>
        </div>
        <div class="col-md-3 box" style="height:90%;width:30%; margin-right:9px;"  >
        	<div id="saleLine" class='box' style='width:100%;height:60%;margin-bottom: 10px'>
        	</div>
        	<div id="salePie" class='box' style='width:100%;height:40%;margin-bottom: 10px'>
        	</div>
        </div>
    </div>
 </div>
</div>
</body>
</html>
	
</body>
</html>