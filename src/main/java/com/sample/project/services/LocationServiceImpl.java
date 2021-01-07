package com.sample.project.services;

import com.sample.project.dto.LocationDto;
import com.sample.project.model.Location;
import com.sample.project.repositories.LocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<LocationDto> findAll() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().map(this::mapFromLocationToDto).collect(toList());
    }
    private LocationDto mapFromLocationToDto(Location location) {
        ModelMapper mapper = new ModelMapper();
        LocationDto locationDto = mapper.map(location, LocationDto.class);
        return locationDto;
    }
}
