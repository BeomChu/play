package me.beomchu.play.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.beomchu.play.domain.Member;
import me.beomchu.play.dto.request.MemberUpdate;
import me.beomchu.play.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final EntityManager em;
    private final MemberRepository memberRepository;

    @Transactional
    public Member get(long userId) {
        return em.createQuery("SELECT m FROM Member m WHERE m.id = :id", Member.class)
                .setParameter("id", userId)
                .getSingleResult();
    }

    @Transactional
    public void edit(long userId, MemberUpdate request) {
        Member memberEntity = get(userId);
        System.out.println("memberEntity = " + memberEntity.getPassword());

        log.info("memberEntity== {}", request);
        
        String a = null;
        String b = "";
        String c = "a";

        System.out.println("c.isEmpty() = " + c.isEmpty());
        System.out.println("b.isEmpty() = " + b.isEmpty());
        System.out.println(StringUtils.hasText(a));



        memberEntity.edit(request);
        System.out.println("memberEntity. edit" + memberEntity.getPassword());
    }

    @Transactional
    public void edit2(long userId, MemberUpdate request) {
        memberRepository.edit(userId,request);
        em.flush();
        em.clear();
    }
}
