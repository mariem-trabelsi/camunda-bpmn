package com.test.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.*;

public class PreSelectionService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        List<Map<String, Object>> candidatures = new ArrayList<>();

        candidatures.add(createCandidat("Ali Ben Salah", 85));
        candidatures.add(createCandidat("Fatma Trabelsi", 62));
        candidatures.add(createCandidat("Youssef Khaldi", 91));
        candidatures.add(createCandidat("Rania Messaoud", 70));

        int seuil = 75;

        List<Map<String, Object>> candidatsRetenus = new ArrayList<>();
        for (Map<String, Object> candidat : candidatures) {
            int score = (int) candidat.get("score");
            if (score >= seuil) {
                candidatsRetenus.add(candidat);
            }
        }

        execution.setVariable("candidatsRetenus", candidatsRetenus);
        execution.setVariable("nombreCandidatsRetenus", candidatsRetenus.size());

        System.out.println("Candidatures retenues :");
        candidatsRetenus.forEach(c -> System.out.println(c.get("nom") + " avec un score de " + c.get("score")));
    }

    private Map<String, Object> createCandidat(String nom, int score) {
        Map<String, Object> candidat = new HashMap<>();
        candidat.put("nom", nom);
        candidat.put("score", score);
        return candidat;
    }
}
