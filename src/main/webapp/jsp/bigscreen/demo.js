
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
            formatter: function (params, ticket, callback) {
                return params.name + '成交率' + params.value*100 + '%';
            },
            position: 'right'
        },
        yAxis: [
            {
                type: 'category',
                data: $.getJsonElementArray(salerRank,'name'),                
                splitLine: { show: false },
                axisLabel: {
                    show: true,
                    interval:2
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
/**
 * 销售报表MAP
 * @returns
 */
function initSaleReportMap() {
	var resdata=[
		{"name":"万科金域华府","position":[108.252648,27.485480],"value":2000},
		{"name":"重庆天地","position":[106.252648,23.485480],"value":1800},
		{"name":"万科观承","position":[106.052648,27.485480],"value":1700},
		{"name":"万科金域蓝湾","position":[106.944707,25.985633],"value":1500},
		{"name":"万科江上明月","position":[106.28736,25.363147],"value":1400},
		{"name":"万科金色悦城","position":[106.262654,26.311847],"value":1400},
		{"name":"万科御澜道","position":[108.335570,25.355060],"value":1200},
		{"name":"万科金域学府","position":[109.031240,27.294028],"value":1150},
		{"name":"万科御澜山","position":[108.31327,26.383661],"value":1000},
	];
	var getPosition=function(data){
		var resp = [];
		$.each(data,function(i,node){
			var p = new Object();
			p.name = node.name;
			p.coord = node.position;
			p.value = node.value;
			//p.symbol = 'image://'+basepath+'skin/images/gs.ico',
			p.label = {
				normal:{
                    offset:[-20,0],
				}
			};
			resp.push(p);
		});
		return resp;
	}
    $.ajax({
        url: basepath+'skin/plugins/echarts/data/52.json',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            echarts.registerMap('chongqing', data); 
            option = {
                baseOption: {
                    title: {
                        text: '重庆万科地产项目销售报表',
                        textStyle: {
                            fontSize: '16'
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
                    },
                    series : [
                    	{
                    		type: 'map',
                            map: 'chongqing',
                            markPoint: {
				                symbolSize:20,
				                label:{
				                    normal:{
				                        show:true,
				                        formatter: '{b}',
				                        textStyle:{
				                        	color:'red',
				                        	fontWeight:'bold'
				                        }
				                    }
				                },
				                data: getPosition(resdata)
				            }
                    	}
                    ]
                },  
            }
            var myChart = echarts.init(document.getElementById('saleReportMap'), 'walden');
            myChart.setOption(option);
          
        }
    })

}
/**
 * 销售报表BAR
 * @returns
 */
function initSaleReportBar() {
	var resdata=[
		{"name":"万科金域华府","position":[106.252648,28.485480],"value":2000},
		{"name":"重庆天地","position":[106.252648,28.485480],"value":1800},
		{"name":"万科观承","position":[106.252648,28.485480],"value":1700},
		{"name":"万科金域蓝湾","position":[106.344707,28.385633],"value":1500},
		{"name":"万科江上明月","position":[106.28736,28.363147],"value":1400},
		{"name":"万科金色悦城","position":[106.262654,29.311847],"value":1400},
		{"name":"万科御澜道","position":[106.335570,29.355060],"value":1200},
		{"name":"万科金域学府","position":[106.331240,29.294028],"value":1150},
		{"name":"万科御澜山","position":[106.31327,29.383661],"value":1000},
	];
    option = {
		title: {
            text: '重庆万科地产项目销售报表',
            textStyle: {
                fontSize: '16'
            },
            left:'center',
            top: 20
        },
        grid: {
            left: 25
        },
        xAxis: {
            type: 'category',
            splitLine: { show: false },
            data:$.getJsonElementArray(resdata,'name'),
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
                data: $.getJsonElementArray(resdata,'value'),
                itemStyle: {
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

    var myChart = echarts.init(document.getElementById('saleReportBar'), 'walden');

    myChart.setOption(option);
     
}
/**
 * 金域华府项目成交率趋势
 * @returns
 */
function initSaleLine(){
	 var data=[
		 {"name":"4月1日","value":23},
		 {"name":"4月2日","value":27},
		 {"name":"4月3日","value":29},
		 {"name":"4月4日","value":25},
		 {"name":"4月5日","value":22},
		 {"name":"4月6日","value":24},
		 {"name":"4月7日","value":30},
		 {"name":"4月8日","value":31},
		 {"name":"4月9日","value":27},
		 {"name":"4月10日","value":24},
		 {"name":"4月11日","value":30},
		 {"name":"4月12日","value":31},
		 {"name":"4月13日","value":27},
		 {"name":"4月14日","value":28},
		 {"name":"4月15日","value":32},
		 {"name":"4月16日","value":26},
		 {"name":"4月17日","value":23},
		 {"name":"4月18日","value":22},
		 {"name":"4月19日","value":23},
		 {"name":"4月20日","value":24},
		 {"name":"4月21日","value":29},
		 {"name":"4月22日","value":33},
		 {"name":"4月23日","value":34},
		 {"name":"4月24日","value":22},
		 {"name":"4月25日","value":21},
		 {"name":"4月26日","value":22},
		 {"name":"4月27日","value":20},
		 {"name":"4月28日","value":27},
		 {"name":"4月29日","value":28},
		 {"name":"4月30日","value":23}
	 ];
	    var option = {
	        tooltip: {
	            trigger: 'axis', 
	        },
	        backgroundColor: 'rgba(41,64,94,0.4)',
	        title: {
	            text: '金域华府项目成交率趋势',	               
	            left: 'center',
	            textStyle: {
	                color: '#fff'
	            }
	        },
	        xAxis: {
	            type: 'category',
	            boundaryGap: true,
	            splitLine: { 
	            	show: true , 
	            },
            	axisLabel: {
                    show: true,
                    interval: 3,
                    "rotate" : 35,
                },
	            data: $.getJsonElementArray(data,'name')
	        },
	        yAxis: [{
	            type: 'value',
	            splitLine: { show: false }, 
	         
	            axisLabel: {
	                formatter: '{value} '
	            }
	        }],
	        grid: {
	            top: 30,
	            left: 60,
	            right: 60
	        },

	        series: [
	           {
	               name: '成交额',
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
	               data: $.getJsonElementArray(data,'value')
	           }  
	        ]
	    };
	    var myChart = echarts.init(document.getElementById('saleLine'), 'walden');
	    myChart.setOption(option);
}
/**
 * 客户来访渠道
 * */
function initSalePie() {
	var data= [
		 {'name':'老客户介绍','value':26},
         {'name':'户外广告','value':21},
         {'name':'流动媒体','value':16},
         {'name':'网络电视','value':13},
         {'name':'报纸杂志','value':9},
         {'name':'传单','value':8},
         {'name':'项目围墙','value':7}
         ]
	option = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: 数量{c} <br/>占比({d}%)同比（12.13%）"
		},
		backgroundColor: 'rgba(41,64,94,0.4)',
		title : [ {
			text : '客户来访渠道',
			top : 0,
			x : 'center',
			textStyle : {
				fontSize : 16,
			}

		}, ],
		series : [ {
			name : '占比',
			type : 'pie',
			radius : [ '30%', '70%' ],
			center : [ '50%', '50%' ],
			avoidLabelOverlap : false,
			labelLine : {
				normal : {
					show : true
				}
			},
			label : {
				normal : {
					show : true
				}
			},
			data : data
		} ]
	};
	var myChart = echarts.init(document.getElementById('salePie'), 'walden');
	myChart.setOption(option);
}
