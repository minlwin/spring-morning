package com.jdc.balance.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.data.entity.TransactionItem;

public interface TransactionItemRepo extends JpaRepositoryImplementation<TransactionItem, Long>{

}
