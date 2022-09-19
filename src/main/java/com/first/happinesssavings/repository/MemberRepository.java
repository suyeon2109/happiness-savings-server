package com.first.happinesssavings.repository;

import com.first.happinesssavings.domain.IdProviderType;
import com.first.happinesssavings.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public Optional<Member> findByIdProviderTypeAndIdProviderUserId(IdProviderType idProviderType, String idProviderUserId) {
        try {
            Member member = em.createQuery("select m from Member m where m.idProviderType=:idProviderType and m.idProviderUserId=:idProviderUserId", Member.class)
                    .setParameter("idProviderType", idProviderType)
                    .setParameter("idProviderUserId", idProviderUserId)
                    .getSingleResult();
            return Optional.of(member);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
