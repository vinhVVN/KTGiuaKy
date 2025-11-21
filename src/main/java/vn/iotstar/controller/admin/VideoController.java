package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.Video;
import vn.iotstar.service.VideoService;
import vn.iotstar.service.impl.VideoServiceImpl;

@WebServlet(urlPatterns = {"/admin/video/list"})
public class VideoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    VideoService videoService = new VideoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String keyword = req.getParameter("keyword");
        List<Video> list;
        
    	
        if (keyword != null && !keyword.trim().isEmpty()) {
            // Gọi hàm tìm kiếm đã có trong Service
            list = videoService.findByTitle(keyword);
        } else {
            // Nếu không tìm kiếm thì lấy tất cả
            list = videoService.findAll();
            keyword = ""; // Reset để tránh null khi hiển thị lại view
        }
        
        req.setAttribute("videos", list);
        req.setAttribute("keyword", keyword);
        req.getRequestDispatcher("/views/admin/list-video.jsp").forward(req, resp);
    }
}
