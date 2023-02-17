package com.hackathon.Channel.repository;

import com.hackathon.Channel.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class MemberRepositoryImpl implements MemberRepository{

    private EntityManager em;

    @Autowired
    public MemberRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public String addUser(String name) {
        Member member = new Member(name);
        em.persist(member);
        return "200";
    }

    @Override
    public String deleteUser(String name) {
        em.remove(em.find(Member.class, name));
        return "200";
    }

    @Override
    public String updateUser(String name) {
        em.createQuery("UPDATE Member A SET A.name = : name WHERE A.name = : name")
                .setParameter("name", name)
                .executeUpdate();
        return "200";
    }

    @Override
    public List<Member> readMembers() {
        List<Member> Members = em.createQuery("SELECT M FROM Member M", Member.class)
                .getResultList();
        return Members;
    }

}
