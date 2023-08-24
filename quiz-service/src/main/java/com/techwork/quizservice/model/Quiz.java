package com.techwork.quizservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Entity class representing a quiz containing questions.
 */
@Entity
@Data
public class Quiz {

    /** The unique identifier of the quiz. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** The title of the quiz. */
    private String title;

    /** The list of IDs of questions associated with the quiz. */
    @ElementCollection
    private List<Integer> questionIds;
}
