package com.example.soft_cons.repository;

import com.example.soft_cons.model.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {
}