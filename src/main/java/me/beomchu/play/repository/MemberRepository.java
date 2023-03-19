package me.beomchu.play.repository;

import me.beomchu.play.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {
}
