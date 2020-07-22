function transfer(url, data){
    var result=new Array();
    $.ajax({
        type:"POST",
        url:url,
        dataType:"json",
        async:false,
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify(data),
        success:function (dataReturn) {
            var temp=JSON.stringify(dataReturn);
            var dataObj = JSON.parse(temp);
            result[0]=dataObj.status;
            result[1]=dataObj.object;
        }
    });
    return result;
}

function addObject(url,data) {
    var result=transfer(url,data);
    if(result[0]==200){
        popInformation("添加成功");
    }
    else {
        popInformation("添加失败");
    }
}

function updateObject(url,data) {
    var result=transfer(url,data);
    if(result[0]==200){
        popInformation("更新成功");
    }
    else {
        popInformation("更新失败");
    }
}

function deleteObject(url,data) {
    var result=transfer(url,data);
    if(result[0]==200){
        popInformation("删除成功");
    }
    else {
        popInformation("删除失败");
    }
}

function popInformation(info) {
    //弹窗显示操作信息
    $.messager.alert('结果', info,
        'info', function() {
            window.location
                .reload();
        });
}