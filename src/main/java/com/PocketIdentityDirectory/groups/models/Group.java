package com.PocketIdentityDirectory.groups.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
//
//@Table(name = "groups")
//@Entity
public class Group {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String displayName;

    @Column
    private String description;

}
