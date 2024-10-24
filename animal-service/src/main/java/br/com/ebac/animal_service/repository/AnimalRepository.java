package br.com.ebac.animal_service.repository;

import java.util.List;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ebac.animal_service.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataEntrada IS NOT NULL AND a.tipoAnimal = :tipoAnimal")
    List<Animal> findAllCat(@Param("tipoAnimal") String tipoAnimal);

    @Query("SELECT a.nomeRecebedor, COUNT(a) FROM Animal a GROUP BY a.nomeRecebedor ORDER BY COUNT(a) DESC")
    List<Object[]> foundByReceiver();

    @Query("SELECT a.nomeRecebedor, COUNT(a) FROM Animal a WHERE a.dataEntrada >= :dataInicio GROUP BY a.nomeRecebedor ORDER BY COUNT(a) DESC")
    List<Object[]> foundByReceiverDate(@Param("dataInicio") Date dataInicio);
}
