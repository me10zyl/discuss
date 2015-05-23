<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<s:if test="#session.loginStatus == 'login'">
<style>
#header{background:#66CDAA;width:100%;height: 80px;border-bottom: 1px solid #CCCCCC;position: fixed;top: 0;left: 0;right: 0;margin: 0 auto;}
#header .logo{float: left;width: 116px;height: 35px;padding-top: 14px;padding-left: 30px;}
#header .userPicName{float: right;width: 35px;height: 50px;margin-top: 20px;}
#header .userPicName span{color: #ffffff;font-weight: bold;margin-left: -30px;}
#header .newsCon{width:36px;height:32px;background: url("images/newsPic.png") no-repeat;float: right;margin-top:25px;margin-left: 30px;line-height: 32px;text-align: center;}
#header .newsCon a{text-decoration: none;color:darksalmon;font-weight: bold;font-family: "arial unicode ms"}
#header .nav{float:right;width: 180px;height: 40px; margin:20px 0px;}
#header .nav a{text-decoration: none;padding-left: 10px;}
</s:if>
</style>  
<div id="header">
    <div class="logo">
        <a href="index.jsp"><img src="images/logo.png" ></a>
    </div>
    <s:if test="#session.loginStatus != 'login'">
    <div class="nav">
        <a href="#">首页</a>
        <a href="#"><img src="images/search.png" id="search" title="搜索"></a>
        <span id="btnRegister"><a href="#">注册</a></span>
        <span id="btnLogin"><a href="#">登录</a></span>
    </div>
    </s:if>
    <s:else>
     <div class="nav">
        <a href="#"><img src="images/search.png" width="40px" height="40px" title="搜索"></a>
        <a href="login!logout"><img src="images/logoout.png"></a>
    </div>
    <div class="newsCon"><a href="profile_me.html">1</a></div>
    <div class="userPicName">
        <img src="images/pic2.jpg" width="35px" height="35px">
        <span><s:property value="#session.user.user_nickname"></s:property></span>
    </div>
    </s:else>
</div>
<s:if test="#session.loginStatus != 'login'">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/LoginRegMask.js" type="text/javascript"></script>
<script src="js/indexAjax.js" type="text/javascript"></script>
</s:if>