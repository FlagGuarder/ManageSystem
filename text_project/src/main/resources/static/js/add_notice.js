function init() {
    var E = window.wangEditor
    var editor = new E('#editor')
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.create()
    //初始化页面
    //var ue = UE.getEditor('editor', {
    //    toolbars:[[
    //        'undo', //撤销
    //        'bold', //加粗
    //        'underline', //下划线
    //        'preview', //预览
    //        'horizontal', //分隔线
    //        'inserttitle', //插入标题
    //        'cleardoc', //清空文档
    //        'fontfamily', //字体
    //        'fontsize', //字号
    //        'paragraph', //段落格式
    //        'simpleupload', //单图上传
    //        'insertimage', //多图上传
    //        'attachment', //附件
    //        'music', //音乐
    //        'inserttable', //插入表格
    //        'emotion', //表情
    //        'insertvideo', //视频
    //        'justifyleft', //居左对齐
    //        'justifyright', //居右对齐
    //        'justifycenter', //居中对
    //        'justifyjustify', //两端对齐
    //        'forecolor', //字体颜色
    //        'fullscreen', //全屏
    //        'edittip ', //编辑提示
    //        'customstyle', //自定义标题
    //        'template', //模板
    //    ]]
    //});
}

function submitNotice() {
    var data={};
    data['name']=$('#name').val();
    data['title']=$('#title').val();
    //data['content']=UE.getEditor('editor').getContent();
    data['content'] = editor.txt.text;
    //addObject("/text_project/addNotice/add",data);

}