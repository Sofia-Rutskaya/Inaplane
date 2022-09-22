package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.From;
import com.Airtickets.Inaplane.persistence.repository.IFromRepository;
import com.Airtickets.Inaplane.persistence.repository.ITicketRepository;
import com.Airtickets.Inaplane.service.interfaces.IFromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FromService implements IFromService {
    private final IFromRepository _fromRepository;

    public FromService(IFromRepository fromRepository) {
        _fromRepository = fromRepository;
    }


    @Override
    public List<From> getAllItem() {
        return null;
    }

    @Override
    public void create(From from) {

    }

    @Override
    public From getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
