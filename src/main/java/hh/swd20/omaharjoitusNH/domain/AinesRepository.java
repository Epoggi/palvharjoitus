package hh.swd20.omaharjoitusNH.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AinesRepository extends CrudRepository<Ainekset, Long> {
List<Ainekset> findByNimi(String nimi);
}
