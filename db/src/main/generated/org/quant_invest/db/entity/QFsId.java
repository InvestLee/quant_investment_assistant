package org.quant_invest.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFsId is a Querydsl query type for FsId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QFsId extends BeanPath<FsId> {

    private static final long serialVersionUID = 691824054L;

    public static final QFsId fsId = new QFsId("fsId");

    public final StringPath account = createString("account");

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final StringPath freq = createString("freq");

    public final StringPath ticker = createString("ticker");

    public QFsId(String variable) {
        super(FsId.class, forVariable(variable));
    }

    public QFsId(Path<? extends FsId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFsId(PathMetadata metadata) {
        super(FsId.class, metadata);
    }

}

