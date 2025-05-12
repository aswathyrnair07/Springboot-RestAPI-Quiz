package com.telusko.quiz_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.quiz_app.model.Question;
import com.telusko.quiz_app.model.Quiz;

import jakarta.persistence.Id;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

	
}
