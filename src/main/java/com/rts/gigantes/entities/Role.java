package com.rts.gigantes.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ROLES")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ROLE_CODE")
	private String roleCode;

	@Column(name = "ACTIVE")
	private Boolean active = Boolean.TRUE;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "USERS_ROLES", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "USER_ID") })
	private List<User> usersList = new ArrayList<>();

}
