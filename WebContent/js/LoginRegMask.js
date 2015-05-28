function openNew(oDiv){
    //获取页面的高度
    var sHeight=document.documentElement.scrollHeight;
    var sWidth=document.documentElement.scrollWidth;
    //可视区域的高度和宽度
    //竖向页面的可视区域的宽度和页面宽度是一样的
    var wHeight=document.documentElement.clientHeight;

    //创建遮蔽层
    var oMask=document.createElement("div");
    oMask.id="mask";
    oMask.style.height=wHeight+"px";
    oMask.style.width=sWidth+"px";
    document.body.appendChild(oMask);

    document.body.appendChild(oDiv);
    var dHeight=oDiv.offsetHeight;
    var dWidth=oDiv.offsetWidth;

    oDiv.style.left=(sWidth-dWidth)/2+"px";
    oDiv.style.top=(wHeight-dHeight)/2+"px";

    var oClose=document.getElementById("close");
    //点击关闭和遮罩层退出登录状态
    oMask.onclick=oClose.onclick=function(){
        document.body.removeChild(oMask);
        document.body.removeChild(oDiv);
    }
}
window.onload=function(){
    var oLogin=document.createElement("div");
    oLogin.id="login";
    oLogin.innerHTML="<div class='loginCon'>" +
        "<table class='loginTab'>" +
        "<tr>" +
        "<td  align='right'>邮箱：</td>" +
        "<td><input type='text' name='username' size='15' id='login_user_email'/></td>" +
        "</tr>" +
        "<tr>" +
        "<td  align='right'>密码：</td>" +
        "<td><input type='password' name='password' size='15' id='login_user_password'/></td>" +
        "</tr>" +
        "</table>"+
        "<img src='images/login_line.png' style='margin-top:300px' /><div id='Now_login'><a href='javascript:void(0)' onclick='login()'>立即登录</a></div><div id='close'></div></div>";

    var oBtn=document.getElementById("btnLogin");
    if(oBtn)
    {
	    oBtn.onclick=function(){
	        openNew(oLogin);
	    };
    }

    var oRegister=document.createElement("div");
    oRegister.id="register";
    oRegister.innerHTML="<div class='registerCon'><form action='login!register' method='post'><table class='registerTab'>" +
        "<tr>" +
        "<td  align='right'>Email：</td>" +
        "<td><input type='text' name='user_email' size='15' id='user_email'/></td>" +
        "</tr>" +
        "<tr>" +
        "<td  align='right'>昵称：</td>" +
        "<td><input type='text' name='user_nickname' size='15' id='user_nickname'/></td>" +
        "</tr>" +
        "<tr>" +
        "<td  align='right'>密码：</td>" +
        "<td><input type='password' name='user_password' size='15' id='user_password'/></td>" +
        "</tr>" +
        "<tr>" +
        "<td  align='right'>确认密码：</td>" +
        "<td><input type='password' name='user_password_confirm' size='15' id='user_password_confirm'/></td>" +
        "</tr>" +
        "</table>"+
        "<img src='images/register_line.png' style='margin-top:300px' /><div id='Now_register'><a href='javascript:void(0)' onclick='register()'>立即注册</a></div><div id='close'></div></form></div>";
	
    oBtn=document.getElementById("btnRegister");
    if(oBtn)
    {
	    oBtn.onclick=function(){
	        openNew(oRegister);
	    }
    }
  
};
