package crox.microservices.msscbeerservices.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crox.microservices.msscbeerservices.web.model.BeerDto;


@RestController
@RequestMapping("/api/v1/beer")
public class BeerController
{
    @GetMapping("/{beerId}")
    public ResponseEntity getBeerById(@PathVariable("beerId") UUID beerId)
    {
        return new ResponseEntity(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer( @RequestBody BeerDto beerDto)
    {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto)
    {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
