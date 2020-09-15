$(function () {
    //随着页面加载 做权限控制
    judgeAuthority();

    function judgeAuthority() {
        $.ajax({
            type: "post",
            url: "/queryAuth",
            contentType: 'application/json;charset=utf-8',
            success: function (data) {

                if(data.rows.indexOf("/edit")>0){
                    document.getElementById('knowledgeSubmit').style.display='block';
                    document.getElementById('knowledgeReset').style.display='block';
                }
            }
        })
    }


    let summer = $('.summernote');
    summer.summernote({
        // 重写图片上传方法
        callbacks: {
            onImageUpload: function (files,editor,$editable) {
                sendFile(files,editor,$editable);
            }
        }
    });

    /** * 发送图片文件给服务器端 */
    function sendFile(files,editor,$editable) {
        alert("add image");
        //防止图片拖拽引发二次上传 导致错误提示
        var filename = false ;
        try {
            filename = file['name'];
        }catch(e){

            filename = false ;
        }
        if(!filename){
            $(".note-alarm").remove();

        }


        let imageData = new FormData();
        imageData.append("imageData", files[0]);
        imageData.append("key",filename);





        $.ajax({
            url: '/uploads', // 图片上传url
            type: 'POST',
            data: imageData,
            cache: false,
            contentType: false,
            processData: false,
            dataType: 'json',     // 以json的形式接收返回的数据
            // 图片上传成功
            success: function (data) {
                alert("图片上传成功");
                var result = data;

                summer.summernote('insertImage', result.msg);
            },
            // 图片上传失败
            error: function () {
                console.log('图片上传失败');
            }
        });
    }


        $("#knowledgeSubmit").click(function knowledgeSave() {

            var title = $("#title").val();
            var content = $('.summernote').summernote('code');


            var tips = "";
            if(title == ''){
                tips="标题不能为空  " +tips;
            }
            if(content == ''){
                tips="内容不能为空  " +tips;
            }

            if(tips ==''){
            $.ajax({
                url: '/knowledge/save', // 图片上传url
                type: 'POST',
                data: {title: title, content: content},
                dataType: 'json',     // 以json的形式接收返回的数据
                success: function (data) {
                    alert("保存成功");
                    window.location.href = "knowledgeList.html"
                }
            })
            }else {
                alert(tips);
            }

        });





});