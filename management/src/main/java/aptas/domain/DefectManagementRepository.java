package aptas.domain;

import aptas.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "defectManagements",
    path = "defectManagements"
)
public interface DefectManagementRepository
    extends PagingAndSortingRepository<DefectManagement, Long> {}
