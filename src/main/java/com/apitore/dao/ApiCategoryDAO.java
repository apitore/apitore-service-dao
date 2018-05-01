package com.apitore.dao;

import com.apitore.dao.model.DBApiCategory;


public interface ApiCategoryDAO {
  public DBApiCategory get(Long apiId, Long categoryId);

  public DBApiCategory insert(DBApiCategory val);
  public void update(DBApiCategory val);
  public void delete(DBApiCategory val);

  public long count(Long apiId);
}