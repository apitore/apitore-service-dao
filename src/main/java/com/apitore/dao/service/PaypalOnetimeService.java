package com.apitore.dao.service;

import com.apitore.dao.model.DBPaypalOnetime;


public interface PaypalOnetimeService {
  public DBPaypalOnetime get(String id);

  public DBPaypalOnetime insert(DBPaypalOnetime val);
  public void update(DBPaypalOnetime val);
  public void delete(DBPaypalOnetime val);
}