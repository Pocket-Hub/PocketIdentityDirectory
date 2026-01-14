package com.PocketIdentityDirectory.users.repositories;

import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.models.helpers.Status;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("""
    SELECT DISTINCT u FROM User u
    LEFT JOIN u.groups g
    WHERE (:lastName IS NULL 
           OR LOWER(u.name.lastName) LIKE LOWER(CONCAT('%', :lastName, '%')))
      AND (:type IS NULL 
           OR u.type = :type)
      AND (:status IS NULL 
           OR u.status = :status)
      AND (:groupName IS NULL 
           OR LOWER(g.name) LIKE LOWER(CONCAT('%', :groupName, '%')))
""")
    List<User> filterUsersByUserStatusOrUserTypeOrLastNameOrGroupName(
            @Param("type") UserType type,
            @Param("lastName") String lastName,
            @Param("status") Status status,
            @Param("groupName") String groupName
    );

}
