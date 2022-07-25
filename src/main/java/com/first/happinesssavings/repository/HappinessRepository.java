package com.first.happinesssavings.repository;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.dto.HappinessFindOneDto;
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

    public Happiness findOne(HappinessFindOneDto happinessFindOneDto) {
        return em.createQuery("select h from Happiness h where h.id=:id and h.memberUuid=:memberUuid", Happiness.class)
                .setParameter("id", happinessFindOneDto.getHappinessId())
                .setParameter("memberUuid", happinessFindOneDto.getMemberUuid())
                .getSingleResult();
    }

    public List<Happiness> findAll(String memberUuid){
        return em.createQuery("select h from Happiness h where h.memberUuid=:memberUuid", Happiness.class)
                .setParameter("memberUuid", memberUuid)
                .getResultList();
    }

    public List<Happiness> findByTitle(Happiness happiness) {
        return em.createQuery("select h from Happiness h where h.title like :title and h.memberUuid=:memberUuid", Happiness.class)
                .setParameter("title", happiness.getTitle())
                .setParameter("memberUuid", happiness.getMemberUuid())
                .getResultList();
    }
    public Long count(String memberUuid){
        return em.createQuery("select count(h) as cnt from Happiness h where h.memberUuid=:memberUuid", Long.class)
                .setParameter("memberUuid", memberUuid)
                .getSingleResult();
    }
}
