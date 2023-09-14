package com.techwork.questionservice.service;

import com.techwork.questionservice.dao.QuestionDao;
import com.techwork.questionservice.model.Question;
import com.techwork.questionservice.model.QuestionWrapper;
import com.techwork.questionservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author harsh_patel
 * Service class for managing questions and quiz-related operations.
 */
@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    /**
     * Retrieve all questions from the database.
     * @return A ResponseEntity containing a list of Question objects.
     */
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Retrieve questions by a specified category.
     * @param category The category by which to filter questions.
     * @return A ResponseEntity containing a list of Question objects.
     */
    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Add a new question to the database.
     * @param question The Question object to be added.
     * @return A ResponseEntity with a message indicating the success or failure of the operation.
     */
    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("successfully added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Delete a question from the database.
     * @param question The Question object to be deleted.
     * @return A ResponseEntity with a message indicating the success or failure of the operation.
     */
    public ResponseEntity<String> deleteQuestion(Question question) {
        try {
            questionDao.delete(question);
            return new ResponseEntity<>("successfully deleted", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a question by its unique ID.
     * @param id The ID of the question to be deleted.
     * @return A ResponseEntity with a message indicating the success or failure of the operation.
     */
    public ResponseEntity<String> deleteQuestion(Integer id) {
        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>("successfully deleted " + id + "th question", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Generate a set of quiz questions based on a specified category and number of questions.
     * @param categoryName The name of the quiz category.
     * @param numQuestion  The number of questions to include in the quiz.
     * @return A ResponseEntity containing a list of generated question IDs.
     */
    public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer numQuestion) {
        List<Integer> questions = questionDao.findRandomQuestionByCategory(categoryName, numQuestion);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    /**
     * Retrieve a list of questions based on their IDs.
     * @param questionIds A list of question IDs to retrieve.
     * @return A ResponseEntity containing a list of QuestionWrapper objects.
     */
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        for (Integer id : questionIds) {
            questions.add(questionDao.findById(id).get());
        }

        for (Question question : questions) {
            QuestionWrapper wrapper = new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(),
                    question.getOption2(), question.getOption3(), question.getOption4());
            wrappers.add(wrapper);
        }
        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    /**
     * Calculate the score for a set of quiz responses.
     * @param responses A list of Response objects representing user responses.
     * @return A ResponseEntity containing the calculated score as an integer.
     */
    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int correct = 0;
        for (Response response : responses) {
            Question question = questionDao.findById(response.getId()).get();
            if (response.getResponse().equals(question.getRightAnswer()))
                correct++;
        }
        return new ResponseEntity<>(correct, HttpStatus.OK);
    }
}