package hh.swd20.omaharjoitusNH.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PohjaRepository extends CrudRepository<Pohja, Long> {
	List<Pohja> findByNimi(String nimi);
}
