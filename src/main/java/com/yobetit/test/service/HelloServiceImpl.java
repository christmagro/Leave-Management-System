package com.yobetit.test.service;

import com.yobetit.test.ui.HelloMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Value("${yobetittest.max.leave.days.peremployee}")
    private  int totalLeaveDaysAllowed;

    protected int getTotalLeaveDaysAllowed() {
        return totalLeaveDaysAllowed;
    }

    @Override
    public HelloMessage getHelloMessage() {
        return new HelloMessage(1123, "Wahoy there", "Welcome to the Yobetit test! Impress us from here onwards...");
    }
}
