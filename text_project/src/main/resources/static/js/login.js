function clickLogin() {
    var userName=$("#userName").val();
    var password=$("#password").val();
    var data={};
    data['number']=userName;
    data['password']=password;
    var result=transfer("/text_project/login",data);
    if(result[0]=='200'){
        window.location.href="/text_project/main";
    }
    else{
        console.log("error");
    }
}