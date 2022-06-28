package com.first.happinesssavings.repository;

import com.first.happinesssavings.domain.Happiness;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HappinessRepository {
    @PersistenceContext
    private EntityManager em;

    public Long save(Happiness happiness) {
        em.persist(happiness);
        return happiness.getSeq();
    }

    public Happiness findOne(Long seq) {
        return em.find(Happiness.class, seq);
    }

    public List<Happiness> findAll(){
        return em.createQuery("select h from Happiness h", Happiness.class)
                .getResultList();
    }

    public List<Happiness> findByTitle(String title) {
        return em.createQuery("select h from Happiness h where h.title like :title", Happiness.class)
                .setParameter("title",title)
                .getResultList();
    }

    //TODO count 모르겠음..
//    public Long count(){
//        return em.createQuery("select count(h) as cnt from Happiness h", Happiness.class)
//                .getSingleResult();
//    }
}
