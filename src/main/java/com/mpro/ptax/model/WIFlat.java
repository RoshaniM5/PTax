package com.mpro.ptax.model;


public class WIFlat {
	

	    private String serialNo;
	    private String flatUnitNumber;
	    private String inspectionDate;
	    private String dateOfEffect;
	    private String structureType;
	    private String userCategoryForSDRR;
	    private String userSubCategory;
	    private String floor;
	    private String natureTypeOfBuilding;
	    private String fsiFactor;
	    private String meterUnmeter;
	    private String taxCode;
	    private String totalCarpetArea;
	    private String fsiAsPerCourtOrder;

	    public WIFlat(String serialNo, String flatUnitNumber, String inspectionDate,
	                  String dateOfEffect, String structureType,
	                  String userCategoryForSDRR, String userSubCategory,
	                  String floor, String natureTypeOfBuilding,
	                  String fsiFactor, String meterUnmeter, String taxCode,
	                  String totalCarpetArea, String fsiAsPerCourtOrder) {

	        this.serialNo = serialNo;
	        this.flatUnitNumber = flatUnitNumber;
	        this.inspectionDate = inspectionDate;
	        this.dateOfEffect = dateOfEffect;
	        this.structureType = structureType;
	        this.userCategoryForSDRR = userCategoryForSDRR;
	        this.userSubCategory = userSubCategory;
	        this.floor = floor;
	        this.natureTypeOfBuilding = natureTypeOfBuilding;
	        this.fsiFactor = fsiFactor;
	        this.meterUnmeter = meterUnmeter;
	        this.taxCode = taxCode;
	        this.totalCarpetArea = totalCarpetArea;
	        this.fsiAsPerCourtOrder = fsiAsPerCourtOrder;
	    }

	    // Generate Getters here
	    
	    public String getSerialNo() {
	        return serialNo;
	    }

	    public String getFlatUnitNumber() {
	        return flatUnitNumber;
	    }

	    public String getInspectionDate() {
	        return inspectionDate;
	    }

	    public String getDateOfEffect() {
	        return dateOfEffect;
	    }

	    public String getStructureType() {
	        return structureType;
	    }

	    public String getUserCategoryForSDRR() {
	        return userCategoryForSDRR;
	    }

	    public String getUserSubCategory() {
	        return userSubCategory;
	    }

	    public String getFloor() {
	        return floor;
	    }

	    public String getNatureTypeOfBuilding() {
	        return natureTypeOfBuilding;
	    }

	    public String getFsiFactor() {
	        return fsiFactor;
	    }

	    public String getMeterUnmeter() {
	        return meterUnmeter;
	    }

	    public String getTaxCode() {
	        return taxCode;
	    }

	    public String getTotalCarpetArea() {
	        return totalCarpetArea;
	    }

	    public String getFsiAsPerCourtOrder() {
	        return fsiAsPerCourtOrder;
	    }
	}
	

