package com.techwork.questionservice.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author harsh_patel
 */
@Data
@Entity
public class Question {
    /**
     * The unique identifier for the question.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The category to which the question belongs.
     */
    private String category;

    /**
     * The difficulty level of the question.
     */
    @Column(name = "difficultylevel")
    private String difficultyLevel;

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
     * The title or text of the question.
     */
    @Column(name = "questiontitle")
    private String questionTitle;

    /**
     * The correct answer to the question.
     */
    @Column(name = "rightanswer")
    private String rightAnswer;
}
