package com.hb.cda.projecttodevs.repository;

import com.hb.cda.projecttodevs.entity.Dev;
import com.hb.cda.projecttodevs.repository.interfaces.DevRepository;
import com.hb.cda.projecttodevs.repository.utils.AbstractRepository;

public class DevRepositoryImpl extends AbstractRepository<Dev, Integer> implements DevRepository {
    public DevRepositoryImpl() {
        super(Dev.class);
    }
}
