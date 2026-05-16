package com.mpro.ptax.Utils;

import io.qameta.allure.Allure;

public class StepUtils {

    public static void step(String stepName, Runnable action) {
        Allure.step(stepName);  
        action.run();            
    }
}

