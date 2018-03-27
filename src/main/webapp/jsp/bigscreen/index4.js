 function Chart3() {

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
                        //backgroundColor: 'rgba(41,64,94,0.4)',
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
                            },

            //                pieces: [
           
            //{ min: 900, max: 1500 },
            //{ min: 310, max: 1000 },
            //{ min: 200, max: 300 },
            //{ min: 10, max: 200, label: '10 到 200（自定义label）' },
            //{ value: 123  },
            //{ min: 0, max: 50  },
           
            //                ],
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
                var myChart = echarts.init(document.getElementById('chart3'), 'walden');
                myChart.setOption(option);
            }, error: function (a, b, c) {
                alert(c);
            }
        })

    }
    function Chart4() {
        option = {

            tooltip: {
                formatter: "{a} <br/>{c} {b}"
            },

            series: [
                {
                    name: '总件数',
                    type: 'gauge',
                    min: 0,
                    max: 100,
                    splitNumber: 5,
                    radius: '70%',
                    axisLine: {            // 坐标轴线
                        lineStyle: {       // 属性lineStyle控制线条样式
                            color: [[0.09, 'lime'], [0.82, '#1e90ff'], [1, '#ff4500']],
                            width: 3,
                            shadowColor: '#fff', //默认透明
                            shadowBlur: 10
                        }
                    },
                    axisLabel: {            // 坐标轴小标记
                        textStyle: {       // 属性lineStyle控制线条样式
                            fontWeight: 'bolder',
                            color: '#fff',
                            shadowColor: '#fff', //默认透明
                            shadowBlur: 10
                        }
                    },
                    axisTick: {            // 坐标轴小标记
                        length: 8,        // 属性length控制线长
                        lineStyle: {       // 属性lineStyle控制线条样式
                            color: 'auto',
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
                    title: {
                        textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                            fontWeight: 'bolder',
                            fontSize: 12,
                            fontStyle: 'italic',
                            color: '#fff',
                            shadowColor: '#fff', //默认透明
                            shadowBlur: 10
                        }
                    },
                    detail: {
                        backgroundColor: 'rgba(30,144,255,0.8)',
                        borderWidth: 1,
                        borderColor: '#fff',
                        shadowColor: '#fff', //默认透明
                        shadowBlur: 1,
                        width: 50,
                        height: 20,
                        offsetCenter: [0, '45%'],       // x, y，单位px
                        textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                            fontWeight: 'bolder',
                            color: '#fff',
                            fontSize: 14
                        }
                    },
                    data: [{ value: 20, name: '总件数' }]
                },
                {
                    name: '重大案件',
                    type: 'gauge',
                    center: ['25%', '55%'],    // 默认全局居中
                    radius: '55%',
                    min: 0,
                    max: 10,
                    endAngle: 45,
                    splitNumber: 4,
                    axisLine: {            // 坐标轴线
                        lineStyle: {       // 属性lineStyle控制线条样式
                            color: [[0.29, 'lime'], [0.86, '#1e90ff'], [1, '#ff4500']],
                            width: 2,
                            shadowColor: '#fff', //默认透明
                            shadowBlur: 10
                        }
                    },
                    axisLabel: {            // 坐标轴小标记
                        textStyle: {       // 属性lineStyle控制线条样式
                            fontWeight: 'bolder',
                            color: '#fff',
                            shadowColor: '#fff', //默认透明
                            shadowBlur: 10
                        }
                    },
                    axisTick: {            // 坐标轴小标记
                        length: 8,        // 属性length控制线长
                        lineStyle: {       // 属性lineStyle控制线条样式
                            color: 'auto',
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
                    pointer: {
                        width: 5,
                        shadowColor: '#fff', //默认透明
                        shadowBlur: 5
                    },
                    title: {
                        offsetCenter: [0, '45%'],       // x, y，单位px
                        textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                            fontWeight: 'bolder',

                            color: '#fff',
                            shadowColor: '#fff', //默认透明
                            shadowBlur: 10,
                            fontSize: 13
                        }
                    },
                    detail: {
                        show: false
                    },
                    data: [{ value: 5, name: '重大案件' }]
                },
                {
                    name: '一般案件',
                    type: 'gauge',
                    center: ['75%', '55%'],    // 默认全局居中
                    radius: '55%',
                    min: 0,
                    max: 20,
                    startAngle: 135,
                    endAngle: 15,
                    splitNumber: 4,
                    axisLine: {            // 坐标轴线
                        lineStyle: {       // 属性lineStyle控制线条样式
                            color: [[0.2, 'lime'], [0.8, '#1e90ff'], [1, '#ff4500']],
                            width: 2,
                            shadowColor: '#fff', //默认透明
                            shadowBlur: 10
                        }
                    },
                    axisTick: {            // 坐标轴小标记
                        length: 8,        // 属性length控制线长
                        lineStyle: {       // 属性lineStyle控制线条样式
                            color: 'auto',
                            shadowColor: '#fff', //默认透明
                            shadowBlur: 10
                        }
                    },
                    axisLabel: {
                        textStyle: {       // 属性lineStyle控制线条样式
                            fontWeight: 'bolder',
                            color: '#fff',
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
                    pointer: {
                        width: 2,
                        shadowColor: '#fff', //默认透明
                        shadowBlur: 5
                    },
                    title: {
                        show: true,
                        offsetCenter: [0, '45%'],// x, y，单位px
                        textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                            fontWeight: 'bolder',

                            color: '#fff',
                            shadowColor: '#fff', //默认透明
                            shadowBlur: 10,
                            fontSize: 13
                        }
                    },
                    detail: {
                        show: false
                    },
                    data: [{ value: 15, name: '一般案件' }]
                }
            ]
        };




        var myChart = echarts.init(document.getElementById('chart4'), 'walden');

        myChart.setOption(option);

    }
    function Chart5() {

        option = {

            tooltip: {
                trigger: 'axis',


            }, grid: {

                left: 10
            },
            yAxis: {
                type: 'category',

                splitLine: { show: false },
                data: ['检查中隐瞒真实情况', '经营假冒伪劣商品', '无烟草专卖零售许可证', '假冒注册商标', '虚假的旅游信息和广告宣传', '销售者未执行相关制度', '纳税人不办理税务登记', '不配合工商的管理工作'],
                axisLabel: {
                    show: true,

                    interval: 0
                }
            },
            grid: {
                top: 10,
                bottom: 10,
                left: 160,
                right: 40
            },
            xAxis: {
                type: 'value',
                splitLine: { show: true },
                axisLabel: {
                    show: false
                }
            },
            series: [
                {
                    name: '2017',
                    type: 'bar',
                    barWidth: 8,//固定柱子宽度
                    label: {
                        normal: {
                            show: true,
                            position: 'right',

                        }
                    },
                    data: [20, 50, 100, 200, 300, 300, 400, 410]
                    , itemStyle: {
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
                }, {
                    name: '2016',
                    type: 'bar',
                    barWidth: 8,//固定柱子宽度
                    label: {
                        normal: {
                            show: true,
                            position: 'right',

                        }
                    },
                    data: [1100, 800, 1040, 1200, 1300, 1700, 1500, 1100]
                    , itemStyle: {
                        normal: {
                            color:
                                new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(153,0,0,1)'
                                }, {
                                    offset: 1,
                                    color: 'rgba( 250,59,24,0.4)'
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

        option = {

            tooltip: {
                trigger: 'axis',


            },
            yAxis: {
                type: 'category',

                splitLine: { show: false },
                data: ['中标人不履行合同的', '作虚假宣传，欺骗消费者的', '不正当价格行为的', '盗用、冒用他人名义订立合同', '将验收不合格的房屋交付使用的', '直销企业违反保证金规定的', '违反法律、法规的规定牟取暴利的', '通过贿赂等手段取得经营许可的'],
                axisLabel: {
                    show: true,

                    interval: 0
                }
            },
            grid: {
                top: 3,
                bottom: 15,
                left: 160,
                right: 40
            },
            xAxis: {
                type: 'value',
                splitLine: { show: true },
                axisLabel: {
                    show: false
                }
            },
            series: [
                {
                    name: '2017',
                    type: 'bar',
                    barWidth: 8,//固定柱子宽度
                    label: {
                        normal: {
                            show: true,
                            position: 'right',

                        }
                    },
                    data: [20, 50, 100, 200, 300, 300, 400, 410]
                    , itemStyle: {
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
                }, {
                    name: '2016',
                    type: 'bar',
                    barWidth: 8,//固定柱子宽度
                    label: {
                        normal: {
                            show: true,
                            position: 'right',

                        }
                    },
                    data: [1000, 800, 1000, 1200, 1300, 1100, 1200, 1100]
                    , itemStyle: {
                        normal: {
                            color:
                                new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(153,0,0,1)'
                                }, {
                                    offset: 1,
                                    color: 'rgba( 250,59,24,0.4)'
                                }])
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
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data: ['简易案件', '一般案件', '重大案件']
            },

            calculable: false,
            series: [
                {
                    name: '件数',
                    type: 'pie',
                    selectedMode: 'single',
                    radius: [0, 40],

                    // for funnel
                    x: '20%',
                    width: '40%',
                    funnelAlign: 'right',
                    max: 1548,

                    itemStyle: {
                        normal: {
                            label: {
                                position: 'inner'
                            },
                            labelLine: {
                                show: false
                            }
                        }
                    },
                    data: [
                        { value: 335, name: '简易案件' },
                        { value: 679, name: '一般案件' },
                        { value: 1548, name: '重大案件'}
                    ]
                },
                {
                    name: '案值',
                    type: 'pie',
                    radius: [60, 80],

                    // for funnel
                    x: '60%',
                    width: '35%',
                    funnelAlign: 'left',
                    max: 1048,

                    data: [
                        { value: 335, name: '简易案件' },
                        { value: 310, name: '一般案件' },
                        { value: 234, name: '重大案件' },

                    ]
                }
            ]
        };

        var myChart = echarts.init(document.getElementById('chart7'), 'walden');

        myChart.setOption(option);
    }
    function Chart8() {



        option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data: ['直达', '营销广告', '搜索引擎', '邮件营销', '联盟广告', '视频广告', '百度', '谷歌', '必应', '其他']
            },
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    selectedMode: 'single',
                    radius: [0, '30%'],

                    label: {
                        normal: {
                            position: 'inner'
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data: [
                        { value: 335, name: '直达', selected: true },
                        { value: 679, name: '营销广告' },
                        { value: 1548, name: '搜索引擎' }
                    ]
                },
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: ['40%', '55%'],

                    data: [
                        { value: 335, name: '直达' },
                        { value: 310, name: '邮件营销' },
                        { value: 234, name: '联盟广告' },
                        { value: 135, name: '视频广告' },
                        { value: 1048, name: '百度' },
                        { value: 251, name: '谷歌' },
                        { value: 147, name: '必应' },
                        { value: 102, name: '其他' }
                    ]
                }
            ]
        };


        var myChart = echarts.init(document.getElementById('chart8'), 'walden');

        myChart.setOption(option);
    }
    function Chart9() {

        var option = {
            tooltip: {
                trigger: 'axis',


            },
            xAxis: {
                type: 'category',
                boundaryGap: true,
                splitLine: { show: true },
                data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月']
            },
            yAxis: [{
                type: 'value',
                splitLine: { show: false },

                boundaryGap: [0, '100%'],
                axisLabel: {
                    formatter: '{value} 件'
                }

            }, {
                type: 'value',
                axisLine: { show: false },
                axisTick: { show: false },

                splitArea: { show: false },
                splitLine: { show: false },
                axisLabel: {
                    formatter: '{value} 万元'
                }
            }],
            grid: {
                top: 10,
                left: 60,
                right: 60
            },

            series: [
               {
                   name: '重大案件',
                   type: 'line',
                   yAxisIndex: 1,
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
                   data: [120, 132, 101, 134, 90, 230, 210]
               },
                {
                    name: '全部案件',
                    type: 'line',
                    yAxisIndex: 1,
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
                    data: [220, 182, 191, 234, 290, 330, 310]
                },
                 {
                     name: '全部案件',
                     type: 'line',
                     data: [1119, 1108, 1900, 1100, 1888, 1787, 1999]
                 },
                 {
                     name: '重大案件',
                     type: 'line',
                     data: [115, 107, 1098, 600, 558, 1404, 905]
                 }
            ]
        };

        var myChart = echarts.init(document.getElementById('chart9'), 'walden');

        myChart.setOption(option);
    }
    function Chart10() {


        option = {
            title: {
                text: '结案率',
                top: '75%',
                textStyle: {
                    fontSize: '12px'
                }, left: '38%'
            },
            tooltip: {
                formatter: "{a} <br/>{b} : {c}%"
            },

            series: [
                {
                    name: '结案率',
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
        var myChart = echarts.init(document.getElementById('chart10'), 'walden');

        myChart.setOption(option);
    }
    function Chart11() {


        option = {
            title: {
                text: '超期结案率',
                top: '75%',
                textStyle: {
                    fontSize: '12px'
                }, left: '30%'
            },
            tooltip: {
                formatter: "{a} <br/>{b} : {c}%"
            },

            series: [
                {
                    name: '超期结案率',
                    type: 'gauge',
                    detail: { formatter: '{value}%' },
                    data: [{ value: 13 }],
                    axisLine: {            // 坐标轴线
                        lineStyle: {       // 属性lineStyle控制线条样式
                            color: [[0.09, '#F82A15'], [0.82, '#F82A15'], [1, '#F82A15']],
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
        var myChart = echarts.init(document.getElementById('chart11'), 'walden');

        myChart.setOption(option);
    }