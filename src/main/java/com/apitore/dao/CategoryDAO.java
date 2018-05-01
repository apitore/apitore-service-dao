package com.apitore.dao;

import com.apitore.dao.model.DBCategory;


public interface CategoryDAO {
  public DBCategory get(String category);

  public DBCategory insert(DBCategory val);
}