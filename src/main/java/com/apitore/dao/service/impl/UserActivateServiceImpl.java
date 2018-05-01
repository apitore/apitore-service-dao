package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserActivateDAO;
import com.apitore.dao.model.DBUserActivate;
import com.apitore.dao.service.UserActivateService;


@Service
public class UserActivateServiceImpl implements UserActivateService {

  @Autowired
  UserActivateDAO dao;


  @Override
  @Transactional(readOnly=true)
  public List<DBUserActivate> getNewAccountNotEnabled() {
    return dao.getNewAccountNotEnabled();
  }

  @Override
  @Transactional(readOnly=true)
  public DBUserActivate get(String username) {
    return dao.get(username);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUserActivate insert(DBUserActivate val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBUserActivate val) {
    dao.update(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void delete(DBUserActivate val) {
    dao.delete(val);
  }

  @Override
  @Transactional(readOnly=true)
  public long count() {
    return dao.count();
  }

}