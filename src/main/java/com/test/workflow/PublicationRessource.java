package com.test.workflow;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicationRessource {

    private final PublicationService publicationService;

    public PublicationRessource(PublicationService publicationService) {
        this.publicationService = publicationService;
    }


    @GetMapping("/run")
    public ResponseEntity<String> getPublication() {
        publicationService.demarrer();
        return ResponseEntity.ok("Processus de recrutement a été démarré  avec succés");
    }

    @GetMapping("/notify")
    public ResponseEntity<String> candidatureNotifiee() {
        publicationService.candidatureNotifiee();
        return ResponseEntity.ok("Candiidature réçue");
    }
}
