package com.udea.virtualvuelo.controller;

import com.udea.virtualvuelo.exception.InvalidRate;
import com.udea.virtualvuelo.exception.ModelNotFoundException;
import com.udea.virtualvuelo.model.Flight;
import com.udea.virtualvuelo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flight")
@CrossOrigin(origins = "*")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping("/save")
    public long save(@RequestBody Flight flight) throws InvalidRate {
        if(flight.getRating()>5){
            throw new InvalidRate("Ratins should be between 0 and 5");
        }
        flightService.save(flight);
        return flight.getIdFlight();
    }

    @GetMapping("/listAll")
    public Iterable<Flight> listAllFlights(){
        return flightService.list();
    }

    @GetMapping("/list/{id}")
    public Flight listFlightById(@PathVariable("id") long id){
        Optional<Flight> flight = flightService.ListId(id);
        if(flight.isPresent()){
            return flight.get();
        }else
        {
            throw new ModelNotFoundException("Flight id invalid");
        }
    }

    @GetMapping("/BestFlights")
    public ResponseEntity<List<Flight>> viewBestFlights(){
        List<Flight> list = flightService.viewBestFlights();
        return  new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @PutMapping
    public Flight updateFlight(@RequestBody Flight flight){
        return flightService.update(flight);
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable("id") long id){
        return flightService.delete(id);
    }


}
