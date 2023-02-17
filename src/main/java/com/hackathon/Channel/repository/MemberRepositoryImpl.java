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
    public String addUser(Member member) {
        em.persist(member);
        return "200";
    }

    @Override
    public String deleteUser(String email) {
        em.remove(em.find(Member.class, email));
        return "200";
    }

    @Override
    public String updateUser(Member member) {
        String password = member.getPassword();
        String name = member.getName();
        String email = member.getEmail();

        em.createQuery("UPDATE Member A SET A.password = : password, A.name = : name WHERE A.email = : email")
                .setParameter("password", password)
                .setParameter("name", name)
                .setParameter("email", email)
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
