package nhat.coder.bai_thi_thuc_hanh.service;

import nhat.coder.bai_thi_thuc_hanh.model.Question;
import nhat.coder.bai_thi_thuc_hanh.model.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionTypeService {
    List<QuestionType> findAll();
}
