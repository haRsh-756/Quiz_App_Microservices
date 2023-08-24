package com.techwork.quizservice.feign;

import com.techwork.quizservice.model.QuestionWrapper;
import com.techwork.quizservice.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Feign client interface for interacting with the QUESTION-SERVICE.
 */
@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    /**
     * Retrieves a list of question IDs for quiz creation.
     *
     * @param categoryName The category name for quiz questions.
     * @param numQuestion The number of questions to retrieve.
     * @return A ResponseEntity containing the list of question IDs.
     */
    @GetMapping("question/generate")
    ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestion);

    /**
     * Retrieves a list of QuestionWrapper objects based on provided question IDs.
     *
     * @param questionIds The list of question IDs to retrieve questions for.
     * @return A ResponseEntity containing the list of QuestionWrapper objects.
     */
    @PostMapping("question/getQuestions")
    ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    /**
     * Calculates and retrieves the quiz score based on user responses.
     *
     * @param responses The list of user responses.
     * @return A ResponseEntity containing the calculated quiz score.
     */
    @PostMapping("question/getScore")
    ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
