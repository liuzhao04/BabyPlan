$(document).ready(function () {
    var maxVolume = 300; // 一次最大摄入牛奶量
    var minVolume = 10; // 一次最小摄入牛奶量
    var stepVolume = 30; // 按钮控制+/-的增量值
    // part 1: load controller function
    $("#addVolume").val("+ " + stepVolume + "ml");
    $("#minusVolume").val("- " + stepVolume + "ml");
    $("#volume").attr("max", maxVolume);
    $("#volume").attr("min", minVolume);

    // 时间选择框初始化
    var initTimeSelect = function () {
        laydate.render({
            elem: "#feedTime",
            type: "datetime",
            format: "yyyy-MM-dd HH:mm",
            min: -1,
            max: new Date().getMilliseconds(),
            value: new Date()
        })
    };
    initTimeSelect();

    $("#addVolume").click(function () {
        var val = $("#volume").val();
        if ("" == val) {
            val = 0;
        }
        val = parseInt(val);
        var step = val % stepVolume == 0 ? stepVolume : stepVolume - (val % stepVolume);

        if (val < maxVolume) {
            val += step;
        } else {
            val = maxVolume;
        }
        $("#volume").val(val);
    });
    $("#minusVolume").click(function () {
        var val = $("#volume").val();
        if ("" == val) {
            val = minVolume;
        }
        val = parseInt(val);
        var step = val % stepVolume == 0 ? stepVolume : val % stepVolume;
        if (val > stepVolume) {
            val -= step;
        } else {
            val = minVolume;
        }
        $("#volume").val(val);
    });

    var clearFeedForm = function () {
        initTimeSelect();
        $("#form_feed #volume").val("");
        $("#form_feed #choice label").removeClass("active");
        $("#form_feed #choice label:eq(0)").addClass("active")
    };

    $("#form_feed").submit(function (e) {
        var jsonObject = $(this).serializeObject();
        $.ajax({
            url: "/bplan/insert",
            contentType: "application/json;charset=utf-8",
            type: 'POST',
            data: JSON.stringify(jsonObject),
            dataType: "json",
            success: function (response) {
                if (response.success) {
                    alert("新增成功!");
                    clearFeedForm();
                    $("#bplanTable").bootstrapTable('refresh');
                    $('#tabs-332789 ul.nav.nav-tabs li a:last').tab("show")
                } else {
                    alert(response.message);
                }
            },
            error: function () {
                alert("网络异常");
            }
        })
        return false;
    });

    $("#bplanTable").bootstrapTable('destroy').bootstrapTable({
        method: 'post',
        url: '/bplan/list',
        queryParams: function (params) {
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                pageSize: params.limit,                         //页面大小
                pageIndex: (params.offset / params.limit) + 1,   //页码
                // sort: params.sort,      //排序列名
                // sortOrder: params.order //排位命令（desc，asc）
            };
            return JSON.stringify(temp);
        },
        contentType: 'application/json;charset=utf-8',
        striped: true,
        undefinedText: '',
        showColumns: !0,
        // toolbar: "#bplanToolbar",
        pagination: true,
        sidePagination: 'server',
        iconSize: "outline",
        icons: {
            columns: "glyphicon-list",
        },
        clickToSelect: false,
        pageSize: 10,
        pageList: [10, 25, 50, 100, 200],
        uniqueId: 'id',
        // data : 'dataList',
        columns: [
            {field: 'id', title: 'ID', visible: false, width: '100px'},
            {field: 'feedTime', title: '喂奶时间', width: '120px'},
            {field: 'volume', title: '摄入量(毫升)', width: '120px'},
            {
                field: 'nutrition', title: '辅助营养', width: '100px', formatter: function (val,row,index) {
                    if(undefined == val || "" == val){
                        return "-";
                    }
                    if(val == "no"){
                        return "无"
                    }else if(val == "dha") {
                        return "DHA";
                    }else if(val == "vd3") {
                        return "维生素D3"
                    }else {
                        return "-";
                    }
                }
            },
            {field: 'createTime', title: '创建时间', width: '120px'},
            {field: 'updateTime', title: '更新时间', width: '120px'},
            {field: 'operating', title: '操作', width: '200px'}
        ]
    });

    // function operateFormatter(value, row, index) {
    //     var r1 = $("#r1").val();
    //     var r2 = $("#r2").val();
    //     var r3 = $("#r3").val();
    //     var r4 = $("#r4").val();
    //     var r5 = $("#r5").val();
    //     var op = "";
    //     //console.log(row.dealFlag);
    //     //处理标记（0-未预审、1-预审不通过、2-上报审核中、3-上报审核不通过、4-提交上报、5-上报成功、6-上报失败）
    //     if (row.czlx != 3 && (row.dealFlag == 0 || row.dealFlag == 1 || row.dealFlag == 3 || row.dealFlag == 5 || row.dealFlag == 6)) {
    //         if (r1 == 1) {
    //             op += "<a data-toggle='modal' data-target='#myModaledit' onclick=\"beforeUpdate('" + row.jyzId + "');\" title='修改' class='m-r'><i class='fa fa-edit fa-lg'></i></a>";
    //         }
    //         if (r2 == 1) {
    //             op += "<a class='m-r demo4' onclick=\"deleteFun('" + row.jyzId + "');\"  title='删除'><i class='fa fa-close fa-lg'></i></a>";
    //         }
    //     }
    //     if (row.dealFlag == 0 || row.dealFlag == 6) {
    //         if (r3 == 1) {
    //             op += "<a class='m-r demo2 ' onclick=\"preValid('" + row.jyzId + "');\"  title='预审' class='m-r'><i class='fa fa-legal fa-lg'></i></a>";
    //         }
    //         if (r4 == 1) {
    //             op += "<a class='m-r demo2 ' onclick=\"cascadeValid('" + row.jyzId + "');\" title='级联预审' ><i class='fa fa-eye fa-lg'></i></a>";
    //         }
    //     }
    //     if (row.dealFlag == 2) {
    //         if (r5 == 1) {
    //             op += "<a class='m-r demo2 ' onclick=\"revokeValid('" + row.jyzId + "');\" title='撤销预审' class='m-r'><i class='fa fa-backward fa-lg'></i></a>";
    //         }
    //     }
    //     op += "<a class='m-r demo2 ' onclick=\"refreshFun('" + row.jyzId + "');\"  title='刷新' class='m-r'><i class='fa fa-refresh fa-lg'></i></a>";
    //     return op;
    //     /*return  "<a data-toggle='modal' data-target='#myModaledit' onclick=\"beforeUpdate('"+row.jyzId+"');\" title='修改' class='m-r'><i class='fa fa-edit fa-lg'></i></a>" +
    //         "<a  class='m-r demo4' title='删除'><i class='fa fa-close fa-lg'></i></a>" +
    //         "<a class='m-r demo2 'title='预审' class='m-r'><i class='fa fa-legal fa-lg'></i></a>" +
    //         "<a href='#' title='级联预审' class='m-r'><i class='fa fa-file-text-o fa-lg'></i></a>" ;*/
    // }
});