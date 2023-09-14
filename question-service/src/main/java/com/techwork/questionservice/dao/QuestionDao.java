package com.techwork.questionservice.dao;

import com.techwork.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author harsh_patel
 * Spring Data JPA repository for managing Question entities.
 */
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    /**
     * Retrieve a list of questions by their category.
     * @param category The category by which to filter questions.
     * @return A list of Question objects matching the specified category.
     */
    List<Question> findByCategory(String category);

    /**
     * Retrieve a list of random question IDs from a specific category.
     * @param category The category from which to select random questions.
     * @param numQ     The number of random question IDs to retrieve.
     * @return A list of random question IDs from the specified category.
     */
    @Query(value = "SELECT q.id FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, int numQ);
}