package com.armancodeblock.carShow.repository;

import com.armancodeblock.carShow.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
