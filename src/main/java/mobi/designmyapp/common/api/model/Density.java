/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

public class Density {

  private String density;
  private float factor;

  public Density(String density, float factor) {
    this.density = density;
    this.factor = factor;
  }

  public String getDensity() {
    return density;
  }

  public float getFactor() {
    return factor;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("density=").append(this.density);
    sb.append(", ").append("factor=").append(this.factor);
    return sb.toString();
  }

}
