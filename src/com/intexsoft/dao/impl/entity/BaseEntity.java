package com.intexsoft.dao.impl.entity;

import java.util.Date;

import com.intexsoft.dao.api.entity.IBaseEntity;
import com.intexsoft.dao.api.enums.Group;
import com.intexsoft.dao.api.enums.Rate;

public class BaseEntity implements IBaseEntity {

	private String firstName;
	private String lastName;
	private Rate rate;
	private Group group;
	private double salary;
	private int workDuration;
	private Date created;
	
	public BaseEntity() {
		super();
		this.created = new Date();
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public Rate getRate() {
		return rate;
	}

	@Override
	public void setRate(Rate rate) {
		this.rate = rate;
	}
	
	@Override
	public Group getGroup() {
		return group;
	}

	@Override
	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public double getSalary() {
		return salary;
	}

	@Override
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public Date getCreated() {
		return created;
	}
	
	@Override
	public int getWorkDuration() {
		return workDuration;
	}

	@Override
	public void setCreated(Date created) {
		this.created = created;
	}

}
