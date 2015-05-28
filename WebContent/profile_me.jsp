<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
#header .nav{float:right;width: 380px;height: 60px;font-family: "骞煎渾";font-size:18px;line-height:60px;}
#header .nav a{text-decoration: none;float: left;font-weight: bold;color: #ffffff;padding: 8px 15px;}
#header .nav a:hover{text-decoration: underline;}
    </style>
    <link href="style/profile_me.css" rel="stylesheet">
</head>
<body>
<s:action name="login!getHeader" executeResult="true" namespace="/"></s:action>

<div id="main_body">
    <div class="simpleMesBar">
        <div class="personImg">
           <a href="#"><img src="${user.user_avatar}" width="48px" height="54px"></a>
           <span id="name">${user.user_nickname}</span>
        </div>
        <div class="Logout"><a href="login!logout">注销</a></div>
    </div>
    <div class="detailMesCon">
        <div class="detailMesCon_L">
            <div class="hover">个人资料</div>
            <div>我的主题</div>
            <div>我的消息</div>
        </div>
        <div class="detailMesCon_R">
            <div class="detailMesCon_R1" style="display: block">
                <table class="detailMesCon_R1tab">
                    <tr>
                        <td class="detailMesCon_R1tabR">Email:</td>
                        <td class="detailMesCon_R1tabL">${user.user_email}</td>
                    </tr>
                    <tr>
                        <td class="detailMesCon_R1tabR">昵称:</td>
                        <td class="detailMesCon_R1tabL">${user.user_nickname}</td>
                    </tr>
                    <tr>
                        <td class="detailMesCon_R1tabR">密码:</td>
                        <td class="detailMesCon_R1tabL">******</td>
                    </tr>
                    <tr>
                        <td class="detailMesCon_R1tabR">头像:</td>
                        <td class="detailMesCon_R1tabL"><img src="${user.user_avatar}" width="58px" height="64px"></td>
                    </tr>
                    <tr>
                        <td class="detailMesCon_R1tabR">个人简介:</td>
                        <td><textarea cols="20" rows="10">${user.user_introduction}</textarea></td>
                    </tr>
                </table>
            </div>
            <div class="detailMesCon_R1">
                <ul>
                	<s:iterator value="topics" var="topic">
                	 <li><a href="topic!scanTopicSingle?topic_id=<s:property value="topic_id"/>"><s:property value="topic_title"/></a></li>
                	</s:iterator>
                </ul>
            </div>
            <div class="detailMesCon_R1">
                <ul>
                	<s:iterator value="replies">
                    <li><a href="topic!scanTopicSingle?topic_id=<s:property value="topic.topic_id"/>"><s:property value="user.user_nickname"/>回复你了 - <s:property value="topic.topic_title"/></a></li>
                    </s:iterator>
                </ul>
            </div>
        </div>
    </div>
</div>

<s:action name="category!getFooter" executeResult="true" namespace="/"></s:action>
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
window.onload=function(){
    $(".detailMesCon_L div").click(function(){
        $(this).addClass("hover").siblings().removeClass("hover");
        $(".detailMesCon_R .detailMesCon_R1").eq($(this).index()).show().siblings().hide();
    });
    var hover = "${hover}";
    if(hover == "")
    {
    	hover = 0;
    }else
    {
    	hover = ${hover};
    }
    $(".detailMesCon_L div:eq("+hover+")").addClass("hover").siblings().removeClass("hover");
    $(".detailMesCon_R .detailMesCon_R1:eq("+hover+")").show().siblings().hide();
}
</script>
</body>
</html>