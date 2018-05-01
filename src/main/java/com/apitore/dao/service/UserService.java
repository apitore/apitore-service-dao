package com.apitore.dao.service;

import com.apitore.dao.model.DBUser;
import com.apitore.dao.model.DBUserSimple;


public interface UserService {
  public DBUser getUser(String username);

  public DBUserSimple insert(DBUserSimple val);
  public void update(DBUserSimple val);

  public long count();
}