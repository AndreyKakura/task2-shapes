package com.kakura.task2.filler;

import com.kakura.task2.entity.Point;
import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.repository.RectangleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryFillerTest {
    private RepositoryFiller repositoryFiller;
    private RectangleRepository repository;

    @BeforeEach
    void setUp() {
        repositoryFiller = new RepositoryFiller();
        repository = RectangleRepository.getInstance();
    }

    @AfterEach
    void tearDown() {
        repositoryFiller = null;
        repository = null;
    }

    @Test
    void fillRepository() {
        Rectangle expectedRectangle = new Rectangle(new Point(1, 1), new Point(1, 5), new Point(7, 5),
                new Point(7, 1));
        repositoryFiller.fillRepository(expectedRectangle);

        assertEquals(expectedRectangle, repository.getRectangles().get(repository.size() - 1));
    }

    @Test
    void fillRepositoryWithList() {
        List<Rectangle> expectedList = new ArrayList<>();
        expectedList.add(new Rectangle(new Point(1, 1), new Point(1, 5), new Point(7, 5),
                new Point(7, 1)));
        expectedList.add(new Rectangle(new Point(1, 2), new Point(1, 5), new Point(6, 5),
                new Point(6, 2)));

        repositoryFiller.fillRepository(expectedList);

        assertEquals(expectedList, repository.getRectangles());
    }
}