package com.hb.cda.projecttodevs.repository.interfaces;

import com.hb.cda.projecttodevs.entity.Application;
import com.hb.cda.projecttodevs.entity.Project;

import java.util.List;

public interface ApplicationRepository extends GenericRepository<Application, Integer> {
    List<Application> findByProjectId(Integer projectId);
}
