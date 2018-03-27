function uuid(len, radix) {
    var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
    var uuid = [], i;
    radix = radix || chars.length;
 
    if (len) {
      // Compact form
      for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
    } else {
      // rfc4122, version 4 form
      var r;
 
      // rfc4122 requires these characters
      uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
      uuid[14] = '4';
 
      // Fill in random data.  At i==19 set the high bits of clock sequence as
      // per rfc4122, sec. 4.1.5
      for (i = 0; i < 36; i++) {
        if (!uuid[i]) {
          r = 0 | Math.random()*16;
          uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
        }
      }
    }
 
    return uuid.join('');
}
/**
 * 对url进行添加csrf
 */
function urlcsrf(url){
	var param =  $("meta[name='_csrf_parameter']").attr("content");
	var token = $("meta[name='_csrf']").attr("content");
	if(url.indexOf("?")>0){
		url=url+"&"+param+"="+token;
	}else{
		url=url+"?"+param+"="+token;
	}
	return url;
}
/**
 * 枚举字段formatter
 * @param value
 * @param rowdata
 * @param ds
 */
function formatterEnum(value,rowdata,ds){
	if(!value){
		return "";
	}
	if(!ds){
		return value;
	}
	for(var i=0;i<ds.length;i++){
		if(value==ds[i].code){
			return ds[i].name;
		}
	}
}
/**
 * 根据code获取枚举name
 * 
 * @param enums
 * @param code
 */
function getEnumName(enums, code) {
	if (enums instanceof Array) {
		for ( var i in enums) {
			if (code == enums[i].code) {
				return enums[i].name;
			}
		}
	}
	return code;
}
function formatterDict(value,rowdata,ds){
	if(!value){
		return "";
	}
	if(!ds){
		return value;
	}
	for(var i=0;i<ds.length;i++){
		if(value==ds[i].code){
			return ds[i].name;
		}
	}
}
function myBrowser() {
	var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
	var isOpera = userAgent.indexOf("Opera") > -1;
	if (isOpera) {
		return "Opera"
	}
	; //判断是否Opera浏览器
	if (userAgent.indexOf("Firefox") > -1) {
		return "FF";
	} //判断是否Firefox浏览器
	if (userAgent.indexOf("Chrome") > -1) {
		return "Chrome";
	}
	if (userAgent.indexOf("Safari") > -1) {
		return "Safari";
	} //判断是否Safari浏览器
	if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1
			&& !isOpera) {
		return "IE";
	}
	; //判断是否IE浏览器
}
/**
 * 添加右击菜单div内容
 * @param tbid(列表按钮div id)
 * @param dgid(列表id)
 */
function initRightClick(tbid,dgid){
	var rmDivId='rightClick'+dgid;
	var rmDiv=$('<div id="'+rmDivId+'" class="easyui-menu" style="width:120px;"></div>');
	rmDiv.appendTo('body');
	$('#'+rmDivId).menu();
	$("#"+tbid+" a").each(function(index,element){
		var onclick=$(element).attr('onclick');
		var text = element.innerText;
		$('#'+rmDivId).menu('appendItem', {
			text: text,
			iconCls: $(element).linkbutton('options').iconCls,
			onclick: onclick
		});
	});
	
}
/**
 * 添加列表右键事件
 * @param dgid(列表id)
 * @param e(事件)
 * @param rowIndex(行索引)
 * @param rowData(行数据)
 */
function onRowContextMenu(dgid,e,rowIndex,rowData){
	var rmDivId='rightClick'+dgid;
	if(1==$("#"+rmDivId+"").children('div').length){
		return;
	}
	e.preventDefault();
	var selected=$("#"+dgid+"").datagrid('getRows'); //获取所有行集合对象
	$("#"+dgid+"").datagrid('selectRow',rowIndex);
	$("#"+dgid+"").datagrid('uncheckAll');
	$("#"+dgid+"").datagrid('checkRow',rowIndex);
	$('#'+rmDivId).menu('show', {
	       left:e.pageX,
	       top:e.pageY
	});   
}
/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * java风格
 * eg:
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 */
Date.prototype.pattern = function (fmt) {
   var o = {
      "M+" : this.getMonth() + 1, //月份
      "d+" : this.getDate(), //日
      "h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时
      "H+" : this.getHours(), //小时
      "m+" : this.getMinutes(), //分
      "s+" : this.getSeconds(), //秒
      "q+" : Math.floor((this.getMonth() + 3) / 3), //季度
      "S" : this.getMilliseconds() //毫秒
   };
   var week = {
      "0" : "/u65e5",
      "1" : "/u4e00",
      "2" : "/u4e8c",
      "3" : "/u4e09",
      "4" : "/u56db",
      "5" : "/u4e94",
      "6" : "/u516d"
   };
   if (/(y+)/.test(fmt)) {
      fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
   }
   if (/(E+)/.test(fmt)) {
      fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
   }
   for (var k in o) {
      if (new RegExp("(" + k + ")").test(fmt)) {
         fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
      }
   }
   return fmt;
};
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
var MIUtils = {
	/**
	 * 替换特殊字符方法
	 * @param str
	 * @returns {String}
	 */
	repSpecial:function(str) {
		var pattern = new RegExp("[\n]"); // 创建一个包含\n的正则对象
		var result = ""; // 定义一个空字符
		for ( var i = 0; i < str.length; i++) {
			result = result + str.substr(i, 1).replace(pattern, '');// 逐字检索
																	// 发现\n就换为空;
		}
		return result; // 返回转换完成的新json字符串
	},
	getCityName:function(organCode){
		var citylist = [
		                {"code":"370100", "name":"山东省济南市"},
		                {"code":"370200", "name":"山东省青岛市"},
		                {"code":"370300", "name":"山东省淄博市"},
		                {"code":"370400", "name":"山东省枣庄市"},
		                {"code":"370500", "name":"山东省东营市"},
		                {"code":"370600", "name":"山东省烟台市"},
		                {"code":"370700", "name":"山东省潍坊市"},
		                {"code":"370800", "name":"山东省济宁市"},
		                {"code":"371500", "name":"山东省聊城市"},
		                {"code":"371600", "name":"山东省滨州市"},
		                {"code":"371700", "name":"山东省菏泽市"},
		                {"code":"370900", "name":"山东省泰安市"},
		                {"code":"371000", "name":"山东省威海市"},
		                {"code":"371100", "name":"山东省日照市"},
		                {"code":"371200", "name":"山东省莱芜市"},
		                {"code":"371300", "name":"山东省临沂市"},
		                {"code":"371400", "name":"山东省德州市"}
		            ];
		for(var i=0;i<citylist.length;i++){
			if(organCode.substring(0,4)==citylist[0].code.substr(0,4)){
				return citylist[0].name;
			}
		}
		return '不详';
	},
	formatterDate : function (date) {
		 var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
		 var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"
		 + (date.getMonth() + 1);
		 var hor = date.getHours();
		 var min = date.getMinutes();
		 var sec = date.getSeconds();
		 return date.getFullYear() + '-' + month + '-' + day+" "+hor+":"+min+":"+sec;
	},
	formatterDateAdd : function(date,days){
		 if (days == undefined || days == '') {
            return;
         }
         var date = new Date(date);
         date.setDate(date.getDate() + days);
         return MIUtils.formatterDate(date);
	},
	getEntcatColors:function(){
		return ['#00468C','#389BB7','#009ACD','#4169E1','#6495ED','#87CEFA','#AFEEEE','#4682B4','#1E90FF','#00BFFF','#87CEEB','#87CEFA','#B0E0E6','#00CED1','#48D1CC','#40E0D0','#66CDAA','#1E90FF','#4169E1','#00BFFF'];
	}
};
 
function NumberToChinese(num){
	 
	switch (num)
	{
	case 1:
		  return '一';
		  break;
	case 2:
	      return '二';
		  break;
	case 3:
		  return '三';
		  break;
	case 4:
		  return '四';
		  break;
	case 5:
		  return '五';
		  break;
	case 6:
		  return '六';
		  break;
	case 7:
		  return '七';
		  break;
	case 8:
		  return '八';
		  break;
	case 9:
		  return '九';
		  break;
	case  10:
		  return '十';
		  break;
	case 11:
		  return '十一';
		  break;
	case 12:
		  return '十二';
		  break; 
	 
	default:
		 return '-1';
	}
	}
(function($) {
	$.fn.serializeJson = function() {
		var serializeObj = {};
		$(this.serializeArray()).each(function() {
			serializeObj[this.name] = this.value;
		});
		return serializeObj;
	};
	//获取JSONList元素数组
	$.extend({
		getJsonElementArray:function(list,key){
			var obj=[];			
			if(list instanceof Array){
				for(var i in list){
					var json=list[i];
					obj.push(json[key]);
				}
			}
			return obj;
		},
		getJsonElementDataArray:function(list,key){
			var objList=[];			
			if(list instanceof Array){
				for(var i in list){
					var json=list[i];
					var obj=new Object();
					obj.value=undefined==json[key]?"":json[key];				 
					obj.data=json;
					objList.push(obj);
					}
			}
			console.log(JSON.stringify(objList));
			return objList;
		},
		getSumbyJsonArray:function(list,key){
			var total=0;
			debugger;
			if(list instanceof Array){
				for(var i in list){
					var json=list[i];
					total+=json[key];
				}
			}
			return total;
		},
		getJsonElementfilterArray:function(list,key,value){
			debugger;
			var obj=[];			
			if(list instanceof Array){
				for(var i in list){
					var json=list[i];
				   if(json[key]==value)
					obj.push(json);
				}
			}
			return obj;
		},
		getDaysInOneMonth:function(year, month){  
			  month = parseInt(month, 10);  
			  var d= new Date(year, month, 0);  
			  return d.getDate();  
		},
		/**
		 * 字符串换行
		 * @param text
		 * @param lineMax
		 * @returns
		 */
		breakLine:function(text,lineMax){  
			if(text.length<=lineMax){
				return text;
			}
			var rowNumber = Math.ceil(text.length/lineMax);// 换行的话，需要显示几行，向上取整
			var newtext="";
			for(var p = 0; p < rowNumber; p++) {
				var tempStr = "";// 表示每一次截取的字符串
				var start = p * lineMax;// 开始截取的位置
				var end = start + lineMax;// 结束截取的位置
				// 此处特殊处理最后一行的索引值
				if (p == rowNumber - 1) {
					// 最后一次不换行
					tempStr = text.substring(start,text.length);
				} else {
					// 每一次拼接字符串并换行
					tempStr = text.substring(start, end) + "\n";
				}
				newtext += tempStr;// 最终拼成的字符串
			}
			return newtext;
		},
		cloneObj: function (obj) {
	        var objClone;
	        if (obj instanceof Array) {
	            objClone = [];
	            for (var i = 0; i < obj.length; i++){
	                objClone[i] = $.cloneObj(obj[i]);
	            }
	            return objClone;
	        } else if (obj instanceof Object) {
	            if (obj.constructor == Object) {
	                objClone = new obj.constructor();
	            } else {
	                objClone = new obj.constructor(obj.valueOf());
	            }
	            for (var key in obj) {
	                if (objClone[key] != obj[key]) {
	                    if (typeof (obj[key]) == 'object') {
	                        objClone[key] = $.cloneObj(obj[key]);
	                    } else {
	                        objClone[key] = obj[key];
	                    }
	                }
	            }
	            objClone.toString = obj.toString;
	            objClone.valueOf = obj.valueOf;
	            return objClone;
	        }
	        return obj;
	   },
	   toThousands : function (num) {
	       var num = (num || 0).toString(), result = '';
	       while (num.length > 3) {
	           result = ',' + num.slice(-3) + result;
	           num = num.slice(0, num.length - 3);
	       }
	       if (num) { result = num + result; }
	       return result;
	   }
	});
	// 初始化下拉选择
	$.fn.initDropdownSel=function(){
		$(this).find('a').on('click',function(){
			var nowtext = $(this).parent().parent().parent().children('a.dropdown-toggle').text().trim().replace("<span class='caret'></span>",'');;
			var newtext = $(this).text();
			$(this).parent().parent().parent().children('a.dropdown-toggle').empty();
			$(this).parent().parent().parent().children('a.dropdown-toggle').html(newtext+"<span class='caret'></span>");
			//$(this).empty();
			//$(this).html(nowtext);
		});
	};
	/**
	 * 初始化下拉年度
	 * {
	 * 	beginYear:'yyyy'默认倒推5年,
	 * 	endYear:'yyyy'默认当前年,
	 *  selectedYear:'year'默认最近年度
	 * }
	 */
	$.fn.initSelectYears=function(options){
		var currentYear = (new Date()).pattern("yyyy");
		var defaults={
				beginYear:currentYear-5,
				endYear:currentYear,
				selectedYear:currentYear
			};
		var opts = $.extend({}, defaults, options);
		if(opts.selectedYear>opts.endYear){
			opts.selectedYear=opts.endYear;
		}
		var optionsItem="";
		for(var i=opts.endYear;i>=opts.beginYear;i--){
			optionsItem=optionsItem+"<option value='"+i+"' "+(i==opts.selectedYear?'selected':'')+">"+i+"</option>";
		}
		$(this).append(optionsItem);
	};
	//根据内容生成doc并下载
	$.createAndDownLoadDoc=function(options){
		var imgBase64=options.imgBase64;
		var text=options.text;
		if(!imgBase64){
			return;
		}
		if(!text){
			return;
		}
		var url = urlcsrf(basepath+"download/common/createDocByContent");
		$.post(url,options,function(data){
								var filePath = data.filePath;
								var url = basepath+'anonymous/fileupdownload/downzip';
								url=urlcsrf(url);
								var form=$("<form id='"+uuid(32)+"'>");//定义一个form表单
								form.attr("style","display:none");
								form.attr("target","");
								form.attr("method","post");
								form.attr("action",url);
								var input1=$("<input>");
								input1.attr("type","hidden");
								input1.attr("name","filerealpath");
								input1.attr("value",filePath);
								$("body").append(form);//将表单放置在web中
								form.append(input1);
								form.submit();//表单提交 
							},'json');
	};
})(jQuery);