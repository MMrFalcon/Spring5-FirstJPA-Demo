package falcon.springframework.spring5webapp.Repositories;

import falcon.springframework.spring5webapp.Model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
