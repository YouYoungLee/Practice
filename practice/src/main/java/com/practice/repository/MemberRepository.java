package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
   
}