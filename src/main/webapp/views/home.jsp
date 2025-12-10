<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <title>Trang chủ</title>
</head>

<body>
    <c:if test="${not empty featuredVideo}">
        <section class="bg-dark text-white py-5 mb-4" 
                 style="background: linear-gradient(rgba(0,0,0,0.7), rgba(0,0,0,0.7)), url('<c:url value='/upload/video/${featuredVideo.poster}'/>'); background-size: cover; background-position: center;">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-8">
                        <h1 class="display-4 fw-bold">${featuredVideo.title}</h1>
                        <p class="lead">${featuredVideo.description}</p>
                        <a href="<c:url value='/video/detail?id=${featuredVideo.videoId}'/>" class="btn btn-danger btn-lg">
                            <i class="fa-solid fa-play"></i> Xem Ngay
                        </a>
                    </div>
                </div>
            </div>
        </section>
    </c:if>

    <div class="container mb-5">
        <h3 class="border-start border-4 border-danger ps-2 mb-4">Phim Mới Cập Nhật</h3>
        
        <div class="row row-cols-2 row-cols-md-4 row-cols-lg-5 g-3">
            <c:forEach items="${listVideo}" var="video">
                <div class="col">
                    <div class="card h-100 border-0 shadow-sm video-card">
                        <a href="<c:url value='/video/detail?id=${video.videoId}'/>" class="position-relative">
                            <c:choose>
                                <c:when test="${not empty video.poster && video.poster.startsWith('http')}">
                                    <img src="${video.poster}" class="card-img-top rounded" style="aspect-ratio: 2/3; object-fit: cover;">
                                </c:when>
                                <c:otherwise>
                                    <img src="<c:url value='/upload/video/${video.poster}'/>" class="card-img-top rounded" style="aspect-ratio: 2/3; object-fit: cover;">
                                </c:otherwise>
                            </c:choose>
                            <div class="play-icon text-white position-absolute top-50 start-50 translate-middle" style="opacity: 0.8; display: none;">
                                <i class="fa-regular fa-circle-play fa-3x"></i>
                            </div>
                        </a>
                        
                        <div class="card-body p-2">
                            <h6 class="card-title text-truncate mb-1">
                                <a href="<c:url value='/video/detail?id=${video.videoId}'/>" class="text-decoration-none text-dark fw-bold">
                                    ${video.title}
                                </a>
                            </h6>
                            <div class="d-flex justify-content-between small text-muted">
                                <span><i class="fa-solid fa-eye"></i> ${video.views}</span>
                                <span><i class="fa-solid fa-thumbs-up"></i> Like</span>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <style>
        .video-card:hover { transform: translateY(-5px); transition: 0.3s; }
        .video-card:hover .play-icon { display: block !important; }
    </style>
</body>