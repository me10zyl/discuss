<%@page import="net.xicp.zyl_me.entity.Message"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="net.xicp.zyl_me.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<tr class="tabstyle" align="center">
    <th>主题</th> <th>种类</th> <th>用户</th> <th>回复数</th> <th>浏览数</th> <th>活跃时间</th>
</tr>
<%
	ArrayList<User> users = new ArrayList<User>();
%>
<s:iterator value="topics" var="topic" status="status">
<s:if test="#status.odd == true">
<tr class="tabstyleBg" align="center">
</s:if>
<s:else>
<tr class="tabstyle" align="center">
</s:else>
    <td align="center"><a href="topic!scanTopicSingle?topic_id=<s:property value="topic_id"/>"><s:property value="topic_title"></s:property></a></td>
    <td class="category3"><s:property value="category.category_name"></s:property></td>
    <td>
    	<s:iterator value="messages.{user}" end="3" status="status" var="user">
    		<% 
    			User user = (User)ActionContext.getContext().get("user");
    			if(!users.contains(user))
    			{
    		%>
    			<a href="user!scanUserInformationById?user.user_id=<s:property value="user_id"/>"><img src="<s:property value="user_avatar" />"></a>
    		<% }%>
    		<% users.add(user);%>
    	</s:iterator>
	</td>
    <td><s:property value="topic_replyCount"></s:property></td>
    <td><s:property value="topic_scanCount"></s:property></td>
    <td title="<s:property value="messages.{message_time}[0]"></s:property>"><s:property value="topic_activeTime"></s:property></td>
</tr>
</s:iterator>
<script>
$(".category3").each(function(){
	$(this).css("color",colorList2[$(this).text().trim()]);
});
</script>