package com.Airtickets.Inaplane.persistence.repository;


import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<E extends BaseEntity>  extends JpaRepository<E, Long> { }
