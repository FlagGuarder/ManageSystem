function init() {
    initEmployee();
    setButton();
}

function initEmployee() {
    $('#dg').datagrid({
        title : '员工列表',
        border : false,
        rownumbers : true,
        toolbar : '#tb',
        pagination : true,
        pageSize : "10",
        pageList : [ 5, 10, 15, 20 ],
        singleSelect : true,
        fitColumns:true,
        url:'/text_project/selectEmployee/init',
        columns : [ [
            {field : 'id1', value : 'id', checkbox : true, title : '选择', width : 100
        }, {field : 'id', title : '编号', width : 150},
            {field : 'name', title : '姓名', width : 250},
            {field : 'sex',
                title : '性别',
                width : 150,
                formatter:function (value,row,index) {
                    if(row.sex==1){
                        return "男";
                    }
                    else {
                        return "女";
                    }
                }
            },
            {
            field : 'depart',
            title : '部门',
            width : 200,
            formatter: function (value,row,index) {
                if(row.depart){
                    return row.depart.name;
                }
            }
        }, {field : 'job',
            title : '工作',
            width : 300,
            formatter: function (value,row,index) {
                if(row.job){
                    return row.job.name;
                }
            }},
            {field : 'cardId', title : '卡号', width : 350},
            {field : 'address', title : '地址', width : 700},
            {field : 'postCode', title : '邮政编号', width : 250},
            {field : 'tel', title : '固定电话', width : 350},
            {field : 'phone', title : '手机', width : 350},
            {field : 'qqNumber', title : 'QQ', width : 400},
            {field : 'email', title : '邮箱', width : 700},
            {field : 'party', title : '政治面貌', width : 350},
            {field : 'birthday', title : '出生日期', width : 450},
            {field : 'race', title : '民族', width : 250},
            {field : 'education', title : '学历', width : 250},
            {field : 'speciality', title : '专业', width : 250},
            {field : 'hobby', title : '爱好', width : 400},
            {field : 'remark', title : '备注', width : 400},
        ] ]
    });
}

function setButton() {
    //设置删除以及修改按钮
    $(function() {
        var pager = $('#dg').datagrid().datagrid('getPager');

        pager.pagination({
            buttons : [{
                    iconCls : 'icon-no',
                    text : '删除',
                    handler : function() {
                        var row = $('#dg').datagrid('getSelected');
                        if (row != null) {
                            $.messager.confirm('确认是否要删除', '确定要删除('
                                + row.name + ')吗?', function(r) {
                                if (r) {
                                    handleDeleteEmployee(row.id);
                                }
                            });
                        }
                    }
                }, {
                    iconCls : 'icon-edit',
                    text : '修改',
                    handler : function() {
                        var row = $('#dg').datagrid('getSelected');
                        if (row != null) {
                            $('#dlg').dialog('open');
                            var row = $('#dg').datagrid('getSelected');
                            if (row != null) {
                                //读取方式,根据row的字段row.xxx
                                $("#id").textbox('setValue', row.id);
                                $("#name").textbox('setValue',row.name);
                                if(row.sex==1){
                                    $("#sex").textbox('setValue',"男");
                                }
                                else {
                                    $("#sex").textbox('setValue',"女");
                                }
                                $("#deptname").textbox('setValue', row.depart.name);
                                $("#jobname").textbox('setValue',row.job.name);
                                $("#cardId").textbox('setValue',row.cardId);
                                $("#address").textbox('setValue',row.address);
                                $("#postCode").textbox('setValue',row.postCode);
                                $("#tel").textbox('setValue',row.tel);
                                $("#phone").textbox('setValue',row.phone);
                                $("#qqNumber").textbox('setValue',row.qqNumber);
                                $("#email").textbox('setValue',row.email);
                                $("#party").textbox('setValue',row.party);
                                $("#birthday").textbox('setValue',row.birthday);
                                $("#race").textbox('setValue',row.race);
                                $("#education").textbox('setValue',row.education);
                                $("#hobby").textbox('setValue',row.hobby);
                                $("#remark").textbox('setValue', row.remark);
                                $('#dlg').dialog('open');
                            }
                        }
                    }
                } ]
        });

    })
}

function handleDeleteEmployee(id) {
    var data={};
    data['id']=id;
    deleteObject("/text_project/selectEmployee/delete",data);
}

function handleUpdateEmployee() {
    var data={};
    data['id']=$("#id").val();
    data['cardId']=$("#cardId").val();
    data['address']=$("#address").val();
    data['postCode']=$("#postCode").val();
    data['tel']=$("#tel").val();
    data['phone']=$("#phone").val();
    data['qqNumber']=$("#qqNumber").val();
    data['email']=$("#email").val();
    data['party']=$("#party").val();
    if($("#birthday").val()!=undefined){
        data['birthday']=$("#birthday").val();
    }
    data['race']=$("#race").val();
    data['education']=$("#education").val();
    data['hobby']=$("#hobby").val();
    data['remark']=$("#remark").val();
    updateObject("/text_project/selectEmployee/update",data);
}

