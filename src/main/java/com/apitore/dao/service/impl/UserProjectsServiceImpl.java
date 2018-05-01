package com.apitore.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserProjectsDAO;
import com.apitore.dao.model.DBUserProjects;
import com.apitore.dao.service.UserProjectsService;


@Service
public class UserProjectsServiceImpl implements UserProjectsService {

  @Autowired
  UserProjectsDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBUserProjects getUserProject(long projectId) {
    return dao.getUserProject(projectId);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBUserProjects> getUserProjects(long userId) {
    return dao.getUserProjects(userId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBUserProjects insert(DBUserProjects val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBUserProjects val) {
    dao.update(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void delete(DBUserProjects val) {
    dao.delete(val);
  }

  @Override
  @Transactional(readOnly=true)
  public long count(Long userId) {
    return dao.count(userId);
  }

}