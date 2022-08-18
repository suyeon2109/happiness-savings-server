package com.first.happinesssavings.repository;

import com.first.happinesssavings.domain.Happiness;
import com.first.happinesssavings.dto.*;
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

    public List<Happiness> findByTitle(HappinessFindByTitleDto happinessFindByTitleDto) {
        return em.createQuery("select h from Happiness h where h.title like :title and h.memberUuid=:memberUuid", Happiness.class)
                .setParameter("title", happinessFindByTitleDto.getTitle())
                .setParameter("memberUuid", happinessFindByTitleDto.getMemberUuid())
                .getResultList();
    }
    public Long count(String memberUuid){
        return em.createQuery("select count(h) as cnt from Happiness h where h.memberUuid=:memberUuid", Long.class)
                .setParameter("memberUuid", memberUuid)
                .getSingleResult();
    }

    public List<HappinessIndexDailyAvgResponse> findDailyAvg(HappinessIndexAvgRequest request){
        return em.createQuery("select h.date as date, avg(h.happinessIndex) as dailyAvg from Happiness h " +
                        "where year(h.date)=year(:date) and h.memberUuid=:memberUuid " +
                        "group by h.date order by h.date desc", HappinessIndexDailyAvgResponse.class)
                .setParameter("memberUuid", request.getMemberUuid())
                .setParameter("date", request.getDate())
                .setMaxResults(10)
                .getResultList();
    }

    public List<HappinessIndexMonthlyAvgResponse> findMonthlyAvg(HappinessIndexAvgRequest request){
        return em.createQuery("select month(h.date) as date, avg(h.happinessIndex) as monthlyAvg from Happiness h " +
                        "where year(h.date)=year(:date) and h.memberUuid=:memberUuid " +
                        "group by month(h.date)", HappinessIndexMonthlyAvgResponse.class)
                .setParameter("memberUuid", request.getMemberUuid())
                .setParameter("date", request.getDate())
                .setMaxResults(12)
                .getResultList();
    }
}
