package com.wql;

import com.dao.pojo.jdbctemplatetestpojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.Optional;

public class MyCustomer implements PagingAndSortingRepository<jdbctemplatetestpojo,Integer> {

    EntityManager en;

    Class<jdbctemplatetestpojo> pojoClass;

    public MyCustomer(EntityManager en, Class<jdbctemplatetestpojo> pojoClass) {
        this.en = en;
        this.pojoClass = pojoClass;
    }

    public MyCustomer(){}

    @Override
    public Iterable<jdbctemplatetestpojo> findAll(Sort sort) {

        return null;
    }

    @Override
    public Page<jdbctemplatetestpojo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends jdbctemplatetestpojo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends jdbctemplatetestpojo> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<jdbctemplatetestpojo> findById(Integer id) {

        System.out.println("wqlqwdkasd");

        System.out.println(pojoClass);

        System.out.println(id);

        System.out.println(en);

        return Optional.of(en.find(pojoClass,id));
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<jdbctemplatetestpojo> findAll() {
        return null;
    }

    @Override
    public Iterable<jdbctemplatetestpojo> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(jdbctemplatetestpojo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends jdbctemplatetestpojo> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
