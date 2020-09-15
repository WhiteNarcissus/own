$(function () {
    var stuIded = "";
    selectList();



});

function selectList(){
    //初始化Vue 对象
    var vm = new Vue({
        el:'#secondHandView',
        data:{
            list:"" ,
        }
    });

    $.ajax({
        url:'/secondhand/list',
        type:'post',
        async : false, //默认为true 异步
        dataType:'json',
        success:function(result){
            debugger
            vm.list = result.rows;
        },
        error:function(result){
            alert('error');
        }
    });
}

function safetostring(str) {
    return String(str).replace(/&amp;/g, '&').replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&#39;/g, "'");
}

setTimeout(function () {
    var cw = $('.list-img').width();
    $('.list-img').css({'height': cw + 'px'});
}, 0);

$(window).resize(function () {
    var cw = $('.list-img').width();
    $('.list-img').css({'height': cw + 'px'});
});


//关闭操作栏
function hideActionSheet(weuiActionsheet, mask) {
    weuiActionsheet.removeClass('weui_actionsheet_toggle');
    mask.removeClass('weui_fade_toggle');
    weuiActionsheet.on('transitionend', function () {
        mask.hide();
    }).on('webkitTransitionEnd', function () {
        mask.hide();
    })
}
//显示操作栏
function showActionSheet(num) {
    //点击评论时弹出此框同时将 要评论对象的学号传
    stuIded = num;
    var mask = $('#mask');
    var weuiActionsheet = $('#weui_actionsheet');
    weuiActionsheet.addClass('weui_actionsheet_toggle');
    mask.show().addClass('weui_fade_toggle').click(function () {
        hideActionSheet(weuiActionsheet, mask);
    });
    $('#actionsheet_cancel').click(function () {
        hideActionSheet(weuiActionsheet, mask);
    });
    weuiActionsheet.unbind('transitionend').unbind('webkitTransitionEnd');
}

//我想要
function Iwant() {
    var mask = $('#mask');
    var weuiActionsheet = $('#weui_actionsheet');
    hideActionSheet(weuiActionsheet, mask);
    document.getElementById('reviewers'+stuIded).style.display='block';
}

//点赞
function admire(str) {
    $.ajax({
        url: '/secondhand/admire',
        type: 'POST',
        data: {stuIded:stuIded},
        dataType: 'json',     // 以json的形式接收返回的数据
        success: function (data) {
            window.location.reload();
        }
    });

}



//提交留言
function wantMessage() {
        var id= 'message'+stuIded ;
        var message = $("#"+id).val();
    debugger
    $.ajax({
        url: '/secondhand/want',
        type: 'POST',
        data: {message:message,stuIded:stuIded},
        dataType: 'json',     // 以json的形式接收返回的数据
        success: function (data) {
            alert(data.msg);
            window.location.reload();
        }
    });
}

