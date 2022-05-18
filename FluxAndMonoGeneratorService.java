package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Array;
import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> nameFlux() {
        return Flux.fromIterable(List.of("Name1", "Name2", "Name3")).log();
    }

    public Flux<String> nameFluxMap() {
        return Flux.fromIterable(List.of("Name1", "Name2", "Name3"))
                .map(String::toUpperCase).log();
    }

    public Flux<String> nameFluxMapImmutable() {
        var fluxMapImmutable = Flux.fromIterable(List.of("Name1", "Name2", "Name3"));
         fluxMapImmutable.map(String::toUpperCase).log();
        return fluxMapImmutable;
    }

    public Flux<String> nameFluxMapFilter(int length) {
        return Flux.fromIterable(List.of("Name1", "Name2", "Name3"))
                .map(String::toUpperCase).filter(item -> item.length()>length).log();
    }

    public Flux<String> nameFluxMapFilterFlatMap(int length) {
        return Flux.fromIterable(List.of("Name1", "Name22", "Name333"))
                .map(String::toUpperCase).filter(item -> item.length()>length)
                .flatMap(input -> splitter(input));
    }

    public Flux<String> splitter(String input){

      return   Flux.fromArray(input.split(""));
    }

    public Mono<String> nameMono() {
        return Mono.just("Name1-mono").log();
    }

    public Mono<String> nameMonoMap() {
        return Mono.just("Name1-mono")
                .map(name -> name.toUpperCase()).log();
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        service.nameFlux().subscribe(name -> System.out.println("Name : " + name));
        service.nameFluxMap().subscribe(name -> System.out.println("Name : " + name));
        service.nameMono().subscribe(name -> System.out.println("Name : " + name));
        service.nameMonoMap().subscribe(name -> System.out.println("Name : " + name));
    }
}
