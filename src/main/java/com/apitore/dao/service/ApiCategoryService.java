package com.apitore.dao.service;

import com.apitore.dao.model.DBApiCategory;


public interface ApiCategoryService {
  public DBApiCategory get(Long apiId, Long categoryId);

  public DBApiCategory insert(DBApiCategory val);
  public void update(DBApiCategory val);
  public void delete(DBApiCategory val);

  public long count(Long apiId);
}