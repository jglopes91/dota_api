package com.joaogabriel.dotaApi.service;

import com.joaogabriel.dotaApi.dto.hero.HeroListAPIResponseDTO;
import com.joaogabriel.dotaApi.dto.hero.OpenDotaApi;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroService {
    private final OpenDotaApi<HeroListAPIResponseDTO> openDotaApi;

    public HeroService(final OpenDotaApi<HeroListAPIResponseDTO> openDotaApi) {
        this.openDotaApi = openDotaApi;
    }

    @Cacheable("getHeroCache")
    public List<HeroListAPIResponseDTO> findAllHeros() {
       return openDotaApi.getListFromEntity("/heroes", HeroListAPIResponseDTO[].class);
    }

    public List<HeroListAPIResponseDTO> findHerosByName(final String name) {
        List<HeroListAPIResponseDTO> response = this.findAllHeros();
        return response.parallelStream().filter(object -> object.getName()
                        .toLowerCase()
                        .contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
