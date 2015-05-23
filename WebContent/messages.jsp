<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<s:iterator value="messages" var="message" begin="1" status="status">
 	<div class="Replayer">
        <div class="personImg">
            <a href="#"><img src="images/pic8.jpg" width="80px" height="80px"></a>
            <span class="name"><s:property value="user.user_nickname"/></span>
        </div>
        <div class="description"><s:property value="message_content"/></div>
        <div class="publicTime"><p><s:property value="message_time"/></p></div>
        <div class="replayBtn">回&nbsp;复</div>
    </div>
</s:iterator>