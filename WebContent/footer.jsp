<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
</style>
<div id="footer">
	<div class="footer_topimg"></div>
	<div class="footer_imgs">
		<c:forEach items="${categories}" var="category">
		<a href="topic!scanTopicListByCategoryId?category_id=${category.category_id}">
			<div class="footer_img">
				<p>
					<c:out value="${category.category_name}"></c:out>
				</p>
			</div>
		</a>
		</c:forEach>
		<s:debug></s:debug>
	</div>
</div>