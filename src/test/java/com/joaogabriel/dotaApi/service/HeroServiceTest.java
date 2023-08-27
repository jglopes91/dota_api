package com.joaogabriel.dotaApi.service;

import com.joaogabriel.dotaApi.dto.hero.HeroListAPIResponseDTO;
import com.joaogabriel.dotaApi.dto.hero.OpenDotaApi;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
public class HeroServiceTest {
    @Mock
    private RestTemplate restTemplate;
    private HeroService heroService;
    private OpenDotaApi<HeroListAPIResponseDTO> openDotaApi;

    @BeforeEach
    public void setup() {
        this.openDotaApi = new OpenDotaApi<>(restTemplate);
        this.heroService = new HeroService(openDotaApi);
    }

    @Test
    public void shouldReturnHeroList() {
        HeroListAPIResponseDTO[] responseFaker = new EasyRandom().nextObject(HeroListAPIResponseDTO[].class);

        Mockito.when(restTemplate.getForEntity("/heroes", HeroListAPIResponseDTO[].class)).thenReturn(new ResponseEntity<>(responseFaker, HttpStatus.OK));

        List<HeroListAPIResponseDTO> heroServiceResponse = heroService.findAllHeros();

        Assertions.assertThat(heroServiceResponse).isNotNull();
        Assertions.assertThat(responseFaker).isEqualTo(heroServiceResponse.toArray());
    }

    @Test
    public void shouldThrowRunTimeExceptionWhenDotaApiFails() {

        Mockito.when(restTemplate.getForEntity("/heroes", HeroListAPIResponseDTO[].class)).thenReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE));
        Throwable throwable = Assertions.catchThrowable(() -> {
            heroService.findAllHeros();
        });
        Assertions.assertThat(throwable).isInstanceOf(RuntimeException.class).hasMessage("Dota API Exception.");
    }

    @Test
    public void shouldReturnHeroListFilteredByHeroName() {
        HeroListAPIResponseDTO[] responseFaker = new EasyRandom().nextObject(HeroListAPIResponseDTO[].class);
        for (HeroListAPIResponseDTO data: responseFaker
             ) {
            data.setName("AAA");
        }
        Mockito.when(restTemplate.getForEntity("/heroes", HeroListAPIResponseDTO[].class)).thenReturn(new ResponseEntity<>(responseFaker, HttpStatus.OK));
        List<HeroListAPIResponseDTO> heroServiceResponse = heroService.findHerosByName("BBB");
        Assertions.assertThat(heroServiceResponse).isEmpty();
    }
}
