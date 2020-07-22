function init() {
    var data={};
    var result=transfer("/text_project/main/init",data);
    if(result[0]=='200'){
        $("#userName").html(result[1].userName);
    }
    else {
        alert("加载失败");
    }
    initTime();
}

function initTime() {
    //初始化时间
    var mytime = setInterval(function() {
        getTime();
    }, 1000);//1000毫秒==1秒
    function getTime() {
        var d = new Date();
        /*得到月，日，时，分，秒，要处理少10补0  */
        var M = (d.getMonth() + 1) < 10 ? ('0' + (d.getMonth() + 1)) : (d
            .getMonth() + 1);
        var D = d.getDate() < 10 ? ('0' + d.getDate()) : d.getDate();
        var H = d.getHours() < 10 ? ('0' + d.getHours()) : d.getHours();
        var m = d.getMinutes() < 10 ? ('0' + d.getMinutes()) : d.getMinutes();
        var s = d.getSeconds() < 10 ? ('0' + d.getSeconds()) : d.getSeconds();
        var t = d.getFullYear() + "年" + M + "月" + D
            + "号&nbsp;&nbsp;&nbsp;&nbsp;" + H + ":" + m + ":" + s
            + "&nbsp;&nbsp;&nbsp;&nbsp;星期" + "日一二三四五六".charAt(d.getDay());
        ;
        //将控件的内容修改为处理好的字符串
        $("#ptime").html(t);
    }
}

function logout() {
    var data={};
    var result=transfer("/text_project/main/logout",data);
    if(result[0]=='200'){
        window.location.href="/text_project/login";
    }
}

$(function() {

    $("#selectuser").click(function() {
        addTab("#usertab", "用户查询", "icon-zoom", "/text_project/selectUser");
    });
    $("#adduser").click(function() {
        addTab("#usertab", "添加用户", "icon-groupadd", "/text_project/addStudent");
    });

    $("#selectdept").click(function() {
        addTab("#usertab", "部门查询", "icon-groupadd", "/text_project/selectDepart");
    });

    $("#adddept").click(function () {
        addTab("#usertab", "添加部门", "icon-groupadd", "/text_project/addDepart");
    });

    $("#selectjob").click(function() {
        addTab("#usertab", "职位查询", "icon-groupadd", "/text_project/selectJob");
    });

    $("#addjob").click(function () {
        addTab("#usertab", "添加职位", "icon-groupadd", "/text_project/addJob");
    });

    $("#selectEmp").click(function() {
        addTab("#usertab", "员工查询", "icon-zoom", "/text_project/selectEmployee");
    });

    $("#addEmp").click(function(){
        addTab("#usertab", "添加员工", "icon-groupadd", "/text_project/addEmployee");
    });

    $("#selectNotice").click(function(){
        addTab("#usertab", "公告查询", "icon-groupadd", "/text_project/selectNotice");
    });

    $("#addNotice").click(function(){
        addTab("#usertab", "添加公告", "icon-groupadd", "/text_project/addNotice");
    });
    $("#filesDL").click(function(){
        addTab("#usertab", "文件下载", "icon-fileDL", "/text_project/downloadFile");
    });

    $("#upload").click(function(){
        addTab("#usertab", "文件上传", "icon-upload", "/text_project/uploadFile");
    });

});

function addTab(id, info, icon, url) {
    //先判断是否存在,返回一个boolean值
    var res = $(id).tabs("exists", info);
    //如果选项卡存在，则直接选中：select选中
    if (res) {
        //让table选中
        $(id).tabs("select", info);
    } else {//如果不存在则添加
        //调用添加tab的函数
        var content = '<iframe scrolling="auto" frameborder="0"  src="'
            + url + '" style="width:100%;height:100%;"></iframe>';
        $(id).tabs("add", {
            "iconCls" : icon,
            "title" : info,
            content : content,
            "closable" : "true"
        });
    }
}