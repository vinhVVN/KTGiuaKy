package vn.iotstar.configs;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.User;
import vn.iotstar.entity.Video;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.UserService;
import vn.iotstar.service.VideoService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.UserServiceImpl;
import vn.iotstar.service.impl.VideoServiceImpl;

import java.util.List;

@WebListener
public class StartUpListener implements ServletContextListener {

    // Khởi tạo các Service
    UserService userService = new UserServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    VideoService videoService = new VideoServiceImpl();

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            // Tạo tài khoản Admin mặc định (nếu chưa có)
            if (userService.get("admin") == null) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("123"); // Password mẫu
                admin.setFullname("Administrator");
                admin.setEmail("admin@iotstar.vn");
                admin.setPhone("0123456789");
                admin.setAdmin(true);
                admin.setActive(true);
                // admin.setImages("admin.png"); // Nếu muốn
                
                userService.insert(admin);
                System.out.println(">>> DATA SEEDING: Created Admin User (admin/123)");
            }

            // Tạo tài khoản User mẫu
            if (userService.get("user01") == null) {
                User user = new User();
                user.setUsername("user01");
                user.setPassword("123");
                user.setFullname("Nguyen Van A");
                user.setEmail("user01@gmail.com");
                user.setAdmin(false);
                user.setActive(true);
                
                userService.insert(user);
                System.out.println(">>> DATA SEEDING: Created Normal User (user01/123)");
            }

            // Tạo Danh mục mẫu (nếu danh sách rỗng)
            if (categoryService.findAll().isEmpty()) {
                Category c1 = new Category();
                c1.setCategoryName("Phim Hành Động");
                c1.setCategoryCode("ACTION");
                c1.setStatus(1);
                c1.setImages("https://via.placeholder.com/150");
                categoryService.insert(c1);

                Category c2 = new Category();
                c2.setCategoryName("Phim Hoạt Hình");
                c2.setCategoryCode("ANIME");
                c2.setStatus(1);
                c2.setImages("https://via.placeholder.com/150");
                categoryService.insert(c2);
                
                System.out.println(">>> DATA SEEDING: Created Categories");
            }

            // Tạo Video mẫu (nếu danh sách rỗng)
            if (videoService.findAll().isEmpty()) {
                // Lấy danh mục vừa tạo để gán
                List<Category> categories = categoryService.findAll();
                if (!categories.isEmpty()) {
                    Video v1 = new Video();
                    v1.setVideoId("V001");
                    v1.setTitle("Avengers: Endgame");
                    v1.setDescription("Marvel Studios");
                    v1.setViews(1000);
                    v1.setActive(true);
                    v1.setPoster("https://via.placeholder.com/300x200");
                    v1.setCategory(categories.get(0)); // Gán danh mục đầu tiên
                    videoService.insert(v1);
                    
                    System.out.println(">>> DATA SEEDING: Created Sample Video");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(">>> DATA SEEDING ERROR: " + e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Code chạy khi server tắt (nếu cần đóng kết nối resource)
    }
}