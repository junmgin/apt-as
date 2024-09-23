package aptas.domain;

import aptas.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "defectContractors",
    path = "defectContractors"
)
public interface DefectContractorRepository
    extends PagingAndSortingRepository<DefectContractor, Long> {}
