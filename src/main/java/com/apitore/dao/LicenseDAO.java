package com.apitore.dao;

import java.util.List;

import com.apitore.dao.model.DBLicense;


public interface LicenseDAO {
  public List<DBLicense> get();
}