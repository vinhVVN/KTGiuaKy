package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.dao.VideoDAO;
import vn.iotstar.entity.Video;

public class VideoDAOImpl implements VideoDAO{
	
	
	
	@Override
	public List<Video> findAll() {
		EntityManager entityManager = JPAConfig.getEnityManager();
		String jpql = "SELECT v FROM Video v";
        TypedQuery<Video> query = entityManager.createQuery(jpql, Video.class);
        return query.getResultList();
	}

	@Override
	public Video findById(String id) {
		EntityManager entityManager = JPAConfig.getEnityManager();
		return entityManager.find(Video.class, id);
	}

	@Override
	public void insert(Video video) {
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
	public void update(Video video) {
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
		Video video = findById(id);
        if (video != null) {
            entityManager.remove(video);
        } else {
            throw new Exception("Không tìm thấy Video để xóa");
        }
		
	}

	@Override
	public List<Video> findByTitle(String keyword) {
		EntityManager entityManager = JPAConfig.getEnityManager();
		String jpql = "SELECT v FROM Video v WHERE v.title LIKE :keyword";
        TypedQuery<Video> query = entityManager.createQuery(jpql, Video.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
	}

}
