$(function () {

    //点击登陆按钮时进行的判断
    $(".login_bt").on("click", function () {
        if ($("#stuId").val() == "" || $("#pwdtxt").val() == "") {
            $(".Error_prompt").fadeIn(800).html("stuId or password can not be null");
            return false;
        }
       let str =   $("#stuId").val();
        if(checknumber(str)){
            alert("studId only number allowed");
            return false;
        } else {
            $(".Error_prompt").fadeOut(400);
            //前端初步判断数据类型成功以后像后台发出请求来判断登陆是否成功
            $.ajax({
                type: "post",
                url: "signUp",//这里的data.json 是我模拟的一个json文件名。url放的是当前页面请求的后台地址。
                dataType: "json",
                data: $('#ajaxForm').serialize(),
                success: function (data) {

                    var result = data ;
                    alert(result.msg);
                    if(result.code =='SUCCESS'){
                    window.location.href="home/main.html";
                    }
                    // window.location.href="secondHandUpload.html"
                    //用户名和密码校验错误
                    // if (result == "0") {
                    //     $(".Error_prompt").fadeIn(800).html("该用户不存在或密码错误");
                    //     $(".Error_prompt").fadeIn("fast", "linear");
                    // }
                },
                error:function (data ){
                    var erroMessage = data.responseJSON.errors ;
                    var message = "";
                    if(erroMessage!= null && typeof erroMessage != 'undifined'){
                    for(var  i=0 ; i<erroMessage.length ; i++){
                        message += erroMessage[i].defaultMessage + "   "  ;
                    }
                    }
                    alert(message);

                }
            });
        }
    });


    // //用户键盘按下enter键判断的事件
    // document.onkeypress = function (event) {
    //     e = event ? event : (window.event ? window.event : null);
    //     var currKey = 0;
    //     currKey = e.keyCode || e.which || e.charCode;
    //     if (currKey == 13) {
    //         if ($("#usertxt").val() == "" || $("#pwdtxt").val() == "") {
    //             $(".Error_prompt").fadeIn(800).html("员工编号或密码不能为空！");
    //             return false;
    //         } else {
    //             $(".Error_prompt").fadeOut(400);
    //             //前端初步判断数据类型成功以后像后台发出请求来判断登陆是否成功
    //             $.ajax({
    //                 type: "post",
    //                 url: "data.json",//这里的data.json 是我模拟的一个json文件名。url放的是当前页面请求的后台地址。
    //                 dataType: "json",
    //                 data: $('#ajaxFrm').serialize(),
    //                 success: function (data) {
    //                     window.location.href="secondHandShow.html";
    //                 },
    //                 error: function () {
    //                     alert("请求失败！");
    //                 }
    //             });
    //         }
    //     }
    // };



});

//只允许数字
function checknumber(str)
{

    var Letters = "1234567890";
    var i;
    var c;
    for( i = 0; i <str.length ; i ++ )
    {
        c = str.charAt( i );
        if (Letters.indexOf( c ) ==-1)
        {
            return true;
        }
    }
    return false;
}