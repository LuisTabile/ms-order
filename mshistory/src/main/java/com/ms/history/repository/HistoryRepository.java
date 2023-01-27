package com.ms.history.repository;

import com.ms.history.models.entities.HistoryEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryEntity, String> {

    List<HistoryEntity> findAll(Sort orderDate);
}
