package com.apitore.dao;

import com.apitore.dao.model.DBUser;
import com.apitore.dao.model.DBUserSimple;


public interface UserDAO {
  public DBUser getUser(String username);

  public DBUserSimple insert(DBUserSimple val);
  public void update(DBUserSimple val);

  public long count();
}