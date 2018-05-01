package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.ApiUseLogDAO;
import com.apitore.dao.model.DBApiUseLog;
import com.apitore.dao.service.ApiUseLogService;


@Service
public class ApiUseLogServiceImpl implements ApiUseLogService {

  @Autowired
  ApiUseLogDAO dao;


  @Override
  @Transactional(readOnly=true)
  public List<DBApiUseLog> getApiUseLog_ByUserId(long userId, int offset, int limit) {
    return dao.getApiUseLog_ByUserId(userId, offset, limit);
  }


  @Override
  @Transactional(readOnly=true)
  public DBApiUseLog get_NotPaid() {
    return dao.get_NotPaid();
  }


  @Override
  @Transactional(readOnly=true)
  public List<DBApiUseLog> gets_NotPaid(long userId) {
    return dao.gets_NotPaid(userId);
  }


  @Override
  @Transactional(readOnly=true)
  public List<DBApiUseLog> gets_NotPaid(long apiId, long userId) {
    return dao.gets_NotPaid(apiId, userId);
  }


  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBApiUseLog insert(DBApiUseLog value) {
    return dao.insert(value);
  }


  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBApiUseLog value) {
    dao.update(value);
  }

}