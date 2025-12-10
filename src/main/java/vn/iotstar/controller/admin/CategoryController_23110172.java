package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.Category;
import vn.iotstar.service.CategoryService_23110172;
import vn.iotstar.service.impl.CategoryServiceImpl_23110172;

@WebServlet(urlPatterns = {"/admin/category/list"})
public class CategoryController_23110172 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CategoryService_23110172 cateService = new CategoryServiceImpl_23110172();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lấy danh sách từ Service
        List<Category> list = cateService.findAll();
        
        // Đẩy dữ liệu ra view
        req.setAttribute("categories", list);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-category.jsp");
        dispatcher.forward(req, resp);
		
	}
}
