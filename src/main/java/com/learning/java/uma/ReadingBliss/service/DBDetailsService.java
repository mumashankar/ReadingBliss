package com.learning.java.uma.ReadingBliss.service;

import com.learning.java.uma.ReadingBliss.dao.DBDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Component
public class DBDetailsService {
    @Autowired
    private DBDetailsDao dbDetailsDao;

    @Scheduled(cron = "0 0 */12 * * *")
    public List<String> getTables(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a", Locale.ENGLISH);
        System.out.println(now.format(formatter) + ": Getting list of tables from public schema.");
        return dbDetailsDao.getDBTables();
    }
}
