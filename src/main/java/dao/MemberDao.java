package dao;

import org.springframework.stereotype.Repository;

import entity.Member;

@Repository
public interface MemberDao {

	Integer save(Member member);
}
