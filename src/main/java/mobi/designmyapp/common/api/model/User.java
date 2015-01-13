/*
Copyright © 2014 by eBusiness Information
All rights reserved. This source code or any portion thereof
may not be reproduced or used in any manner whatsoever
without the express written permission of eBusiness Information.
*/
package mobi.designmyapp.common.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.jongo.marshall.jackson.oid.Id;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

  /*=========================================*/
  /*------------ATTRIBUTES-------------------*/
  /*=========================================*/

  @Id
  private String uuid;

  /**
   * User First name
   */
  private String firstName;

  /**
   * User Last name
   */
  private String lastName;

  /**
   * User e-mail address
   */
  private String email;

  /**
   * User Password
   */
  private String password;

  private boolean emailProtected;

  private boolean locked;

  /**
   * User account creation date
   */
  private Date creationDate;

  /**
   * User account last modification date
   */
  private Date lastModifDate;

  private Date lastLoginDate;

  private Portal portal;

  private String phoneNumber;

  private Role role;


  /*=========================================*/
  /*------------BUILDER----------------------*/
  /*=========================================*/

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private User user;

    private Builder() {
      user = new User();
    }

    public Builder uuid(String id) {
      user.uuid = id;
      return this;
    }

    public Builder firstName(String firstName) {
      user.firstName = firstName;
      return this;
    }

    public Builder lastName(String lastName) {
      user.lastName = lastName;
      return this;
    }

    public Builder email(String email) {
      user.email = email;
      return this;
    }

    public Builder password(String password) {
      user.password = password;
      return this;
    }

    public Builder emailProtected(boolean emailProtected) {
      user.emailProtected = emailProtected;
      return this;
    }

    public Builder locked(boolean locked) {
      user.locked = locked;
      return this;
    }

    public Builder creationDate(Date creationDate) {
      user.creationDate = creationDate;
      return this;
    }

    public Builder lastModifDate(Date lastModifDate) {
      user.lastModifDate = lastModifDate;
      return this;
    }

    public Builder lastLoginDate(Date lastLoginDate) {
      user.lastLoginDate= lastLoginDate;
      return this;
    }

    public Builder portal(Portal portal) {
      user.portal= portal;
      return this;
    }

    public Builder phoneNumber(String phoneNumber) {
      user.phoneNumber= phoneNumber;
      return this;
    }

    public Builder Role(Role role){
      user.role = role;
      return this;
    }

    public User build() {
      return user;
    }
  }

/*=========================================*/
  /*--------------- GETTER/SETTER------------*/
  /*=========================================*/

  public String getUuid() {
    return uuid;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public boolean isEmailProtected() { return emailProtected; }

  public boolean isLocked() { return locked; }

  public Date getCreationDate() {
    return creationDate;
  }

  public Date getLastModifDate() {
    return lastModifDate;
  }

  public Date getLastLoginDate() { return lastLoginDate; }

  public Portal getPortal() { return  portal; }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public Role getRole() {
    return role;
  }
  /*=========================================*/
  /*--------------- SETTER ------------------*/
  /*=========================================*/


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) { this.password = password; }

  public void setEmailProtected(boolean emailProtected) {
    this.emailProtected = emailProtected;
  }

  public void setLocked(boolean locked) {
    this.locked = locked;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public void setLastModifDate(Date lastModifDate) {
    this.lastModifDate = lastModifDate;
  }

  public void setLastLoginDate(Date lastLoginDate) { this.lastLoginDate = lastLoginDate; }

  public void setPortal(Portal portal) { this.portal = portal; }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  /*=========================================*/
  /*------------CODE-------------------------*/
  /*=========================================*/

  @Override
  public String toString() {
    return "User{" +
        "uuid=" + uuid +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", emailProtected=" + emailProtected +
        ", locked=" + locked +
        ", creationDate=" + creationDate +
        ", lastModifDate=" + lastModifDate +
        ", lastLoginDate=" + lastLoginDate +
        ", portal=" + portal +
        ", phoneNumber=" + phoneNumber +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (uuid != null ? !uuid.equals(user.uuid) : user.uuid != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return uuid != null ? uuid.hashCode() : 0;
  }

  public enum Role {
    USER, DEVELOPER, ADMIN
  }
}
