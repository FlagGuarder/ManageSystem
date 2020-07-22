function init() {
    initDepartInfo()
    setButton();
}

function initDepartInfo() {
    $('#dg').datagrid({
        title : '部门列表',
        border : false,
        rownumbers : true,
        toolbar : '#tb',
        pagination : true,
        pageSize : "5",
        pageList : [ 5, 10, 15, 20 ],
        singleSelect : true,
        fitColumns:true,
        url : '/text_project/selectDepart/init',
        columns : [ [ {
            field : 'id1',
            value : 'id',
            checkbox : true,
            title : '选择',
            width : 100
        }, {
            field : 'id',
            title : '部门编号',
            width : 250
        }, {
            field : 'name',
            title : '部门名称',
            width : 250
        },{
            field : 'remark',
            title : '备注',
            width : 250
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
                                + row.name + ')吗?', function(r) {
                                if (r) {
                                    handleDeleteDepart(row.id);
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
                                $("#id").textbox('setValue', row.id);
                                $("#deptname").textbox('setValue', row.name);
                                $("#remark").textbox('setValue', row.remark);
                                $('#dlg').dialog('open');

                            }
                        }
                    }
                } ]
        });

    })
}

function handleDeleteDepart(id) {
    var data={};
    data['id']=id;
    deleteObject("/text_project/selectDepart/deleteDepart",data);
}

function handleUpdateDepart() {
    var data={};
    data['id']=$("#id").val();
    data['name']=$("#deptname").val();
    data['remark']=$("#remark").val();
    updateObject("/text_project/selectDepart/updateDepart",data);
}
