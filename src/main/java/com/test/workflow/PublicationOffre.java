package com.test.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PublicationOffre implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String titrePoste = (String) execution.getVariable("titrePoste");
        String description = (String) execution.getVariable("description");
        String profil = (String) execution.getVariable("profil");
        String experience = (String) execution.getVariable("experience");
        String typeContratStr = (String) execution.getVariable("typeContrat");

        TypeContrat typeContrat;
        try {
            typeContrat = TypeContrat.valueOf(typeContratStr.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new RuntimeException("Type de contrat invalide ou manquant : " + typeContratStr);
        }

        System.out.println("******** L'offre a été publiée avec succès !*************\t");
        System.out.println(" Titre du poste      : " + titrePoste);
        System.out.println(" Description         : " + description);
        System.out.println(" Profil recherché    : " + profil);
        System.out.println(" Expérience requise  : " + experience);
        System.out.println(" Type de contrat     : " + typeContrat);
    }
}
