package com.apitore.dao.service;

import com.apitore.dao.model.DBUserAttribute;


public interface UserAttributeService {
  public DBUserAttribute get(Long userId);
  public DBUserAttribute insert(DBUserAttribute val);
  public void update(DBUserAttribute val);
}