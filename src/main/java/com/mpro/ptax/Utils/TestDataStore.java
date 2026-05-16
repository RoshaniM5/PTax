package com.mpro.ptax.Utils;

public class TestDataStore {
	

	    private static ThreadLocal<String> sacNo = new ThreadLocal<>();

	    public static void setSacNo(String value) {
	        sacNo.set(value);
	        
	    }

	    public static String getSacNo() {
	        return sacNo.get();
	    }
	}


