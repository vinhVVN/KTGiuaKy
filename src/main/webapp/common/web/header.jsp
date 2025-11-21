<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<nav class="navbar navbar-expand-lg navbar-dark fixed-top" 
     style="z-index: 9999; background: linear-gradient(to bottom, rgba(0,0,0,0.8) 0%, transparent 100%); transition: 0.5s;">
    
    <div class="container-fluid px-5">
        <a class="navbar-brand fw-bold text-danger fs-3" href="<c:url value='/home'/>">IOTSTAR</a>
        
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link active fw-bold" href="<c:url value='/home'/>">Trang chủ</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Phim bộ</a></li>
            </ul>
            
            <ul class="navbar-nav ms-auto align-items-center">
                <li class="nav-item me-3">
                    <a class="nav-link" href="#"><i class="fa-solid fa-magnifying-glass"></i></a>
                </li>

                <c:if test="${sessionScope.account == null}">
                    <li class="nav-item">
                        <a class="btn btn-danger btn-sm fw-bold px-3" href="<c:url value='/login'/>">Đăng nhập</a>
                    </li>
                </c:if>
                
                <c:if test="${sessionScope.account != null}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle d-flex align-items-center" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown">
                            <c:choose>
                                <c:when test="${not empty sessionScope.account.images}">
                                    <img src="<c:url value='/upload/user/${sessionScope.account.images}'/>" class="rounded" style="width: 32px; height: 32px; object-fit: cover;">
                                </c:when>
                                <c:otherwise>
                                    <img src="https://upload.wikimedia.org/wikipedia/commons/0/0b/Netflix-avatar.png" class="rounded" style="width: 32px; height: 32px;">
                                </c:otherwise>
                            </c:choose>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end bg-dark border-secondary mt-2">
                            <li><a class="dropdown-item text-light" href="<c:url value='/user/profile'/>">Hồ sơ</a></li>
                            <li><hr class="dropdown-divider bg-secondary"></li>
                            <li><a class="dropdown-item text-danger" href="<c:url value='/logout'/>">Đăng xuất</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>