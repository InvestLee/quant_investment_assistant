package org.quant_invest.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QYieldEntity is a Querydsl query type for YieldEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QYieldEntity extends EntityPathBase<YieldEntity> {

    private static final long serialVersionUID = 178273058L;

    public static final QYieldEntity yieldEntity = new QYieldEntity("yieldEntity");

    public final QDateEntity _super = new QDateEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> date = _super.date;

    public final NumberPath<Double> t10y2y = createNumber("t10y2y", Double.class);

    public final NumberPath<Double> t10y3m = createNumber("t10y3m", Double.class);

    public final NumberPath<Double> t10yie = createNumber("t10yie", Double.class);

    public QYieldEntity(String variable) {
        super(YieldEntity.class, forVariable(variable));
    }

    public QYieldEntity(Path<? extends YieldEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QYieldEntity(PathMetadata metadata) {
        super(YieldEntity.class, metadata);
    }

}

