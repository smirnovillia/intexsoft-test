package com.intexsoft.dao.impl.entity;

import java.util.Date;

import com.intexsoft.dao.api.entity.IOfficial;
import com.intexsoft.dao.api.enums.Group;

public class Official extends BaseEntity implements IOfficial {
	
	private Group group = Group.OFFICIAL;
	private static final int ESTIMATION = 1000;
	private static final int FULL_RATE_TIME = 160;
	private static final int WORK_DAY_TIME = 8;
	private int bonusPercent;
	
	@Override
	public int getBonusPercent() {
		return bonusPercent;
	}

	@Override
	public void setBonusPercent(int bonusPercent) {
		this.bonusPercent = bonusPercent;
	}
	
	@Override
	public Group getGroup() {
		return group;
	}

	@Override
	public double getSalary() {
		double daysWorked = 0;
		int duration = getWorkDuration();
		double monthTimeRate = FULL_RATE_TIME * getRate().getValue();
		double monthDayRate = FULL_RATE_TIME/WORK_DAY_TIME;
		double dayTimeRate = WORK_DAY_TIME * getRate().getValue();
		if (duration <= monthTimeRate) {
			daysWorked = Math.floor(duration / dayTimeRate);
		} else {
			daysWorked = Math.floor(duration % monthTimeRate);
		}
		double workedDayPercent = daysWorked/monthDayRate;
		return workedDayPercent*ESTIMATION*(1 + getBonusPercent()/100);
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
