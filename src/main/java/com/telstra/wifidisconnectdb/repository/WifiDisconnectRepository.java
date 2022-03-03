package com.telstra.wifidisconnectdb.repository;

import com.telstra.wifidisconnectdb.dao.WifiDisconnect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WifiDisconnectRepository extends JpaRepository<WifiDisconnect, Long> {

    List<WifiDisconnect> findByStatusAndScheduledDate(String status, String scheduledDate);
}
