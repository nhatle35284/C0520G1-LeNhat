package nhat.coder.model;

import javax.persistence.*;

@Entity
@Table
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int mark;
    private String author;
    private String feedback;
    private Long like;

    public Test(int id, int mark, String author, String feedback, Long like) {
        this.id = id;
        this.mark = mark;
        this.author = author;
        this.feedback = feedback;
        this.like = like;
    }

    public Test() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }
}
