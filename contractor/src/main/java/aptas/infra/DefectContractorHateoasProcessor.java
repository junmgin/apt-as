package aptas.infra;

import aptas.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DefectContractorHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DefectContractor>> {

    @Override
    public EntityModel<DefectContractor> process(
        EntityModel<DefectContractor> model
    ) {
        return model;
    }
}
