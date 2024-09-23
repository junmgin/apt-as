package aptas.infra;

import aptas.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DefectRegistrationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DefectRegistration>> {

    @Override
    public EntityModel<DefectRegistration> process(
        EntityModel<DefectRegistration> model
    ) {
        return model;
    }
}
