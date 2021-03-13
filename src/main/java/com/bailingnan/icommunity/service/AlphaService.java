package com.bailingnan.icommunity.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author bailingnan
 * @date 2021/3/11
 */
@Service
public class AlphaService {
    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }
}
