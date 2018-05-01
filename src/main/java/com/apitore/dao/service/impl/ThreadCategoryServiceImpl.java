package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.ThreadCategoryDAO;
import com.apitore.dao.model.DBThreadCategory;
import com.apitore.dao.service.ThreadCategoryService;


@Service
public class ThreadCategoryServiceImpl implements ThreadCategoryService {

  @Autowired
  ThreadCategoryDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBThreadCategory get(Long threadId, Long categoryId) {
    return dao.get(threadId, categoryId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBThreadCategory insert(DBThreadCategory val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBThreadCategory val) {
    dao.update(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void delete(DBThreadCategory val) {
    dao.delete(val);
  }

  @Override
  @Transactional(readOnly=true)
  public long count(Long threadId) {
    return dao.count(threadId);
  }

}