package me.beomchu.play.dto.request;

import me.beomchu.play.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberUpdateTest {

    @Test
    @DisplayName("builder활용")
    public void test(){
        MemberUpdate memberUpdate = MemberUpdate.builder()
                .email("aa@aa.aa")
                .name("이름")
                .build();

        System.out.println(memberUpdate.toString());
    }

}