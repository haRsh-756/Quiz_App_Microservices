package com.techwork.quizservice.controller;

import com.techwork.quizservice.model.QuestionWrapper;
import com.techwork.quizservice.model.QuizDto;
import com.techwork.quizservice.model.Response;
import com.techwork.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author harsh_patel
 * Controller class responsible for handling HTTP requests related to quizzes.
 */
@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    /**
     * Creates a new quiz based on the provided QuizDto.
     *
     * @param quizDto The QuizDto containing quiz details.
     * @return A ResponseEntity indicating the result of the quiz creation.
     */
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestions(), quizDto.getTitle());
    }

    /**
     * Retrieves the list of questions for a specific quiz.
     *
     * @param id The ID of the quiz.
     * @return A ResponseEntity containing a list of QuestionWrapper objects representing quiz questions.
     */
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    /**
     * Submits user responses for a specific quiz and calculates the quiz result.
     *
     * @param id The ID of the quiz.
     * @param responses The list of user responses.
     * @return A ResponseEntity containing the calculated quiz result.
     */
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
