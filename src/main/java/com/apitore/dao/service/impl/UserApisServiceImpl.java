package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserApisDAO;
import com.apitore.dao.model.DBUserApis;
import com.apitore.dao.service.UserApisService;


@Service
public class UserApisServiceImpl implements UserApisService {

  @Autowired
  UserApisDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBUserApis getUserApis(long userId, long apiId) {
    return dao.getUserApis(userId, apiId);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBUserApis> getUserApis_Desc(long userId, String field, int offset, int limit) {
    return dao.getUserApis_Desc(userId, field, offset, limit);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUserApis insert(DBUserApis val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBUserApis val) {
    dao.update(val);
  }

  @Override
  @Transactional(readOnly=true)
  public long count(Long userId) {
    return dao.count(userId);
  }

}