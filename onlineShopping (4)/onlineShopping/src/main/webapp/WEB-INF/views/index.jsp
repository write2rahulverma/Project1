<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${userClickHome == true }">
	<%@include file = "/WEB-INF/views/home.jsp"%>
	
</c:if>

<c:if test="${userClickContact == true }">
	<%@include file = "/WEB-INF/views/contact.jsp"%>
</c:if>

<c:if test="${userClickAbout == true }">
	<%@include file = "/WEB-INF/views/about.jsp"%>
</c:if>

<c:if test="${userClickRegister == true }">
	<%@include file = "/WEB-INF/views/register.jsp"%>
</c:if>

<c:if test="${userClickLogin == true }">
	<%@include file = "/WEB-INF/views/login.jsp"%>
</c:if>

<c:if test="${userClickSingleProduct == true }">
	<%@include file = "/WEB-INF/views/productDetail.jsp"%>
</c:if>

<c:if test="${userClickAddProduct == true }">
	<%@include file = "/WEB-INF/views/addProduct.jsp"%>
</c:if>

<c:if test="${userClickManageProducts == true }">
	<%@include file = "/WEB-INF/views/manageProduct.jsp"%>
</c:if>

<c:if test="${userClickShowCart == true }">
	<%@include file = "/WEB-INF/views/cart.jsp"%>
</c:if>

<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true }">
	<%@include file = "/WEB-INF/views/manageProduct.jsp"%>
</c:if>

<%@include file = "/WEB-INF/views/templates/footer1.jsp"%>