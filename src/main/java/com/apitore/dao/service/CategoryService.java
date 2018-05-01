package com.apitore.dao.service;

import java.util.List;

import com.apitore.dao.model.DBCategory;
import com.apitore.dao.model.DBThread;


public interface CategoryService {
  public DBCategory getCategory(String category);
  public DBCategory getCategoryLazyApi(String category, int offset, int limit);

  public List<DBThread> getThread_RegisteredAt(String category, int offset, int limit);
  public List<DBThread> getThread_UpdatedAt(String category, int offset, int limit);
  public List<DBThread> getThread_NumWant(String category, int offset, int limit);
  public List<DBThread> getThread_NumGood(String category, int offset, int limit);

  public DBCategory insert(DBCategory val);
}