package com.apitore.dao;

import com.apitore.dao.model.DBUserCredits;


public interface UserCreditDAO {
  public DBUserCredits get(long userId);

  public DBUserCredits insert(DBUserCredits val);
  public void update(DBUserCredits val);
}