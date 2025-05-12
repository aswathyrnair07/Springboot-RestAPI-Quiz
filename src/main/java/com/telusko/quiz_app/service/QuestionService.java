package com.telusko.quiz_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.quiz_app.dao.Questiondao;
import com.telusko.quiz_app.model.Question;

@Service
public class QuestionService {
	@Autowired
	Questiondao dao;

	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		System.out.println("-------------------"+dao.findAll());
		return dao.findAll();
	}

	public void addRecord(List<Question> questions) {
		dao.saveAll(questions);
	}

	public List<Question> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		
		return dao.findByCategory(category);
	}

	public String addQuestion(Question qn) {
		// TODO Auto-generated method stub
		dao.save(qn);
		return "success";
	}
	public String updateQuestion(Question qn) {
		// TODO Auto-generated method stub
		dao.save(qn);
		return "success";
	}
	
	public String deleteQuestion(int id) {
		dao.deleteById(id);
		
		return "deleted";
	}

	public List<Question> getQuestionByDiffLevel(String level) {
		// TODO Auto-generated method stub
		return dao.findByDifficltyLvl(level);
	}

}
