<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<head>
    <title>Trang chủ - IoTStar Cinema</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
    <style>
        /* Cấu hình màu sắc chủ đạo */
        :root {
            --netflix-bg: #141414;
            --netflix-red: #e50914;
            --netflix-hover: #181818;
            --text-white: #ffffff;
            --text-gray: #b3b3b3;
        }

        body {
            background-color: var(--netflix-bg);
            color: var(--text-white);
            font-family: 'Roboto', sans-serif;
            overflow-x: hidden;
        }

        /* Hero Section */
        .hero-section {
            position: relative;
            height: 90vh; /* Chiều cao banner phim */
            width: 100%;
            background-size: cover;
            background-position: center center;
            display: flex;
            align-items: center;
            /* Header đã fixed-top nên không cần margin âm nữa, 
               nhưng nếu bị hở trắng thì thêm top:0 */
            top: 0; 
            left: 0;
        }
        
        /* Lớp phủ tối để chữ dễ đọc hơn */
        .hero-overlay {
            position: absolute;
            top: 0; left: 0; right: 0; bottom: 0;
            background: linear-gradient(to top, #141414 5%, transparent 95%),
                        linear-gradient(to bottom, rgba(0,0,0,0.4) 0%, transparent 30%);
            z-index: 1;
        }

        .hero-content {
            position: relative;
            z-index: 2; /* Chữ phải nổi lên trên lớp phủ */
            padding-left: 50px;
            padding-top: 100px; /* Đẩy chữ xuống một chút cho cân */
            max-width: 600px;
        }

        .hero-title {
            font-size: 3.5rem;
            font-weight: 800;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.5);
            margin-bottom: 1rem;
        }

        .hero-desc {
            font-size: 1.2rem;
            color: #e5e5e5;
            margin-bottom: 2rem;
            display: -webkit-box;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;
            overflow: hidden;
        }

        .btn-hero {
            padding: 0.8rem 2rem;
            font-size: 1.2rem;
            border-radius: 4px;
            font-weight: bold;
            border: none;
            transition: all 0.2s;
        }

        .btn-play {
            background-color: var(--text-white);
            color: black;
        }
        .btn-play:hover { background-color: rgba(255,255,255,0.75); }

        .btn-info {
            background-color: rgba(109, 109, 110, 0.7);
            color: white;
            margin-left: 10px;
        }
        .btn-info:hover { background-color: rgba(109, 109, 110, 0.4); color: white; }

        /* Movie List Section */
        .movie-section {
            padding: 20px 5%;
            margin-bottom: 40px;
        }

        .section-title {
            font-size: 1.5rem;
            font-weight: 600;
            margin-bottom: 15px;
            color: #e5e5e5;
            border-left: 4px solid var(--netflix-red);
            padding-left: 10px;
        }

        /* Movie Card */
        .movie-card {
            position: relative;
            border-radius: 4px;
            overflow: hidden;
            cursor: pointer;
            transition: transform 0.3s ease, z-index 0.3s;
            background-color: #2f2f2f;
            height: 100%;
        }

        .movie-card:hover {
            transform: scale(1.05);
            z-index: 10;
            box-shadow: 0 10px 20px rgba(0,0,0,0.5);
        }

        .movie-poster {
            width: 100%;
            aspect-ratio: 2/3; /* Tỉ lệ poster chuẩn */
            object-fit: cover;
        }

        .movie-info {
            padding: 10px;
            background: #181818;
        }

        .movie-title {
            font-size: 1rem;
            font-weight: bold;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            margin-bottom: 5px;
        }

        .movie-meta {
            font-size: 0.8rem;
            color: var(--text-gray);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .badge-hd {
            border: 1px solid var(--text-gray);
            border-radius: 3px;
            padding: 0 4px;
            font-size: 0.7rem;
        }
    </style>
</head>

<body>

    <c:if test="${not empty featuredVideo}">
        <div class="hero-section" 
             style="background-image: url('<c:url value='/upload/video/${featuredVideo.poster}'/>');">
            <div class="hero-overlay"></div>
            <div class="hero-content">
                <h1 class="hero-title">${featuredVideo.title}</h1>
                <p class="hero-desc">${featuredVideo.description}</p>
                <div class="d-flex">
                    <a href="#" class="btn btn-hero btn-play">
                        <i class="fa-solid fa-play me-2"></i> Phát ngay
                    </a>
                    <a href="#" class="btn btn-hero btn-info">
                        <i class="fa-solid fa-circle-info me-2"></i> Chi tiết
                    </a>
                </div>
            </div>
        </div>
    </c:if>

    <div class="movie-section">
        <h3 class="section-title">Danh sách phim mới</h3>
        
        <div class="row row-cols-2 row-cols-md-4 row-cols-lg-5 g-4">
            <c:forEach items="${listVideo}" var="video">
                <div class="col">
                    <div class="movie-card">
                        <c:choose>
                            <c:when test="${fn:startsWith(video.poster, 'http')}">
                                <img src="${video.poster}" class="movie-poster" alt="${video.title}">
                            </c:when>
                            <c:otherwise>
                                <img src="<c:url value='/upload/video/${video.poster}'/>" class="movie-poster" alt="${video.title}">
                            </c:otherwise>
                        </c:choose>

                        <div class="movie-info">
                            <div class="movie-title">${video.title}</div>
                            <div class="movie-meta">
                                <span><i class="fa-solid fa-eye text-success me-1"></i> ${video.views} lượt xem</span>
                                <span class="badge-hd">HD</span>
                            </div>
                            <div class="mt-2 d-grid">
                                <a href="#" class="btn btn-sm btn-outline-light rounded-pill">Xem ngay</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <c:if test="${empty featuredVideo && empty listVideo}">
        <div class="container text-center py-5">
            <h3 class="text-white">Chưa có bộ phim nào được cập nhật.</h3>
        </div>
    </c:if>

</body>