function resetForm() {
    $("dataForm").form("clear");
}

function submitDepart() {
    var data={};
    data['name']=$("#deptName").val();
    data['remark']=$("#remark").val();
    addObject("/text_project/addDepart/add",data);
}