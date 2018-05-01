package com.apitore.dao.service;

import java.util.Date;
import java.util.List;

import com.apitore.dao.model.DBApiDetails;


public interface ApiDetailsService {
  public DBApiDetails get(long apiId);

  public List<DBApiDetails> getApiDetails_GT_Date(Date from);

  public DBApiDetails insert(DBApiDetails val);
  public void update(DBApiDetails val);
}