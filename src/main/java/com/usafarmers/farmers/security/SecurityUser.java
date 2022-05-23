package com.usafarmers.farmers.security;

import org.springframework.security.core.userdetails.UserDetails;
import com.usafarmers.farmers.domain.User;

public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = -768590123482494682L;

	public SecurityUser() {
	}

	public SecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setUserId(user.getUserId());
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
