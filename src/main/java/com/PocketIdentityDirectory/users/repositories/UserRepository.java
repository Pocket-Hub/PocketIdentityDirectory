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
    SELECT DISTINCT e FROM User e
    LEFT JOIN e.groups g
    WHERE (:lastName IS NULL OR e.name.lastName = :lastName)
      AND (:type IS NULL OR e.type = :type)
      AND (:status IS NULL OR e.status = :status)
      AND (:groupId IS NULL OR g.id = :groupId)
""")
    List<User> filterUsersByUserStatusOrUserTypeOrLastName(@Param("type") UserType userType,
                                                           @Param("lastName") String lastName,
                                                           @Param("status") Status status,
                                                           @Param("groupId") UUID groupId);
}
