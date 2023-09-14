package com.techwork.questionservice.controller;

import com.techwork.questionservice.model.Question;
import com.techwork.questionservice.model.QuestionWrapper;
import com.techwork.questionservice.model.Response;
import com.techwork.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author harsh_patel
 * Controller class for managing questions.
 */
@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    /**
     * Retrieve all questions available in the system.
     * @return A ResponseEntity containing a list of Question objects.
     */
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    /**
     * Retrieve questions by a specified category.
     * @param category The category by which to filter questions.
     * @return A ResponseEntity containing a list of Question objects.
     */
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    /**
     * Add a new question to the system.
     * @param question The Question object to be added.
     * @return A ResponseEntity with a message indicating the success or failure of the operation.
     */
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    /**
     * Delete a question from the system.
     * @param question The Question object to be deleted.
     * @return A ResponseEntity with a message indicating the success or failure of the operation.
     */
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteQuestion(@RequestBody Question question) {
        return questionService.deleteQuestion(question);
    }

    /**
     * Delete a question by its unique ID.
     * @param id The ID of the question to be deleted.
     * @return A ResponseEntity with a message indicating the success or failure of the operation.
     */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }

    /**
     * Generate a set of quiz questions based on a specified category and number of questions.
     * @param categoryName The name of the quiz category.
     * @param numQuestion  The number of questions to include in the quiz.
     * @return A ResponseEntity containing a list of generated question IDs.
     */
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestion) {
        return questionService.getQuestionForQuiz(categoryName, numQuestion);
    }

    /**
     * Retrieve a list of questions based on their IDs.
     * @param questionIds A list of question IDs to retrieve.
     * @return A ResponseEntity containing a list of QuestionWrapper objects.
     */
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(questionIds);
    }

    /**
     * Calculate the score for a set of quiz responses.
     * @param responses A list of Response objects representing user responses.
     * @return A ResponseEntity containing the calculated score as an integer.
     */
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
        return questionService.getScore(responses);
    }
}
