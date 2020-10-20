package nhat.coder.bai_thi_thuc_hanh.service.impl;

import nhat.coder.bai_thi_thuc_hanh.model.QuestionType;
import nhat.coder.bai_thi_thuc_hanh.repository.QuestionRepository;
import nhat.coder.bai_thi_thuc_hanh.repository.QuestionTypeRepository;
import nhat.coder.bai_thi_thuc_hanh.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
