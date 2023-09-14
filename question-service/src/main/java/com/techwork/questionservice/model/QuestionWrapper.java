package com.techwork.questionservice.model;

import lombok.Data;

/**
 * @author harsh_patel
 * A wrapper class used to represent simplified question data.
 */
@Data // Lombok annotation to generate getters, setters, and other common methods.
public class QuestionWrapper {
    /**
     * The unique identifier for the question.
     */
    private Integer id;

    /**
     * The title or text of the question.
     */
    private String questionTitle;

    /**
     * The first option for the question.
     */
    private String option1;

    /**
     * The second option for the question.
     */
    private String option2;

    /**
     * The third option for the question.
     */
    private String option3;

    /**
     * The fourth option for the question.
     */
    private String option4;

    /**
     * Constructs a new instance of the {@code QuestionWrapper} class with the specified data.
     * @param id            The unique identifier for the question.
     * @param questionTitle The title or text of the question.
     * @param option1       The first option for the question.
     * @param option2       The second option for the question.
     * @param option3       The third option for the question.
     * @param option4       The fourth option for the question.
     */
    public QuestionWrapper(Integer id, String questionTitle, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}

