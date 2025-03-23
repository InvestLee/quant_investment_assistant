package org.quant_invest.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFsEntity is a Querydsl query type for FsEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFsEntity extends EntityPathBase<FsEntity> {

    private static final long serialVersionUID = -1099532546L;

    public static final QFsEntity fsEntity = new QFsEntity("fsEntity");

    public final StringPath account = createString("account");

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final StringPath freq = createString("freq");

    public final StringPath ticker = createString("ticker");

    public final NumberPath<Double> value = createNumber("value", Double.class);

    public QFsEntity(String variable) {
        super(FsEntity.class, forVariable(variable));
    }

    public QFsEntity(Path<? extends FsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFsEntity(PathMetadata metadata) {
        super(FsEntity.class, metadata);
    }

}

