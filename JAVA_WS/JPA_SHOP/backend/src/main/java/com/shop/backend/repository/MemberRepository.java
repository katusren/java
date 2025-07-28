package com.shop.backend.repository;

import com.shop.backend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // Optional: null 값 안정성 확보
    // @Select(select username from Member)
    Optional<Member> findByUsername(String username);

    Optional<Member> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query("SELECT m FROM Member m WHERE m.username = :username OR m.email = :email")
    Optional<Member> findByUsernameOrEmail(@Param("username") String username, @Param("email") String email);
}