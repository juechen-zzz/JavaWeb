package com.komorebi.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    // 在一个特定的时间执行这个方法
    // cron表达式
    // 秒 分 时 日 月 星期，？只能用在日期和星期上，*指匹配任何值
    /*
        0 50 10 * * ？           每天的10点50分执行
        30 0/5 10,18 * * ?       每天的10点和18点，每隔5分钟执行一次
     */
    @Scheduled(cron = "0 50 10 * * 0-7")
    public void hello(){
        System.out.println("hello");
    }
}
