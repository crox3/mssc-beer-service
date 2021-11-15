package crox.microservices.msscbeerservices.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import crox.microservices.msscbeerservices.domain.Beer;


public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID>
{
}
