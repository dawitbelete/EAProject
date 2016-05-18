package edu.mum.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity(name = "CREDENTIALS")
public class UserCredentials {

	@Id
	@Column(nullable = false, unique = true)
	@Size(min = 4, max = 8)
	String username;

	@Column(nullable = false,length=256,name="password")
	String realPassword;
	
	@Transient
	@Size(min = 8, max = 14)
	String password;
	
	@Transient
	@NotNull(message="not match")
	String verifyPassword;
	
	Boolean enabled;

	@OneToOne(mappedBy = "userCredentials", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private User user;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "credentials_id")
	List<Authority> authority = new ArrayList<Authority>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		checkPassword();
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
		checkPassword();
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

	public void addAuthority(Authority authority) {
		this.authority.add(authority);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private void checkPassword() {
	    if(this.password == null || this.verifyPassword == null){
	        return;
	    }else if(!this.password.equals(verifyPassword)){
	        this.verifyPassword = null;
	    }
	    else{
	    	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();   		
	   	 	this.realPassword = passwordEncoder.encode(password);
	    }
	}

	public String getRealPassword() {
		return realPassword;
	}

	public void setRealPassword(String realPassword) {
		this.realPassword = realPassword;
	}
}
