package org.example.service.impl;

import org.example.exception.NotEnoughQuestionsException;
import org.example.model.Question;
import org.example.service.ExaminerService;
import org.example.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl  implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService){
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount){
        Collection<Question> questions = questionService.getAll();
        if (amount > questions.size() || amount < 1){
            throw new NotEnoughQuestionsException();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount){
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }

}
