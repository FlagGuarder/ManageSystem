function resetForm() {
    $("#form").form("clear");
}

function submitData() {
    if($("#password").val()!=$("#confirmPassword").val()){
        alert("两次密码不一致，请重新输入");
        return;
    }
    /*if(!$("#userName").empty() || !$("#number").empty() || !$("#password").empty() || !$("#confirmPassword").empty())
    {
        alert("数据为空。");
        return;
    }*/

    var data={};
    data['password']=$("#password").val();
    data['userName']=$("#userName").val();
    data['number']=$("#number").val();
    data['classInfo']=$("#classInfo").val();
    addObject("/text_project/addStudent/add",data);
}