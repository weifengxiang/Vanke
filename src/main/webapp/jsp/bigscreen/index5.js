 function Chart1() {

        $.ajax({
            url: '../../skin/echarts/data/qingdao.json',
            type: 'get',
            dataType: 'json',
            success: function (qingdaoData) {
                echarts.registerMap('qingdao', qingdaoData);


                option = {

                    baseOption: {
                        timeline: {
                            data: [

                                 '2014', '2015', '2016', '2017'
                            ],
                            label: {
                                formatter: function (s) {
                                    return (new Date(s)).getFullYear();
                                }
                            },
                            autoPlay: true,
                            playInterval: 5000,
                            bottom: 0,
                            //top:100
                        },
                        tooltip: {
                            trigger: 'item',
                            show: true,
                            formatter: function (params) {
                                return params.name + ' : ' + params.value;
                            }
                        },
                        backgroundColor: 'rgba(41,64,94,0.4)',
                        x: '200px',
                        visualMap: {
                            min: 0,
                            max: 1000,
                            calculable: true,
                            bottom: 50,
                            type: 'piecewise',
                            inRange: {

                                //color: ['#E0022B', '#E09107', '#A3E00B']
                                color: ['lightskyblue', 'yellow', 'orangered']
                            },
                            textStyle: {
                                color: '#fff'
                            }
                        }, series: [
                                    {
                                        name: '案件数量',
                                        type: 'map',
                                        mapType: 'qingdao',

                                        symbolSize: 12,
                                        label: {
                                            normal: {
                                                show: true
                                            },
                                            emphasis: {
                                                show: true
                                            }
                                        },
                                        itemStyle: {
                                            emphasis: {
                                                borderColor: '#fff',
                                                borderWidth: 1
                                            }
                                        },
                                        left: 100,
                                        top: 0,
                                        bottom: 50

                                    }
                        ]

                    },
                    options: [
                            {
                                series: [
                                    {

                                        data: [
                                               { name: '城阳区', value: Math.round(Math.random() * 1000) },
                            { name: '黄岛区', value: Math.round(Math.random() * 1000) },
                            { name: '即墨市', value: Math.round(Math.random() * 1000) },
                            { name: '胶南市', value: Math.round(Math.random() * 100) },
                            { name: '平度市', value: Math.round(Math.random() * 100) },
                            { name: '胶州市', value: Math.round(Math.random() * 100) },
                            { name: '崂山区', value: Math.round(Math.random() * 100) },
                            { name: '李沧区', value: Math.round(Math.random() * 100) },
                            { name: '四方区', value: Math.round(Math.random() * 100) },
                            { name: '市北区', value: Math.round(Math.random() * 100) },
                            { name: '市南区', value: Math.round(Math.random() * 100) },
                            { name: '莱西市', value: Math.round(Math.random() * 100) }
                                        ]

                                    }
                                ]
                            },
                              {

                                  series: [
                                      {

                                          data: [
                                                 { name: '城阳区', value: Math.round(Math.random() * 1000) },
                              { name: '黄岛区', value: Math.round(Math.random() * 100) },
                              { name: '即墨市', value: Math.round(Math.random() * 1000) },
                              { name: '胶南市', value: Math.round(Math.random() * 100) },
                              { name: '平度市', value: Math.round(Math.random() * 1000) },
                              { name: '胶州市', value: Math.round(Math.random() * 100) },
                              { name: '崂山区', value: Math.round(Math.random() * 100) },
                              { name: '李沧区', value: Math.round(Math.random() * 100) },
                              { name: '四方区', value: Math.round(Math.random() * 100) },
                              { name: '市北区', value: Math.round(Math.random() * 100) },
                              { name: '市南区', value: Math.round(Math.random() * 100) },
                              { name: '莱西市', value: Math.round(Math.random() * 100) }
                                          ]

                                      }
                                  ]
                              },
                                  {

                                      series: [
                                          {

                                              data: [
                                                     { name: '城阳区', value: Math.round(Math.random() * 1000) },
                                  { name: '黄岛区', value: Math.round(Math.random() * 100) },
                                  { name: '即墨市', value: Math.round(Math.random() * 100) },
                                  { name: '胶南市', value: Math.round(Math.random() * 1000) },
                                  { name: '平度市', value: Math.round(Math.random() * 1000) },
                                  { name: '胶州市', value: Math.round(Math.random() * 100) },
                                  { name: '崂山区', value: Math.round(Math.random() * 100) },
                                  { name: '李沧区', value: Math.round(Math.random() * 100) },
                                  { name: '四方区', value: Math.round(Math.random() * 100) },
                                  { name: '市北区', value: Math.round(Math.random() * 100) },
                                  { name: '市南区', value: Math.round(Math.random() * 100) },
                                  { name: '莱西市', value: Math.round(Math.random() * 100) }
                                              ]

                                          }
                                      ]
                                  },
                                      {

                                          series: [
                                              {

                                                  data: [
                                                         { name: '城阳区', value: Math.round(Math.random() * 1000) },
                                      { name: '黄岛区', value: Math.round(Math.random() * 1000) },
                                      { name: '即墨市', value: Math.round(Math.random() * 1000) },
                                      { name: '胶南市', value: Math.round(Math.random() * 100) },
                                      { name: '平度市', value: Math.round(Math.random() * 100) },
                                      { name: '胶州市', value: Math.round(Math.random() * 100) },
                                      { name: '崂山区', value: Math.round(Math.random() * 100) },
                                      { name: '李沧区', value: Math.round(Math.random() * 100) },
                                      { name: '四方区', value: Math.round(Math.random() * 100) },
                                      { name: '市北区', value: Math.round(Math.random() * 100) },
                                      { name: '市南区', value: Math.round(Math.random() * 100) },
                                      { name: '莱西市', value: Math.round(Math.random() * 100) }
                                                  ]

                                              }
                                          ]
                                      },

                    ],

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
                text: '各区市被诉主体千分比排名'
                ,
                textStyle: {
                    fontSize: '14px'
                },
                left: '10%',
                top: 20
            },

            tooltip: {
                show: true,
                //   formatter: ' {b}被诉百分比{c}%,数量{c}',
                formatter: function (params, ticket, callback) {

                    return params.name + '被诉百分比' + params.value + '‰，数量' + params.value * 100;
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
                    data: ['市南区', '市北区', '黄岛区', '崂山区', '李沧区', '城阳区', '保税区', '高新区', '胶州市', '即墨市', '平度市'],
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
                    data: [0.04, 0.05, 0.08, 0.1, 0.26, 0.28, 0.35, 0.4, 0.6, 0.7, 0.8],
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
                text: '处理办结率', top: 20, textStyle: {
                    fontSize: '14px'
                }, left: '22%'
            },
            tooltip: {
                formatter: "{a} <br/>{b} : {c}%"
            },
            backgroundColor: 'rgba(41,64,94,0.4)'
            ,
            series: [
                {
                    name: '处理办结率',
                    type: 'gauge',
                    detail: { formatter: '{value}%' },
                    data: [{ value: 70 }],
                    axisLine: {            // 坐标轴线
                        lineStyle: {       // 属性lineStyle控制线条样式
                            color: [[0.09, 'lime'], [0.82, '#1e90ff'], [1, '#ff4500']],
                            width: 3,
                            shadowColor: '#fff', //默认透明
                            shadowBlur: 10
                        }
                    },


                    splitLine: {           // 分隔线
                        length: 10,         // 属性length控制线长
                        lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                            width: 3,
                            color: '#fff',
                            shadowColor: '#fff', //默认透明
                            shadowBlur: 10
                        }
                    },
                    pointer: {           // 分隔线
                        shadowColor: '#fff', //默认透明
                        shadowBlur: 5
                    },

                    detail: {
                        //backgroundColor: 'rgba(30,144,255,0.8)',
                        //borderWidth: 1,
                        //borderColor: '#fff',
                        //shadowColor: '#fff', //默认透明
                        //shadowBlur: 5,
                        //offsetCenter: [0, '50%'],       // x, y，单位px
                        textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE


                            fontSize: 16
                        }
                    }
                }
            ]
        };
        var myChart = echarts.init(document.getElementById('chart3'), 'walden');

        myChart.setOption(option);
    }
    function Chart4() {






        option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            title: {
                text: '群众满意率',
                top: 20,
                textStyle: {
                    fontSize: '14px'
                },
                left: '25%'
            }, backgroundColor: 'rgba(41,64,94,0.4)'
            ,
            color: ['#06F8FF', '#34BA72', '#FF0000'],
            series: [
                {
                    name: '群众满意率',
                    type: 'pie',
                    radius: ['40%', '80%'],
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: true,
                            position: 'inside',
                            //textStyle: {
                            //    fontSize: '14',
                            //    fontWeight: 'bold'
                            //}
                        }

                    },
                    labelLine: {
                        normal: {
                            show: true
                        }
                    },
                    data: [
                        { value: 335, name: '满意' },
                          { value: 310, name: '一般' },
                        { value: 310, name: '不满意' }
                    ]
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

    function chart9() {
        var base = +new Date(2016, 12, 0);
        var oneDay = 24 * 3600 * 1000;
        var date = [];

        var data = [Math.random() * 300];

        for (var i = 1; i < 366; i++) {
            var now = new Date(base += oneDay);
            date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'));
            data.push(parseInt( Math.abs(Math.round((Math.random() - 0.5) * 20) + data[i - 1])));
        }

        option = {
            title: {
                text: '被诉主体增减趋势',
                //textAlign: 'center'

                top: 5,
                textStyle: {
                    fontSize: '12px'
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

        myChart.setOption(option);
    }