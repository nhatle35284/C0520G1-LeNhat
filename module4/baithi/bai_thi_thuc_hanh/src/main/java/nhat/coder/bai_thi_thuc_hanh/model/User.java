package nhat.coder.bai_thi_thuc_hanh.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private Long userName;

}
