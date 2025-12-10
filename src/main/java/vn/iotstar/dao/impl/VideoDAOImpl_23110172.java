package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.dao.VideoDAO_23110172;
import vn.iotstar.entity.Video_23110172;

public class VideoDAOImpl_23110172 implements VideoDAO_23110172{
	
	
	
	@Override
	public List<Video_23110172> findAll() {
		EntityManager entityManager = JPAConfig.getEnityManager();
		String jpql = "SELECT v FROM Video v";
        TypedQuery<Video_23110172> query = entityManager.createQuery(jpql, Video_23110172.class);
        return query.getResultList();
	}

	@Override
	public Video_23110172 findById(String id) {
		EntityManager entityManager = JPAConfig.getEnityManager();
		return entityManager.find(Video_23110172.class, id);
	}

	@Override
	public void insert(Video_23110172 video) {
		EntityManager enma = JPAConfig.getEnityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(video);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			enma.close();
		}
		
	}

	@Override
	public void update(Video_23110172 video) {
		EntityManager enma = JPAConfig.getEnityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(video);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			enma.close();
		}
		
	}

	@Override
	public void delete(String id) throws Exception {
		EntityManager entityManager = JPAConfig.getEnityManager();
		Video_23110172 video = findById(id);
        if (video != null) {
            entityManager.remove(video);
        } else {
            throw new Exception("Không tìm thấy Video để xóa");
        }
		
	}

	@Override
	public List<Video_23110172> findByTitle(String keyword) {
		EntityManager entityManager = JPAConfig.getEnityManager();
		String jpql = "SELECT v FROM Video v WHERE v.title LIKE :keyword";
        TypedQuery<Video_23110172> query = entityManager.createQuery(jpql, Video_23110172.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
	}

	@Override
	public List<Video_23110172> findAll(int page, int pageSize) {
		EntityManager enma = JPAConfig.getEnityManager();
	    TypedQuery<Video_23110172> query = enma.createQuery("SELECT v FROM Video v", Video_23110172.class);
	    query.setFirstResult((page - 1) * pageSize);
	    query.setMaxResults(pageSize);
	    return query.getResultList();
	}

	@Override
	public int count() {
		EntityManager enma = JPAConfig.getEnityManager();
	    String jpql = "SELECT count(v) FROM Video v";
	    Query query = enma.createQuery(jpql);
	    return ((Long) query.getSingleResult()).intValue();
	}

	@Override
	public List<Video_23110172> findByCategoryId(int cateId) {
		EntityManager enma = JPAConfig.getEnityManager();
	    try {
	        String jpql = "SELECT v FROM Video v WHERE v.category.categoryId = :cateId";
	        TypedQuery<Video_23110172> query = enma.createQuery(jpql, Video_23110172.class);
	        query.setParameter("cateId", cateId);
	        List<Video_23110172> list = query.getResultList();
	        
	        // --- ĐOẠN CODE FIX LỖI LAZY ---
	        for (Video_23110172 v : list) {
	            // Ép tải danh sách Share và Favorite
	            v.getShares().size();
	            v.getFavorites().size();
	        }
	        // ------------------------------
	        
	        return list;
	    } finally {
	        enma.close();
	    }
	}

}
