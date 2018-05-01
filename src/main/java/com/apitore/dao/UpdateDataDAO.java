package com.apitore.dao;

import com.apitore.dao.model.DBUpdateData;


public interface UpdateDataDAO {
  public DBUpdateData get(Integer id);

  public DBUpdateData insert(DBUpdateData val);
  public void update(DBUpdateData val);
}