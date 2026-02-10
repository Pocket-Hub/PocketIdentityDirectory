package com.PocketIdentityDirectory.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GeneralController {

    private final GeneralService generalService;

    @Autowired
    public GeneralController(GeneralService generalService) {
        this.generalService = generalService;
    }

    @PostMapping("/sync")
    public ResponseEntity<Void> sync() throws InterruptedException {
        Thread.sleep(10000);
        generalService.sync();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
