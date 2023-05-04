package com.examportal.examserver.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.examserver.dao.QuestionRepository;
import com.examportal.examserver.entity.Question;
import com.examportal.examserver.entity.Quiz;
import com.examportal.examserver.exception.QuestionNotFoundException;
import com.examportal.examserver.model.QuestionModel;

@Service
public class QuestionService 
{
	
	@Autowired
	private QuestionRepository questionRepo;
	
//	public Question addQuestion(Question question)
//	{
//		question = questionRepo.save(question);
//		return question;
//	}
//	
//	public Question updateQuestion(Question question)
//	{
//		return this.questionRepo.save(question);
//	}
	
	public List<Question> getQuestions()
	{
		return this.questionRepo.findAll();
	}
	
	public Question getQuestion(int quesId) throws QuestionNotFoundException
	{ 
		
		return this.questionRepo.findById(quesId).get();
		
//		List<Question> l1 = questionRepo.findAll();
//		List<Question> l2 = new ArrayList<>();
//		for(Question q :l1) 
//		{
//			if(q.getContent().contains(content)) {
//				l2.add(q);
//			}
//		}
//		if(l2.size()==0) {
//			throw new QuestionNotFoundException("No such Question found");
//		}
//		return l2;
	}

	
	public Set<Question> getQuestionsByQuiz(Quiz quiz)
	{
		int id = quiz.getQid();
		return this.questionRepo.findByQuiz(id);
	}
	
//	public void deleteQuestion(int quesId) throws QuestionNotFoundException
//	{
//		Question q=this.questionRepo.findById(quesId).orElse(null);
//		if (q==null)
//			throw new QuestionNotFoundException("Question Not Present!");
//		
//		this.questionRepo.delete(q);
//	}
	
	public Map<String,Object> evaluateQuiz(List<QuestionModel> questions) throws QuestionNotFoundException
	{
		int marksSingle=5,marksDeduct=2,marksGot=0;
		int correctAns=0;
		int attempted=0;
		
		for (QuestionModel q:questions)
		{
			Question question=this.getQuestion(q.getQuesId());
			
			if (question==null)
				throw new QuestionNotFoundException("Question Not Found!");
			
			if (question.getAns().equals(q.getGivenAns()))
			{
				//Correct  ans
				correctAns++;
				
				//marksSingle=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
				
				marksGot+=marksSingle;
			}
			
			else
			{
				marksGot-=marksDeduct;
			}
			
			if (q.getGivenAns()!=null)
			{
				attempted++;
			}
			
		}
		
		Map<String,Object> map=Map.of("markssGot",marksGot,"correctAnswers",correctAns,"attempted",attempted);
		
		return map;
	}
	
}
