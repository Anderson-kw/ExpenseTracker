package com.expensetracker;

import java.time.LocalDate;

public class Expense {
	private double amount;
	private String description;
	private LocalDate date;
	
	public Expense(double amo ,String desc, LocalDate date) {
		this.amount = amo;
		this.description = desc;
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
