package com.apitore.dao.common;


public enum EnumMeCollection {
  REGISTERED("registeredDesc","登録日降順","registeredAt"),
  CALLED("called","使用回数降順","numCalledTotal"),
  PAID("paid","使用クレジット降順","usedCreditTotal");
  //REVIEW("reviewDesc","レビュー数降順","numReview"),
  //RATED("rateDesc","高評価順","rateNumReview"),

  private final String id;
  private final String title;
  private final String field;
  private EnumMeCollection(final String id, final String title, final String field) {
    this.id = id;
    this.title = title;
    this.field = field;
  }
  public String getId() {
    return id;
  }
  public String getTitle() {
    return title;
  }
  public String getField() {
    return field;
  }
  public static EnumMeCollection getEnumFromId(String id) {
    if (REGISTERED.getId().equals(id))
      return REGISTERED;
    else if (CALLED.getId().equals(id))
      return CALLED;
    else if (PAID.getId().equals(id))
      return PAID;
    else
      return null;
  }
}
