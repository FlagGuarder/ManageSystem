function resetForm() {
    $("dataForm").form("clear");
}

function submitJob() {
    var data={};
    data['name']=$("#name").val();
    data['remark']=$("#remark").val();
    console.log(data['name']);
    console.log(data['remark']);
    addObject("/text_project/addJob/add",data);
}