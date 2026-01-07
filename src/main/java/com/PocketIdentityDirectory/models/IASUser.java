package com.PocketIdentityDirectory.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class IASUser {

    @Id
    private UUID id;

    @Column
    private String email;

    @Column
    @Embedded
    private Name name;





}
