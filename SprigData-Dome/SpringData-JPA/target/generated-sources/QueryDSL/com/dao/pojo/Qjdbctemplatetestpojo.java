package com.dao.pojo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * Qjdbctemplatetestpojo is a Querydsl query type for jdbctemplatetestpojo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qjdbctemplatetestpojo extends EntityPathBase<jdbctemplatetestpojo> {

    private static final long serialVersionUID = 771896236L;

    public static final Qjdbctemplatetestpojo jdbctemplatetestpojo = new Qjdbctemplatetestpojo("jdbctemplatetestpojo");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> money = createNumber("money", Integer.class);

    public final StringPath name = createString("name");

    public Qjdbctemplatetestpojo(String variable) {
        super(jdbctemplatetestpojo.class, forVariable(variable));
    }

    public Qjdbctemplatetestpojo(Path<? extends jdbctemplatetestpojo> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qjdbctemplatetestpojo(PathMetadata metadata) {
        super(jdbctemplatetestpojo.class, metadata);
    }

}

