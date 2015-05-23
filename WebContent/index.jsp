<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head lang="en">
	<base href="<%=path%>/">
    <meta charset="UTF-8">
    <title></title>
    <link href="style/index.css" rel="stylesheet">
    <link href="style/LoginRegMask.css" rel="stylesheet"/>
</head>
<body bgcolor="#66CDAA">
<s:action name="login!getHeader" executeResult="true" namespace="/"></s:action>
<div id="main_body">
    <div class="love"><a href="topic!scanTopicList"><img src="images/love.png" title="点击进入"/></a></div>
    <div class="tableGame"><a href='topic!scanTopicList'><img alt="点击进入" src="images/tableGame.png"></a></div>
    <div class="words">
        <div class="words1">在这里,你可以和不同的桌游爱好者讨论技巧,预约面玩....</div>
        <div class="words2">www.discuss.com</div>
        <div class="words3">
            <a href="#">简单 |</a>
            <a href="#">开放 |</a>
            <a href="#">趣味</a>
        </div>
    </div>
</div>
<s:action name="category!getFooter"  namespace="/" executeResult="true"></s:action>
<script type="text/javascript">
    $("#main_body .love").hover(function(){
        $("#main_body .love img").attr('src','images/love_mouseOver.png');
    },function(){
        $("#main_body .love img").attr('src','images/love.png');
    });
</script>

</body>
</html>