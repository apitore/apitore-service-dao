package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserReportDAO;
import com.apitore.dao.model.DBUserReport;
import com.apitore.dao.service.UserReportService;


@Service
public class UserReportServiceImpl implements UserReportService {

  @Autowired
  UserReportDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBUserReport get(Long apiId, Long userId) {
    return dao.get(apiId, userId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUserReport insert(DBUserReport val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBUserReport val) {
    dao.update(val);
  }

}