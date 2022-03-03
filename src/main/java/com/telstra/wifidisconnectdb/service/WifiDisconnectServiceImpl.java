package com.telstra.wifidisconnectdb.service;

import com.telstra.wifidisconnectdb.dao.WifiDisconnect;
import com.telstra.wifidisconnectdb.repository.WifiDisconnectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WifiDisconnectServiceImpl implements WifiDisconnectService{

    @Autowired
    WifiDisconnectRepository wifiDisconnectRepository;

    @Override
    public ResponseEntity<WifiDisconnect> findById(long id) {
        System.out.println("THIS IS THE ID " + id);
        Optional<WifiDisconnect> wd = wifiDisconnectRepository.findById(id);
        if (wd.isPresent()) {
            System.out.println("SUCCESS");
            return new ResponseEntity<>(wd.get(), HttpStatus.OK);
        } else {
            System.out.println("FAILED");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<WifiDisconnect> save(@RequestBody WifiDisconnect wifiDC) {
        Date date = new Date();
        try {
            WifiDisconnect wd = wifiDisconnectRepository
                    .save(new WifiDisconnect(wifiDC.getCustomerAccountCode(), wifiDC.getBillingAccountCode(),
                            wifiDC.getServiceId(), wifiDC.getStatus(), wifiDC.getSwbVersion(),
                            wifiDC.getCreditCode(), wifiDC.getDnumber(), wifiDC.getScheduledDate(), date));
            return new ResponseEntity<>(wd, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<WifiDisconnect> findByIdUpdate(long id, @RequestBody WifiDisconnect wifiDC) {
        Optional<WifiDisconnect> wifiDisconnectData = wifiDisconnectRepository.findById(id);
        if (wifiDisconnectData.isPresent()) {

            System.out.println("Working");

            WifiDisconnect wifiHolder = wifiDisconnectData.get();
            wifiHolder.setCustomerAccountCode(wifiDC.getCustomerAccountCode());
            wifiHolder.setBillingAccountCode(wifiDC.getBillingAccountCode());
            wifiHolder.setServiceId(wifiDC.getServiceId());
            wifiHolder.setStatus(wifiDC.getStatus());
            wifiHolder.setSwbVersion(wifiDC.getSwbVersion());
            wifiHolder.setCreditCode(wifiDC.getCreditCode());
            wifiHolder.setDnumber(wifiDC.getDnumber());
            return new ResponseEntity<>(wifiDisconnectRepository.save(wifiHolder), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<WifiDisconnect>> findByStatusAndScheduledDate() {
        try {
            List<WifiDisconnect> wd = new ArrayList<WifiDisconnect>();

            DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            Date date = new Date();
            System.out.println("DATE " + dateFormat.format(date));

            if (wd.isEmpty()) {
                wifiDisconnectRepository.findByStatusAndScheduledDate("Active", dateFormat.format(date)).forEach(wd::add);
            } else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(wd, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
