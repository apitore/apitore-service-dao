package com.apitore.dao.service;

import com.apitore.dao.model.DBUpdateData;


public interface UpdateDataService {
  public DBUpdateData get(Integer id);

  public DBUpdateData insert(DBUpdateData val);
  public void update(DBUpdateData val);
}