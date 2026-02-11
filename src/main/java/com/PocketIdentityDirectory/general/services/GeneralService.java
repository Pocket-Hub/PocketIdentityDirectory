package com.PocketIdentityDirectory.general.services;

import com.PocketIdentityDirectory.groups.services.GroupService;
import com.PocketIdentityDirectory.users.models.helpers.Country;
import com.PocketIdentityDirectory.users.models.helpers.Status;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.PocketIdentityDirectory.users.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class GeneralService {

    private final UserService userService;

    private final GroupService groupService;

    @Autowired
    public GeneralService(UserService userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
    }

    @Transactional
    @Scheduled(fixedRate = 100_000)
    public void sync() {
        groupService.syncGroups();
        userService.syncUsers();
    }

    public Country[] getCountries() {
        return Country.values();
    }

    public UserType[] getUserTypes() {
        return UserType.values();
    }

    public Status[] getStatuses() {
        return Status.values();
    }

}
