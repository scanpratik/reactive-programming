package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService sut = new FluxAndMonoGeneratorService();

    @Test
    void nameFlux() {
        //given

        //when
        Flux<String> nameFlux = sut.nameFlux();

        //then
        StepVerifier.create(nameFlux).expectNext("Name1", "Name2", "Name3")
                .verifyComplete();
    }

    @Test
    void nameFluxCount() {
        //given

        //when
        Flux<String> nameFlux = sut.nameFlux();

        //then
        StepVerifier.create(nameFlux).expectNext("Name1").expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void nameMono() {
        //given

        //when
        Mono<String> nameMono = sut.nameMono();

        //then
        StepVerifier.create(nameMono).expectNext("Name1-mono")
                .verifyComplete();
    }

    @Test
    void nameMonoCount() {
        //given

        //when
        Mono<String> nameMono = sut.nameMono();

        //then
        StepVerifier.create(nameMono).expectNext("Name1-mono").expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void nameFluxMap() {

        //given

        //when
        Flux<String> nameFluxMap = sut.nameFluxMap();

        //then
        StepVerifier.create(nameFluxMap).expectNext("NAME1", "NAME2" , "NAME3")
                .verifyComplete();


    }

    @Test
    void nameFluxMapImmutable() {

        //given

        //when
        Flux<String> nameFluxMapImmutable = sut.nameFluxMapImmutable();

        //then
        StepVerifier.create(nameFluxMapImmutable).expectNext("Name1", "Name2", "Name3")
                .verifyComplete();

    }

    @Test
    void nameMonoMap() {
        //given

        //when
        Mono<String> nameMonoMap = sut.nameMonoMap();

        //then
        StepVerifier.create(nameMonoMap).expectNext("NAME1-MONO").expectNextCount(0)
                .verifyComplete();

    }

    @Test
    void nameFluxMapFilter() {
        //given

        //when
        Flux<String> nameFluxMapFilter = sut.nameFluxMapFilter(5);

        //then
        StepVerifier.create(nameFluxMapFilter).expectNext()
                .verifyComplete();

    }

    @Test
    void nameFluxMapFilterFlatMap() {

        //given

        //when
        Flux<String> nameFluxMapFilterFlatMap = sut.nameFluxMapFilterFlatMap(2 );

        //then
        StepVerifier.create(nameFluxMapFilterFlatMap).expectNext("N","A","M","E","3","3","3")
                .verifyComplete();
    }
}