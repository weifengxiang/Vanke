function Chart1() {
	var years=[ '2014','2015','2016','2017'];
    $.ajax({
        url: basepath+'skin/plugins/echarts/data/52.json',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            echarts.registerMap('taian', data); 
            option = {
                baseOption: {
               
                    title: {
                        text: '各地区主体发展情况'
                        ,
                        textStyle: {
                            fontSize: '20'
                        },
                        left:'center',
                        top: 20
                    },
                    tooltip: {
                        trigger: 'item',
                        show: true,
                        formatter: function (params) {
                            return params.name + ' : ' + params.value;
                        }
                    },
                    backgroundColor: 'rgba(41,64,94,0.4)',
                    
                    visualMap: {
                        min: 0,
                        max: 1000,
                        calculable: true,
                        bottom: 50,
                        type: 'piecewise',
                        inRange: {
                        	color: ['lightskyblue', 'yellow', 'orangered']
                        },
                        textStyle: {
                            color: '#fff'
                        }
                    }, series: [
                                {
                                    name: '市场主体数量',
                                    type: 'map',
                                    map: 'taian',
                                    data: [
                                           { name: '新泰市', value: Math.round(Math.random() * 1000) },
                        { name: '肥城市', value: Math.round(Math.random() * 1000) },
                        { name: '宁阳县', value: Math.round(Math.random() * 1000) },
                        { name: '东平县', value: Math.round(Math.random() * 100) },
                        { name: '泰山区', value: Math.round(Math.random() * 100) },
                        { name: '岱岳区', value: Math.round(Math.random() * 100) },
                        
                                    ],
                                    label:{
						        		normal:{
						        			show:true,
						        			textStyle:{
						        				fontWeight:'bold',
						        				fontSize:12
						        			}
						        		}
						        },
						       
                                    itemStyle: {
                                        emphasis: {
                                            borderColor: '#fff',
                                            borderWidth: 1
                                        }
                                    },
                                    zoom:0.8,
                                    top: 0,
                                    bottom: 50

                                }
                    ]

                },
                
            }
            
            var myChart = echarts.init(document.getElementById('chart1'), 'walden');
            myChart.setOption(option);
          
        }, error: function (a, b, c) {
            alert(c);
        }
    })

}
/**
 * 销售排行榜
 * */
function initSalerRankingChart() {
	var salerRank=[
		{"name":"A","value":0.203},
		{"name":"B","value":0.198},
		{"name":"C","value":0.190},
		{"name":"D","value":0.172},
		{"name":"E","value":0.169},
		{"name":"F","value":0.165},
		{"name":"G","value":0.161},
		{"name":"H","value":0.154},
		{"name":"I","value":0.154},
		{"name":"J","value":0.152},
		{"name":"K","value":0.151},
		{"name":"L","value":0.148},
		{"name":"M","value":0.143},
		{"name":"N","value":0.140},
		{"name":"O","value":0.101},
		{"name":"P","value":0.097},
		{"name":"Q","value":0.095},
		{"name":"R","value":0.092},
		{"name":"S","value":0.089},
		{"name":"T","value":0.088}
	];
    option = {
        title: {
            text: '金域华府项目置业顾问成交率总排名'
            ,
            textStyle: {
                fontSize: '16'
            },
            left:'center',
            top: 20
        },

        tooltip: {
            show: true,
            //   formatter: ' {b}被诉百分比{c}%,数量{c}',
            formatter: function (params, ticket, callback) {
                return params.name + '成交率' + params.value*100 + '%';
            },
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
                type: 'category',
                data: $.getJsonElementArray(salerRank,'name'),                
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
            right: 37,
            containLabel: true
        }],
        backgroundColor: 'rgba(41,64,94,0.4)'
        ,
        series: [
            {
                name: '数量',
                type: 'bar',             
                data: $.getJsonElementArray(salerRank,'value'),
                barWidth: 30,
               
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter:function(params, ticket, callback) {
                            return  (params.value*100).toFixed(2) + '%';
                        },
                        color:'#FFF'
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
            }
            
        ]
    };
    var myChart = echarts.init(document.getElementById('salerRanking'), 'walden');
    myChart.setOption(option);
}
/**
 * 销售团队排行榜
 * */
function initSaleTeamRankingChart() {
	var saleTeamRank=[
		{"name":"飞鹰","value":0.25},
		{"name":"狼牙","value":0.22},
		{"name":"跃虎","value":0.19}
	];
    option = {
        title: {
            text: '金域华府项目销售团队成交率排名'
            ,
            textStyle: {
                fontSize: '16'
            },
            left:'center',
            top: 20
        },

        tooltip: {
            show: true,
            //   formatter: ' {b}被诉百分比{c}%,数量{c}',
            formatter: function (params, ticket, callback) {
                return params.name + '成交率' + params.value*100 + '%';
            },
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
                type: 'category',
                data: $.getJsonElementArray(saleTeamRank,'name'),                
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
            right: 37,
            containLabel: true
        }],
        backgroundColor: 'rgba(41,64,94,0.4)'
        ,
        series: [
            {
                name: '数量',
                type: 'bar',             
                data: $.getJsonElementArray(saleTeamRank,'value'),
                barWidth: 30,
               
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter:function(params, ticket, callback) {
                            return  (params.value*100).toFixed(2) + '%';
                        },
                        color:'#FFF'
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


            }
            
        ]
    };
    var myChart = echarts.init(document.getElementById('saleTeamRanking'), 'walden');
    myChart.setOption(option);
}
function Chart3() {
	 option = {
	           
	            title: {
	                text: '全市年报情况'
	                ,
	                textStyle: {
	                    fontSize: '20'
	                },
	               
	                left:'center',
	                top: 15
	            },
	            
	            series: [
	                {

	                    type: 'pie',
	                    radius: ['90%', '70%'],
	                    avoidLabelOverlap: false,

	                    
	                    data: [
	                        

	                    ]
	                }
	            ]
	        };
    var myChart = echarts.init(document.getElementById('chart3'), 'walden');

    myChart.setOption(option);
}
function Chart4() {

    option = {        
         
        color: ['#3DA8EA', 'rgba(1,7,55,0.1)'],
        series: [
            {

                type: 'pie',
                radius: ['90%', '70%'],
                avoidLabelOverlap: false,

                label: {
                    normal: {
                        show: true,
                        position: 'center',
                        textStyle: {
                            fontSize: '14',
                            fontWeight: 'bold',
                            color: '#fff'
                        }, formatter: function (params) {
                            if (params.name == '年度检查完成比例') {
                                return '95%'
                            }
                        }
                    }

                },
                data: [
                    { value: 335, name: '年度检查完成比例' },
                    { value: 10 }

                ]
            }
        ]
    };
    var myChart = echarts.init(document.getElementById('chart4'), 'walden');

    myChart.setOption(option);
    option = {
          
            color: ['#3DA8EA', 'rgba(1,7,55,0.1)'],
            series: [
                {

                    type: 'pie',
                    radius: ['90%', '70%'],
                    avoidLabelOverlap: false,

                    label: {
                        normal: {
                            show: true,
                            position: 'center',
                            textStyle: {
                                fontSize: '14',
                                fontWeight: 'bold',
                                color: '#fff'
                            }, formatter: function (params) {
                                if (params.name == '年度检查合格比例') {
                                    return '85%'
                                }
                            }
                        }

                    },
                    data: [
                        { value: 85, name: '年度检查合格比例' },
                        { value: 15 }

                    ]
                }
            ]
        };
        myChart = echarts.init(document.getElementById('chart5'), 'walden');
        myChart.setOption(option);
        option = {
                
                color: ['#3DA8EA', 'rgba(1,7,55,0.1)'],
                series: [
                    {

                        type: 'pie',
                        radius: ['90%', '70%'],
                        avoidLabelOverlap: false,

                        label: {
                            normal: {
                                show: true,
                                position: 'center',
                                textStyle: {
                                    fontSize: '14',
                                    fontWeight: 'bold',
                                    color: '#fff'
                                }, formatter: function (params) {
                                    if (params.name == '年度检查合格比例') {
                                        return '99%'
                                    }
                                }
                            }

                        },
                        data: [
                            { value: 99, name: '年度检查合格比例' },
                            { value: 1 }

                        ]
                    }
                ]
            };
            myChart = echarts.init(document.getElementById('chart6'), 'walden');
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

function chart9() {
	
var option = {
		  title: {
	            text: '消费投诉举报实时监控',
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
		        data:['分流数量', '接电数量']
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
		            data: (function (){
		                var now = new Date();
		                var res = [];
		                var len = 8;
		                while (len--) {
		                    res.unshift(now.toLocaleTimeString().replace(/^\D*/,''));
		                    now = new Date(now - 2000);
		                }
		                return res;
		            })()
		        }
		         
		    ],
		    yAxis: [
		       
		        {
		            type: 'value',
		            scale: true,
		            name: '接电数量',
		            splitLine: { show: false },
		            max: 120,
		            min: 0,
		            boundaryGap: [0.2, 0.2]
		        }
		    ],
		    series: [
		        {
		            name:'接电数量',
		            type:'line',   
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
		           
		            data:(function (){
		                var res = [];
		                var len = 8;
		                while (len--) {
		                    res.push(Math.round(Math.random() * 100));
		                }
		                return res;
		            })()
		        },
		        {
		            name:'分流数量',
		            type:'line',
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
		            data:(function (){
		                var res = [];
		                var len = 0;
		                while (len < 8) {
		                    res.push((Math.random()*10 + 5).toFixed(0) - 0);
		                    len++;
		                }
		                return res;
		            })()
		        }
		    ]
		};
		var count=11;
		 var myChart = echarts.init(document.getElementById('chart9'), 'walden');
		setInterval(function (){
		    axisData = (new Date()).toLocaleTimeString().replace(/^\D*/,'');
            
		    var data0 = option.series[0].data;
		    var data1 = option.series[1].data;
		    data0.shift();
		    data0.push(Math.round(Math.random() * 100));
		    data1.shift();
		    data1.push((Math.random() * 10 + 5).toFixed(0) - 0);

		    option.xAxis[0].data.shift();
		    option.xAxis[0].data.push(axisData);
		  
		   
		    myChart.setOption(option);
		}, 2100); 
}
function chart10() { 
    option = {
        title: {
            text: '按行业新增市场主体top5',
            //textAlign: 'center'
            x:'center',
            top: 5,
            textStyle: {
                fontSize: '14'
            }

        } ,
        tooltip: {
            show: true,
            //   formatter: ' {b}被诉百分比{c}%,数量{c}',
            formatter: function (params, ticket, callback) {

                return params.name + ':' + params.value + '户';
            },
           
            position: 'right'
        },
        yAxis: [
				{
				    type: 'value',
				    show:false,
				    splitNumber :4,
				    splitLine: { show: false },
				    axisLine: { show: false },
				    axisLabel: {
                        show: false,
                        
                    },
				    
				}
			],
        xAxis: [
                {
                    type: 'category',
                    data: ['批发零售业', '制造业', '住宿餐饮业', '农林牧渔', '交通运输'],   
                    axisLabel: {
                        show: true,
                        interval: 0
                    },
                   
                }
            
        ], grid: [{
            //top: 50,
            //width: '50%',
            //bottom: '45%',
            left: -10,
            right: 10,
            containLabel: true
        }],
        
        series: [
            {
                name: '数量',
                type: 'bar',             
                data: [2742,1923,1027,980,578],
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
                            color: 'rgba(3,76,122,0.7)'
                        }, {
                            offset: 1,
                            color: 'rgba(6,248,255,1)'
                        }])
                    }
                }


            }
        ]
        
        
    };
    var myChart = echarts.init(document.getElementById('chart10'), 'walden');

    myChart.setOption(option);
}