package com.techwork.questionservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author harsh_patel
 * Represents a response to a question in a quiz.
 */
@Data // Lombok annotation to generate getters, setters, and other common methods.
@RequiredArgsConstructor // Lombok annotation to generate a constructor for required fields.
public class Response {
    /**
     * The unique identifier for the question to which this response corresponds.
     */
    private Integer id;

    /**
     * The response provided for the question.
     */
    private String response;
}

