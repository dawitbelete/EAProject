package edu.mum.service;

import java.util.List;

import edu.mum.domain.Category;

public interface CategoryService {
	public void save(Category category);

	public Category update(Category category);

	public List<Category> findAll();

	public Category findOne(Long id);

	public void delete(Long id);
}
