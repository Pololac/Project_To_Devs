package com.hb.cda.projecttodevs.repository;

import com.hb.cda.projecttodevs.entity.ProductOwner;
import com.hb.cda.projecttodevs.repository.interfaces.ProductOwnerRepository;
import com.hb.cda.projecttodevs.repository.utils.AbstractRepository;
import jakarta.persistence.EntityManager;

public class ProductOwnerRepositoryImpl extends AbstractRepository<ProductOwner, Integer> implements ProductOwnerRepository {

    /**
     * @param em          un EntityManager déjà ouvert dans le Main (pas fermé ici)
     */
    public ProductOwnerRepositoryImpl(EntityManager em) {
        super(em, ProductOwner.class);
    }
}
