package aptas.domain;

import aptas.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "defectRegistrations",
    path = "defectRegistrations"
)
public interface DefectRegistrationRepository
    extends PagingAndSortingRepository<DefectRegistration, String> {}
