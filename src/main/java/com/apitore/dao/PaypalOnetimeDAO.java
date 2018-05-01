package com.apitore.dao;

import com.apitore.dao.model.DBPaypalOnetime;


public interface PaypalOnetimeDAO {
  public DBPaypalOnetime get(String id);

  public DBPaypalOnetime insert(DBPaypalOnetime val);
  public void update(DBPaypalOnetime val);
  public void delete(DBPaypalOnetime val);
}