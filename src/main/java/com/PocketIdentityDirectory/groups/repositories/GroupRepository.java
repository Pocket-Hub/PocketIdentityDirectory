package com.PocketIdentityDirectory.groups.repositories;

import com.PocketIdentityDirectory.groups.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {

    @Query("""
    SELECT DISTINCT g FROM Group g
    WHERE (:name IS NULL OR LOWER(g.name) LIKE LOWER(CONCAT('%', :name, '%')))
      AND (:displayName IS NULL OR LOWER(g.displayName) LIKE LOWER(CONCAT('%', :displayName, '%')))
""")
    List<Group> filterGroupsByNameAndDisplayName(
            @Param("name") String name,
            @Param("displayName") String displayName
    );

}
