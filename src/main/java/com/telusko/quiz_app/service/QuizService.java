package com.telusko.quiz_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quiz_app.dao.Questiondao;
import com.telusko.quiz_app.dao.QuizDao;
import com.telusko.quiz_app.model.ClientResponse;
import com.telusko.quiz_app.model.Question;
import com.telusko.quiz_app.model.QuestionWrapper;
import com.telusko.quiz_app.model.Quiz;

@Service
public class QuizService {
@Autowired
	QuizDao quizDao;

@Autowired
Questiondao questionDao;

public String createQuiz(String category, int numQ) {
	// TODO Auto-generated method stub
	
	Quiz quiz=new Quiz();
	quiz.setCategory(category);
	quiz.setNumQ(numQ);
	quiz.setQuestions(questionDao.findQuestionByCategoryAndNumQ(category,numQ));
	quizDao.save(quiz);
	return "Quiz created successfully";
	
}

public Optional<Quiz> getQuizById(int id) {
	// TODO Auto-generated method stub
	
	return quizDao.findById(id);
}

public List<QuestionWrapper> getQuizQuestions(int id) {
	// TODO Auto-generated method stub
	Optional<Quiz> quizObj=quizDao.findById(id);
	List<Question> questionsFromDB= quizObj.get().getQuestions();
	List<QuestionWrapper> questionstoDisplay= new ArrayList<QuestionWrapper>();
	for(Question question : questionsFromDB) {
		QuestionWrapper questionOnly=new QuestionWrapper(question.getId(),question.getQuestion_title(),question.getOption1(),question.getOption2(),question.getOption3());
		questionstoDisplay.add(questionOnly);
	}
	
	return questionstoDisplay;
}

public ResponseEntity<Integer> checkAnswers(int quizId, List<ClientResponse> answerList) {
	// TODO Auto-generated method stub
	
	Optional<Quiz> quizObj=quizDao.findById(quizId);
	List<Question> questionsFromDB= quizObj.get().getQuestions();
	List<ClientResponse> compareDBList=new ArrayList<ClientResponse>();
	ClientResponse compareResp;
	for(Question qn:questionsFromDB) {
		compareResp=new ClientResponse(qn.getId(),qn.getRightAnswer());
		compareDBList.add(compareResp);
	}
	int index=0;
	int numRightAnswers=0;
	for(ClientResponse dbAnswer:compareDBList) {
		
			if(dbAnswer.getRightAnswer().equals(answerList.get(index).getRightAnswer())){
				numRightAnswers++;	
			
		}
			index++;
	}
	
	return new ResponseEntity<>(numRightAnswers,HttpStatus.OK);
}

}
