/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;


import org.jongo.marshall.jackson.oid.Id;

import java.util.List;

public class Portal {

  @Id
  private String uuid;

  private List<String> urls;

  /**
   * The name of the portal
   */
  private String name;

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String id) {
    this.uuid = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getUrls() {
    return urls;
  }

  public void setUrls(List<String> urls) {
    this.urls = urls;
  }

  @Override
  public String toString() {
    return "Portal{" +
        "id=" + uuid +
        ", name='" + name + '\'' +
        ", urls='" + urls +
        '}';
  }
}
