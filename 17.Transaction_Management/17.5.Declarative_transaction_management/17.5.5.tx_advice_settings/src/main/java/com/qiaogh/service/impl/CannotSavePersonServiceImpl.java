package com.qiaogh.service.impl;

import com.qiaogh.domain.Person;
import com.qiaogh.exception.CannotSaveException;
import com.qiaogh.service.CannotSavePersonService;

public class CannotSavePersonServiceImpl extends PersonServiceImpl implements CannotSavePersonService {

    @Override
    public void exSave( Person person ) throws CannotSaveException {
        super.save( person );
        throw new CannotSaveException();
    }

}
