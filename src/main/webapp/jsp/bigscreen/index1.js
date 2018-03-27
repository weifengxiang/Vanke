function Chart1() {
	var tb=[(Math.random()*20).toFixed(2),(Math.random()*10).toFixed(2),(Math.random()*5).toFixed(2)];
	var data= [
                     { value: 7527, name: '企业' },
                     { value: 16102, name: '个体' },
                     { value: 810, name: '农合' },
                     
                 ];
	 
	 option = {
	            tooltip: {
	                trigger: 'item',
	                formatter: "{a} <br/>{b}: 数量{c} <br/>占比({d}%)同比（12.13%）"
	            },
	           
	            title: [{
	                text: '2017年度新增主体企业类别占比',
	                top: 0,
	                x:'center',
	                textStyle: {
	                    fontSize: 16,
	                   
	                     
	                }

	            },
	            {
	                text:data[0].value+'户\n同比：'+tb[0]+'%',
	                subtext:data[0].name ,
	                left: '50%',
	                top: '50%',
	                textAlign: 'center',
	                textBaseline: 'middle',
	                subtextStyle: {
	                     
	                    fontWeight: 'normal',
	                    fontSize: 18
	                },
	                textStyle: {
	                     
	                    fontWeight: 'normal',
	                    fontSize: 24
	                }
	            }],
	              //color: ['#203CFC', '#04B6FD', '#00FDFF', '#382048'],
	            series: [
	                {
	                    name: '主体占比',
	                    type: 'pie',
	                     
	                    radius: ['50%', '80%'],
	                    center: ['50%', '55%'],
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
	                }
	            ]
	        };

	        var myChart = echarts.init(document.getElementById('chart1'), 'walden');

	        myChart.setOption(option);
	        i=-1;
	        setInterval(function (){
	        	if(i<2)
	        		i++;
	        	else
	        		i=0;
	        	for(j=0;j<data.length;j++){
	        		if(j!=i)
	        			 data[j].selected=false;
	        	}  data[i].selected=true;
	        	 option = {
	     	            
	     	            title: [{
	     	                text: '2017年度新增主体企业类别占比',
	     	                top: 0,
	     	                x:'center',
	     	                textStyle: {
	     	                    fontSize: 16,
	     	                     
	     	                }

	     	            },
	     	            {
	     	                text:data[i].value+'户\n同比'+tb[i]+'%',
	     	                subtext:data[i].name , 
	     	            }],
	     	           series: [
	     		                {   
	     		                    data:  data
	     		                }
	     		            ]
	     	            
	     	        };
	        	 
			   
			    myChart.setOption(option);
			}, 2100); 
}
function Chart2() { 
	var data= [
               { value: 14823, name: '批发零售业'},
               { value: 4485, name: '住宿和餐饮业' },
               { value: 3266, name: '居民服务、修理和其他服务业' },
               { value: 2521, name: '制造业' },
               { value: 2063, name: '农林牧渔业' },
               { value: 1627, name: '租赁和商业服务业' },
               { value: 1312, name: '建筑业' },
               { value: 723, name: '科学研究和技术服务业' },
               { value: 379, name: '文化、体育和娱乐业' },
               { value: 560, name: '交通运输、仓储和邮政服务业' },
               { value: 500, name: '信息传输、软件和信息技术服务业' },
               { value: 92, name: '电力、热力燃气及水生产和供应业' },
               { value: 288, name: '房地产业' },
               { value: 204, name: '教育' },
               { value: 54, name: '卫生、社会工作' },
               { value: 20, name: '采矿业' },

               
           ];
	option = {
		    title: {
		        text: '行业活力分析',
		       
		        x: 'center',
		        textStyle: {
		            fontSize: 16
		        }

		    },
		    
		    tooltip: {
		        show: true
		    },
		    
		    series: [{
		        name: '行业活力分析',
		        type: 'wordCloud',
		        size: ['9%', '99%'],
		        sizeRange: [20, 66],
		        textRotation: [0, 45, 90, -45], 
		        shape: 'circle',
		        textPadding: 0,
		        autoSize: {
		            enable: true,
		            minSize: 20
		        },
		     
		        data: data
		    }]
		};
    var myChart = echarts.init(document.getElementById('chart2'), 'walden');
    myChart.setOption(option);
}
function Chart3() {
 var data= [{'name':'市直','value':443,'regcap':1641.14},{'name':'新泰市','value':7201,'regcap':450.09},{'name':'肥城市','value':5303,'regcap':122.05},{'name':'宁阳县','value':3479,'regcap':165.28},{'name':'东平县','value':3177,'regcap':154.11},{'name':'泰山区','value':7008,'regcap':174.11},{'name':'岱岳区','value':4296,'regcap':340.86},{'name':'高新区','value':1190,'regcap':231.14},{'name':'景区','value':86,'regcap':117.14}]; 

	option = {
			 title: [{
	                text: '各辖区市场主体分布情况',
	                top: 0,
	                x:'left',
	                textStyle: {
	                    fontSize: 16,
	                   
	                     
	                }

	            }],

            tooltip: {
                trigger: 'axis',
                show: true
            },
            legend : {
				top : '20',
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
            yAxis: [
                {   name:'户数',
                    type: 'value',
                    splitLine: { show: false },
                    axisLabel: {
                        formatter: '{value} '
                    }
                }, {name:'万元',
                    type: 'value',
                    splitLine: { show: false },
                    axisLabel: {
                        formatter: '{value} '
                    }
                }
            ], grid: [{
                //top: 50,
                //width: '50%',
                //bottom: '45%',
                left: 10,
                containLabel: true
            }],
            series: [
                {
                    name: '市场主体户数',
                    type: 'bar',
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
                    name: '户均资本',
                    type: 'line',
                    yAxisIndex: 1,
                    data: $.getJsonElementArray(data,'regcap'),
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
function Chart4() { 
	 var data= [{'name':'第一产业','value':1443},
	            {'name':'第二产业','value':4443},
	            {'name':'第三产业','value':13443}]
	option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: 数量{c} <br/>占比({d}%)同比（12.13%）"
            },
           
            title: [{
                text: '产业分布',
                top: 0,
                x:'center',
                textStyle: {
                    fontSize: 16,
                   
                     
                }

            },
             ],
              //color: ['#203CFC', '#04B6FD', '#00FDFF', '#382048'],
            series: [
                {
                    name: '主体占比',
                    type: 'pie', 
                    roseType: 'radius',
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
                    data:  data
                }
            ]
        };

    var myChart = echarts.init(document.getElementById('chart4'), 'walden');

    myChart.setOption(option);
}
function Chart5() {
	  option = {

	            tooltip: {
	                show: true
	            },
	            title: {
			        text: '主体规模',
			       
			        x: 'center',
			        textStyle: {
			            fontSize: 16
			        }

			    },
			    
	            yAxis: [
	                {
	                    type: 'category',

	                    data: ['10万以下', '10-50万', '50-100万', '100-1000万', '1000万-1亿', '1亿以上'],
	                    splitLine: { show: false },
	                    axisLabel: {
	                        show: true,

	                        interval: 0
	                    }
	                }, {
	                    type: 'category',

	                    data: ['10万以下', '10-50万', '50-100万', '100-1000万', '1000万-1亿', '1亿以上'],
	                    axisLine: { show: false },
	                    axisTick: { show: false },
	                    axisLabel: {
	                        show: false,
	                        inside: true
	                    },
	                    splitArea: { show: false },
	                    splitLine: { show: false }

	                } 
	            ],
	            xAxis: [
	                {
	                    type: 'value',
	                    max: 120000,
	                    min: 0,
	                    splitLine: { show: false },
	                    axisLabel: { show: false }
	                }
	            ], grid: [{
	                top: 20,
	                //width: '50%',
	                //bottom: '45%',
	                left: 0,
	                bottom: 0,
	                right: 0,
	                containLabel: true
	            }],

	            series: [
	                {
	                    name: '数量',
	                    type: 'bar',
	                    data: [79912, 45896, 18411, 25887, 7204, 1054],
	                    barWidth: 20,
	                    
	                    label: {
	                        normal: {
	                            show: false,
	                            position: 'right',

	                        }
	                    }, itemStyle: {
	                        normal: {
	                            color: '#81FFFE',
	                            barBorderRadius: [0, 5, 5, 0]
	                        }
	                    }


	                },   {

	                    type: 'bar',
	                    data: [150000, 150000, 150000, 150000, 150000, 150000],
	                    barWidth: 22,
	                    
	                    yAxisIndex: 1,
	                    itemStyle: {
	                        normal: {
	                            borderColor: 'rgba(204,206,219, 1)',
	                            color: 'rgba(204,206,219,0.3)',
	                            borderWidth: 5,
	                            barBorderRadius: [0, 5, 5, 0],

	                        }, emphasis: {
	                            borderColor: '#CCCEDB',
	                            borderWidth: 2,

	                        }
	                    }


	                }
	            ]
	        };
    var myChart = echarts.init(document.getElementById('chart5'), 'walden');

    myChart.setOption(option);
}

function Chart6() {
	var data= [{'name':'201608','value':443,'regcap':1641},
	           {'name':'201609','value':7201,'regcap':1450},
	           {'name':'201610','value':5303,'regcap':1022},
	           {'name':'201611','value':3479,'regcap':665},
	           {'name':'201612','value':3177,'regcap':454},
	           {'name':'201701','value':7008,'regcap':744},
	           {'name':'201702','value':4296,'regcap':340},
	           {'name':'201703','value':1190,'regcap':231},
	           {'name':'201704','value':86,'regcap':817},
	           {'name':'201705','value':1286,'regcap':1390},
	           {'name':'201706','value':486,'regcap':1777},
	           {'name':'201707','value':286,'regcap':1071}]; 

	option = {
			 title: [{
	                text: '近12个月新增市场主体走势',
	                top: 0,
	                x:'left',
	                textStyle: {
	                    fontSize: 16,
	                   
	                     
	                }

	            }],

            tooltip: {
                trigger: 'axis',
                show: true
            },
            legend : {
				top : '20',
				 data : ['企业','个体','农合']
			},
            xAxis: [
                {
                    type: 'category',
                    data:  $.getJsonElementArray(data,'name'),
                    splitLine: { show: true },
                    axisLabel: {
                        show: true,

                        interval: 0,
                      
						"rotate" : 35,
						"show" : true,
                    }
                }
            ],
            yAxis: [
                {   name:'户数',
                    type: 'value',
                    splitLine: { show: false },
                    
                    axisLabel: {
                    	show:false,
                        formatter: '{value} '
                    }
                } 
            ], grid: [{
                //top: 50,
                //width: '50%',
                //bottom: '45%',
                left: 0,
                containLabel: true
            }],
            series: [
                {
                    name: '个体',
                    type: 'line',
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
                    name: '企业',
                    type: 'line',
                    yAxisIndex: 0,
                    data: $.getJsonElementArray(data,'regcap'),
                  
                    
					 
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            color: 'rgba( 255 140 0,0.1)'
                            

                        }
                    } 

                } 
                , {
                    name: '农合',
                    type: 'line',
                    yAxisIndex: 0,
                    data: [90,189,99,78,198,578,287,103,984,883,112,33],
                    barWidth: 10,//固定柱子宽度
                     
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
    var myChart = echarts.init(document.getElementById('chart6'), 'walden');

    myChart.setOption(option);
}
function Chart7() {
    option = {
        title: {
            text: '被诉热点服务(top6) %',
            //textAlign: 'center'
            left: '5%',
            top: 20,
            textStyle: {
                fontSize: '14px'
            }

        },
        tooltip: {

            formatter: function (params, ticket, callback) {

                return params.name + '百分比' + params.value + '%，数量' + params.value * 100;
            }
        }, grid: {

            left: 10
        },
        xAxis: {
            type: 'category',

            splitLine: { show: false },
            data: ['培训服务', '住宿服务', '家电售后', '境内旅游', '车辆出租', '餐饮服务'],
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
                data: [8, 9, 17, 20, 25, 28]
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

    var myChart = echarts.init(document.getElementById('chart7'), 'walden');

    myChart.setOption(option);
    option = {
        title: {
            text: '被诉热点商标(top6) %',
            //textAlign: 'center'
            left: '5%',
            top: 20,
            textStyle: {
                fontSize: '14px'
            }

        },
        tooltip: {
            show: true,
            formatter: function (params, ticket, callback) {

                return params.name + '百分比' + params.value + '%，数量' + params.value * 100;
            }
        }, grid: {

            left: 10
        },
        xAxis: {
            type: 'category',

            splitLine: { show: false },
            data: ['百龄堂', '益倍诺', '百龄堂', '极核5S', '卡乐比', '和光堂'],
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
                data: [4, 6, 7, 7, 8, 9]
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
    var myChart = echarts.init(document.getElementById('chart8'), 'walden');

    myChart.setOption(option);
}

 