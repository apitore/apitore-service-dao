package com.apitore.dao.service;

import java.util.List;

import com.apitore.dao.model.DBLicense;


public interface LicenseService {
  public List<DBLicense> get();
}