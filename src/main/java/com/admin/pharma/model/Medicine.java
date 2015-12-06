package com.admin.pharma.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 12/3/2015.
 */
@Getter
@Setter
public class Medicine {
    public  String drugID;
    public Map<String,Double> contents =new HashMap<>();

    @Override
    public boolean equals(Object obj) {
        if(obj == null ) return  false;
        return drugID.equals(((Medicine)obj).drugID);
    }

    @Override
    public int hashCode() {
        return drugID.hashCode() ;
    }
}
