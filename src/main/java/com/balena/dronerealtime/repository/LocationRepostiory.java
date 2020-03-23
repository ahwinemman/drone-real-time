package com.balena.dronerealtime.repository;

import com.balena.dronerealtime.model.LocationModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class LocationRepostiory implements CrudRepository<LocationModel, String> {

    @Override
    public <S extends LocationModel> S save(S s) {
        return null;
    }

    @Override
    public <S extends LocationModel> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<LocationModel> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<LocationModel> findAll() {
        return null;
    }

    @Override
    public Iterable<LocationModel> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(LocationModel locationModel) {

    }

    @Override
    public void deleteAll(Iterable<? extends LocationModel> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
