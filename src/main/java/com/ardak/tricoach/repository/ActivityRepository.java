package com.ardak.tricoach.repository;

import com.ardak.tricoach.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByStartTimeBetween(Instant startTime, Instant endTime);
}
