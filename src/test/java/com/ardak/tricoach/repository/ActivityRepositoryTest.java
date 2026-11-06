package com.ardak.tricoach.repository;

import com.ardak.tricoach.FakeHashGenerator;
import com.ardak.tricoach.TestcontainersConfiguration;
import com.ardak.tricoach.entity.Activity;
import com.ardak.tricoach.entity.Sport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestcontainersConfiguration.class)
public class ActivityRepositoryTest {

    @Autowired
    private ActivityRepository activityRepository;
    private static final Instant BEFORE_PERIOD_TIME = Instant.parse("2026-11-05T06:30:00Z");
    private static final Instant IN_PERIOD_TIME = Instant.parse("2026-11-06T05:30:00Z");
    private static final Instant IN_PERIOD_TIME_2 = Instant.parse("2026-11-07T08:00:00Z");
    private static final Instant AFTER_PERIOD_TIME = Instant.parse("2026-11-08T12:30:00Z");
    private static final Instant PERIOD_START_TIME = Instant.parse("2026-11-06T00:00:00Z");
    private static final Instant PERIOD_END_TIME = Instant.parse("2026-11-08T00:00:00Z");


    // Test for happy path and only for Running, I guess we need to create for each Sport Type
    @Test
    void returnsOnlyActivitiesStartedInsideGivenPeriod(){
        //Given
        saveActivityAt(BEFORE_PERIOD_TIME);
        saveActivityAt(IN_PERIOD_TIME);
        saveActivityAt(IN_PERIOD_TIME_2);
        saveActivityAt(AFTER_PERIOD_TIME);

        //When
        List<Activity> activityList = activityRepository.findByStartTimeBetween(PERIOD_START_TIME, PERIOD_END_TIME);

        //Then
        assertThat(activityList).extracting(Activity::getStartTime)
                .containsExactlyInAnyOrder(IN_PERIOD_TIME, IN_PERIOD_TIME_2);
    }

    private void saveActivityAt(Instant startTime){
        activityRepository
                .save(new Activity(Sport.RUN, startTime, 6000, 10000.0, 145, FakeHashGenerator.nextFakeHash()));
    }
}
