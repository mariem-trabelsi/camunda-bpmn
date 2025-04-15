package com.test.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class GenererPromesseEmbauche implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String nomCandidat = (String) execution.getVariable("nomCandidat");
        String titrePoste = (String) execution.getVariable("titrePoste");
        String typeContrat = (String) execution.getVariable("typeContrat");
        String salaire = (String) execution.getVariable("salaireSouhaite");


        String contenu = "PROMESSE D'EMBAUCHE\n\n"
                + "Cher(e) " + nomCandidat + ",\n\n"
                + "Nous sommes heureux de vous proposer le poste de " + titrePoste + ".\n"
                + "Type de contrat : " + typeContrat + "\n"
                + "Salaire proposé : " + salaire + " EUR/mois.\n\n"
                + "Veuillez trouver ci-joint cette promesse d’embauche.\n"
                + "Cordialement,\nL'équipe RH";

        System.out.println("\n=== Promesse d'embauche générée ===\n");
        System.out.println(contenu);
        System.out.println("\n===================================\n");

        execution.setVariable("promesseEmbaucheTexte", contenu);
    }
}
