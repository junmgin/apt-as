package aptas.infra;

import aptas.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DefectManagementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DefectManagement>> {

    @Override
    public EntityModel<DefectManagement> process(
        EntityModel<DefectManagement> model
    ) {
        return model;
    }
}
