package edu.mum.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3855561356507854561L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long id = null;

	@Version
	private int version = 0;

	@Column(name = "FIRSTNAME", nullable = false)
	@NotEmpty
	private String firstName;

	@Column(name = "LASTNAME", nullable = false)
	@NotEmpty
	private String lastName;

	@Column(name = "EMAIL", nullable = false)
	@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
	private String email;

	@Column(name = "RANK", nullable = false)
	private int ranking = 0;

	@Column(name = "IS_ADMIN", nullable = false)
	private boolean admin = false;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	@Embedded
	@Valid
	private UserCredentials userCredentials;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "user")
	@Embedded
	@Valid
	private Address address = new Address();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
		this.userCredentials.setUser(this);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

//	public Set<Item> getBoughtItems() {
//		return boughtItems;
//	}
//
//	public void setBoughtItems(Set<Item> boughtItems) {
//		this.boughtItems = boughtItems;
//	}
//
//	public void addBoughtItem(Item boughtItem) {
//		this.boughtItems.add(boughtItem);
//	}
}