package com.telusko.quiz_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.quiz_app.model.Question;

@Repository
public interface Questiondao extends JpaRepository<Question, Integer>{

	

	List<Question> findByCategory(String category);

	List<Question> findByDifficltyLvl(String level);
	
	@Query(value="select * from Question where category=:category ORDER BY RANDOM() limit:numQ",nativeQuery = true)
	public List<Question> findQuestionByCategoryAndNumQ(String category,int numQ);

}
