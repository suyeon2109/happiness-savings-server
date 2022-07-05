package com.first.happinesssavings.repository;

import com.first.happinesssavings.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public String save(Member member){
        em.persist(member.getMemberId());
        return member.getMemberId();
    }
}
