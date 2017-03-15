package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.entity.Category;
import system.repository.CategoryRepository;

import java.util.List;

@Service("categoryService")
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findOne(Integer category_id) {
        return categoryRepository.findOne(category_id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void delete(Integer category_id) {
        categoryRepository.delete(category_id);
    }
}
