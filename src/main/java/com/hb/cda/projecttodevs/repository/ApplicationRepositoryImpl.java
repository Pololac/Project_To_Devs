package com.hb.cda.projecttodevs.repository;

import com.hb.cda.projecttodevs.entity.Application;
import com.hb.cda.projecttodevs.repository.interfaces.ApplicationRepository;
import com.hb.cda.projecttodevs.repository.utils.AbstractRepository;

public class ApplicationRepositoryImpl extends AbstractRepository<Application, Integer> implements ApplicationRepository {
    public ApplicationRepositoryImpl() {
        super(Application.class);
    }
}
