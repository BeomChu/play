package me.beomchu.play.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.beomchu.play.dto.request.MemberUpdate;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String name;

    @Builder
    public Member(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public void edit(MemberUpdate memberUpdate) {
        System.out.println("edit 실행됨");
        System.out.println(this.password);
        this.email = memberUpdate.getEmail();
        this.name = memberUpdate.getName();
        if (memberUpdate.getPassword() !=null || StringUtils.hasText(memberUpdate.getPassword())) {
            this.password = memberUpdate.getPassword();
        }
//        if(memberUpdate.getPassword() == null || memberUpdate.getPassword().isEmpty()) {
//            return;
//        }
//        this.password = memberUpdate.getPassword();
//
    }
}
