package com.jdc.balance.controller.member;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.balance.model.data.form.TransactionForm;
import com.jdc.balance.model.data.form.TransactionForm.Type;

@Controller
@RequestMapping("employee/transaction")
public class DailyTransactionController {

	public String search(int project, Optional<Type> type, Optional<Integer> ledger, Optional<LocalDate> from, Optional<LocalDate> to) {
		// TODO implement here
		return "";
	}

	public String selectLedgerType() {
		// TODO implement here
		return "";
	}

	public String createTransaction(int ledger) {
		// TODO implement here
		return "";
	}

	public String addDetails(TransactionForm form, BindingResult result) {
		// TODO implement here
		return "";
	}

	public String deleteDetails(TransactionForm form, BindingResult result) {
		// TODO implement here
		return "";
	}

	public String save(TransactionForm form, BindingResult result) {
		// TODO implement here
		return "";
	}

	public TransactionForm form() {
		// TODO implement here
		return null;
	}

}