package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserCreditDAO;
import com.apitore.dao.model.DBUserCredits;
import com.apitore.dao.service.UserCreditService;


@Service
public class UserCreditServiceImpl implements UserCreditService {

  @Autowired
  UserCreditDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBUserCredits get(long userId) {
    return dao.get(userId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUserCredits insert(DBUserCredits val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBUserCredits val) {
    dao.update(val);
  }

}