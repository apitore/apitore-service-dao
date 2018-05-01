package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserDAO;
import com.apitore.dao.model.DBUser;
import com.apitore.dao.model.DBUserSimple;
import com.apitore.dao.service.UserService;


@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBUser getUser(String username) {
    return dao.getUser(username);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUserSimple insert(DBUserSimple val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBUserSimple val) {
    dao.update(val);
  }

  @Override
  @Transactional(readOnly=true)
  public long count() {
    return dao.count();
  }

}