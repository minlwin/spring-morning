package com.jdc.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jdc.demo.BaseDao;
import com.jdc.demo.NeedToLogBefore;
import com.jdc.demo.dao.dto.Account;

@Repository
@Qualifier("account")
public class AccountDao implements BaseDao<Account>{

	@Override
	public int create(Account data) {
		System.out.println("Create %s".formatted(data));
		return 10;
	}

	@Override
	public void update(int id, Account data) {
		// TODO Auto-generated method stub
		
	}

	@NeedToLogBefore
	@Override
	public Account findById(int id) {
		System.out.println("Find By Id Method of Account Dao Class");
		return null;
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
