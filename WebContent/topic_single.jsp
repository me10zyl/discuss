<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="style/topic_single_beforeLogin.css" rel="stylesheet">
    <link href="style/LoginRegMask.css" rel="stylesheet"/>
</head>
<body>
<s:action name="login!getHeader" executeResult="true" namespace="/"></s:action>

<div id="main_body">
    <div class="Topic_autor">
        <div class="topicName">
           <h1><p><s:property value="topic.topic_title"/></p></h1>
            <span><s:property value="topic.category.category_name"/></span>
        </div>
        <div class="topicDescription">
            <div class="personImg">
                <a href="user!scanUserInformationById?user.user_id=<s:property value="topic.messages.{?#this.message_floor==1}.{user}[0].user_id"/>"><img src="<s:property value="topic.messages.{?#this.message_floor==1}.{user}[0].user_avatar"/>" width="80px" height="80px"></a>
                <span class="name"><s:property value="topic.messages.{?#this.message_floor==1}.{user}[0].user_nickname"/></span>
            </div>
            <div class="description"><s:property value="topic.messages.{?#this.message_floor==1}.{message_content}[0]"/></div>
            <div class="publicTime"><p><s:property value="topic.messages.{?#this.message_floor==1}.{message_time}[0]"/></p></div>
        </div>
    </div>
    <div id="replies">
   		<s:include value="messages.jsp"></s:include>
    </div>
    <div class="ReplayEdit">
        <div class="addPicLook">
            <ul>
                <li><img src="images/look.png">表情
                    <div class="looks" style="background: #ffffff;display: none;position: absolute;z-index: 1000px">
                        <table>
                            <tr>
                                <td><img src="images/look1.png"></td>
                                <td><img src="images/look2.png"></td>
                                <td><img src="images/look3.png"></td>
                                <td><img src="images/look4.png"></td>
                            </tr>
                            <tr>
                                <td><img src="images/look5.png"></td>
                                <td><img src="images/look6.png"></td>
                                <td><img src="images/look7.png"></td>
                                <td><img src="images/look8.png"></td>
                            </tr>
                            <tr>
                                <td><img src="images/look1.png"></td>
                                <td><img src="images/look2.png"></td>
                                <td><img src="images/look3.png"></td>
                                <td><img src="images/look4.png"></td>
                            </tr>
                            <tr>
                                <td><img src="images/look5.png"></td>
                                <td><img src="images/look6.png"></td>
                                <td><img src="images/look7.png"></td>
                                <td><img src="images/look8.png"></td>
                            </tr>
                        </table>
                    </div>
                </li>
                <li><img src="images/picture.png">图片</li>
            </ul>
        </div>
        <textarea class="EditTex" rows="8" cols="100" id="message_content"></textarea>
        <div class="public" onclick="reply()">发&nbsp;表</div>
    </div>
</div>

<s:action name="category!getFooter"  namespace="/" executeResult="true"></s:action>

<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
    window.onload=function(){
        $(".addPicLook ul li").hover(function(){
            $(this).find(".looks").show();
        },function(){
            $(this).find(".looks").hide();
        });
    }
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
    function reply()
    {
    	$.ajax({
    		url:"topic!setMessage",
    		data:"message_content="+$('#message_content').val()+"&topic_id="+<s:property value="topic.topic_id"/>,
    		success : function(data)
    		{
    			var json = JSON.parse(data);
    			if(json.result)
    			{
    				$('#replies').load("topic!getMessageList?topic_id="+<s:property value="topic.topic_id"/>);
    				$('.ReplayEdit textarea').val("");
    			}else
    			{
    				alert(json.message);
    			}
    		}
    	})
    }
</script>
<script src="js/LoginRegMask.js" type="text/javascript"></script>
</body>
</html>