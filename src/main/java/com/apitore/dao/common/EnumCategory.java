package com.apitore.dao.common;


public enum EnumCategory {
  TEXT_ANALYSIS ("text_analysis","Text Analysis"),
  MACHINE_LEARNING ("machine_learning","Machine Learning"),
  COMPUTER_VISION ("computer_vision","Computer Vision"),
  UTILITY ("utility","Utility");

  private final String id;
  private final String title;
  private EnumCategory(final String id, final String title) {
    this.id = id;
    this.title = title;
  }
  public String getId() {
    return id;
  }
  public String getTitle() {
    return title;
  }
  public String getField() {
    return id;
  }
  public static EnumCategory getEnumFromId(final String id) {
    if (TEXT_ANALYSIS.getId().equals(id))
      return TEXT_ANALYSIS;
    else if (MACHINE_LEARNING.getId().equals(id))
      return MACHINE_LEARNING;
    else if (COMPUTER_VISION.getId().equals(id))
      return COMPUTER_VISION;
    else if (UTILITY.getId().equals(id))
      return UTILITY;
    else
      return null;
  }
}
