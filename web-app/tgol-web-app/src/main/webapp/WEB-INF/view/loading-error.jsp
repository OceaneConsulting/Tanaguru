<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import = "java.util.Date,java.text.SimpleDateFormat,java.text.ParseException"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<c:choose>
    <c:when test="${fn:contains(pageContext.response.locale, '_')}">
        <c:set var="lang">
            ${fn:substringBefore(pageContext.response.locale, "_")}
        </c:set>
    </c:when>
    <c:otherwise>
        <c:set var="lang" value="${pageContext.response.locale}"/>
    </c:otherwise>
</c:choose>
<html lang="${lang}">
    <c:set var="pageTitle" scope="page">
        <fmt:message key="errorLoadingPage.pageTitle"/>
    </c:set>
    <%@include file="template/head.jsp" %>
    <body id="tgm-loading-error no-bg-container">
        <%@include file="template/header-utils.jsp" %>
        <div class="container no-bg-container">
            <div class="row">
                <div class="span16">
                    <div class="alert-message block-message">
                        <h1><fmt:message key="errorLoadingPage.message"/></h1>
                        <p>
                            <fmt:message key="resultPage.url"/> <a href="${auditUrl}">${auditUrl}</a>
                        </p>
                        <p>
                            <fmt:message key="resultPage.date"/> <fmt:formatDate type="both" value="${auditDate}" dateStyle="long" timeStyle="medium"/>
                        </p>
                        <p id="error-loading-explanation"><fmt:message key="errorLoadingPage.explanation"/></p>
                        <ul>
                            <li><fmt:message key="errorLoadingPage.explanationPageDetail1"/></li>
                            <li><fmt:message key="errorLoadingPage.explanationPageDetail2"/></li>
                            <li><fmt:message key="errorLoadingPage.explanationPageDetail3"/></li>
                        </ul>
                        <div class="alert-actions">
                            <a href="<c:url value="/dispatch.html" />" class="btn small"><fmt:message key="accessDeniedPage.backToHome"/></a>
                        </div><!-- class="alert-actions"-->
                    </div><!-- class="alert-message block-message"-->
                </div><!-- class="span16" -->
            </div><!-- class="row" -->
            <div class="row">
                <div class="span16 main-logo">
                    <img src="<c:url value="/Images/error_loading.jpg"/>" alt=""/>
                </div><!-- class="span16 main-logo" -->
            </div><!-- class="row" -->
            <div class="row">
                <div class="span4 offset10">
                    <a title="Creative Commons Attribution 3.0 License" href="http://creativecommons.org/licenses/by/3.0/">
                        <img src="<c:url value="/Images/creative_common_logo.png"/>" alt="License"/>
                    </a>
                    <a title="Flickr: Galerie de ABC Archives" href="http://www.flickr.com/photos/abcarchives/">ABC Archives</a>
                </div><!-- class="span4 offset9" -->
            </div><!-- class="row" -->
        </div><!-- class="container" -->
       <%@include file="template/footer.jsp" %>
    </body>
</html>
