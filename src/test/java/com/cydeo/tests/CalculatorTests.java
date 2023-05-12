package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTests {


    //APPIUM FOR ANDROID APP AUTOMATION SET UP:
    //
    //1) we need mobile device with our application:
    //     -> we can connect physical device
    //     -> we can use emulator virtual device
    //    Android studio -> for android virtual devices
    //    XCode -> ios virtual devices
    //
    //2) Appium server -> we need to connect and run automated steps in mobile devices
    //
    //3) Appium client -> we added dependency in our project for   <dependency>
    //            <groupId>io.appium</groupId>
    //            <artifactId>java-client</artifactId>
    //            <version>7.6.0</version>
    //        </dependency>
    //
    //4) now we can write our code in intellij class, and run automated test for android application(calculator)

    //=======================
    //
    //We need DesiredCapabilities to describe what we need from Appium server.
    //We are saying "hey appium server, I want to run my tests for below description:"
    //
    // DesiredCapabilities caps = new DesiredCapabilities();
    //       // caps.setCapability("deviceName", "Pixel 3");
    //        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
    //        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    //        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
    //        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk" );
    //======================
    //Appium server runs in certain machine: we need IP address and port number.
    //
    //URL url = new URL("http://localhost:4723/wd/hub");
    //
    //http://localhost:4723/wd/hub => Appium server is running in our local computer at port number 4723.
    ///wd/hub is the path that we add.

    //===============================

    //AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);
    //
    //AppiumDriver driver  is similar to WebDriver driver
    //AppiumDriver is an interface and has several implementations:
    //
    //AndroidDriver -> is a class to controll android application in mobile device
    //
    //IOSDriver -> is a class to control ios application in mobile device
    //
    //(url, caps) -> we are specifying the location/url of appium server and capabilities that describe what we need from appium server.
    //
    //===============================
    @Test
    public void CalculatorAddTest() throws MalformedURLException, InterruptedException {
        //DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setCapability("deviceName", "Pixel 3");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk" );

        //set URL for the appium server
        URL url = new URL("http://localhost:4723/wd/hub");

        //launch appiumDriver
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);
       // System.out.println(driver.getTitle()); --> wrong command
        System.out.println(driver.getDeviceTime());
        Assertions.assertEquals("android",  driver.getPlatformName());

        Thread.sleep(4000);

        MobileElement clearElement = driver.findElement(MobileBy.AccessibilityId("clear"));

        System.out.println("TExt of element:  " + clearElement.getText());
        Assertions.assertTrue(clearElement.isDisplayed());

        //close the app
        driver.closeApp();

//

    }
}
