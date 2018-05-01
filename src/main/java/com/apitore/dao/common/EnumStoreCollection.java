package com.apitore.dao.common;


public enum EnumStoreCollection {
  TOP("top","高評価APIs","rateNumReview"),
  NEW("new","新着APIs","registeredAt"),
  CALLED("called","コール数上位APIs","numCalled"),
  CALLED_FREE("calledFree","無料トップAPIs","numCalled"),
  CALLED_PAID("calledPaid","有料トップAPIs","numCalled"),
  REGISTERED("registered","登録数上位APIs","numRegistered");

  private final String id;
  private final String title;
  private final String field;
  private EnumStoreCollection(final String id, final String title, final String field) {
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
  public static EnumStoreCollection getEnumFromId(String id) {
    if (TOP.getId().equals(id))
      return TOP;
    else if (NEW.getId().equals(id))
      return NEW;
    else if (CALLED.getId().equals(id))
      return CALLED;
    else if (CALLED_FREE.getId().equals(id))
      return CALLED_FREE;
    else if (CALLED_PAID.getId().equals(id))
      return CALLED_PAID;
    else if (REGISTERED.getId().equals(id))
      return REGISTERED;
    else
      return null;
  }
}
