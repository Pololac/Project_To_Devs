package com.hb.cda.projecttodevs.repository;

import com.hb.cda.projecttodevs.entity.Project;
import com.hb.cda.projecttodevs.repository.interfaces.ProjectRepository;
import com.hb.cda.projecttodevs.repository.utils.AbstractRepository;

public class ProjectRepositoryImpl extends AbstractRepository<Project, Integer> implements ProjectRepository {

    public ProjectRepositoryImpl() {
        super(Project.class);
    }

}
