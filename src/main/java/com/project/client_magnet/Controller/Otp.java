package com.project.client_magnet.Controller;

import java.util.Random;
public class Otp extends Random{
    static Random r = new Random();
    
    public static int otpGenerator() {        
        return 999999 - r.nextInt(899999);
    }
}