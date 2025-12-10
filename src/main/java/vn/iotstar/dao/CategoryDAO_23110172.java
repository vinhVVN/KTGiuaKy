package vn.iotstar.dao;

import vn.iotstar.entity.Category_23110172;
import java.util.List;

public interface CategoryDAO_23110172 {
	List<Category_23110172> findAll();
    Category_23110172 findById(int id);
    void insert(Category_23110172 category);
    void update(Category_23110172 category);
    void delete(int id) throws Exception;
    List<Category_23110172> findByName(String keyword);
    List<Category_23110172> findAllWithVideos();
}
