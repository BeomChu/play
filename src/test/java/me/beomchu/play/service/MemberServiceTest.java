package me.beomchu.play.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.beomchu.play.domain.Member;
import me.beomchu.play.dto.request.MemberUpdate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("updateDto에 password가 공백이면 기존 비밀번호를 유지한다")
    @Transactional
    public void updateTest1() {
        //given
        Member member = Member.builder()
                .username("beomchu")
                .password("1234")
                .email("aa@aa.aa")
                .name("범츄")
                .build();

        em.persist(member);
        System.out.println("member.getId() = " + member.getId());

        em.flush();
        em.clear();

        //when
        MemberUpdate request = MemberUpdate.builder()
                .email("aa@aa.aa")
                .name("범수")
                .password(null)
                .build();

        try {
            memberService.edit(1L, request);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        em.flush();
        em.clear();
        Member beomchu = memberService.get(1L);

        System.out.println("여기" + beomchu.getPassword());

        //expert
        assertEquals(beomchu.getId(), 1L);
        assertEquals(beomchu.getPassword(), "1234");
        assertEquals(beomchu.getEmail(), "aa@aa.aa");
        assertEquals(beomchu.getName(), "범수");

    }

    @Test
    @Transactional
    public void test2() {
        Member member = Member.builder()
                .username("beomchu")
                .password("1234")
                .email("aa@aa.aa")
                .name("범츄")
                .build();

        em.persist(member);
        System.out.println("member.getId() = " + member.getId());

        em.flush();
        em.clear();

        //when
        MemberUpdate request = MemberUpdate.builder()
                .email("aa@aa.aa")
                .name("범수")
                .password(null)
                .build();

        try {
            memberService.edit2(1L, request);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        em.flush();
        em.clear();
        Member beomchu = memberService.get(1L);

        System.out.println("여기" + beomchu.getPassword());

        //expert
        assertEquals(beomchu.getId(), 1L);
        assertEquals(beomchu.getPassword(), "1234");
        assertEquals(beomchu.getEmail(), "aa@aa.aa");
        assertEquals(beomchu.getName(), "범수");


    }

}