package com.dao;

import java.util.List;

import com.pojos.Orders;
import com.pojos.Transaction;

public interface TransactionDAO {

	int addTransaction (Transaction transaction);
	List<Transaction> getAllTransactions(String userid);
}
