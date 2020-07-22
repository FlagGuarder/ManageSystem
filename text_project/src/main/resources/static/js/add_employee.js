function init() {
    //初始化页面数据
    initEducation();
    initParty();
    initDept();
    initJob();
}

function initJob() {
    //初始化工作
    var data={};
    var result=transfer("/text_project/addEmployee/initJob",data);
    if(result[0]==200){
        $("#job").combobox({
            valueField: 'id',
            textField: 'name',
            data: result[1]
        })
    }
}

function initDept() {
    //初始化部门
    var data={};
    var result=transfer("/text_project/addEmployee/initDept",data);
    if(result[0]==200){
        $("#depart").combobox({
            valueField: 'id',
            textField: 'name',
            data: result[1]
        })
    }
}

function initParty() {
    //初始化政治面貌
    var data={};
    var result=transfer("/text_project/addEmployee/initParty",data);
    if(result[0]==200){
        $("#party").combobox({
            valueField: 'party',
            textField: 'party',
            data: result[1]
        })
    }
}

function initEducation() {
    //初始化学历
    var data={};
    var result=transfer("/text_project/addEmployee/initEducation",data);
    if(result[0]==200){
        $("#education").combobox({
            valueField: 'education',
            textField: 'education',
            data: result[1]
        })
    }
}

function resetForm() {
    $("#dataForm").form("clear");
}

function submitEmployee() {
    var data={};
    data['depart']={};
    data['depart']['id']=$('#depart').combobox('getValue');
    data['job']={};
    data['job']['id']=$('#job').combobox('getValue');
    data['name']=$('#name').val();
    data['cardId']=$('#card').val();
    data['address']=$('#address').val();
    data['postCode']=$('#post').val();
    data['tel']=$('#tel').val();
    data['phone']=$('#phone').val();
    data['qqNumber']=$('#qq').val();
    data['email']=$('#email').val();
    data['sex']=$('#sex').val();
    data['party']=$('#party').combobox('getValue');
    data['birthday']=$('#birthday').val();
    data['race']=$('#race').val();
    data['education']=$('#education').combobox('getValue');
    data['speciality']=$('#speciality').val();
    data['hobby']=$('#hobby').val();
    data['remark']=$('#remark').val();
    console.log(data);
    addObject("/text_project/addEmployee/addEmployee",data);
}