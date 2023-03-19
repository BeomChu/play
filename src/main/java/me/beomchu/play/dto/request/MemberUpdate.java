package me.beomchu.play.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberUpdate {

    private String password;
    private String email;
    private String name;

    @Builder
    public MemberUpdate(String password, String email, String name) {
        this.password = password;
        this.email = email;
        this.name = name;
    }
}
