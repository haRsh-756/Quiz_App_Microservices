package com.techwork.quizservice.model;

import lombok.Data;

/**
 * Data transfer object (DTO) class representing quiz details for quiz creation.
 */
@Data
public class QuizDto {

    /** The category name of the quiz. */
    String categoryName;

    /** The number of questions in the quiz. */
    Integer numQuestions;

    /** The title of the quiz. */
    String title;
}
