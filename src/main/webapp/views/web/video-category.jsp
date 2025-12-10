<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <title>Danh mục: ${cateName}</title>
</head>

<body>
    <div class="container mt-4 mb-5">
        <div class="d-flex align-items-center mb-4 border-bottom pb-2">
            <h2 class="text-uppercase text-danger fw-bold me-3">
                <i class="fa-solid fa-layer-group"></i> ${cateName}
            </h2>
            <span class="badge bg-secondary fs-6">${videos.size()} Video</span>
        </div>

        <c:if test="${empty videos}">
            <div class="alert alert-warning text-center">
                Chưa có video nào trong danh mục này.
            </div>
        </c:if>

        <div class="row row-cols-1 row-cols-md-3 row-cols-lg-4 g-4">
            <c:forEach items="${videos}" var="v">
                <div class="col">
                    <div class="card h-100 shadow-sm border-0 hover-card">
                        <div style="position: relative; overflow: hidden;">
                            <c:choose>
                                <c:when test="${not empty v.poster && v.poster.startsWith('http')}">
                                    <img src="${v.poster}" class="card-img-top" alt="${v.title}" style="height: 200px; object-fit: cover;">
                                </c:when>
                                <c:otherwise>
                                    <img src="<c:url value='/upload/video/${v.poster}'/>" class="card-img-top" alt="${v.title}" style="height: 200px; object-fit: cover;">
                                </c:otherwise>
                            </c:choose>
                            
                            <a href="<c:url value='/video/detail?id=${v.videoId}'/>" class="stretched-link">
                                <div class="play-overlay" style="position: absolute; top:0; left:0; width:100%; height:100%; background: rgba(0,0,0,0.3); opacity: 0; transition: 0.3s; display: flex; align-items: center; justify-content: center;">
                                    <i class="fa-solid fa-circle-play text-white fa-3x"></i>
                                </div>
                            </a>
                        </div>

                        <div class="card-body">
                            <h6 class="card-title fw-bold text-truncate" title="${v.title}">
                                <a href="<c:url value='/video/detail?id=${v.videoId}'/>" class="text-decoration-none text-dark">
                                    ${v.title}
                                </a>
                            </h6>
                            <div class="d-flex justify-content-between small text-muted">
                                <span><i class="fa-solid fa-eye"></i> ${v.views}</span>
                                <span><i class="fa-solid fa-thumbs-up"></i> Like</span>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <style>
        .hover-card:hover { transform: translateY(-5px); transition: 0.3s; }
        .hover-card:hover .play-overlay { opacity: 1 !important; }
    </style>
</body>