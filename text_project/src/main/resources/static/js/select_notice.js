function init() {
    var result=transfer("/text_project/selectNotice/getNotice",{});
    if(result[0]==200){
        document.getElementById("content").innerHTML=result[1].content;
        $('#name').text(result[1].name);
        $('#title').text(result[1].title);
        $('#stuName').text(result[1].stuName);
        $('#time').text(result[1].time);
    }
    else {
        alert("加载公告失败");
    }
}