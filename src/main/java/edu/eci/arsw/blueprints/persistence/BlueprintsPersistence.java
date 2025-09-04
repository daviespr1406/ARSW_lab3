/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence;

import edu.eci.arsw.blueprints.model.Blueprint;

/**
 *
 * @author hcadavid
 */

import java.util.Set;

public interface BlueprintsPersistence {
    void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException;
    Blueprint getBlueprint(String author, String name) throws BlueprintNotFoundException;
    Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException;
    Set<Blueprint> getAllBlueprints();
}


