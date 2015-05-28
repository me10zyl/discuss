<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
<s:if test="#session.loginStatus == 'login'">
#header{background:#66CDAA;width:100%;height: 80px;border-bottom: 1px solid #CCCCCC;position: fixed;top: 0;left: 0;right: 0;margin: 0 auto;}
#header .logo{float: left;width: 116px;height: 35px;padding-top: 14px;padding-left: 30px;}
#header .userPicName{float: right;width: 35px;height: 50px;margin-top: 20px;}
#header .userPicName span{color: #ffffff;font-weight: bold;margin-left: -30px;}
#header .newsCon{width:36px;height:32px;background: url("images/newsPic.png") no-repeat;float: right;margin-top:25px;margin-left: 30px;line-height: 32px;text-align: center;}
#header .newsCon a{text-decoration: none;color:darksalmon;font-weight: bold;font-family: "arial unicode ms"}
#header .nav{float:right;width: 180px;height: 40px; margin:20px 0px;}
#header .nav a{text-decoration: none;padding-left: 10px;}
</s:if>
.searchCon{width:400px;height:100px;background:url("images/searchBg.png") no-repeat;position:absolute;right:10px;top:60px;line-height:120px;display:none}
.inpt{width:290px;height:30px;margin-left:30px;font-size:18px;font-weight:bold;font-family:"幼圆";border:1px solid rgba(193,199,202,.5);color:#424242}
.searchBtn{height:30px;width:40px;border:0px;margin-left:0px;font-weight:bold}
</style>  
<div id="header">
    <div class="logo">
        <a href="index.jsp"><img src="images/logo.png" ></a>
    </div>
    <s:if test="#session.loginStatus != 'login'">
    <div class="nav">
        <a href="#">首页</a>
       <a href="javascript:void(0)"><img src="images/search.png" width="40px" height="40px" title="搜索" id="search"></a>
        <span id="btnRegister"><a href="javascript:void(0)">注册</a></span>
        <span id="btnLogin"><a href="javascript:void(0)">登录</a></span>
    </div>
    </s:if>
    <s:else>
     <div class="nav">
        <a href="javascript:void(0)"><img src="images/search.png" width="40px" height="40px" title="搜索" id="search"></a>
        <a href="login!logout"><img src="images/logoout.png"></a>
    </div>
    <div id="newMessage"></div>
    <div class="userPicName">
        <a href="user!scanUserInformation"><img src="images/pic2.jpg" width="35px" height="35px" ></a>
        <span><s:property value="#session.user.user_nickname"></s:property></span>
    </div>
    </s:else>
    <div class="searchCon">
            <input type="text" class="inpt"/>
            <input type="button" class="searchBtn" value="搜索"/>
    </div>
</div>
<script src="js/jquery-1.11.1.min.js"></script>
<script>
$("#search").bind("click",function(){
    $(".searchCon").slideToggle(300);
});
$("#main_body").bind("click",function(){
    $(".searchCon").slideUp(300);
})
</script>
<s:if test="#session.loginStatus != 'login'">
<script src="js/LoginRegMask.js" type="text/javascript"></script>
<script src="js/indexAjax.js" type="text/javascript"></script>
</s:if>
<s:else>
<script type="text/javascript">
	window.onload = function(){
		$.ajax({
			url: "user!getUnReadMessageCount",
			success : function(data){
				var json = JSON.parse(data);
				if(json.count)
				{
					$('#newMessage').addClass("newsCon").append("<a href='user!scanUserInformation?hover=2'>"+json.count+"</a>");
				}else{
					$('#newMessage a').removeClass("newCon").remove();
				}
			}
		})
	}
</script>
</script>
</s:else>