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
        System.out.println("member.getMemberId() : " + member.getMemberId());
        em.persist(member);
        return member.getMemberId();
    }
}
