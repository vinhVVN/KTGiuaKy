<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow px-4">

    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
        <i class="fa fa-bars"></i>
    </button>

    <a class="navbar-brand d-flex align-items-center justify-content-center" href="<c:url value='/admin/home'/>">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">IoTStar Admin</div>
    </a>

    <ul class="navbar-nav ms-auto">
        
        <div class="topbar-divider d-none d-sm-block"></div>

        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="me-2 d-none d-lg-inline text-gray-600 small">
                    Xin chào, <b>${sessionScope.account.fullname}</b>
                </span>
                <c:choose>
                    <c:when test="${not empty sessionScope.account.images}">
                        <img class="img-profile rounded-circle" src="<c:url value='/upload/user/${sessionScope.account.images}'/>" style="width: 32px; height: 32px; object-fit: cover;">
                    </c:when>
                    <c:otherwise>
                        <i class="fas fa-user-circle fa-2x text-gray-300"></i>
                    </c:otherwise>
                </c:choose>
            </a>
            
            <div class="dropdown-menu dropdown-menu-end shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="<c:url value='/admin/profile'/>">
                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                    Hồ sơ cá nhân
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<c:url value='/logout'/>">
                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                    Đăng xuất
                </a>
            </div>
        </li>
    </ul>
</nav>