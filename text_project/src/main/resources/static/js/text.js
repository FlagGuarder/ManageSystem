function search() {
    $('#dg').datagrid('load',{
        number: $('#id').val(),
        userName: $('#name').val()
    });
}
function init() {
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
        url : '/text_project/textInit',
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