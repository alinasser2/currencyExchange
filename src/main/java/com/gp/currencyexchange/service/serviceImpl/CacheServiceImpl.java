package com.gp.currencyexchange.service.serviceImpl;

import com.gp.currencyexchange.service.CacheService;
import com.gp.currencyexchange.service.ExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private ExchangeService exchangeService;
    // define logger variable
    private static final Logger log = LoggerFactory.getLogger(CacheServiceImpl.class);


    @Scheduled(cron = "0 0 * * * *")
    public void evictAllcachesAtIntervals() {
        String cacheMessage = exchangeService.clearCache();
        log.info(cacheMessage);
    }
}
