package com.PocketIdentityDirectory.users.repositories;

import com.PocketIdentityDirectory.users.models.IASUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IASUserRepository extends JpaRepository<IASUser, UUID> {
}
