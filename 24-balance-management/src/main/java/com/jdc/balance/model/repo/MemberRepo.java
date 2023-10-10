package com.jdc.balance.model.repo;

import java.util.Optional;

import com.jdc.balance.model.data.entity.Member;
import com.jdc.balance.model.repo.base.BaseRepository;

public interface MemberRepo extends BaseRepository<Member, Long>{

	Optional<Member> findOneByEmail(String email);
}
