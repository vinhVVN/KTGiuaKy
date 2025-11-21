<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title><sitemesh:write property="title"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <sitemesh:write property="head"/>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="#">IoTStar User</a>
            <div class="collapse navbar-collapse justify-content-end">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/user/profile'/>">Hồ sơ</a></li>
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/logout'/>">Đăng xuất</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-4" style="min-height: 80vh;">
        <sitemesh:write property="body"/>
    </div>

    <footer class="bg-light text-center py-3 mt-4">
        <p class="mb-0">© 2025 IoTStar Project</p>
    </footer>
</body>
</html>