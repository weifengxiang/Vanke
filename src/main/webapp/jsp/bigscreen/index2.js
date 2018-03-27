function Chart1() {
	  
	  var myHosName = '泰安市';
	  option = null;
	  var geoCoordMap = {
	      '安徽省': [117.17, 31.52],
	      '泰安市': [117.088539,36.203851],
	      '重庆市': [106.54, 29.59],
	      '福建省': [119.18, 26.05],
	      '甘肃省': [103.51, 36.04],
	      '广东省': [113.14, 23.08],
	      '广西壮族自治区': [108.19, 22.48],
	      '贵州省': [106.42, 26.35],
	      '海南省': [110.20, 20.02],
	      '河北省': [114.30, 38.02],
	      '河南省': [113.40, 34.46],
	      '黑龙江省': [128.36, 45.44],
	      '湖北省': [112.27, 30.15],
	      '湖南省': [112.59, 28.12],
	      '吉林省': [125.19, 43.54],
	      '江苏省': [118.46, 32.03],
	      '江西省': [115.55, 28.40],
	      '辽宁省': [123.25, 41.48],
	      '内蒙古': [108.41, 40.48],
	      '宁夏回族自治区': [106.16, 38.27],
	      '青海省': [101.48, 36.38],
	      '山东省': [118.00, 36.40],
	      '山西省': [112.33, 37.54],
	      '陕西省': [108.57, 34.17],
	      '上海市': [121.29, 31.14],
	      '海南': [108.77, 19.10],
	      '四川省': [104.04, 30.40],
	      '天津市': [117.12, 39.02],
	      '西藏自治区': [91.08, 29.39],
	      '新疆维吾尔自治区': [87.36, 43.45],
	      '云南省': [102.42, 25.04],
	      '浙江省': [120.10, 30.16],
	      '澳门': [115.07, 21.33],
	      '台湾省': [121.21, 23.53]
	  };

	  var BJData = [
	      [{
	          name: '泰安市'
	      }, {
	          name: '上海市',
	          value: 195
	      }],
	      [{
	          name: '泰安市'
	      }, {
	          name: '广东省',
	          value: 90
	      }],
	      [{
	          name: '泰安市'
	      }, {
	          name: '辽宁省',
	          value: 80
	      }],
	      [{
	          name: '泰安市'
	      }, {
	          name: '湖北省',
	          value: 70
	      }],
	      [{
	          name: '泰安市'
	      }, {
	          name: '内蒙古',
	          value: 70
	      }],
	      [{
	          name: '泰安市'
	      }, {
	          name: '江苏省',
	          value: 60
	      }],
	      [{
	          name: '泰安市'
	      }, {
	          name: '新疆维吾尔自治区',
	          value: 70
	      }],
	      [{
	          name: '泰安市'
	      }, {
	          name: '四川省',
	          value: 40
	      }],
	      [{
	          name: '泰安市'
	      }, {
	          name: '云南省',
	          value: 130
	      }],
	      [{
	          name: '泰安市'
	      }, {
	          name: '黑龙江省',
	          value: 130
	      }],
	      [{
	          name: '泰安市'
	      }, {
	          name: '甘肃省',
	          value: 200
	      }],
	      [{
	          name: '泰安市'
	      }, {
	          name: '西藏自治区',
	          value: 60
	      }],
	       
	  ];
	  var planePath = "path://M917.965523 917.331585c0 22.469758-17.891486 40.699957-39.913035 40.699957-22.058388 0-39.913035-18.2302-39.913035-40.699957l-0.075725-0.490164-1.087774 0c-18.945491-157.665903-148.177807-280.296871-306.821991-285.4748-3.412726 0.151449-6.751774 0.562818-10.240225 0.562818-3.450589 0-6.789637-0.410346-10.202363-0.524956-158.606321 5.139044-287.839661 127.806851-306.784128 285.436938l-1.014096 0 0.075725 0.490164c0 22.469758-17.854647 40.699957-39.913035 40.699957s-39.915082-18.2302-39.915082-40.699957l-0.373507-3.789303c0-6.751774 2.026146-12.903891 4.91494-18.531052 21.082154-140.712789 111.075795-258.241552 235.432057-312.784796C288.420387 530.831904 239.989351 444.515003 239.989351 346.604042c0-157.591201 125.33352-285.361213 279.924387-285.361213 154.62873 0 279.960203 127.770012 279.960203 285.361213 0 97.873098-48.391127 184.15316-122.103966 235.545644 124.843356 54.732555 215.099986 172.863023 235.808634 314.211285 2.437515 5.290493 4.01443 10.992355 4.01443 17.181311L917.965523 917.331585zM719.822744 346.679767c0-112.576985-89.544409-203.808826-199.983707-203.808826-110.402459 0-199.944821 91.232864-199.944821 203.808826s89.542362 203.808826 199.944821 203.808826C630.278335 550.488593 719.822744 459.256752 719.822744 346.679767z";
	 
	  //    var  planePath="path://M621.855287 587.643358C708.573965 540.110571 768 442.883654 768 330.666667 768 171.608659 648.609267 42.666667 501.333333 42.666667 354.057399 42.666667 234.666667 171.608659 234.666667 330.666667 234.666667 443.22333 294.453005 540.699038 381.59961 588.07363 125.9882 652.794383 21.333333 855.35859 21.333333 1002.666667L486.175439 1002.666667 1002.666667 1002.666667C1002.666667 815.459407 839.953126 634.458526 621.855287 587.643358Z";

	  var convertData = function(data) {
	      var res = [];
	      for (var i = 0; i < data.length; i++) {
	          var dataItem = data[i];
	          var fromCoord = geoCoordMap[dataItem[1].name];
	          var toCoord = geoCoordMap[dataItem[0].name];
	          if (fromCoord && toCoord) {
	              res.push({
	                  fromName: dataItem[1].name,
	                  toName: dataItem[0].name,
	                  coords: [fromCoord, toCoord]
	              });
	          }
	      }
	      return res;
	  };

	  var color = ['#a6c84c', '#ffa022', '#46bee9'];
	  var mySeries = [];
	  [
	   [myHosName,BJData]
	  ].forEach(function(item, i) {
	      mySeries.push({ //线
	          name: item[0],
	          //                      name: item[0] + ' Top10',
	          type: 'lines',
	          zlevel: 1,
	          effect: {
	              show: true,
	              period: 6,
	              trailLength: 1.2,
	              color: 'gold',
	              symbolSize: 3
	          },
	          lineStyle: {
	              normal: {
	                  color: color[0],
	                  width: 0,
	                  curveness: 0.2
	              }
	          },
	          data: convertData(item[1])
	      }, { //移动 点
	          name: item[0],
	          //                      name: item[0] + ' Top10',
	          type: 'lines',
	          zlevel: 2,
	          effect: {
	              show: true,
	              period: 6,
	              trailLength: 0,
	              symbol: planePath,
	              symbolSize: 15
	          },
	          lineStyle: {
	              normal: {
	                  color: color[1],
	                  width: 1,
	                  opacity: 0.4,
	                  curveness: 0.2
	              }
	          },
	          data: convertData(item[1])
	      }, { //省份圆点
	          name: item[0],
	          //                      name: item[0] + ' Top10',
	          type: 'effectScatter',
	          coordinateSystem: 'geo',
	          zlevel: 2,
	          rippleEffect: {
	              brushType: 'stroke'
	          },
	          label: {
	              normal: {
	                  show: true,
	                  position: 'right',
	                  formatter: '{b}'
	              }
	          },
	          symbolSize: function(val) {
	              return val[2] / 6;
	          },
	          itemStyle: {
	              normal: {
	                  color: function(params) {
	                      var tmp = params.data.value[2]
	                      if (tmp < 100) {
	                          return 'green';
	                      } else if (tmp > 150) {
	                          return 'Orange'
	                      } else
	                          return 'yellow';
	                  }
	              }
	          },
	          
	          data: item[1].map(function(dataItem) {
	              return {
	                  name: dataItem[1].name,
	                  value: geoCoordMap[dataItem[1].name].concat([dataItem[1].value])
	              };
	          })
	      });
	  });

	  option = {
	     
	      title: {
	          text: '国内各省市流入泰安资金情况',	          
	          left: 'center',
	          textStyle: {
	              color: '#fff'
	          },
	          
	      },
	      tooltip: {
	          trigger: 'item',
	          formatter: function(params) {
	              if (params.seriesIndex == 2 || params.seriesIndex == 5 || params.seriesIndex == 8) {
	                  return params.name + '投资' + params.seriesName + ':' + params.data.value[2] + '万元';
	              } else if (params.seriesIndex == 1 || params.seriesIndex == 4 || params.seriesIndex == 7) {
	                  return params.data.fromName + '→' + params.data.toName;
	              }
	          }
	      },
	     
	      geo: {
	          map: 'china',
	          label: {
	              emphasis: {
	                  show: false
	              }
	          },
	          layoutCenter: ['50%', '50%'],
	       // 如果宽高比大于 1 则宽度为 100，如果小于 1 则高度为 100，保证了不超过 100x100 的区域
	       layoutSize: '110%',
	          roam: true,
	          itemStyle: {
	              normal: {
	                  areaColor: 'rgba(173,216,230,2)',
	                  borderColor: '#404a59'
	              },
	              emphasis: {
	                  areaColor: 'blue'
	              }
	          }
	      },
	      series: mySeries
	  };
	       var myChart = echarts.init(document.getElementById('chart1'), 'walden');
	       myChart.setOption(option);
	 

}
 function Chart2() {
    var data=[];
    for(i=0;i<48;i++){
    	data.push( (Math.random()*120).toFixed(2));  
    }
    var option = {
        tooltip: {
            trigger: 'axis', 
        },
        legend:{
        	top:'40',
        	data:['外籍投资','国内投资','省内投资']
        },
        title: {
            text: '近12个月外来投资趋势分析(万元)',	               
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
            top: 30,
            left: 60,
            right: 60
        },

        series: [
           {
               name: '外籍投资',
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
                name: '国内投资',
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
                 name: '省内投资',
                 type: 'line',
                 data: data.slice(24,36)
             },
              
        ]
    };

    var myChart = echarts.init(document.getElementById('chart2'), 'walden');

    myChart.setOption(option);
}
function Chart3() {
	 var data=[];
	    for(i=0;i<10;i++){
	    	data.push( Math.ceil(Math.random()*4000));  
	    	 
	    }
	    var option = {
	        tooltip: {
	            trigger: 'axis', 
	        },
	        
	        title: {
	            text: '2017年度国际外来投资分析',	               
	            left: 'center',
	            textStyle: {
	                color: '#fff'
	            }
	        },
	        legend:{
	        	top:40,
	        	data:['户均投资','外来投资']
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
	            data: ['韩国', '香港', '中国台湾', '加拿大', '俄罗斯', '墨西哥', '美国', '萨摩亚', '白俄罗斯', '日本']
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
	               name: '户均投资',
	               type: 'line',
	               yAxisIndex: 0, 
	               data: data.slice(0,12)
	           },
	             
	           {
	                name: '外来投资',
	                type: 'bar',             
	                data: [13200.12,8298.34,5556.54,4700.00,4400.00,2600.00,1100.00,1000.00,1000.00,532.00],
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

	    var myChart = echarts.init(document.getElementById('chart3'), 'walden');

	    myChart.setOption(option);
}
function Chart4() {
	var data=[] ;
	var data1=[] ;
    for(i=0;i<10;i++){
    	data.push( Math.ceil(Math.random()*4600)); 
    	data1.push( Math.ceil(Math.random()*18000));
    }
    var option = {
        tooltip: {
            trigger: 'axis', 
        },
        
        title: {
            text: '2017年度国内外来投资分析',	               
            left: 'center',
            textStyle: {
                color: '#fff'
            }
        },
        legend:{
        	top:40,
        	data:['户均投资','国内外来']
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
            data: ['山东', '内蒙古', '甘肃', '辽宁', '黑龙江', '安徽 ', '江苏', '河南', '河北']
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
               name: '户均投资',
               type: 'line',
               
               yAxisIndex: 0, 
               data: data.slice(0,12)
           },
             
           {
                name: '国内外来',
                type: 'bar',             
                data: data1,
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

    var myChart = echarts.init(document.getElementById('chart4'), 'walden');

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
 
 