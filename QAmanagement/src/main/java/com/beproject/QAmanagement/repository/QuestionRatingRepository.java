package com.beproject.QAmanagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beproject.QAmanagement.models.*;

@Repository
public interface QuestionRatingRepository extends CrudRepository<QuestionRating,Long>
{
	@Query("select count(q) from QuestionRating q where q.questionid=:qid and type= :t ")
	long getvote(@Param("qid") long qid, @Param("t") String s);
	
	@Query("select q from QuestionRating q where q.questionid=:qid and q.userid= :uid ")
	QuestionRating findByUseridQuestionid(@Param("qid") long qid, @Param("uid") long uid);
	
}