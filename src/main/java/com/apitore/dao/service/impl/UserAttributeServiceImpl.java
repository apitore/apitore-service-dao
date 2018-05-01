package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserAttributeDAO;
import com.apitore.dao.model.DBUserAttribute;
import com.apitore.dao.service.UserAttributeService;


@Service
public class UserAttributeServiceImpl implements UserAttributeService {

  @Autowired
  UserAttributeDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBUserAttribute get(Long userId) {
    return dao.get(userId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUserAttribute insert(DBUserAttribute val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBUserAttribute val) {
    dao.update(val);
  }

}