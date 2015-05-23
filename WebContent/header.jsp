<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
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
        <a href="profile_me.html"><img src="images/pic2.jpg" width="35px" height="35px"></a>
        <span><font color='pink'><s:property value="#session.user.user_nickname"></s:property></font></span>
    </div>
    <div class="newsCon"><a href="profile_me.html">1</a></div>
    <a href="login!logout"><img src="images/logoout.png"></a>

    </s:else>
</div>
<s:if test="#session.loginStatus != 'login'">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/LoginRegMask.js" type="text/javascript"></script>
<script src="js/indexAjax.js" type="text/javascript"></script>
</s:if>