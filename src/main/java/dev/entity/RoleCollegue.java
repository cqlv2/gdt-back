package dev.entity;

import javax.persistence.*;

import enumeration.Role;

@Entity
@Table(name = "role_collegue")
public class RoleCollegue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "collegue_id")
	private Collegue collegue;
	@Enumerated(EnumType.STRING)
	private Role role;

	// construct
	public RoleCollegue() {
	}

	public RoleCollegue(Collegue collegue, Role role) {
		this.collegue = collegue;
		this.role = role;
	}

	// getteurSetteur
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Collegue getCollegue() {
		return collegue;
	}

	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}
}
