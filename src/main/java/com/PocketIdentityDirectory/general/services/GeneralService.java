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

import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class GeneralService {

    private final UserService userService;

    private final GroupService groupService;

    private final AtomicBoolean isRunning = new AtomicBoolean(false);

    @Autowired
    public GeneralService(UserService userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
    }

    @Transactional
    @Scheduled(fixedRate = 100_000)
    public void sync() throws InterruptedException {
        if (isRunning.get()){
            throw new RuntimeException("Sync is currently being executed");
        }
        try {
            isRunning.set(true);
            Thread.sleep(10000);
            System.out.println("Started: " + System.currentTimeMillis());
            groupService.syncGroups();
            userService.syncUsers();
            System.out.println("Ended: " + System.currentTimeMillis());
            isRunning.set(false);
        } catch (Exception e) {
            isRunning.set(false);
            throw e;
        }
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
