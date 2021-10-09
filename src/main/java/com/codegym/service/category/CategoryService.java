package com.codegym.service.category;

import com.codegym.dao.DBConnection;
import com.codegym.dao.category.CategoryDAO;
import com.codegym.dao.category.ICategoryDAO;
import com.codegym.model.Category;

import java.util.List;

public class CategoryService implements ICategoryService{

    private static final ICategoryDAO CATEGORY_DAO = new CategoryDAO();

    @Override
    public List<Category> getAll() {
        return CATEGORY_DAO.getAll();
    }

    @Override
    public boolean save(Category category) {
        return CATEGORY_DAO.save(category);
    }

    @Override
    public boolean update(int id, Category category) {
        return CATEGORY_DAO.update(id, category);
    }

    @Override
    public boolean delete(int id) {
        return CATEGORY_DAO.delete(id);
    }

    @Override
    public Category findById(int id) {
        return CATEGORY_DAO.findById(id);
    }
}