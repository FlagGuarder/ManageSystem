function init() {
    initTable();
}

function initTable() {
    $('#dg').datagrid({
        title : '资源列表',
        border : false,
        rownumbers : true,
        toolbar : '#tb',
        pagination : true,
        pageSize : "5",
        pageList : [ 5, 10, 15, 20 ],
        singleSelect : true,
        fitColumns:true,
        url : '/text_project/downloadFile/getFiles',
        columns : [ [ {
            field : 'id',
            title : '资源编号',
            width : 250
        }, {
            field : 'customName',
            title : '资源名称',
            width : 250
        },{
            field : 'uploader',
            title : '上传者',
            width : 250
        } ,{
            field : 'time',
            title : '上传时间',
            width : 250
        },{
            field : 'name',
            title : '操作',
            width : 150,
            formatter:function (value,row,index) {
                return '<a href="#" onclick="downloadFile('+index+')">下载</a>';
            }
        }] ]
    });
}

function downloadFile(index){
    $('#dg').datagrid('selectRow',index);// 关键在这里
    var row = $('#dg').datagrid('getSelected');
    if(row){
        window.location.href="/text_project/downloadFile/download?name="+row.name+"&customName="+row.customName;
    }
    else {
        alert("获取资源信息失败");
    }
}