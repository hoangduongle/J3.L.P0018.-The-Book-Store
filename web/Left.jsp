

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${sessionScope.listc}" var="c">
                <li class="list-group-item text-white "><a href="MainController?action=category&cid=${c.getCategoryID()}">${c.getCategoryName()}</a></li>
                </c:forEach>
                <li class="list-group-item text-white "><a href="MainController?action=category&cid=0">All</a></li>
        </ul>
    </div>
</div>