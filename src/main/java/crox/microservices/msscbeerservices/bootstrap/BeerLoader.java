package crox.microservices.msscbeerservices.bootstrap;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import crox.microservices.msscbeerservices.domain.Beer;
import crox.microservices.msscbeerservices.repositories.BeerRepository;


@Component
public class BeerLoader implements CommandLineRunner
{
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository)
    {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        loadBeerObject();
    }
    private void loadBeerObject() {
        if(beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bob")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(23498237L)
                    .minOnHand(12)
                    .price(new BigDecimal(12.95))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("Pale Ale")
                    .quantityToBrew(200)
                    .upc(23423488L)
                    .minOnHand(12)
                    .price(new BigDecimal(11.95))
                    .build());
        }
    }
}
