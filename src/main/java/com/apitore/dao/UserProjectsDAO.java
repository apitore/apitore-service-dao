package com.apitore.dao;

import java.util.List;

import com.apitore.dao.model.DBUserProjects;


public interface UserProjectsDAO {
  public DBUserProjects getUserProject(long projectId);
  public List<DBUserProjects> getUserProjects(long userId);

  public DBUserProjects insert(DBUserProjects val);
  public void update(DBUserProjects val);
  public void delete(DBUserProjects val);

  public long count(Long userId);
}