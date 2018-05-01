package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.ApiDAO;
import com.apitore.dao.model.DBApi;
import com.apitore.dao.service.ApiService;


@Service
public class ApiServiceImpl implements ApiService {

  @Autowired
  ApiDAO dao;


  @Override
  @Transactional(readOnly=true)
  public List<DBApi> getApis_Enabled_Desc(String[] fields, int offset, int limit) {
    return dao.getApis_Enabled_Desc(fields, offset, limit);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBApi> getApis_Enabled_Free_Desc(String[] fields, int offset, int limit) {
    return dao.getApis_Enabled_Free_Desc(fields, offset, limit);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBApi> getApis_Enabled_Paid_Desc(String[] fields, int offset, int limit) {
    return dao.getApis_Enabled_Paid_Desc(fields, offset, limit);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBApi> getApis_DevId_Desc_Public(long devId, String[] fields, int offset, int limit) {
    return dao.getApis_DevId_Desc_Public(devId, fields, offset, limit);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBApi> getApis_UserId_Desc_Public(long userId, String[] fields, int offset, int limit) {
    return dao.getApis_UserId_Desc_Public(userId, fields, offset, limit);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBApi> getApis_UserId_Desc_Private(long userId, String[] fields, int offset, int limit) {
    return dao.getApis_UserId_Desc_Private(userId, fields, offset, limit);
  }

  @Override
  @Transactional(readOnly=true)
  public DBApi getApi(long apiId) {
    return dao.getApi(apiId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBApi insert(DBApi val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBApi val) {
    dao.update(val);
  }

  @Override
  @Transactional(readOnly=true)
  public long countByDevId(Long devId) {
    return dao.countByDevId(devId);
  }

  @Override
  @Transactional(readOnly=true)
  public long countByUserId(Long userId) {
    return dao.countByUserId(userId);
  }

}