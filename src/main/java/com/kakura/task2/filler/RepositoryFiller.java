package com.kakura.task2.filler;

import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.repository.RectangleRepository;

import java.util.List;

public class RepositoryFiller {

    public void fillRepository(Rectangle rectangle) {
        RectangleRepository repository = RectangleRepository.getInstance();
        WarehouseFiller warehouseFiller = new WarehouseFiller();

        repository.add(rectangle);
        warehouseFiller.fillWarehouse(rectangle);
    }

    public void fillRepository(List<Rectangle>rectangles) {
        for(Rectangle rectangle : rectangles) {
            fillRepository(rectangle);
        }
    }

}
