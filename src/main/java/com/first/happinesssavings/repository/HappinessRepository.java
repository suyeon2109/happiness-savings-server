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
        return happiness.getId();
    }

    public Happiness findOne(Happiness happiness) {
        return em.createQuery("select h from Happiness h where h.id=:id and h.memberId=:memberId", Happiness.class)
                .setParameter("id", happiness.getId())
                .setParameter("memberId", happiness.getMemberId())
                .getSingleResult();
    }

    public List<Happiness> findAll(String memberId){
        return em.createQuery("select h from Happiness h where h.memberId=:memberId", Happiness.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    public List<Happiness> findByTitle(Happiness happiness) {
        return em.createQuery("select h from Happiness h where h.title like :title and h.memberId=:memberId", Happiness.class)
                .setParameter("title", happiness.getTitle())
                .setParameter("memberId", happiness.getMemberId())
                .getResultList();
    }
    public Long count(String memberId){
        return em.createQuery("select count(h) as cnt from Happiness h where h.memberId=:memberId", Long.class)
                .setParameter("memberId", memberId)
                .getSingleResult();
    }
}
