package tacos.web.api;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import tacos.Taco;

public class TacoResourceAssembler implements RepresentationModelAssembler<Taco, TacoResource> {

    @Override
    public TacoResource toModel(Taco entity) {


        return null;
    }

    @Override
    public CollectionModel<TacoResource> toCollectionModel(Iterable<? extends Taco> entities) {
        return null;
    }
}
