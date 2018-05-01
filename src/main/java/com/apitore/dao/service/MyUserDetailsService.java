package com.apitore.dao.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.UserDAO;
import com.apitore.dao.model.DBUser;


@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  UserDAO userDAO;

  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    DBUser domainUser = userDAO.getUser(username);
    return new User(domainUser.getUsername(),
        domainUser.getPassword(),
        domainUser.getEnabled(),
        domainUser.getAccountNonExpired(),
        domainUser.getCredentialsNonExpired(),
        domainUser.getAccountNonLocked(),
        getAuthorities(domainUser.getRole().getId())
        );
  }

  public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
    List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
    return authList;
  }

  public List<String> getRoles(Integer role) {
    List<String> roles = new ArrayList<String>();

    if (role.intValue() == 1) {
      roles.add("ROLE_ADMIN");
      roles.add("ROLE_USER");
    } else if (role.intValue() == 2) {
      roles.add("ROLE_USER");
    }
    return roles;
  }

  public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    for (String role : roles) {
      authorities.add(new SimpleGrantedAuthority(role));
    }
    return authorities;
  }

}