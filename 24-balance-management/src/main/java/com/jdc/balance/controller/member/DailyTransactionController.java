package com.jdc.balance.controller.member;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.balance.model.data.entity.consts.BalanceType;
import com.jdc.balance.model.data.form.TransactionForm;

@Controller
@RequestMapping("employee/transaction")
public class DailyTransactionController {

	@GetMapping("{project}/{type}")
	public String search(
			@PathVariable int project, @PathVariable BalanceType type, 
			@RequestParam Optional<Integer> ledger, 
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> from, 
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> to) {
		// TODO implement here
		return "views/project/transaction";
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
	
	@ModelAttribute("type")
	BalanceType type(@PathVariable BalanceType type) {
		return type;
	}

	@ModelAttribute("projectId")
	int projectId(@PathVariable int project) {
		return project;
	}
}