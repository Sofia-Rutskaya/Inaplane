package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.Plane;
import com.Airtickets.Inaplane.persistence.repository.ITicketRepository;
import com.Airtickets.Inaplane.service.interfaces.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaneService implements IPlaneService {
    private final IPlaneService _planeService;

    public PlaneService(IPlaneService planeService) {
        _planeService = planeService;
    }

    @Override
    public List<Plane> getAllItem() {
        return null;
    }

    @Override
    public void create(Plane plane) {

    }

    @Override
    public Plane getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
