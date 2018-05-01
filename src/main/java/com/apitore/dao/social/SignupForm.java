package com.apitore.dao.social;


import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;

import lombok.Data;


@Data
public class SignupForm {
  @NotEmpty
  private String username;
  @Size(min = 8, max = 16, message = "must be 8-16 characters")
  private String password;
  @NotEmpty
  private String displayName;
  @NotEmpty
  private String firstName;
  @NotEmpty
  private String lastName;

  private String imageUrl = null;

  public static SignupForm fromProviderUser(Connection<?> connection) {
    UserProfile providerUser = connection.fetchUserProfile();

    SignupForm form = new SignupForm();
    form.setFirstName(providerUser.getFirstName());
    form.setLastName(providerUser.getLastName());
    form.setDisplayName(providerUser.getName());
    form.setUsername(providerUser.getEmail());
    form.setImageUrl(connection.getImageUrl());
    return form;
  }
}