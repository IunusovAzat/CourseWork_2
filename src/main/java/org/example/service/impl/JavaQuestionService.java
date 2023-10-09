package org.example.service.impl;

import org.example.exception.QuestionAlreadyExistException;
import org.example.exception.QuestionNotFoundExceprion;
import org.example.model.Question;
import org.example.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Random random;

    private final Set<Question> questions;

    public JavaQuestionService(){
        this.random = new Random();
        this.questions = new HashSet<>();
    }
    @Override
    public Question getRandomQuestion(){
        if (!questions.size() == 0){
            return null;
        }
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }

    @Override
    public  Question add(String question, String answer){
        return add(new Question(question, answer));
    }

    @Override
    public  Question add(Question question){
        if (!question.add(question)){
            throw new QuestionAlreadyExistException();
        }
        return question;
    }

    @Override
    public Question remove (Question question){
        if (!questions.remove(question)){
            throw new QuestionNotFoundExceprion();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll(){
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandoQestion() {
        return null;
    }


}
