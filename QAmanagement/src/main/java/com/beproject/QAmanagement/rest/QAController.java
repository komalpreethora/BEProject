	package com.beproject.QAmanagement.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beproject.QAmanagement.configuration.URLConstants;
import com.beproject.QAmanagement.dto.*;
import com.beproject.QAmanagement.models.*;

@RestController
@Named
@Path("/v1.0/")
public class QAController 
{

	@Autowired
	DTOService dservice;
	
	
	//for frontend tested
	@GET
	@Path(URLConstants.GET_USER_INTRESTED_QUESTIONS_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<QuestionDTO> getUserInterestedtopicQuestions(@PathParam("userid") long userid, @PathParam("pageno")int pageno) {
		System.out.println("in get user interested questions controller");
	
		List<QuestionDTO> qlist = dservice.getuserinterestedtopicQuestions(userid,pageno);
		return qlist;
	}
	
	// for frontend tested
	@GET
	@Path(URLConstants.GET_USER_EXPERTISE_QUESTIONS_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<QuestionDTO> getUserexpertisetopicQuestions(@PathParam("userid") long userid, @PathParam("pageno")int pageno) {
		System.out.println("in get user expertise questions controller");
	
		return dservice.getuserexpertisetopicQuestions(userid,pageno);
	}
	
	@GET
	@Path(URLConstants.GET_USER_ASKED_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<QuestionDTO> getUserAskedQuestions(@PathParam("userid") long userid,@PathParam("pageno") int pageno) {
		System.out.println("in get user asked questions controller");	
		return dservice.getuseraskedQuestions(userid,pageno);
	}
	
	@GET
	@Path(URLConstants.GET_USER_ANSWERS_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<AnswerDTO> getUserAnswers(@PathParam("userid") long userid) {
		System.out.println("in get user asked questions controller");	
		return dservice.getuseranswer(userid);
	}
	
	@GET
	@Path(URLConstants.GET_QUESTION_ANSWERS_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public QADTO getQuestionAnswers(@PathParam("questionid") long qid) {
		System.out.println("in get question answer controller");	
		return dservice.getquestionanswer(qid);
	}
	
	@POST
	@Path(URLConstants.POST_ANSWER_URL)
	public boolean postAnswer(@RequestBody Answers a) {
		System.out.println("in post answer controller");	
		return dservice.postanswer(a);
	}
	
	@POST
	@Path(URLConstants.POST_ANSWER_VOTE_URL)
	public boolean postAnswerVote(@RequestBody AnswerRating a) {
		System.out.println("in post answer vote controller");	
		return dservice.postanswervote(a);
	}
	
	@POST
	@Path(URLConstants.POST_QUESTION_VOTE_URL)
	public boolean postQuestionVote(@RequestBody QuestionRating r) {
		System.out.println("in post question vote controller");	
		return dservice.postquestionvote(r);
	}
	
	@POST 
	@Path(URLConstants.POST_QUESTION_URL)
	public boolean postQuestion(@RequestBody PostQuestionDTO q) {
		System.out.println("in post question controller");	
		return dservice.postquestion(q);
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
