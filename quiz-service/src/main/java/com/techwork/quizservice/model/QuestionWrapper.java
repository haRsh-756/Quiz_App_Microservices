package com.techwork.quizservice.model;

import lombok.Data;

/**
 * Data class representing a question and its options.
 */
@Data
public class QuestionWrapper {

    /** The unique identifier of the question. */
    private Integer id;

    /** The title or content of the question. */
    private String questionTitle;

    /** The first option for the question. */
    private String option1;

    /** The second option for the question. */
    private String option2;

    /** The third option for the question. */
    private String option3;

    /** The fourth option for the question. */
    private String option4;

    /**
     * Constructor to initialize a QuestionWrapper object with provided details.
     *
     * @param id The unique identifier of the question.
     * @param questionTitle The title or content of the question.
     * @param option1 The first option for the question.
     * @param option2 The second option for the question.
     * @param option3 The third option for the question.
     * @param option4 The fourth option for the question.
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
