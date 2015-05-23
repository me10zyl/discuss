<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
[
<s:iterator value="categories" var="category" status="status">
{
	"id" : <s:property value="category_id"/>,
	"name" : "<s:property value="category_name"/>"
}
<s:if test="!#status.last">,</s:if>
</s:iterator>
]
