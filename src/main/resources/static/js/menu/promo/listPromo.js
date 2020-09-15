$(function () {

    //1.初始化Table
    let oTable = new TableInit();
    oTable.Init();

});





var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_promo').bootstrapTable({
            url: '/promo/list',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'title',
                title: '知识分享标题'
            }, {
                field: 'stuId',
                title: '学号'
            }, {
                field: 'createTime',
                title: '创建时间',
                formatter: function (value, row, index) {
                    return changeDateFormat(value)
                }
            },{
                title: "操作",
                align: 'center',
                valign: 'middle',
                width: 160, // 定义列的宽度，单位为像素px
                formatter: function (value, row, index) {
                    return '<a class="cut"> <button class="btn btn-primary btn-sm"  onclick="del(\''+row.id+'#'+row.stuId+'\')">删除</button> </a>'
                            + '<button class="btn btn-primary btn-sm" onclick="see(\'' +row.title+'#'+ row.content + '\')">查看</button> '

                  }
            } ]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            stuId: $("#txt_search_stuId").val(),
            title: $("#txt_search_title").val()
        };
        return temp;
    };

    return oTableInit;
};



//查看公告详情
function see(msg) {

    var text = msg.split("#");

    $("#modal_text").html(text[1]);

    $("#modal_title").html(text[0]);
    $('#myModal').modal('show')

};

// 点击查询按钮
function query() {

    $('#tb_promo').bootstrapTable('refresh');
    console.info(params);

}

//点击新增
function goEdit(){
    window.location.href="editPromo.html"
}

//删除
function del(msg) {
    var text = msg.split("#");
    var id = '';
    var stuId='';
    if(text!=null && text !='' ){
         id = text[0];
         stuId = text[1];
    }
    $.ajax({
        url: '/promo/delete',
        type: 'POST',
        data: {id:id,stuId:stuId},
        dataType: 'json',     // 以json的形式接收返回的数据
        success: function (data) {
            alert(data.msg);
            window.location.reload();
        }
    });
}



//列表时间 格式转换
function changeDateFormat(cellval) {
    if (cellval != null) {
        var date = new Date(parseInt(cellval));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

        var hh24 = date.getHours();
        var mi = date.getMinutes();
        var ss = date.getSeconds();

        return date.getFullYear() + "-" + month + "-" + currentDate+" "+ hh24 +":"+mi+":"+ss;
    }
}