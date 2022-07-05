package com.first.happinesssavings.repository;

import com.first.happinesssavings.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public String signUp(Member member){
        em.persist(member);
        return member.getUuid();
    }

    public Long findOne(Member member) {
        return em.createQuery("select count(m) from Member m where m.uuid=:uuid", Long.class)
                .setParameter("uuid", member.getUuid())
                .getSingleResult();
    }
}
