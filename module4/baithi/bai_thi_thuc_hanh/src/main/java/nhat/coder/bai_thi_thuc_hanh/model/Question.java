package nhat.coder.bai_thi_thuc_hanh.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idQuestion;

    @Size(min = 5,max = 100,message = "5 to 100 key")
    private String title;
    @Size(min = 10,max = 500,message = "10 to 500 key")
    private String questionContext;
    private String answer;
    private String dateCreate;
    private String Status;
    private String userCreate;
    private String userFeedback;
    @ManyToOne()
    @JoinColumn(name = "id")
    private QuestionType questionType;

    public Question() {
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestionContext() {
        return questionContext;
    }

    public void setQuestionContext(String question) {
        this.questionContext = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public QuestionType getQuestionType() {

        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(String userFeedback) {
        this.userFeedback = userFeedback;
    }
}
