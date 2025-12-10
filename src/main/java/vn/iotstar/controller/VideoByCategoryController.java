package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Video;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.VideoService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.VideoServiceImpl;

@WebServlet("/video/category")
public class VideoByCategoryController extends HttpServlet {
    VideoService videoService = new VideoServiceImpl();
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cateId = Integer.parseInt(req.getParameter("id"));
        
        List<Video> videos = videoService.findByCategoryId(cateId);
        Category category = cateService.findById(cateId);
        
        req.setAttribute("videos", videos);
        req.setAttribute("cateName", category.getCategoryName());
        
        req.getRequestDispatcher("/views/web/video-category.jsp").forward(req, resp);
    }
}
