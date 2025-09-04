package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        BlueprintsServices service = context.getBean(BlueprintsServices.class);

        try {
            Blueprint bp1 = new Blueprint("David", "Casa1",
                    new Point[]{new Point(0, 0), new Point(10, 10), new Point(20, 20)});
            Blueprint bp2 = new Blueprint("David", "Casa2",
                    new Point[]{new Point(5, 5), new Point(15, 15)});
            Blueprint bp3 = new Blueprint("Ana", "Edificio1",
                    new Point[]{new Point(0, 0), new Point(0, 10), new Point(10, 10)});

            service.addNewBlueprint(bp1);
            service.addNewBlueprint(bp2);
            service.addNewBlueprint(bp3);

            System.out.println("🔹 Consultar Casa1 de David:");
            System.out.println(service.getBlueprint("David", "Casa1"));

            System.out.println("\n🔹 Planos de David:");
            Set<Blueprint> planosDavid = service.getBlueprintsByAuthor("David");
            planosDavid.forEach(System.out::println);

            System.out.println("\n🔹 Todos los planos:");
            service.getAllBlueprints().forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("⚠️ Error: " + e.getMessage());
        }

        context.close();
    }
}
