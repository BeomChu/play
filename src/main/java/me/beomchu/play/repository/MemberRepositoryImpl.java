package me.beomchu.play.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.RequiredArgsConstructor;
import me.beomchu.play.domain.QMember;
import me.beomchu.play.dto.request.MemberUpdate;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

import static me.beomchu.play.domain.QMember.*;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    @Override
    public void edit(Long id ,MemberUpdate request) {
        JPAUpdateClause updateQuery = queryFactory.update(member)
                .set(member.email, request.getEmail())
                .set(member.name, request.getName())
                .where(member.id.eq(id));

        //TODO 메서드로 분리해서 사용 가능 할듯 나중에 해보자
        if(request.getPassword() !=null || StringUtils.hasText(request.getPassword())){
            updateQuery.set(member.password, request.getPassword());
        }

        updateQuery.execute();
    }
}
