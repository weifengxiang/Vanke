function Chart1() {
	 var data= [{'name':'市直','value':4760,'regcap':4465},
	            {'name':'新泰市','value':73174,'regcap':72877},
	            {'name':'肥城市','value':38615,'regcap':37889},
	            {'name':'宁阳县','value':28348,'regcap':28270},
	            {'name':'东平县','value':27687,'regcap':27441},
	            {'name':'泰山区','value':67400,'regcap':65881},
	            {'name':'岱岳区','value':36449,'regcap':35133},
	            {'name':'高新区','value':5981,'regcap':5802},{'name':'景区','value':1488,'regcap':1482}]; 
	 

		option = {
				 title: [{
		                text: '各辖区年报情况',
		                top: 0,
		                x:'center',
		                textStyle: {
		                    fontSize: 20,
		                   
		                     
		                }

		            }],

	            tooltip: {
	                trigger: 'axis',
	                show: true
	            },
	            legend : {
					top : '30',
					 data : ['市场主体户数','户均资本']
				},
	            xAxis: [
	                {
	                    type: 'category',
	                    data:  $.getJsonElementArray(data,'name'),
	                    splitLine: { show: true },
	                    axisLabel: {
	                        show: true,

	                        interval: 0
	                    }
	                }
	            ],
	            backgroundColor: 'rgba(41,64,94,0.4)',
	            yAxis: [
	                {   name:'户数',
	                    type: 'value',
	                    splitLine: { show: false },
	                    axisLabel: {
	                        formatter: '{value} '
	                    }
	                }, {name:'年报率（%）',
	                    type: 'value',
	                    splitLine: { show: false },
	                    axisLabel: {
	                        formatter: '{value} '
	                    }
	                }
	            ], grid: [{
	                top: 50,
	                width: '95%%',
	                //bottom: '45%',
	                left: 30,
	                containLabel: true
	            }],
	            series: [
	                {
	                    name: '应报户数',
	                    type: 'bar',
	                    barGap :0.2,
	                    data: data,
	                    barWidth: 30,//固定柱子宽度
	                    label: {
	                        normal: {
	                            show: true,
	                            position: 'top',

	                        }
	                    }, itemStyle: {
	                        normal: {
	                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                                offset: 0,
	                                color: 'rgba(6,248,255,1)'
	                            }, {
	                                offset: 1,
	                                color: 'rgba( 88,255,255,0.1)'
	                            }])
	                        }
	                    }


	                }, {
	                    name: '已报户数',
	                    type: 'bar',
	                    data: $.getJsonElementArray(data,'regcap'),
	                    barGap :0.2,
	                    barWidth: 30,//固定柱子宽度
	                    label: {
	                        normal: {
	                            show: true,
	                            position: 'top',

	                        }
	                    }, itemStyle: {
	                        normal: {
	                            color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
	                                offset: 0,
	                                color: 'rgba(255,160,122,0.7)'
	                            }, {
	                                offset: 1,
	                                color: 'rgba(255, 140, 0,1)'
	                            }])
	                        }
	                    }


	                }, {
	                    name: '已报户数',
	                    type: 'line',
	                    yAxisIndex: 1,
	                    data: [99.12,98.12,99.01,97.12,87.12,78.12,89.44,94.56,89.12],
	                    barWidth: 10,//固定柱子宽度
	                    itemStyle: {
	                        normal: {
	                            color: 'yellow'
	                        }
	                    },
	                    label: {
	                        normal: {
	                            show: true,
	                            position: 'top',
	                            color: 'rgba( 255 140 0,0.1)'
	                            

	                        }
	                    } 

	                } 
	            ]
	        };
	        var myChart = echarts.init(document.getElementById('chart1'), 'walden');

	        myChart.setOption(option);

}
function Chart2() {

    option = {
        title: {
            text: '2017年度全市年报情况'
            ,
            textStyle: {
                fontSize: '20'
            },
            left:'center',
            top: 20
        },

        tooltip: {
            show: true,
            //   formatter: ' {b}被诉百分比{c}%,数量{c}',
           
            //position: function (pos, params, dom, rect, size) {
            //    // 鼠标在左侧时 tooltip 显示到右侧，鼠标在右侧时 tooltip 显示到左侧。
            //    var obj = { top: 60 };
            //    obj[['left', 'right'][+(pos[0] < size.viewSize[0] / 2)]] = 5;
            //    return obj;
            //},
            position: 'right'
        },
        yAxis: [
            {
            	show:'false',
                type: 'category',
                data: [],                
                splitLine: { show: false },
                axisLabel: {
                    show: true,
                    interval: 0
                }
            },
            {
            	show:'false',
                type: 'category',
                gridIndex:1,
                data: [],                
                splitLine: { show: false },
                axisLabel: {
                    show: true,
                    interval: 0
                }
            },
            {
            	show:'false',
                type: 'category',
                gridIndex:2,
                data: [],                
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
            },
            {
                type: 'value',
                gridIndex:1,
                splitLine: { show: false },
                axisLabel: { show: false }
            },
            {
                type: 'value',
                gridIndex:2,
                splitLine: { show: false },
                axisLabel: { show: false }
            }
        ], grid: [{
           
        	top:60,
        	height :'30%',
            left: 43,
            right: 80,
            containLabel: true
        },
        {           
        	top:160,
            height :'30%',
            left: 43,
            right:48,
            containLabel: true
        },{           
        	top:260,
            height :'30%',
            left:40,
            right: 60,
            containLabel: true
        },
         ],
        backgroundColor: 'rgba(41,64,94,0.4)'
        ,
        series: [
{

    type: 'pie',
    center:['15%', '28%'],
    radius: ['20%', '25%'],
    avoidLabelOverlap: false,
    label: {
        normal: {
            show: true,
            position: 'center',
            textStyle: {
                fontSize: 18,
                fontWeight: 'bold',
                color: '#fff'
            }, formatter: function (params) {
                
                    return '企业\n95%' 
            }
        } 
    }, 
    data: [
        { value: 95, name: '企业年报率' },
        { value: 1 ,itemStyle :{normal:{color:'rgba(41,64,94,0.4)'}}} 
    ]
},
{

    type: 'pie',
    center:['15%', '55%'],
    radius: ['20%', '25%'],
    avoidLabelOverlap: false,
    label: {
        normal: {
            show: true,
            position: 'center',
            textStyle: {
                fontSize: 18,
                fontWeight: 'bold',
                color: '#fff'
            }, formatter: function (params) {
                
                    return '个体\n99%' 
            }
        } 
    }, 
    data: [
        { value: 99, name: '个体年报率' },
        { value: 1 ,itemStyle :{normal:{color:'rgba(41,64,94,0.4)'}}} 
    ]
},{

    type: 'pie',
    center:['15%', '82%'],
    radius: ['20%', '25%'],
    avoidLabelOverlap: false,
    label: {
        normal: {
            show: true,
            position: 'center',
            textStyle: {
                fontSize: 18,
                fontWeight: 'bold',
                color: '#fff'
            }, formatter: function (params) {
                
                    return '农合\n85%' 
            }
        } 
    }, 
    data: [
        { value: 85, name: '农合体年报率' },
        { value: 15 ,itemStyle :{normal:{color:'rgba(41,64,94,0.4)'}}} 
    ]
},
            {
                name: '企业应报户数',
                type: 'bar', 
                 
                data: [59107],
                barWidth: 18, 
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: ' 应报{c}户'
                    }
                }, itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
                            offset: 0,
                            color: 'rgba(3,76,122,0.7)'
                        }, {
                            offset: 1,
                            color: 'rgba(6,248,255,1)'
                        }])
                    }
                }


            },
            {
                name: '企业已报户数',
                type: 'bar',  
                
                data: [ 54747],
                barWidth: 18,
               
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: ' 已报{c}户'
                    }
                }, itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
                            offset: 0,
                            color: 'rgba(255,160,122,0.7)'
                        }, {
                            offset: 1,
                            color: 'rgba(255, 140, 0,1)'
                        }])
                    }
                }


            },
            {
                name: '个体应报户数',
                type: 'bar',
                xAxisIndex :1,
                yAxisIndex :1,
                data: [217905],
                barWidth: 18, 
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: ' 应报{c}户'
                    }
                }, itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
                            offset: 0,
                            color: 'rgba(3,76,122,0.7)'
                        }, {
                            offset: 1,
                            color: 'rgba(6,248,255,1)'
                        }])
                    }
                }


            },
            {
                name: '个体已报户数',
                type: 'bar',  
                xAxisIndex :1,
                yAxisIndex :1,
                data: [ 215905],
                barWidth: 18, 
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: ' 已报{c}户'
                    }
                }, itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
                            offset: 0,
                            color: 'rgba(255,160,122,0.7)'
                        }, {
                            offset: 1,
                            color: 'rgba(255, 140, 0,1)'
                        }])
                    }
                }


            },
            {
                name: '农合应报户数',
                type: 'bar',
                xAxisIndex :2,
                yAxisIndex :2,
                data: [9529],
                barWidth: 20, 
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: ' 应报{c}户'
                    }
                }, itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
                            offset: 0,
                            color: 'rgba(3,76,122,0.7)'
                        }, {
                            offset: 1,
                            color: 'rgba(6,248,255,1)'
                        }])
                    }
                }


            },
            {
                name: '农合已报户数',
                type: 'bar',  
                xAxisIndex :2,
                yAxisIndex :2,
                data: [ 7584],
                barWidth: 20,
               
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: '已报 {c}户'
                    }
                }, itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
                            offset: 0,
                            color: 'rgba(255,160,122,0.7)'
                        }, {
                            offset: 1,
                            color: 'rgba(255, 140, 0,1)'
                        }])
                    }
                }


            }
            
        ]
    };




    var myChart = echarts.init(document.getElementById('chart2'), 'walden');

    myChart.setOption(option);
}
 
 

function Chart3() {
	var data= [{'name':'市直','value':204,'regcap':105},
	            {'name':'新泰市','value':504,'regcap':239},
	            {'name':'肥城市','value':371,'regcap':35},
	            {'name':'宁阳县','value':551,'regcap':139},
	            {'name':'东平县','value':257,'regcap':149},
	            {'name':'泰山区','value':1280,'regcap':553},
	            {'name':'岱岳区','value':740,'regcap':421},
	            {'name':'高新区','value':146,'regcap':68},{'name':'景区','value':10,'regcap':1}]; 
	 

		option = {
				 title: [{
		                text: '重点年报对象分析',
		                top: 0,
		                x:'center',
		                textStyle: {
		                    fontSize: 20,
		                   
		                     
		                }

		            }],

	            tooltip: {
	                trigger: 'axis',
	                show: true
	            },
	            legend : {
					top : '30',
					 data : ['市场主体户数','户均资本']
				},
	            xAxis: [
	                {
	                    type: 'category',
	                    data:  $.getJsonElementArray(data,'name'),
	                    splitLine: { show: true },
	                    axisLabel: {
	                        show: true,
	                         
	    						"rotate" : 35,
	    				 
	                        interval: 0
	                    }
	                }
	            ],
	             
	            yAxis: [
	                {   name:'户数',
	                    type: 'value',
	                    splitLine: { show: false },
	                    axisLabel: {
	                        formatter: '{value} '
	                    }
	                }, {name:'补报率（%）',
	                    type: 'value',
	                    splitLine: { show: false },
	                    axisLabel: {
	                        formatter: '{value} '
	                    }
	                }
	            ], grid: [{
	                top: 50,
	                width: '95%',
	                right:30,
	                //bottom: '45%',
	                left: 20,
	                containLabel: true
	            }],
	            series: [
	                {
	                    name: '上年未年报',
	                    type: 'bar',
	                    barGap :0.1,
	                    data: data,
	                    barWidth: 10,//固定柱子宽度
	                    label: {
	                        normal: {
	                            show: true,
	                            position: 'top',

	                        }
	                    }, itemStyle: {
	                        normal: {
	                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                                offset: 0,
	                                color: 'rgba(6,248,255,1)'
	                            }, {
	                                offset: 1,
	                                color: 'rgba( 88,255,255,0.1)'
	                            }])
	                        }
	                    }


	                }, {
	                    name: '连续两年未年报',
	                    type: 'bar',
	                    data: $.getJsonElementArray(data,'regcap'),
	                    barGap :0.1,
	                    barWidth: 10,//固定柱子宽度
	                    label: {
	                        normal: {
	                            show: false,
	                            position: 'top',

	                        }
	                    }, itemStyle: {
	                        normal: {
	                            color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [{
	                                offset: 0,
	                                color: 'rgba(255,160,122,0.7)'
	                            }, {
	                                offset: 1,
	                                color: 'rgba(255, 140, 0,1)'
	                            }])
	                        }
	                    }


	                }, {
	                    name: '',
	                    type: 'line',
	                    yAxisIndex: 1,
	                    data: [5.12,61.12,10.01,88.12,50.12,28.12,3.44,8.56,1.12],
	                    barWidth: 10,//固定柱子宽度
	                    itemStyle: {
	                        normal: {
	                            color: 'yellow'
	                        }
	                    },
	                    label: {
	                        normal: {
	                            show: true,
	                            position: 'top',
	                            color: 'rgba( 255 140 0,0.1)'
	                            

	                        }
	                    } 

	                } 
	            ]
	        };

    var myChart = echarts.init(document.getElementById('chart3'), 'walden');

    myChart.setOption(option);
     
}

function chart4() {
 
var option = {
		  title: {
	            text: '年报实时监控',
	            //textAlign: 'center'
	            x:'center',
	            top: 5,
	            textStyle: {
	                fontSize: '14'
	            }

	        },
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		    	top:20,
		        data:['年报数']
		    },
		   
		    dataZoom: {
		        show: false,
		        start: 0,
		        end: 100
		    },
		    xAxis: [
		        {
		            type: 'category',
		            boundaryGap: true,
		            axisLabel: {
                        show: true,
                         
    						"rotate" : 35,
    				 
                        interval: 0
                    },
		            data: (function (){
		                var now = new Date();
		                var res = [];
		                var len = 8;
		                while (len--) {
		                    res.unshift(now.toLocaleTimeString().replace(/^\D*/,''));
		                    now = new Date(now - 20000);
		                }
		                return res;
		            })()
		        }
		         
		    ],
		    yAxis: [
		       
		        {
		            type: 'value',
		            scale: true,
		            name: '年报数',
		            splitLine: { show: false },
		            max: 120,
		            min: 0,
		            boundaryGap: [0.2, 0.2]
		        }
		    ],
		    series: [
		        {
		            name:'年报数',
		            type:'bar',   
		            
		            data:(function (){
		                var res = [];
		                var len = 8;
		                while (len--) {
		                    res.push(Math.round(Math.random() * 100));
		                }
		                return res;
		            })()
		        },
		     
		    ]
		};
		var count=11;
		 var myChart = echarts.init(document.getElementById('chart4'), 'walden');

		setInterval(function (){
		    axisData = (new Date()).toLocaleTimeString().replace(/^\D*/,'');
            
		    var data0 = option.series[0].data;
		   
		    data0.shift();
		    data0.push(Math.round(Math.random() * 100));
		 

		    option.xAxis[0].data.shift();
		    option.xAxis[0].data.push(axisData);
		  
		   
		    myChart.setOption(option);
		}, 2100); 
}
 