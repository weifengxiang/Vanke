function Chart10() {
	var data = [
	            {name: '新泰市', value: 351},
	            {name: '肥城市', value: 227},
	            {name: '宁阳县', value: 195},
	            {name: '东平县', value: 111},
	            {name: '泰山区', value: 159},
	            {name: '岱岳区', value: 191},
	            {name: '景区', value: 22},
	            {name: '高新区', value: 10} 
	       ];
	       var geoCoordMap = {
	           '新泰市':[117.77631,35.911015],
	           '肥城市':[116.787709,36.201769],
	           '宁阳县':[116.814668,35.767057],
	           '东平县':[116.477912,35.932533],
	           '泰山区':[117.160531,36.198733],
	           '岱岳区':[117.43379,36.17844],
	           '景区':[117.112465,36.263025],
	           '高新区':[117.18447,36.208245] 
	       };

	       var convertData = function (data) {
	           var res = [];
	           for (var i = 0; i < data.length; i++) {
	               var geoCoord = geoCoordMap[data[i].name];
	               if (geoCoord) {
	                   res.push({
	                       name: data[i].name,
	                       value: geoCoord.concat(data[i].value)
	                   });
	               }
	           }
	           return res;
	       };
             console.log(convertData(data.sort(function (a, b) {
                 return b.value - a.value;
             })));
	       option = {
	    	  
	           title: {
	               text: '全市高危化学品生产销售企业分布',	               
	               left: 'center',
	               textStyle: {
	                   color: '#fff'
	               }
	           },
	           tooltip : {
	               trigger: 'item',
	               formatter: function(param){
                	   return param.name+'('+param.value[2]+'户)';
                   }, 
	             
	               
	           }, 
	           geo: {
	               map: 'taian',
	               label: {
	                   emphasis: {
	                       show: false
	                   }
	               },
	               layoutCenter: ['50%', '35%'],
	               regions: [{
	            	    name: '新泰市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.9)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '肥城市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.5)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '新泰市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.8)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '宁阳县',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.6)',
	            	            color: 'red'
	            	        }
	            	    }
	            	}],
	            // 如果宽高比大于 1 则宽度为 100，如果小于 1 则高度为 100，保证了不超过 100x100 的区域
	            layoutSize:600,
	               roam: true,
	               itemStyle: {
	                   normal: {
	                       areaColor: 'rgba(6, 234, 244,0.7)',
	                       borderColor: '#111'
	                   },
	                   emphasis: {
	                       areaColor: '#FFA500'
	                   }
	               }
	           },
	           grid: [{
	               top: '50%',
	               //width: '50%',
	               //bottom: '45%',
	               left: -10,
	               right: 10,
	               containLabel: true
	           }],
	           yAxis: [
							{
							    type: 'value',
							    splitLine: { show: false },
							    axisLabel: { show: false }
							}
								                  
	               ],
	               xAxis: [
	                       {
		                       type: 'category',
		                       data: $.getJsonElementArray(data,'name'),                
		                       splitLine: { show: false },
		                       axisLabel: {
		                           show: true,
		                           interval: 0,
		                           "rotate" : 35,
		                       }
		                   }
	                   
	               ],
	           series : [
	               
	               {
	                   name: '分布情况',
	                   type: 'effectScatter',
	                   coordinateSystem: 'geo',
	                   data: convertData(data.sort(function (a, b) {
	                       return b.value - a.value;
	                   })),
	                   symbolSize: function (val) {
	                       return val[2] / 10;
	                   },
	                   showEffectOn: 'render',
	                   rippleEffect: {
	                       brushType: 'stroke'
	                   },
	                   hoverAnimation: true,
	                   label: {
	                       normal: {
	                           formatter: function(param){
	                        	   return param.name+'('+param.value[2]+')';
	                           },
	                           position: 'right',
	                           show: true
	                       }
	                   },
	                   itemStyle: {
	                       normal: {
	                           color: '#f4e925',
	                           shadowBlur: 30,
	                           shadowColor: 'red'
	                       }
	                   },
	                   zlevel: 1
	               },
	               {
	                   name: '数量',
	                   type: 'bar',             
	                   data: data,
	                   barWidth: 30,
	                  
	                   label: {
	                       normal: {
	                           show: true,
	                           position: 'top',
	                           formatter: ' {c}'
	                       }
	                   }, itemStyle: {
	                       normal: {
	                           color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
	                               offset: 0,
	                               color: 'rgba(255,215,0,0.7)'
	                           }, {
	                               offset: 1,
	                               color: 'rgba(255,255,0,1)'
	                           }])
	                       }
	                   }


	               }
	           ]
	       };
	       var myChart = echarts.init(document.getElementById('chart1'), 'walden');
	       myChart.setOption(option);
	       /*
	       setInterval(function (){
	    	   var newdata = [
	    		            {name: '新泰市', value: 51},
	    		            {name: '肥城市', value: 78},
	    		            {name: '宁阳县', value: 18},
	    		            {name: '东平县', value: 19},
	    		            {name: '泰山区', value: 36},
	    		            {name: '岱岳区', value: 27},
	    		            {name: '景区', value: 14},
	    		            {name: '高新区', value: 2} 
	    		       ];
	           
			   

			    option.series[0].data=convertData(newdata.sort(function (a, b) {
                    return b.value - a.value;
                }));
			   
			    myChart.setOption(option);
			}, 2100);*/

}
function Chart11() {
	var data = [
	            {name: '新泰市', value: 45},
	            {name: '肥城市', value: 50},
	            {name: '宁阳县', value: 18},
	            {name: '东平县', value: 19},
	            {name: '泰山区', value: 34},
	            {name: '岱岳区', value: 25},
	            {name: '景区', value: 0},
	            {name: '高新区', value: 14} 
	       ];
	       var geoCoordMap = {
	           '新泰市':[117.77631,35.911015],
	           '肥城市':[116.787709,36.201769],
	           '宁阳县':[116.814668,35.767057],
	           '东平县':[116.477912,35.932533],
	           '泰山区':[117.160531,36.198733],
	           '岱岳区':[117.43379,36.17844],
	           '景区':[117.112465,36.263025],
	           '高新区':[117.18447,36.208245] 
	       };

	       var convertData = function (data) {
	           var res = [];
	           for (var i = 0; i < data.length; i++) {
	               var geoCoord = geoCoordMap[data[i].name];
	               if (geoCoord) {
	                   res.push({
	                       name: data[i].name,
	                       value: geoCoord.concat(data[i].value)
	                   });
	               }
	           }
	           return res;
	       };
             console.log(convertData(data.sort(function (a, b) {
                 return b.value - a.value;
             })));
	       option = {
	    	  
	           title: {
	               text: '全市驰著名商品数据分析',	               
	               left: 'center',
	               textStyle: {
	                   color: '#fff'
	               }
	           },
	           tooltip : {
	               trigger: 'item',
	               formatter: function(param){
                	   return param.name+'('+param.value[2]+'户)';
                   }, 
	             
	               
	           }, 
	           geo: {
	               map: 'taian',
	               label: {
	                   emphasis: {
	                       show: false
	                   }
	               },
	               layoutCenter: ['50%', '35%'],
	               regions: [{
	            	    name: '新泰市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.9)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '肥城市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.5)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '新泰市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.8)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '宁阳县',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.6)',
	            	            color: 'red'
	            	        }
	            	    }
	            	}],
	            // 如果宽高比大于 1 则宽度为 100，如果小于 1 则高度为 100，保证了不超过 100x100 的区域
	            layoutSize:600,
	               roam: true,
	               itemStyle: {
	                   normal: {
	                       areaColor: 'rgba(6, 234, 244,0.7)',
	                       borderColor: '#111'
	                   },
	                   emphasis: {
	                       areaColor: '#FFA500'
	                   }
	               }
	           },
	           grid: [{
	               top: '50%',
	               //width: '50%',
	               //bottom: '45%',
	               left: -10,
	               right: 10,
	               containLabel: true
	           }],
	           yAxis: [
							{
							    type: 'value',
							    splitLine: { show: false },
							    axisLabel: { show: false }
							}
								                  
	               ],
	               xAxis: [
	                       {
		                       type: 'category',
		                       data: $.getJsonElementArray(data,'name'),                
		                       splitLine: { show: false },
		                       axisLabel: {
		                           show: true,
		                           interval: 0,
		                           "rotate" : 35,
		                       }
		                   }
	                   
	               ],
	           series : [
	               
	               {
	                   name: '商标',
	                   type: 'effectScatter',
	                   coordinateSystem: 'geo',
	                   data: convertData(data.sort(function (a, b) {
	                       return b.value - a.value;
	                   })),
	                   symbolSize: function (val) {
	                       return val[2] / 2;
	                   },
	                   showEffectOn: 'render',
	                   rippleEffect: {
	                       brushType: 'stroke'
	                   },
	                   hoverAnimation: true,
	                   label: {
	                       normal: {
	                           formatter: function(param){
	                        	   return param.name+'('+param.value[2]+')';
	                           },
	                           position: 'right',
	                           show: true
	                       }
	                   },
	                   itemStyle: {
	                       normal: {
	                           color: '#f4e925',
	                           shadowBlur: 30,
	                           shadowColor: 'red'
	                       }
	                   },
	                   zlevel: 1
	               },
	               {
	                   name: '数量',
	                   type: 'bar',             
	                   data: data,
	                   barWidth: 30,	                  
	                   label: {
	                       normal: {
	                           show: true,
	                           position: 'top',
	                           formatter: ' {c}'
	                       }
	                   }, itemStyle: {
	                       normal: {
	                           color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
	                               offset: 0,
	                               color: 'rgba(255,215,0,0.7)'
	                           }, {
	                               offset: 1,
	                               color: 'rgba(255,255,0,1)'
	                           }])
	                       }
	                   }


	               }
	           ]
	       };
	       var myChart = echarts.init(document.getElementById('chart1'), 'walden');
	       myChart.setOption(option);
	       /*
	       setInterval(function (){
	    	   var newdata = [
	    		            {name: '新泰市', value: 51},
	    		            {name: '肥城市', value: 78},
	    		            {name: '宁阳县', value: 18},
	    		            {name: '东平县', value: 19},
	    		            {name: '泰山区', value: 36},
	    		            {name: '岱岳区', value: 27},
	    		            {name: '景区', value: 14},
	    		            {name: '高新区', value: 2} 
	    		       ];
	           
			   

			    option.series[0].data=convertData(newdata.sort(function (a, b) {
                    return b.value - a.value;
                }));
			   
			    myChart.setOption(option);
			}, 2100);*/

}
function Chart12() {
	var data = [
	            {name: '新泰市', value: 132},
	            {name: '肥城市', value: 70},
	            {name: '宁阳县', value: 58},
	            {name: '东平县', value: 71},
	            {name: '泰山区', value: 46},
	            {name: '岱岳区', value: 58},
	            {name: '景区', value: 9},
	            {name: '高新区', value: 34} 
	       ];
	       var geoCoordMap = {
	           '新泰市':[117.77631,35.911015],
	           '肥城市':[116.787709,36.201769],
	           '宁阳县':[116.814668,35.767057],
	           '东平县':[116.477912,35.932533],
	           '泰山区':[117.160531,36.198733],
	           '岱岳区':[117.43379,36.17844],
	           '景区':[117.112465,36.263025],
	           '高新区':[117.18447,36.208245] 
	       };

	       var convertData = function (data) {
	           var res = [];
	           for (var i = 0; i < data.length; i++) {
	               var geoCoord = geoCoordMap[data[i].name];
	               if (geoCoord) {
	                   res.push({
	                       name: data[i].name,
	                       value: geoCoord.concat(data[i].value)
	                   });
	               }
	           }
	           return res;
	       };
             console.log(convertData(data.sort(function (a, b) {
                 return b.value - a.value;
             })));
	       option = {
	    	  
	           title: {
	               text: '全市成品油数据分析',	               
	               left: 'center',
	               textStyle: {
	                   color: '#fff'
	               }
	           },
	           tooltip : {
	               trigger: 'item',
	               formatter: function(param){
                	   return param.name+'('+param.value[2]+'户)';
                   }, 
	             
	               
	           }, 
	           legend:{
	        	   top:'65%',
	        	 data:['数量','抽检'],  
	           },
	           geo: {
	               map: 'taian',
	               label: {
	                   emphasis: {
	                       show: false
	                   }
	               },
	               layoutCenter: ['50%', '35%'],
	               regions: [{
	            	    name: '新泰市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.9)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '肥城市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.5)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '新泰市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.8)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '宁阳县',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.6)',
	            	            color: 'red'
	            	        }
	            	    }
	            	}],
	            // 如果宽高比大于 1 则宽度为 100，如果小于 1 则高度为 100，保证了不超过 100x100 的区域
	            layoutSize:600,
	               roam: true,
	               itemStyle: {
	                   normal: {
	                       areaColor: 'rgba(6, 234, 244,0.7)',
	                       borderColor: '#111'
	                   },
	                   emphasis: {
	                       areaColor: '#FFA500'
	                   }
	               }
	           },
	           grid: [{
	               top: '50%',
	               //width: '50%',
	               //bottom: '45%',
	               left: -10,
	               right: 10,
	               containLabel: true
	           }],
	           yAxis: [
							{
							    type: 'value',
							    splitLine: { show: false },
							    axisLabel: { show: false }
							}
								                  
	               ],
	               xAxis: [
	                       {
		                       type: 'category',
		                       data: $.getJsonElementArray(data,'name'),                
		                       splitLine: { show: false },
		                       axisLabel: {
		                           show: true,
		                           interval: 0,
		                           "rotate" : 35,
		                       }
		                   }
	                   
	               ],
	           series : [
	               
	               {
	                   name: '成品油',
	                   type: 'effectScatter',
	                   coordinateSystem: 'geo',
	                   data: convertData(data.sort(function (a, b) {
	                       return b.value - a.value;
	                   })),
	                   symbolSize: function (val) {
	                       return val[2] / 2;
	                   },
	                   showEffectOn: 'render',
	                   rippleEffect: {
	                       brushType: 'stroke'
	                   },
	                   hoverAnimation: true,
	                   label: {
	                       normal: {
	                           formatter: function(param){
	                        	   return param.name+'('+param.value[2]+')';
	                           },
	                           position: 'right',
	                           show: true
	                       }
	                   },
	                   itemStyle: {
	                       normal: {
	                           color: '#f4e925',
	                           shadowBlur: 30,
	                           shadowColor: 'red'
	                       }
	                   },
	                   zlevel: 1
	               },
	               {
	                   name: '数量',
	                   type: 'bar',             
	                   data: data,
	                   barGap:0.1,
	                   barWidth: 20,	                  
	                   label: {
	                       normal: {
	                           show: true,
	                           position: 'top',
	                           formatter: ' {c}'
	                       }
	                   }, itemStyle: {
	                       normal: {
	                           color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
	                               offset: 0,
	                               color: 'rgba(6,248,255,0.7)'
	                           }, {
	                               offset: 1,
	                               color: 'rgba(88,255,255,1)'
	                           }])
	                       }
	                   }, 
	               },
	               {
	                   name: '抽检',
	                   type: 'bar', 
	                   barGap:0.1,
	                   data: [63,34,32,17,20,3,3,1],
	                   barWidth: 20,	                  
	                   label: {
	                       normal: {
	                           show: true,
	                           position: 'top',
	                           formatter: ' {c}'
	                       }
	                   }, itemStyle: {
	                       normal: {
	                           color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
	                               offset: 0,
	                               color: 'rgba(255,215,0,0.7)'
	                           }, {
	                               offset: 1,
	                               color: 'rgba(255,255,0,1)'
	                           }])
	                       }
	                   }}
	           ]
	       };
	       var myChart = echarts.init(document.getElementById('chart1'), 'walden');
	       myChart.setOption(option);
	       /*
	       setInterval(function (){
	    	   var newdata = [
	    		            {name: '新泰市', value: 51},
	    		            {name: '肥城市', value: 78},
	    		            {name: '宁阳县', value: 18},
	    		            {name: '东平县', value: 19},
	    		            {name: '泰山区', value: 36},
	    		            {name: '岱岳区', value: 27},
	    		            {name: '景区', value: 14},
	    		            {name: '高新区', value: 2} 
	    		       ];
	           
			   

			    option.series[0].data=convertData(newdata.sort(function (a, b) {
                    return b.value - a.value;
                }));
			   
			    myChart.setOption(option);
			}, 2100);*/

}
function Chart13() {
	var data = [
	            {name: '新泰市', value: 101},
	            {name: '肥城市', value: 81},
	            {name: '宁阳县', value: 49},
	            {name: '东平县', value: 32},
	            {name: '泰山区', value: 74},
	            {name: '岱岳区', value: 121},
	            {name: '景区', value: 4},
	            {name: '高新区', value: 3} 
	       ];
	       var geoCoordMap = {
	           '新泰市':[117.77631,35.911015],
	           '肥城市':[116.787709,36.201769],
	           '宁阳县':[116.814668,35.767057],
	           '东平县':[116.477912,35.932533],
	           '泰山区':[117.160531,36.198733],
	           '岱岳区':[117.43379,36.17844],
	           '景区':[117.112465,36.263025],
	           '高新区':[117.18447,36.208245] 
	       };

	       var convertData = function (data) {
	           var res = [];
	           for (var i = 0; i < data.length; i++) {
	               var geoCoord = geoCoordMap[data[i].name];
	               if (geoCoord) {
	                   res.push({
	                       name: data[i].name,
	                       value: geoCoord.concat(data[i].value)
	                   });
	               }
	           }
	           return res;
	       };
             console.log(convertData(data.sort(function (a, b) {
                 return b.value - a.value;
             })));
	       option = {
	    	  
	           title: {
	               text: '集贸市场数据分析',	               
	               left: 'center',
	               textStyle: {
	                   color: '#fff'
	               }
	           },
	           tooltip : {
	               trigger: 'item',
	               formatter: function(param){
                	   return param.name+'('+param.value[2]+'户)';
                   }, 
	             
	               
	           }, 
	           legend:{
	        	   top:'65%',
	        	 data:['农贸市场','农村大集',,'其他类市场'],  
	           },
	           geo: {
	               map: 'taian',
	               label: {
	                   emphasis: {
	                       show: false
	                   }
	               },
	               layoutCenter: ['50%', '35%'],
	               regions: [{
	            	    name: '新泰市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.9)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '肥城市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.5)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '新泰市',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.8)',
	            	            color: 'red'
	            	        }
	            	    }
	            	},{
	            	    name: '宁阳县',
	            	    itemStyle: {
	            	        normal: {
	            	            areaColor: 'rgba(6, 234, 244,0.6)',
	            	            color: 'red'
	            	        }
	            	    }
	            	}],
	            // 如果宽高比大于 1 则宽度为 100，如果小于 1 则高度为 100，保证了不超过 100x100 的区域
	            layoutSize:600,
	               roam: true,
	               itemStyle: {
	                   normal: {
	                       areaColor: 'rgba(6, 234, 244,0.7)',
	                       borderColor: '#111'
	                   },
	                   emphasis: {
	                       areaColor: '#FFA500'
	                   }
	               }
	           },
	           grid: [{
	               top: '50%',
	               //width: '50%',
	               //bottom: '45%',
	               left: -10,
	               right: 10,
	               containLabel: true
	           }],
	           yAxis: [
							{
							    type: 'value',
							    splitLine: { show: false },
							    axisLabel: { show: false }
							}
								                  
	               ],
	               xAxis: [
	                       {
		                       type: 'category',
		                       data: $.getJsonElementArray(data,'name'),                
		                       splitLine: { show: false },
		                       axisLabel: {
		                           show: true,
		                           interval: 0,
		                           "rotate" : 35,
		                       }
		                   }
	                   
	               ],
	           series : [
	               
	               {
	                   name: '集贸市场',
	                   type: 'effectScatter',
	                   coordinateSystem: 'geo',
	                   data: convertData(data.sort(function (a, b) {
	                       return b.value - a.value;
	                   })),
	                   symbolSize: function (val) {
	                       return val[2] / 2.5;
	                   },
	                   showEffectOn: 'render',
	                   rippleEffect: {
	                       brushType: 'stroke'
	                   },
	                   hoverAnimation: true,
	                   label: {
	                       normal: {
	                           formatter: function(param){
	                        	   return param.name+'('+param.value[2]+')';
	                           },
	                           position: 'right',
	                           show: true
	                       }
	                   },
	                   itemStyle: {
	                       normal: {
	                           color: '#f4e925',
	                           shadowBlur: 30,
	                           shadowColor: 'red'
	                       }
	                   },
	                   zlevel: 1
	               },
	               {
	                   name: '农贸市场',
	                   type: 'bar',             
	                   data: [15,12,2,1,15,7,2,3],
	                   barGap:0.1,
	                   barWidth: 20,	                  
	                   label: {
	                       normal: {
	                           show: true,
	                           position: 'top',
	                           formatter: ' {c}'
	                       }
	                   }, itemStyle: {
	                       normal: {
	                           color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
	                               offset: 0,
	                               color: 'rgba(6,248,255,0.7)'
	                           }, {
	                               offset: 1,
	                               color: 'rgba(88,255,255,1)'
	                           }])
	                       }
	                   }, 
	               },
	               {
	                   name: '农村大集',
	                   type: 'bar', 
	                   barGap:0.1,
	                   data: [83,68,46,31,24,103,1,1],
	                   barWidth: 20,	                  
	                   label: {
	                       normal: {
	                           show: true,
	                           position: 'top',
	                           formatter: ' {c}'
	                       }
	                   }, itemStyle: {
	                       normal: {
	                           color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
	                               offset: 0,
	                               color: 'rgba(255,215,0,0.7)'
	                           }, {
	                               offset: 1,
	                               color: 'rgba(255,255,0,1)'
	                           }])
	                       }
	                   }},
	                   
		               {
		                   name: '其他类市场',
		                   type: 'bar', 
		                   barGap:0.1,
		                   data: [3,1,1,0,35,11,0,0],
		                   barWidth: 20,	                  
		                   label: {
		                       normal: {
		                           show: true,
		                           position: 'top',
		                           formatter: ' {c}'
		                       }
		                   }, itemStyle: {
		                       normal: {
		                           color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
		                               offset: 0,
		                               color: 'rgba(50,205,50,0.7)'
		                           }, {
		                               offset: 1,
		                               color: 'rgba(127,255,0,1)'
		                           }])
		                       }
		                   }} 
	           ]
	       };
	       var myChart = echarts.init(document.getElementById('chart1'), 'walden');
	       myChart.setOption(option);
	       /*
	       setInterval(function (){
	    	   var newdata = [
	    		            {name: '新泰市', value: 51},
	    		            {name: '肥城市', value: 78},
	    		            {name: '宁阳县', value: 18},
	    		            {name: '东平县', value: 19},
	    		            {name: '泰山区', value: 36},
	    		            {name: '岱岳区', value: 27},
	    		            {name: '景区', value: 14},
	    		            {name: '高新区', value: 2} 
	    		       ];
	           
			   

			    option.series[0].data=convertData(newdata.sort(function (a, b) {
                    return b.value - a.value;
                }));
			   
			    myChart.setOption(option);
			}, 2100);*/

}
function Chart2() {
    var data=[];
    for(i=0;i<48;i++){
    	data.push( Math.ceil(Math.random()*35));  
    }
    var option = {
        tooltip: {
            trigger: 'axis', 
        },
        
        title: {
            text: '近12个月驰名著名商标走势',	               
            left: 'center',
            textStyle: {
                color: '#fff'
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: true,
            splitLine: { show: true , 
            	},
            	axisLabel: {
                    show: true,
                    interval: 0,
                    "rotate" : 35,
                },
            data: ['201608', '201609', '201610', '201611', '201612', '201701', '201702', '201703', '201704', '201705', '201706', '201707']
        },
        yAxis: [{
            type: 'value',
            splitLine: { show: false }, 
         
            axisLabel: {
                formatter: '{value} '
            }

        }],
        grid: {
            top: 10,
            left: 60,
            right: 60
        },

        series: [
           {
               name: '驰名商标',
               type: 'line',
               yAxisIndex: 0,
               lineStyle: {
                   normal: {
                       width: 0
                   }
               },
               itemStyle: {
                   normal: {
                       borderWidth: 0,
                       opacity: 0
                   }, emphasis: {
                       opacity: 0
                   }
               },
               areaStyle: {
                   normal: {
                       color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                           offset: 0,
                           color: 'rgba(151,237,248,0.2)'
                       }, {
                           offset: 1,
                           color: 'rgba(151,237,248,0.7)'
                       }])
                   }
               },
               data: data.slice(0,12)
           },
            {
                name: '著名商标',
                type: 'line',
                yAxisIndex: 0,
                lineStyle: {
                    normal: {
                        width: 0
                    }
                },
                itemStyle: {
                    normal: {
                        borderWidth: 0,
                        opacity: 0
                    }, emphasis: {
                        opacity: 0
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(74,139,184,0.2)'
                        }, {
                            offset: 1,
                            color: 'rgba(74,139,184,0.5)'
                        }])
                    }
                },
                data: data.slice(12,24)
            },
             {
                 name: '马德里',
                 type: 'line',
                 data: data.slice(24,36)
             },
             {
                 name: '集体证明',
                 type: 'line',
                 data:  data.slice(36,48)
             }
        ]
    };

    var myChart = echarts.init(document.getElementById('chart2'), 'walden');

    myChart.setOption(option);
}
function Chart3() {
	 var data=[];
	    for(i=0;i<12;i++){
	    	data.push( Math.ceil(Math.random()*2000));  
	    }
	    var option = {
	        tooltip: {
	            trigger: 'axis', 
	        },
	        
	        title: {
	            text: '近12个月注册商标走势',	               
	            left: 'center',
	            textStyle: {
	                color: '#fff'
	            }
	        },
	        xAxis: {
	            type: 'category',
	            boundaryGap: true,
	            splitLine: { show: true , 
	            	},
	            	axisLabel: {
	                    show: true,
	                    interval: 0,
	                    "rotate" : 35,
	                },
	            data: ['201608', '201609', '201610', '201611', '201612', '201701', '201702', '201703', '201704', '201705', '201706', '201707']
	        },
	        yAxis: [{
	            type: 'value',
	            splitLine: { show: false }, 
	         
	            axisLabel: {
	                formatter: '{value} '
	            }

	        }],
	        grid: {
	            top: 10,
	            left: 60,
	            right: 60
	        },

	        series: [
	           {
	               name: '注册商标',
	               type: 'line',
	               yAxisIndex: 0,
	               lineStyle: {
	                   normal: {
	                       width: 0
	                   }
	               },
	               itemStyle: {
	                   normal: {
	                       borderWidth: 0,
	                       opacity: 0
	                   }, emphasis: {
	                       opacity: 0
	                   }
	               },
	               areaStyle: {
	                   normal: {
	                       color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                           offset: 0,
	                           color: 'rgba(151,237,248,0.2)'
	                       }, {
	                           offset: 1,
	                           color: 'rgba(151,237,248,0.7)'
	                       }])
	                   }
	               },
	               data: data.slice(0,12)
	           },
	             
	              
	             
	        ]
	    };

	    var myChart = echarts.init(document.getElementById('chart3'), 'walden');

	    myChart.setOption(option);
}
function Chart4() {
	var tb=[(Math.random()*20).toFixed(2),(Math.random()*10).toFixed(2),(Math.random()*5).toFixed(2)];
	var data= [
                     { value: 54, name: '农贸市场' },
                     { value: 357, name: '农村大集' },
                     { value: 51, name: '其他类型市场' },
                     
                 ];
	var data1= [
               { value: 182, name: '中石化' },
               { value: 60, name: '中石油' },
               { value: 238, name: '社会站' },
               
           ];
	 
	 option = {
	            tooltip: {
	                trigger: 'item',
	                formatter: "{a} <br/>{b}: 数量{c} <br/>占比({d}%)同比（12.13%）"
	            },
	            title: {
	                text: '守重企业分析',	               
	                left: '80%',
	                y:'bottom',
	                textStyle: {
	                    color: '#fff',
	                    fontSize: 14
	                }
	            },
	            xAxis: {
		            type: 'category',
		            boundaryGap: true,
		            splitLine: { show: true , 
		            	},
		            	axisLabel: {
		                    show: true,
		                    interval: 0,
		                   
		                },
		            data: ['国家级', '省级', '市级']
		        },
		        yAxis: [{
		        	show:false,
		            type: 'value',
		            splitLine: { show: false }, 		         
		            axisLabel: {
		                formatter: '{value} '
		            }

		        }],
		        grid: {
		            top: 10,
		            left: '68%',
		            width:'30%',
		            right: 60
		        },
	            
	            series: [
	                {
	                    name: '集贸市场',
	                    type: 'pie', 
	                    radius: ['40%', '70%'],
	                    center: ['17%', '50%'],
	                    avoidLabelOverlap: false, 
	                    labelLine: {
	                        normal: {
	                            show: true
	                        }
	                    }, label: {
	                        normal: {
	                            show: true
	                        }
	                    },
	                    data:  data
	                },
	                {
	                    name: '成品油',
	                    type: 'pie', 
	                    radius: ['40%', '70%'],
	                    center: ['50%', '50%'],
	                    avoidLabelOverlap: false, 
	                    labelLine: {
	                        normal: {
	                            show: true
	                        }
	                    }, label: {
	                        normal: {
	                            show: true
	                        }
	                    },
	                    data:  data1
	                },
	                {
		                   name: '守重企业',
		                   type: 'bar', 		                 
		                   data: [24,201,201],
		                   barWidth: 30,	                  
		                   label: {
		                       normal: {
		                           show: true,
		                           position: 'top',
		                           formatter: ' {c}'
		                       }
		                   }, itemStyle: {
		                       normal: {
		                           color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
		                               offset: 0,
		                               color: 'rgba(50,205,50,0.7)'
		                           }, {
		                               offset: 1,
		                               color: 'rgba(127,255,0,1)'
		                           }])
		                       }
		                   }} 
	            ]
	        };
 
	
            myChart = echarts.init(document.getElementById('chart4'), 'walden');
            myChart.setOption(option);
 
}
function Chart5() {
    option = {
        title: {
            text: '产业被诉率'
            ,
            textStyle: {
                fontSize: '14px'
            },
            left: '10%',
            top: 20
        },

        tooltip: {
            show: true,
            formatter: ' {c}‰'
        },
        yAxis: [
            {
                type: 'category',
                data: ['第一产业', '第二产业', '第三产业'],
                splitLine: { show: false },
                axisLabel: {
                    show: true,

                    interval: 0
                }
            }
        ],
        xAxis: [
            {
                type: 'value',
                splitLine: { show: false },
                axisLabel: { show: false }
            }
        ], grid: [{
            //top: 50,
            //width: '50%',
            //bottom: '45%',
            left: 10,
            right: 35,
            containLabel: true
        }],
        backgroundColor: 'rgba(41,64,94,0.4)'
        ,
        series: [
            {
                name: '数量',
                type: 'bar',
                data: [0.01, 0.03, 0.1],
                barWidth: 12,
                barGap: 60,
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: ' {c}‰'

                    }
                }, itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
                            offset: 0,
                            color: 'rgba(88,255,255,0.4)'
                        }, {
                            offset: 1,
                            color: 'rgba(6,248,255,1)'
                        }])
                    }
                }


            }
        ]
    };


    var myChart = echarts.init(document.getElementById('chart5'), 'walden');

    myChart.setOption(option);
}
 
function Chart7() {
    option = {
        title: {
            text: '行政执法情况',
            //textAlign: 'center'
            x: 'center',
            top: 5,
            textStyle: {
                fontSize: '20'
            }

        },
          grid: {
            left: 25
        },
        xAxis: {
            type: 'category',

            splitLine: { show: false },
            data: ['消费者权益','合同监管','广告监管', '不正当竞争', '商标监管', '市场监管', '无照经营', '主体准入'],
            axisLabel: {
                show: true,
                rotate: -40,
                interval: 0
            }
        },
        backgroundColor: 'rgba(41,64,94,0.4)'
        ,
        yAxis: {
            type: 'value',
            splitLine: { show: true },
            axisLabel: {
                show: false
            }
        },
        series: [
            {
                name: '数量',
                type: 'bar',
                barWidth: 20,//固定柱子宽度
                label: {
                    normal: {
                        show: true,
                        position: 'top',

                    }
                },
                data: [4,7,12, 21, 27, 64, 82, 121]
                , itemStyle: {
                    normal: {
                        color: function (params) {
                            if (params.value >= 70) {
                                return new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(153,0,0,1)'
                                }, {
                                    offset: 1,
                                    color: 'rgba( 250,59,24,0.4)'
                                }]);
                            } else if (params.value >= 20 && params.value < 70) {
                                return new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(216,78,43,1)'
                                }, {
                                    offset: 1,
                                    color: 'rgba(244,226,133,0.4)'
                                }]);
                            } else if (params.value >= 10 && params.value < 20) {
                                return new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(255,245,175,1)'
                                }, {
                                    offset: 1,
                                    color: 'rgba(255,245,175,0.4)'
                                }]);
                            } else {
                                return new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(6,248,255,1)'
                                }, {
                                    offset: 1,
                                    color: 'rgba( 88,255,255,0.4)'
                                }])
                            }
                        }

                    }
                }
            }
        ]
    };

    var myChart = echarts.init(document.getElementById('chart7'), 'walden');

    myChart.setOption(option);
     
}
function initChar1(){
	var i=0;
	 
	setInterval(function (){  
		if(i<3)
			i++;
		else
			i=0;
		 
		
		getFunName(i); 
		}, 1000*6); 
	
}
function getFunName(i)
{
if(i==0)	
	return Chart10();
else if (i==1)
	return Chart11();
else if (i==2)
	return Chart12();
else if (i==3)
	return Chart13();
else 
	Chart12();
}
 