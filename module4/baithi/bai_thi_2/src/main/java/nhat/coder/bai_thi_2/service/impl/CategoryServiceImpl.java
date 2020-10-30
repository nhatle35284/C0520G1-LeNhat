package nhat.coder.bai_thi_2.service.impl;

import nhat.coder.bai_thi_2.model.Category;
import nhat.coder.bai_thi_2.repository.CategoryRepository;
import nhat.coder.bai_thi_2.service.CategoryService;
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
