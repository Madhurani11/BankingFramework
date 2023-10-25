package com.listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utility.Utility;

public class MyListner implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            Utility.takeScreenShot(result.getTestName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
