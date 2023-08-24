package com.techwork.quizservice.service;

import com.techwork.quizservice.dao.QuizDao;
import com.techwork.quizservice.feign.QuizInterface;
import com.techwork.quizservice.model.QuestionWrapper;
import com.techwork.quizservice.model.Quiz;
import com.techwork.quizservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class responsible for handling quiz-related business logic.
 */
@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuizInterface quizInterface;

    /**
     * Creates a new quiz based on provided parameters.
     *
     * @param category The category of the quiz.
     * @param numQ The number of questions in the quiz.
     * @param title The title of the quiz.
     * @return A ResponseEntity indicating the result of the quiz creation.
     */
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions = quizInterface.getQuestionForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    /**
     * Retrieves the list of questions for a specific quiz.
     *
     * @param id The ID of the quiz.
     * @return A ResponseEntity containing a list of QuestionWrapper objects representing quiz questions.
     */
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Integer> questionIds = quiz.get().getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }

    /**
     * Calculates the quiz result based on user responses.
     *
     * @param id The ID of the quiz.
     * @param responses The list of user responses.
     * @return A ResponseEntity containing the calculated quiz result.
     */
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}

//for(Question q: questionsFromDB){
//    QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),
//                    q.getOption1(),q.getOption2(),
//                    q.getOption3(),q.getOption4());
//            questionsForUsers.add(qw);
//        }
//        Optional<Quiz> quiz = quizDao.findById(id);
//        List<Question> questions = quiz.get().getQuestion();
// int correct = 0;
//        int i = 0;
//        for(Response response : responses){
//            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
//                correct++;
//            }
//            i++;
//        }