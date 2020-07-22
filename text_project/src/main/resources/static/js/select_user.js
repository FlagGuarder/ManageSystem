function searchUser() {
    $('#dg').datagrid('load',{
        number: $('#id').val(),
        userName: $('#name').val(),
        classInfo: $('#class').val()
    });
}


function init() {
    initForm();
    setButton();
}

function initForm() {
    //初始化表格
    $('#dg').datagrid({
        title : '学生列表',
        border : false,
        rownumbers : true,
        toolbar : '#tb',
        pagination : true,
        pageSize : "10",
        pageList : [ 5, 10, 15, 20 ],
        singleSelect : true,
        fitColumns:true,
        url : '/text_project/selectUser',
        columns : [ [ {
            field : 'id',
            value : 'id',
            checkbox : true,
            title : '选择',
            width : 50
        }, {
            field : 'number',
            title : '学号',
            width : 220
        }, {
            field : 'userName',
            title : '姓名',
            width : 220
        }, {
            field : 'password',
            title : '密码',
            width : 300
        }, {
            field : 'classInfo',
            title : '班级',
            width : 220
        } ] ]
    });
}

function setButton() {
    //设置删除以及修改按钮
    $(function() {
        var pager = $('#dg').datagrid().datagrid('getPager');

        pager.pagination({
            buttons : [
                {
                    iconCls : 'icon-no',
                    text : '删除',
                    handler : function() {
                        var row = $('#dg').datagrid('getSelected');
                        if (row != null) {
                            $.messager.confirm('确认是否要删除', '确定要删除('
                                + row.userName + ')吗?', function(r) {
                                if (r) {
                                    handleDeleteUser(row.id);
                                }
                            });
                        }
                    }
                },
                {
                    iconCls : 'icon-edit',
                    text : '修改',
                    handler : function() {
                        var row = $('#dg').datagrid('getSelected');
                        if (row != null) {
                            $('#dlg').dialog('open');
                            var row = $('#dg').datagrid('getSelected');
                            if (row != null) {
                                //读取方式,根据row的字段row.xxx
                                $("#number").textbox('setValue', row.number);
                                $("#username").textbox('setValue', row.userName);
                                $("#password").textbox('setValue', row.password);
                                $("#classinfo").combobox('setValue', row.classInfo);
                                $('#dlg').dialog('open');
                            }
                        }
                    }
                } ]
        });

    })
}

function handleDeleteUser(id) {
    //处理删除按钮点击事件
    var data={};
    data['id']=id;
    deleteObject("/text_project/selectUser/deleteUser",data);
}

function handleUpdateUser() {
    var data={};
    data['number']=$("#number").val();
    data['userName']=$("#username").val();
    data['password']=$("#password").val();
    data['classInfo']=$("#classinfo").val();
    updateObject("/text_project/selectUser/updateUser",data);
}
