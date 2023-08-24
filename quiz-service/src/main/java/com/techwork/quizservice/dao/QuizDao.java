package com.techwork.quizservice.dao;

import com.techwork.quizservice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Data Access Object (DAO) interface for Quiz entities.
 * Extends JpaRepository to provide CRUD operations for Quiz objects.
 */
@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
