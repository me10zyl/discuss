<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<tr class="tabstyle" align="center">
    <th>主题</th> <th>种类</th> <th>用户</th> <th>回复数</th> <th>浏览数</th> <th>活跃时间</th>
</tr>
<s:iterator value="topics" var="topic">
<tr class="tabstyleBg" align="center">
    <td align="center"><a href="topic!scanTopicSingle?topic_id=<s:property value="topic_id"/>"><s:property value="topic_title"></s:property></a></td>
    <td class="wolfNight"><s:property value="category.category_name"></s:property></td>
    <td><a href="profile_me.html"><img src="images/pic2.jpg"></a><a href="profile_me.html"><img src="images/pic3.jpg"></a><a href="profile_me.html"><img src="images/pic4.jpg"></a></td>
    <td><s:property value="topic_replyCount"></s:property></td>
    <td><s:property value="topic_scanCount"></s:property></td>
    <td title="<s:property value="messages.{message_time}[0]"></s:property>"><s:property value="topic_activeTime"></s:property></td>
</tr>
</s:iterator>