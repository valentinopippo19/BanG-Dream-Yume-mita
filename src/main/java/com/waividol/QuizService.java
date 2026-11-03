package com.waividol;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public final class QuizService {
    public static final long LIMIT_MS=5000;
    private final List<QuizQuestion> questions;
    private final Map<String, Active> active=new ConcurrentHashMap<>();
    private final WalletService wallet;
    public QuizService(List<QuizQuestion> questions, WalletService wallet){this.questions=questions;this.wallet=wallet;}
    private record Active(String questionId,long startedAt){}

    public Map<String,Object> next(String session,long userId){
        QuizQuestion q=choose(); active.put(session,new Active(q.id(),System.currentTimeMillis()));
        Map<String,Object> out=new LinkedHashMap<>(); out.put("id",q.id());out.put("question",q.question());out.put("options",q.options());out.put("timeLimitMs",LIMIT_MS);out.put("startedAt",System.currentTimeMillis()); return out;
    }
    private QuizQuestion choose(){return questions.get(new Random().nextInt(questions.size()));}

    public Map<String,Object> answer(String session,long userId,String questionId,Integer option){
        Active a=active.remove(session); if(a==null || !a.questionId().equals(questionId)) throw new IllegalStateException("La pregunta ya no está activa.");
        long elapsed=Math.max(0,System.currentTimeMillis()-a.startedAt()); boolean timeout=elapsed>LIMIT_MS; QuizQuestion q=questions.stream().filter(x->x.id().equals(questionId)).findFirst().orElseThrow();
        boolean correct=!timeout && option!=null && option>=0 && option<q.options().size() && option==q.answer();
        try { wallet.recordQuiz(userId,questionId,correct,timeout,elapsed); } catch(Exception e){throw new RuntimeException(e);}
        Map<String,Object> out=new LinkedHashMap<>();out.put("correct",correct);out.put("timedOut",timeout);out.put("reward",correct?1:0);out.put("nextAutomatically",true);out.put("elapsedMs",elapsed);return out;
    }
}
