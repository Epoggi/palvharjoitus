package hh.swd20.omaharjoitusNH.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends CrudRepository<Pizza, Long>{

//Etsi pitsat joissa gluteeniton pohja
//List <Pizza> findByGlut(pohja.sisalto);
//Etsi pitsat ilman lihaa
//List <Pizza> findByVege(ainekset.!meat);
//Etsi pitsat vegaanille
//List <Pizza> findByVegan(ainekset.!animal);
}
