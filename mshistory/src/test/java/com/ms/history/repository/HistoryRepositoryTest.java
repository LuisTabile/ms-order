package com.ms.history.repository;

import com.ms.history.models.entities.HistoryEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HistoryRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HistoryRepository historyRepository;

    @Test
    public void whenFindAll_thenReturnSortedList() {
        // given
        HistoryEntity history1 = new HistoryEntity("123", LocalDateTime.of(2022,1,1,0,0));
        HistoryEntity history2 = new HistoryEntity("456", LocalDateTime.of(2022,2,1,0,0));
        HistoryEntity history3 = new HistoryEntity("789", LocalDateTime.of(2022,3,1,0,0));
        entityManager.persist(history1);
        entityManager.persist(history2);
        entityManager.persist(history3);
        entityManager.flush();

        // when
        Sort orderDate = Sort.by("orderDate").ascending();
        List<HistoryEntity> found = historyRepository.findAll(orderDate);

        // then
        assertThat(found.size()).isEqualTo(3);
        assertThat(found.get(0).getId()).isEqualTo("123");
        assertThat(found.get(1).getId()).isEqualTo("456");
        assertThat(found.get(2).getId()).isEqualTo("789");
    }
}