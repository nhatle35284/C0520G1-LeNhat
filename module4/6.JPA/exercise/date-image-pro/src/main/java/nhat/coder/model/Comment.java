package nhat.coder.model;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int mark;
    private String author;
    private String feedback;
    private int likes;

    public Comment() {
    }

    public Comment(int mark, String author, String feedback, int likes) {
        this.mark = mark;
        this.author = author;
        this.feedback = feedback;
        this.likes = likes;
    }

    public Comment(int id, int mark, String author, String feedback, int likes) {
        this.id = id;
        this.mark = mark;
        this.author = author;
        this.feedback = feedback;
        this.likes = likes;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
