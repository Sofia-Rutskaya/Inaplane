package com.Airtickets.Inaplane.service;


import com.Airtickets.Inaplane.persistence.entity.Tickets.Plane;
import com.Airtickets.Inaplane.persistence.repository.IPlaneRepository;
import com.Airtickets.Inaplane.service.interfaces.IPlaneService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaneService implements IPlaneService {
    private final IPlaneRepository _planeRepository;

    public PlaneService(IPlaneRepository planeRepository) {
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
