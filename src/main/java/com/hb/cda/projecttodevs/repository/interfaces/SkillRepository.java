package com.hb.cda.projecttodevs.repository.interfaces;

import com.hb.cda.projecttodevs.entity.Skill;

import java.util.List;

public interface SkillRepository extends GenericRepository<Skill, Integer>{
    List<Skill> findByIds(List<Integer> ids);
}
