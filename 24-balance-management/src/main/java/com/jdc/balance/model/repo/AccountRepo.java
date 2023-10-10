package com.jdc.balance.model.repo;

import java.util.Optional;

import com.jdc.balance.model.data.entity.Account;
import com.jdc.balance.model.repo.base.BaseRepository;

public interface AccountRepo extends BaseRepository<Account, Long>{

	Optional<Account> findOneByEmail(String email);
}
