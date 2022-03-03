package com.telstra.wifidisconnectdb.service;

import com.telstra.wifidisconnectdb.dao.WifiDisconnect;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface WifiDisconnectService {
    ResponseEntity<WifiDisconnect> findById(long id);
    ResponseEntity<WifiDisconnect> save(@RequestBody WifiDisconnect wifiDC);
    ResponseEntity<WifiDisconnect> findByIdUpdate(long id,  @RequestBody WifiDisconnect wifiDC);
    ResponseEntity<List<WifiDisconnect>> findByStatusAndScheduledDate();
}
