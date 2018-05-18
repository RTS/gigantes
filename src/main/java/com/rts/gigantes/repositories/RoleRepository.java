package com.rts.gigantes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.gigantes.entities.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByRoleCode(String roleCode);

}
