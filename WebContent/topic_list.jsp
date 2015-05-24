<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <base href="<%=path%>/">
    <link href="style/login_after.css" rel="stylesheet">
      <link href="style/login_before.css" rel="stylesheet">
    <link href="style/LoginRegMask.css" rel="stylesheet"/>
</head>
<body>
<s:action name="login!getHeader" executeResult="true" namespace="/"></s:action>
<div id="main_body">
    <div class="bar">
       <select class="choiceList choiceListHide" name='category_id'>
                <option style='color:#A4929C'>&nbsp;&nbsp;&nbsp;所有主题</option>
                <s:iterator value="categories" var="category">
                	 <option style="weight:bold" class="category" value="<s:property value="category_id"/>">&nbsp;&nbsp;&nbsp;<s:property value="category_name"/></option>
                </s:iterator>
        </select>
        <div class="latestTopic">最新主题</div>
         <s:if test="#session.loginStatus == 'login'">
        <div class="addNewTopic">
            <div class="addPic"></div>
            <span style="margin: 5px 5px;float: left;">新主题</span>
        </div>
        </s:if>
    </div>
    <div class="listShow">
        <table class="listTab" id="listTab">
            <s:include value="topics.jsp"></s:include>
        </table>
        <div class="noTopic">这儿没有更多的主题了！</div>
    </div>


    <div class="newTopic">
    <form action="topic!setTopic" method="post">
        <div class="close close1"></div>
        <div class="close close2"></div>
        <div class="Topic">
            <div class="btnTopic">主题</div>
            <input type="text" name="topic_title" id="topic_title"/>
        </div>
        <div class="addPicLook">
            <ul>
                <li><img src="images/look.png">表情
                    <div class="looks" style="background: #ffffff;display: none;position: absolute;z-index: 1000">
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
            <textarea class="EditTex" rows="8" cols="100" name="message_content" id="message_content"></textarea>
            <select class="choiceList choiceListHide" name='category_id' id='category_id'>
                <option style='color:#A4929C' class="category_all" value="-1">&nbsp;&nbsp;&nbsp;所有主题</option>
                <s:iterator value="categories" var="category">
                	 <option style="weight:bold" class="category" value="<s:property value="category_id"/>">&nbsp;&nbsp;&nbsp;<s:property value="category_name"/></option>
                </s:iterator>
            </select>
            <div class="public" onclick="setTopic()">发表</div>
        </div>
        </form>
    </div>
    
</div>

<s:action name="category!getFooter" executeResult="true" namespace="/"></s:action>

<script src="js/jquery-1.11.1.min.js"></script>
<script>
	var colorList = [];
	function setTopic()
	{
		$.ajax({
    		url : "topic!setTopic",
    		data : "category_id="+$('#category_id').val()+"&"+"message_content="+$("#message_content").val()+"&"+"topic_title="+$("#topic_title").val(),
    		success : function(data){
    			var json = JSON.parse(data);
    			if(json.result)
    			{
    				$('#listTab').load("topic!getTopicList");
    				$('.newTopic input').val("");
    				$('.newTopic textarea').val("");
    				$(".newTopic").slideUp(1000);
    			}else
    			{
    				alert(json.message);
    			}
    		}
    	})
	}
    $(function(){
    	$("select").css("color","#A4929C");
    	$.ajax({
    		url : "category!getCategoriesJson",
    		success : function(data){
    			var json = JSON.parse(data);
    		}
    	})
    	 $(".choiceList").bind("change",function(){
    		 var option = $(this).children('option:selected');
    		 if(option.data("order"))
    		 {
    		 	$(this).css("color",colorList[option.data("order")]);
    		 }else
    		{
    			 $(this).css("color","#A4929C");
    		}
        });
        $(".category").each(function(){
        	var color = '#'+('00000'+(Math.random()*0x1000000<<0).toString(16)).slice(-6)
        	colorList.push(color);
        	$(this).css("color",color);
        	$(this).data("order",colorList.length - 1);
        });

            $(".addPicLook ul li").hover(function(){
                $(this).find(".looks").show();
            },function(){
                $(this).find(".looks").hide();
            });

        $(".addNewTopic").bind("click",function(){
            $(".newTopic").slideDown(1000);
//            $(".newTopic").fadeIn(1000);
        });

      $(".close").bind("click",function(){
          $(".newTopic").slideUp(1000);
      });

  });
</script>
</body>
</html>