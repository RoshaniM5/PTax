package com.mpro.ptax.test.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.mpro.ptax.Utils.ReadExcel;
import com.mpro.ptax.model.WIFlat;
import com.mpro.ptax.model.WiData;

public class WIDataProvider {
	
	 @DataProvider(name = "WIDataProvider")   
	    public static Iterator<Object[]> getWiData() {

	        Iterator<WiData> wiIterator = ReadExcel.getWIData();
	        List<Object[]> data = new ArrayList<>();

	        while (wiIterator.hasNext()) {
	            data.add(new Object[]{ wiIterator.next() });
	        }

	        return data.iterator();
	    }

	    @DataProvider(name = "WIFlatDataProvider")   // ← ADD THIS
	    public static Iterator<Object[]> getWIFlatData() {

	        Iterator<WIFlat> flatIterator = ReadExcel.getFlatData();
	        List<Object[]> data = new ArrayList<>();

	        while (flatIterator.hasNext()) {
	            data.add(new Object[]{ flatIterator.next() });
	        }

	        return data.iterator();
	    }
	}