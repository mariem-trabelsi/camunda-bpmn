package com.test.workflow;

import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.stereotype.Service;


@Service
public class PublicationService {

    private final ProcessEngine processEngine;

    public PublicationService(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }



    public void demarrer() {
        processEngine.getRuntimeService().
                startProcessInstanceByMessage("Message_3h94cqj","recrutement-v");
    }


    public void candidatureNotifiee() {
        processEngine.getRuntimeService()
                .createMessageCorrelation("Message_3hl9qbi")
                .processInstanceBusinessKey("recrutement-v")
                .correlate();

    }
}
