package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.ApiProjectsDAO;
import com.apitore.dao.model.DBApiProjects;
import com.apitore.dao.service.ApiProjectsService;


@Service
public class ApiProjectsServiceImpl implements ApiProjectsService {

  @Autowired
  ApiProjectsDAO dao;


  @Override
  @Transactional(readOnly=true)
  public List<DBApiProjects> getApiProjects(long projectId) {
    return dao.getApiProjects(projectId);
  }

  @Override
  @Transactional(readOnly=true)
  public DBApiProjects getApiProject(long projectId, long apiId) {
    return dao.getApiProject(projectId, apiId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBApiProjects insert(DBApiProjects val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBApiProjects val) {
    dao.update(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void delete(DBApiProjects val) {
    dao.delete(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void deleteHQL(long projectId) {
    dao.deleteHQL(projectId);
  }

  @Override
  @Transactional(readOnly=true)
  public long count(Long projectId) {
    return dao.count(projectId);
  }

}