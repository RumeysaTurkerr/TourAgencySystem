package com.patikapaycore.TourAgencySystem.service.iml;
import com.patikapaycore.TourAgencySystem.exception.NotFoundException;
import com.patikapaycore.TourAgencySystem.model.entity.Route;
import com.patikapaycore.TourAgencySystem.repository.RouteRepository;
import com.patikapaycore.TourAgencySystem.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;


    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Route getRoute(Integer id) {
        Optional<Route> byId = routeRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Route"));
    }

    @Override
    public void addRoute(Route route) {
        routeRepository.save(route);
    }

    @Override
    public Route updateRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public boolean deleteRoute(Integer id) {
        routeRepository.delete(getRoute(id));
        return true;
    }

}
