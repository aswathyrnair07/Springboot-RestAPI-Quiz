package com.telusko.quiz_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quiz_app.model.ClientResponse;
import com.telusko.quiz_app.model.QuestionWrapper;
import com.telusko.quiz_app.model.Quiz;
import com.telusko.quiz_app.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	@PostMapping("create")
	public String createQuiz(@RequestBody Quiz quiz) {
		
		return quizService.createQuiz(quiz.getCategory(),quiz.getNumQ());
		
	}
	@GetMapping("getquiz/{id}")
	public  List<QuestionWrapper> getQuizQuestions(@PathVariable int id) {
		
		 
		 return quizService.getQuizQuestions(id);
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<ClientResponse> answerList) {
		System.out.println();
		return quizService.checkAnswers(id,answerList);
		
	}

}
