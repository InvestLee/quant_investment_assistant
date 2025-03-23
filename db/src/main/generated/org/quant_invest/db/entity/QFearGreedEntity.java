package org.quant_invest.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFearGreedEntity is a Querydsl query type for FearGreedEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFearGreedEntity extends EntityPathBase<FearGreedEntity> {

    private static final long serialVersionUID = -1432939202L;

    public static final QFearGreedEntity fearGreedEntity = new QFearGreedEntity("fearGreedEntity");

    public final QDateEntity _super = new QDateEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> date = _super.date;

    public final NumberPath<Integer> value = createNumber("value", Integer.class);

    public QFearGreedEntity(String variable) {
        super(FearGreedEntity.class, forVariable(variable));
    }

    public QFearGreedEntity(Path<? extends FearGreedEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFearGreedEntity(PathMetadata metadata) {
        super(FearGreedEntity.class, metadata);
    }

}

