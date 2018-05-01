package com.apitore.dao.service;

import com.apitore.dao.model.DBThreadCategory;


public interface ThreadCategoryService {
  public DBThreadCategory get(Long threadId, Long categoryId);

  public DBThreadCategory insert(DBThreadCategory val);
  public void update(DBThreadCategory val);
  public void delete(DBThreadCategory val);

  public long count(Long threadId);
}