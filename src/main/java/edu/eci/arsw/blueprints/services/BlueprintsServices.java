package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.filters.BlueprintFilter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BlueprintsServices {

    @Autowired
    private BlueprintsPersistence bpp;

    @Autowired
    private BlueprintFilter filter;

    public void addNewBlueprint(Blueprint bp) throws Exception {
        bpp.saveBlueprint(bp);
    }

    public Blueprint getBlueprint(String author, String name) throws BlueprintNotFoundException {
        Blueprint bp = bpp.getBlueprint(author, name);
        return filter.applyFilter(bp);
    }

    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        Set<Blueprint> bps = bpp.getBlueprintsByAuthor(author);
        return bps.stream()
                .map(filter::applyFilter)
                .collect(Collectors.toSet());

    }

    public Set<Blueprint> getAllBlueprints() {
        return bpp.getAllBlueprints();
    }
}
