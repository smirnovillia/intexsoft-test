package com.intexsoft.dao.api.entity;

import java.util.Date;

import com.intexsoft.dao.api.enums.Group;
import com.intexsoft.dao.api.enums.Rate;

public interface IBaseEntity {

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

	Rate getRate();

	void setRate(Rate rate);

	Group getGroup();

	void setGroup(Group group);

	double getSalary();

	void setSalary(double salary);

	int getWorkDuration();

	Date getCreated();

	void setCreated(Date created);

}
