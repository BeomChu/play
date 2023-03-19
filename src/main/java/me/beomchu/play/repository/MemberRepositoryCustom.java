package me.beomchu.play.repository;

import me.beomchu.play.dto.request.MemberUpdate;

public interface MemberRepositoryCustom {
    void edit(Long id, MemberUpdate request);
}
