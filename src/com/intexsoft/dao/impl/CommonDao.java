package com.intexsoft.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.intexsoft.dao.api.IEmployeeDao;
import com.intexsoft.dao.api.enums.Group;
import com.intexsoft.dao.impl.entity.BaseEntity;

public class CommonDao implements IEmployeeDao {

	private Map<String, BaseEntity> dao = new HashMap<>();

	@Override
	public void insert(BaseEntity entity) {
		dao.put(entity.getLastName().toLowerCase(), entity);
	}

	@Override
	public boolean isExceedLimit(Group entity) {
		if (dao.isEmpty()) {
			return false;
		} else {
			return getCount(entity) >= entity.getLimit();
		}

	}

	@Override
	public void delete(String id) {
		dao.remove(id);
	}

	@Override
	public int getCount(Group group) {
		Map<String, BaseEntity> groupOfEmployee = filterByGroup(group);
		return groupOfEmployee.size();
	}

	private Map<String, BaseEntity> filterByGroup(Group group) {
		return dao.entrySet().stream()
				.filter(p -> p.getValue().getGroup().equals(group))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
	}

	@Override
	public String select(String id) {
		return dao.get(id).toString();
	}

	@Override
	public Map<String, BaseEntity> selectAll() {
		return dao;
	}

	@Override
	public boolean isEntityExist(String entity) {
		if (dao.containsKey(entity.toLowerCase())) {
			return true;
		}
		return false;
	}

	@Override
	public double getPayout(Group group) {
		double groupPayout = 0;
		for (Map.Entry<String, BaseEntity> entity : filterByGroup(group).entrySet()) {
			groupPayout = groupPayout + entity.getValue().getSalary();
		}
		return groupPayout;
	}

}
