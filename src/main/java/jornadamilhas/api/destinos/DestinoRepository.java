package jornadamilhas.api.destinos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DestinoRepository extends JpaRepository<Destinos, Long> {
    Page<Destinos> findAllByAtivoTrue(Pageable paginacao);
}
