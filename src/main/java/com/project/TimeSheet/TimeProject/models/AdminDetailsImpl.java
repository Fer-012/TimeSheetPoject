package com.project.TimeSheet.TimeProject.models;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AdminDetailsImpl implements UserDetails {
	private Long id ;
	private String email;
	private String firstName;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public AdminDetailsImpl(Long id, String email, String firstName, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.password = password;
		this.authorities = authorities;
	}
	

    public static AdminDetailsImpl build(Admin admin) {
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER")); // Remove the condition and always assign ROLE_USER
        return new AdminDetailsImpl(admin.getId(), admin.getEmail(), admin.getFirstName(), admin.getPassword(),
                authorities);
    }

	public boolean equals(Object o) {
		
		if(this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AdminDetailsImpl admin = (AdminDetailsImpl) o;
		return Objects.equals(id, admin.id);
		
	}

	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		return "AdminDetailsImpl [id=" + id + ", email=" + email + ", firstName=" + firstName + ", password=" + password
				+ ", authorities=" + authorities + "]";
	}
}
