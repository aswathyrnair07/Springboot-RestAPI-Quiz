package com.telusko.quiz_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quiz_app.model.Question;
import com.telusko.quiz_app.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;
	
	@GetMapping("allquestions")
public List<Question> getAllQuestions() {
		
	return questionservice.getAllQuestions();
}
	@GetMapping("bycategory/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable String category) {
		
		return questionservice.getQuestionsByCategory(category);
	}
	@GetMapping("getQuestionByLevel/{level}")
	public List<Question> getQuestionByDiffLevel(@PathVariable String level) {
		return  questionservice.getQuestionByDiffLevel(level);
	}
	@PostMapping("add")
	public String addQuestion(@RequestBody  Question qn) {
		return questionservice.addQuestion(qn);
		
	}
	@DeleteMapping("delete/{id}")
	public String deleteQuestion(@PathVariable int id) {
		
		return questionservice.deleteQuestion(id);
		
	}
	@PutMapping("update")
	public String updateQuestion(@RequestBody Question q) {
		
		return questionservice.updateQuestion(q);
	}
	
	@PostMapping("initialize")
	private void initialize() {
		Question jqn1=new Question("2","Java","Java Question1","Java1-1","Java1-2","Java1-3","Java1-1");
		Question jqn2=new Question("1","Java","Java Question2","Java2-1","Java2-2","Java2-3","Java2-1");
		Question jqn3=new Question("2","Java","Java Question3","Java3-1","Java3-2","Java3-3","Java3-1");
		Question jqn4=new Question("1","Java","Java Question4","Java4-1","Java4-2","Java4-3","Java4-1");
		Question jqn5=new Question("2","Java","Java Question5","Java5-1","Java5-2","Java5-3","Java5-1");
		Question jqn6=new Question("1","Java","Java Question6","Java6-1","Java6-2","Java6-3","Java6-1");
		Question jqn7=new Question("2","Java","Java Question7","Java7-1","Java7-2","Java7-3","Java7-1");
		Question jqn8=new Question("1","Java","Java Question8","Java8-1","Java8-2","Java8-3","Java8-1");
		
		Question jsqn1=new Question("2","JS","JSQuestion1","JS1-OPT1","JS1-OPT2","JS1-OPT3","JS1-OPT1");
		Question jsqn2=new Question("1","JS","JSQuestion2","JS2-OPT1","JS2-OPT2","JS2-OPT3","JS2-OPT1");
		Question jsqn3=new Question("2","JS","JSQuestion3","JS3-OPT1","JS3-OPT2","JS3-OPT3","JS3-OPT1");
		Question jsqn4=new Question("1","JS","JSQuestion4","JS4-OPT1","JS4-OPT2","JS4-OPT3","JS4-OPT1");
		Question jsqn5=new Question("2","JS","JSQuestion5","JS5-OPT1","JS5-OPT2","JS5-OPT3","JS5-OPT1");
		Question jsqn6=new Question("1","JS","JSQuestion6","JS6-OPT1","JS6-OPT2","JS6-OPT3","JS6-OPT1");
		Question jsqn7=new Question("2","JS","JSQuestion7","JS7-OPT1","JS7-OPT2","JS7-OPT3","JS7-OPT1");
		Question jsqn8=new Question("1","JS","JSQuestion8","JS8-OPT1","JS8-OPT2","JS8-OPT3","JS8-OPT1");
		
		
		Question mqn1=new Question("2","Math","MathQN1","Math1-OPT1","Math1-OPT2","Math1-OPT3","Math1-OPT1");
		Question mqn2=new Question("1","Math","MathQN2","Math2-OPT1","Math2-OPT2","Math2-OPT3","Math2-OPT1");
		Question mqn3=new Question("2","Math","MathQN3","Math3-OPT1","Math3-OPT2","Math3-OPT3","Math3-OPT1");
		Question mqn4=new Question("1","Math","MathQN4","Math4-OPT1","Math4-OPT2","Math4-OPT3","Math4-OPT1");
		Question mqn5=new Question("2","Math","MathQN5","Math5-OPT1","Math5-OPT2","Math5-OPT3","Math5-OPT1");
		Question mqn6=new Question("1","Math","MathQN6","Math6-OPT1","Math6-OPT2","Math6-OPT3","Math6-OPT1");
		Question mqn7=new Question("2","Math","MathQN7","Math7-OPT1","Math7-OPT2","Math7-OPT3","Math7-OPT1");
		Question mqn8=new Question("1","Math","MathQN8","Math8-OPT1","Math8-OPT2","Math8-OPT3","Math8-OPT1");
		
		List<Question> questions=new ArrayList<Question>();
		questions.add(jqn1);
		questions.add(jqn2);
		questions.add(jqn3);
		questions.add(jqn4);
		questions.add(jqn5);
		questions.add(jqn6);
		questions.add(jqn7);
		questions.add(jqn8);
		
		questions.add(jsqn1);
		questions.add(jsqn2);
		questions.add(jsqn3);
		questions.add(jsqn4);
		questions.add(jsqn5);
		questions.add(jsqn6);
		questions.add(jsqn7);
		questions.add(jsqn8);
		
		questions.add(mqn1);
		questions.add(mqn2);
		questions.add(mqn3);
		questions.add(mqn4);
		questions.add(mqn5);
		questions.add(mqn6);
		questions.add(mqn7);
		questions.add(mqn8);
		
		questionservice.addRecord(questions);
	}
	
}
