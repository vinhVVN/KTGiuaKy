package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.CategoryDAO_23110172;
import vn.iotstar.dao.impl.CategoryDAOImpl_23110172;
import vn.iotstar.entity.Category_23110172;
import vn.iotstar.service.CategoryService_23110172;

public class CategoryServiceImpl_23110172 implements CategoryService_23110172{
	
	CategoryDAO_23110172 cateDAO = new CategoryDAOImpl_23110172();
	
	@Override
	public void insert(Category_23110172 category) {
		cateDAO.insert(category);
	}

	@Override
	public void update(Category_23110172 newCategory) {
		cateDAO.update(newCategory);
		
	}

	@Override
	public void delete(int id) throws Exception {
		cateDAO.delete(id);
		
	}

	@Override
	public Category_23110172 findById(int id) {
		return cateDAO.findById(id);
	}

	@Override
	public List<Category_23110172> findByName(String name) {
		return cateDAO.findByName(name);
	}

	@Override
	public List<Category_23110172> findAll() {
		return cateDAO.findAll();
	}

	@Override
	public List<Category_23110172> findAllWithVideos() {
		return cateDAO.findAllWithVideos();
	}

	
}
