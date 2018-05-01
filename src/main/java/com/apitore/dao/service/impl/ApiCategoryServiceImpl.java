package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.ApiCategoryDAO;
import com.apitore.dao.model.DBApiCategory;
import com.apitore.dao.service.ApiCategoryService;


@Service
public class ApiCategoryServiceImpl implements ApiCategoryService {

  @Autowired
  ApiCategoryDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBApiCategory get(Long apiId, Long categoryId) {
    return dao.get(apiId, categoryId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBApiCategory insert(DBApiCategory val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBApiCategory val) {
    dao.update(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void delete(DBApiCategory val) {
    dao.delete(val);
  }

  @Override
  @Transactional(readOnly=true)
  public long count(Long apiId) {
    return dao.count(apiId);
  }

}