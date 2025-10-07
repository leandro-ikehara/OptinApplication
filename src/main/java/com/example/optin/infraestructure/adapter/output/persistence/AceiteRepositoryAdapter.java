package com.example.optin.infraestructure.adapter.output.persistence;

import com.example.optin.domain.model.Aceite;
import com.example.optin.domain.ports.output.AceiteRepositoryPort;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * Entidade JPA que será mapeada para a tabela no banco de dados.
 */
@Entity
@Table(name = "aceites")
@Getter
@Setter
@NoArgsConstructor
class AceiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String idUsuario;
    private boolean consentimento;
    private LocalDateTime dataHora;
    private String canal;
}
/**
 * Adaptador de Saída (Driven Adapter) para persistência.
 * Implementa a porta de repositório e usa Spring Data JPA para interagir com o banco.
 */
@Component
public class AceiteRepositoryAdapter implements AceiteRepositoryPort {

    private final SpringDataAceiteRepository repository;

    public AceiteRepositoryAdapter(SpringDataAceiteRepository repository) {
        this.repository = repository;
    }


    @Override
    public Aceite salvar(Aceite aceite) {
        AceiteEntity entity = new AceiteEntity();
        entity.setIdUsuario(aceite.getIdUsuario());
        entity.setConsentimento(aceite.isConsentimento());
        entity.setDataHora(aceite.getDataHora());
        entity.setCanal(aceite.getCanal());

        repository.save(entity);

        // Em um caso real, você poderia mapear a entidade salva de volta para o domínio.
        return aceite;
    }
}

/**
 * Interface do Spring Data JPA. O Spring criará a implementação em tempo de execução.
 */
@Repository
interface SpringDataAceiteRepository extends JpaRepository<AceiteEntity, Long> {
}



