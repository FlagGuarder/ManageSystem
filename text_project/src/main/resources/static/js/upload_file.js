function resetForm() {
    $("dataForm").form("clear");
}

function submitFile() {
    var formData = new FormData();
    formData.append("file",$('#file')[0].files[0]);
    formData.append("customName", $.trim($('#customName').val()));
    $.ajax({
        url:'/text_project/uploadFile/upload',
        dataType:'json',
        type:'POST',
        async: false,
        data: formData,
        processData : false, // 使数据不做处理
        contentType : false, // 不要设置Content-Type请求头
        success: function(data){
            var temp=JSON.stringify(data);
            var dataObj = JSON.parse(temp);
            if(dataObj.status==200){
                alert("上传成功");
                window.location.reload();
            }
            else {
                alert("上传失败");
            }
        },
        error:function(response){
            alert("上传失败");
        }
    });
}