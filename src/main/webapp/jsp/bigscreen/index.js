function Chart1() {
	var years=[ '2014','2015','2016','2017'];
    $.ajax({
        url: basepath+'skin/plugins/echarts/data/taian.json',
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
function Chart2() {

    option = {
        title: {
            text: '各地区新增市场主体排名'
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
            formatter: function (params, ticket, callback) {

                return params.name + '新增市场主体' + params.value + '户';
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
                data: ['景区', '高新区', '东平县', '宁阳县', '岱岳区', '肥城市', '泰山区', '新泰市'],                
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
                data: [82,1011,2580,2751,3821,4549,5767,6194],
                barWidth: 30,
               
                label: {
                    normal: {
                        show: true,
                        position: 'right',
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




    var myChart = echarts.init(document.getElementById('chart2'), 'walden');

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
/*
function Chart6() {





    //option = {
    //    title: {
    //        text: '被诉热点行为',
    //        //textAlign: 'center'
    //        left: '20%'
    //        ,
    //        top: 20,
    //        textStyle: {
    //            fontSize: '14px'
    //        }
    //    },
    //    tooltip: {
    //        trigger: 'axis'
    //    },
    //    //legend: {
    //    //    data: ["总数", "投诉", "举报"],
    //    //    bottom: 5,
    //    //    right: 0,
    //    //    left:0
    //    //    //orient: 'vertical'
    //    //},

    //    xAxis: {
    //        type: 'category',
    //        boundaryGap: false,
    //        splitLine: { show: false },
    //        data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
    //        axisLabel: {
    //            show: true,

    //        }
    //    },
    //    yAxis: {
    //        type: 'value',
    //        splitLine: { show: true },
    //        axisLabel: {
    //            show: false
    //        }
    //    }, grid: {

    //        left: 10
    //    }, backgroundColor: 'rgba(41,64,94,0.4)'
    //    ,
    //    series: [
    //        {
    //            name: '总数',
    //            type: 'line',
    //            label: {
    //                normal: {
    //                    show: true,
    //                    position: 'top',

    //                }
    //            },
    //            data: [40, 51, 53, 64, 65, 70, 78, 80, 82, 85, 90, 95]
    //        }, {
    //            name: '投诉',
    //            type: 'line',
    //            label: {
    //                normal: {
    //                    show: true,
    //                    position: 'top',

    //                }
    //            },
    //            data: [30, 21, 43, 44, 55, 40, 48, 50, 50, 45, 60, 75]
    //        }, {
    //            name: '举报',
    //            type: 'line',
    //            label: {
    //                normal: {
    //                    show: true,
    //                    position: 'top',

    //                }
    //            },
    //            data: [10, 30, 10, 20, 10, 30, 30, 30, 32, 40, 30, 15]
    //        }
    //    ]
    //};
    option = {
        title: {
            text: '被诉热点商品(top6) %',
            //textAlign: 'center'
            left: '5%',
            top: 20,
            textStyle: {
                fontSize: '14px'
            }

        },
        tooltip: {
            show: true
            , formatter: function (params, ticket, callback) {

                return params.name + '百分比' + params.value + '%，数量' + params.value * 100;
            }
        }, grid: {

            left: 10
        },
        xAxis: {
            type: 'category',

            splitLine: { show: false },
            data: ['米面制品', '空调产品', '移动电话', '装修建材', '婴幼儿食品', '保健品'],
            axisLabel: {
                show: true,
                rotate: 50,
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
                barWidth: 10,//固定柱子宽度
                label: {
                    normal: {
                        show: true,
                        position: 'top',

                    }
                },
                data: [5, 6, 8, 19, 25, 30]
                , itemStyle: {
                    normal: {
                        color: function (params) {
                            if (params.value >= 30) {
                                return new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(153,0,0,1)'
                                }, {
                                    offset: 1,
                                    color: 'rgba( 250,59,24,0.4)'
                                }]);
                            } else if (params.value >= 20 && params.value < 30) {
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
    var myChart = echarts.init(document.getElementById('chart6'), 'walden');

    myChart.setOption(option);
}*/
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
	/*
    var base = +new Date(2016, 12, 0);
    var oneDay = 24 * 3600 * 1000;
    var date = [];

    var data = [Math.random() * 1000];

    for (var i = 1; i < 366; i++) {
        var now = new Date(base += oneDay);
        date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'));
        data.push(parseInt( Math.abs(Math.round((Math.random() - 0.5) * 20) + data[i - 1])));
    }

    option = {
        title: {
            text: '消费投诉举报实时监控',
            //textAlign: 'center'
            x:'center',
            top: 5,
            textStyle: {
                fontSize: '14'
            }

        }, tooltip: {
            trigger: 'axis',
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            splitLine: { show: false },
            data: date
        },
        yAxis: {
            type: 'value',
            splitLine: { show: false },
            axisLabel: {
                show: false
            },
            boundaryGap: [0, '100%']
        },
        grid: {

            left: 25,
            right: 10
        },

        series: [
            {
                name: '被诉主体',
                type: 'line',
                smooth: true,
                symbol: 'none',
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: 'rgb(8,146,220)'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgb(1,241,209)'
                        }, {
                            offset: 1,
                            color: 'rgb(8,146,220)'
                        }])
                    }
                },
                data: data
            }
        ]
    };
    var myChart = echarts.init(document.getElementById('chart9'), 'walden');

    myChart.setOption(option);*/
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