package com.hb.cda.projecttodevs.repository.interfaces;

import com.hb.cda.projecttodevs.entity.Project;

import java.time.LocalDate;
import java.util.List;

public interface ProjectRepository extends GenericRepository<Project, Integer> {
    List<Project> findByTheme(String themeName);
    List<Project> findByMinBudget(float budget);
    List<Project> findByDeliveryDate(LocalDate date);
}
