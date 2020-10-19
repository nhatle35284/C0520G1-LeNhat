package nhat.coder.baithi.service.impl;

import nhat.coder.baithi.model.Category;
import nhat.coder.baithi.model.Product;
import nhat.coder.baithi.repository.CategoryRepository;
import nhat.coder.baithi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
