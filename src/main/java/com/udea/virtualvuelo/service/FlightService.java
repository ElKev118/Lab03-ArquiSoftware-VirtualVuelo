package com.udea.virtualvuelo.service;

import com.udea.virtualvuelo.dao.IFlightDAO;
import com.udea.virtualvuelo.exception.FlightNotFoundException;
import com.udea.virtualvuelo.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private IFlightDAO dao;

    public Flight save(Flight f){
        return dao.save(f);
    }

    public String delete(Long id){
        dao.deleteById(id);
        return "Flight deleted";
    }

    public Iterable<Flight> list(){
        return dao.findAll();
    }

    public Optional<Flight> ListId(Long id){
        return dao.findById(id);
    }

    public Flight update(Flight f){
        Flight existingFlight = dao.findById(f.getIdFlight()).orElse(null);
        existingFlight.setNombreAvion(f.getNombreAvion());
        existingFlight.setNumeroVuelo(f.getNumeroVuelo());
        existingFlight.setOrigen(f.getOrigen());
        existingFlight.setDestino(f.getDestino());
        existingFlight.setCapacidad(f.getCapacidad());
        existingFlight.setRating(f.getRating());
        existingFlight.setPlanVuelo(f.getPlanVuelo());
        existingFlight.setCumplido(f.getCumplido());
        return dao.save(existingFlight);
    }

    public List<Flight>  viewBestFlights() throws FlightNotFoundException {
        List<Flight> flights = dao.viewBestFlights();
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("No flights found with rating >= 4 ");
        } else {
            return flights;
        }
    }
}
