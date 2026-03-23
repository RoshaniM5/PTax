package com.mpro.ptax.model;

import com.mpro.ptax.model.WiData;

public class WiData {

	private String title;
    private String ownerName;
    private String propertyDescription;
    private String streetName;
    private String location;
    private String pincode;
    private String zone;
    private String subZone;
    private String csCtsNo;
    private String billingType;

    public WiData(String title, String ownerName, String propertyDescription,
                  String streetName, String location, String pincode,
                  String zone, String subZone, String csCtsNo,
                  String billingType) {

        this.title = title;
        this.ownerName = ownerName;
        this.propertyDescription = propertyDescription;
        this.streetName = streetName;
        this.location = location;
        this.pincode = pincode;
        this.zone = zone;
        this.subZone = subZone;
        this.csCtsNo = csCtsNo;
        this.billingType = billingType;
    }

    public String getTitle() { 
    	return title; 
    	}
    
    public String getOwnerName() { 
    	return ownerName; 
    	}
    
    public String getPropertyDescription() { 
    	return propertyDescription; 
    	}
    
    public String getStreetName() { 
    	return streetName; 
    	}
    
    public String getLocation() {
    	return location; 
    	}
    
    public String getPincode() { 
    	return pincode; 
    	}
    
    public String getZone() { 
    	return zone; 
    	}
    
    public String getSubZone() {
    	return subZone; 
    	}
    
    public String getCsCtsNo() { 
    	return csCtsNo; 
    	}
    
    public String getBillingType() { 
    	return billingType; 
    	}
}

