package hh.swd20.omaharjoitusNH.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AinesRepository extends CrudRepository<Aines, Long> {
List<Aines> findByNimi(String nimi);
}
