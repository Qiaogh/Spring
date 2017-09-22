package com.qiaogh.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.qiaogh.domain.Family;
import com.qiaogh.service.FamilyService;

public class FamilyServiceImpl implements FamilyService {

    private Map<String, Family> families = new HashMap<String, Family>();
    
    {
        families.put( "1", new Family( "1", "Qiao" ) );
        families.put( "2", new Family( "2", "Qi" ) );
    }
    
    @Override
    public Family get( String id ) {
        return families.get( id );
    }

}
