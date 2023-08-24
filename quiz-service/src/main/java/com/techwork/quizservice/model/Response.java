package com.techwork.quizservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Data class representing a user's response to a question.
 */
@Data
@RequiredArgsConstructor
public class Response {

    /** The unique identifier of the response. */
    private Integer id;

    /** The user's response to the question. */
    private String response;
}
