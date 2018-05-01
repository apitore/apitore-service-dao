package com.apitore.dao.service;

import java.util.List;

import com.apitore.dao.model.DBApiProjects;


public interface ApiProjectsService {
  public List<DBApiProjects> getApiProjects(long projectId);
  public DBApiProjects getApiProject(long projectId, long apiId);

  public DBApiProjects insert(DBApiProjects val);
  public void update(DBApiProjects val);
  public void delete(DBApiProjects val);
  public void deleteHQL(long projectId);

  public long count(Long projectId);
}