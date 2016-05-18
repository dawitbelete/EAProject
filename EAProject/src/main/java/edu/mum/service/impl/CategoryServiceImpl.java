package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.CategoryDao;
import edu.mum.domain.Category;
import edu.mum.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	public void save(Category category) {
		categoryDao.save(category);
	}

	public Category update(Category category) {
		return categoryDao.update(category);
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public Category findOne(Long id) {
		return categoryDao.findOne(id);
	}

	public void delete(Long id) {
		categoryDao.delete(id);

	}

}
