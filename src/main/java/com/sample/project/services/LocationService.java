package com.sample.project.services;

import com.sample.project.dto.LocationDto;
import java.util.List;

public interface LocationService {
    List<LocationDto> findAll();
}
