package com.intexsoft.service.impl;

import java.util.Map;

import com.intexsoft.dao.api.enums.Group;
import com.intexsoft.dao.impl.CommonDao;
import com.intexsoft.dao.impl.entity.BaseEntity;
import com.intexsoft.service.IBaseEntityService;

public class EntityService implements IBaseEntityService{
	
	private static EntityService instance;
	private CommonDao dao = new CommonDao();
	
	private EntityService() {
	}
	
	public static EntityService getInstance() {
		if(instance == null){
            instance = new EntityService();
        }
        return instance;
	}

	@Override
	public void save(BaseEntity entity) {
		try{
			dao.insert(entity);
		} catch (Exception e){
			e.getMessage();
		}
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}

	@Override
	public Map<String, BaseEntity> getAll() {
		return dao.selectAll();
	}

	@Override
	public String getFullInfo(String id) {
		return dao.select(id);
	}

	@Override
	public double getPayout(Group group) {
		return dao.getPayout(group);
	}

	@Override
	public int getCount(Group group) {
		return dao.getCount(group);
	}

	@Override
	public boolean isExceedLimit(Group group) {
		return dao.isExceedLimit(group);
	}

	@Override
	public boolean isEntityExist(String entity) {
		return dao.isEntityExist(entity);
	}
	
}
