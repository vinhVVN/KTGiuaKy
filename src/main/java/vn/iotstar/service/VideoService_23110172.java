package vn.iotstar.service;

import java.util.List;

import vn.iotstar.entity.Video_23110172;

public interface VideoService_23110172 {
	List<Video_23110172> findAll();
    Video_23110172 findById(String id);
    void insert(Video_23110172 video);
    void update(Video_23110172 video);
    void delete(String id) throws Exception;
    List<Video_23110172> findByTitle(String keyword);
    List<Video_23110172> findAll(int page, int pageSize); // Phân trang
    int count(); // Đếm tổng video
    List<Video_23110172> findByCategoryId(int cateId); // Lọc theo danh mục
}
