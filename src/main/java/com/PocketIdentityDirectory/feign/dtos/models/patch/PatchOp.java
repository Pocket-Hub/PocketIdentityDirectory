package com.PocketIdentityDirectory.feign.dtos.models.patch;

import java.util.List;

public class PatchOp {

    private final String[] schemas = new String[]{"urn:ietf:params:scim:api:messages:2.0:PatchOp"};

    private List<Operations> Operations;

}
