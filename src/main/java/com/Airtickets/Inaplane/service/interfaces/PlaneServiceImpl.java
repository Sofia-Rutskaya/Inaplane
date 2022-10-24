package com.Airtickets.Inaplane.service.interfaces;


import com.Airtickets.Inaplane.persistence.entity.Tickets.Plane;
import com.Airtickets.Inaplane.persistence.repository.TicketsRepo.PlaneRepository;
import com.Airtickets.Inaplane.service.PlaneService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaneServiceImpl implements PlaneService {
    private final PlaneRepository _planeRepository;

    public PlaneServiceImpl(PlaneRepository planeRepository) {
        _planeRepository = planeRepository;
    }

    @Override
    public List<Plane> getAllItem() {
        return _planeRepository.findAll();
    }

    @Override
    public void create(Plane plane) {
        _planeRepository.save(plane);
    }

    @Override
    public Plane getById(Long id) {
        return _planeRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        _planeRepository.deleteById(id);
    }
}
