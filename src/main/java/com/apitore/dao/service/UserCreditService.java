package com.apitore.dao.service;

import com.apitore.dao.model.DBUserCredits;


public interface UserCreditService {
  public DBUserCredits get(long userId);

  public DBUserCredits insert(DBUserCredits val);
  public void update(DBUserCredits val);
}