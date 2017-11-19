package repository.jpa;

import org.springframework.stereotype.Repository;

import repository.MatriculaRepository;
import domain.Matricula;

@Repository
public class JpaMatriculaRepository extends JpaBaseRepository<Matricula, Long> implements
		MatriculaRepository {
}
