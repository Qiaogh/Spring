package com.qiaogh.service;

import com.qiaogh.domain.Person;
import com.qiaogh.exception.CannotSaveException;

public interface CannotSavePersonService extends PersonService {

    void exSave( Person person ) throws CannotSaveException;
}
