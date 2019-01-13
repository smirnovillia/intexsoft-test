package com.intexsoft.dao.impl.entity;

import java.util.Date;

import com.intexsoft.dao.api.entity.IEmploye;
import com.intexsoft.dao.api.enums.Group;

public class Employe extends BaseEntity implements IEmploye {

	private Group group = Group.EMPLOYE;
	private static final int FULL_RATE_TIME = 160;
	private static final int WORK_DAY_TIME = 8;
	private static final int HOUR_RATE = 10;
	private static final double SURCHARGE = HOUR_RATE / 2;

	@Override
	public Group getGroup() {
		return group;
	}

	@Override
	public double getSalary() {
		double daysWorked = 0;
		int overtime = 0;
		int duration = getWorkDuration();
		double monthTimeRate = FULL_RATE_TIME * getRate().getValue();
		double dayTimeRate = WORK_DAY_TIME * getRate().getValue();
		if (duration <= monthTimeRate) {
			daysWorked = Math.floor(duration / dayTimeRate);
			overtime = (int) (duration % daysWorked * WORK_DAY_TIME * getRate().getValue());

		} else {
			daysWorked = Math.floor(duration % monthTimeRate);
			overtime = (int) Math.floor(duration % monthTimeRate - daysWorked);
		}
		return daysWorked * WORK_DAY_TIME * HOUR_RATE + SURCHARGE * overtime;
	}

	@Override
	public int getWorkDuration() {
		Date call = new Date();
		return (int) Math.floor((call.getTime() - getCreated().getTime()) / 60 / 24);
	}

	@Override
	public String toString() {
		return "last name = " + getLastName() +", first name = " + getFirstName() + ", group = " + getGroup() + ", rate = " + getRate() + ", duration = "
				+ getWorkDuration();
	}

}
