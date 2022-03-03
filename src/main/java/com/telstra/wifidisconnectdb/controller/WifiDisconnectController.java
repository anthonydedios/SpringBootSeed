package com.telstra.wifidisconnectdb.controller;

import com.telstra.wifidisconnectdb.dao.WifiDisconnect;
import com.telstra.wifidisconnectdb.repository.WifiDisconnectRepository;

import com.telstra.wifidisconnectdb.service.WifiDisconnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/wifi-disconnect")
public class WifiDisconnectController {

    @Autowired
    WifiDisconnectRepository wifiDisconnectRepository;

    @Autowired
    WifiDisconnectService wifiDisconnectService;

    //All mapping below are connected to wifiDisconnectService
    @CrossOrigin
    @PostMapping("/insertData/")
    public ResponseEntity<WifiDisconnect> createAccount(@RequestBody WifiDisconnect wifiDC) {
        ResponseEntity<WifiDisconnect> response = wifiDisconnectService.save(wifiDC);
        return new ResponseEntity<WifiDisconnect>(response.getBody(), response.getStatusCode());
    }

    @CrossOrigin
    @PutMapping("/updateData/{id}")
    public ResponseEntity<WifiDisconnect> updateAccount (@PathVariable("id") long id, @RequestBody WifiDisconnect wifiDC) {
        ResponseEntity<WifiDisconnect> response = wifiDisconnectService.findByIdUpdate(id,wifiDC);
        return new ResponseEntity<WifiDisconnect>(response.getBody(), response.getStatusCode());
    }

    @CrossOrigin
    @GetMapping("/selectDataById/{id}")
    public ResponseEntity<WifiDisconnect> getAccountById (@PathVariable("id") long id) {
        ResponseEntity<WifiDisconnect> response = wifiDisconnectService.findById(id);
        return new ResponseEntity<WifiDisconnect>(response.getBody(), response.getStatusCode());
    }

    @CrossOrigin
    @GetMapping("/selectAllData/")
    public ResponseEntity<List<WifiDisconnect>> getAllActiveAccounts() {
        ResponseEntity<List<WifiDisconnect>> response = wifiDisconnectService.findByStatusAndScheduledDate();
        return new ResponseEntity<List<WifiDisconnect>>((List<WifiDisconnect>) response.getBody(), response.getStatusCode());
    }
}
