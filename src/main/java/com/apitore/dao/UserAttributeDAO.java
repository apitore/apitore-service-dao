package com.apitore.dao;

import com.apitore.dao.model.DBUserAttribute;


public interface UserAttributeDAO {
  public DBUserAttribute get(Long userId);
  public DBUserAttribute insert(DBUserAttribute val);
  public void update(DBUserAttribute val);
}