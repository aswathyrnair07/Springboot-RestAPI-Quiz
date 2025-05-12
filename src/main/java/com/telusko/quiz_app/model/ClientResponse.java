package com.telusko.quiz_app.model;

public class ClientResponse {
	int questionId;
	String rightAnswer;
	 public ClientResponse(int questionId, String rightAnswer) {
		super();
		this.questionId = questionId;
		this.rightAnswer = rightAnswer;
	}
	
	 
	 
 public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

}
