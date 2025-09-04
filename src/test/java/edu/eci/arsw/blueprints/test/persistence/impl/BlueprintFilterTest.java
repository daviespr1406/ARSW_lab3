package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.AppConfigRedundancy;
import edu.eci.arsw.blueprints.AppConfigSubsampling;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlueprintFilterTest {

    @Test
    public void testRedundancyFilter() throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigRedundancy.class);
        BlueprintsServices services = ac.getBean(BlueprintsServices.class);

        Point[] pts = new Point[]{
                new Point(0, 0),
                new Point(0, 0), // repetido
                new Point(10, 10),
                new Point(10, 10), // repetido
                new Point(20, 20)
        };
        Blueprint bp = new Blueprint("juan", "redundant", pts);
        services.addNewBlueprint(bp);

        Blueprint filtered = services.getBlueprint("juan", "redundant");

        assertEquals(Float.parseFloat("El plano debería tener 3 puntos después de filtrar"), 3,filtered.getPoints().size());
        assertEquals(new Point(0,0), filtered.getPoints().get(0));
        assertEquals(new Point(10,10), filtered.getPoints().get(1));
        assertEquals(new Point(20,20), filtered.getPoints().get(2));
    }

    @Test
    public void testSubsamplingFilter() throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigSubsampling.class);
        BlueprintsServices services = ac.getBean(BlueprintsServices.class);

        Point[] pts = new Point[]{
                new Point(0, 0),
                new Point(10, 10),
                new Point(20, 20),
                new Point(30, 30),
                new Point(40, 40)
        };
        Blueprint bp = new Blueprint("ana", "subsample", pts);
        services.addNewBlueprint(bp);

        Blueprint filtered = services.getBlueprint("ana", "subsample");

        assertEquals(Float.parseFloat("El plano debería tener 3 puntos después de filtrar"), 3, filtered.getPoints().size());
        assertEquals(new Point(0,0), filtered.getPoints().get(0));
        assertEquals(new Point(20,20), filtered.getPoints().get(1));
        assertEquals(new Point(40,40), filtered.getPoints().get(2));
    }
}
