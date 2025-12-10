package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.Video_23110172;
import vn.iotstar.service.VideoService_23110172;
import vn.iotstar.service.impl.VideoServiceImpl_23110172;

@WebServlet("/video/detail")
public class VideoDetailController_23110172 extends HttpServlet {
    VideoService_23110172 videoService = new VideoServiceImpl_23110172();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Video_23110172 video = videoService.findById(id);
            
            // Tăng view
            video.setViews(video.getViews() + 1);
            videoService.update(video);

            req.setAttribute("video", video);
            
            // Đếm like/share (size của list)
            req.setAttribute("likeCount", video.getFavorites().size());
            req.setAttribute("shareCount", video.getShares().size());

            req.getRequestDispatcher("/views/web/video-detail.jsp").forward(req, resp);
        }
    }
}
