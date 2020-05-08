package by.market.mapper;

import java.util.Collection;

public interface MapstructMapper<TDTO, TEntity> {

    TDTO toMap(TEntity entity);
    TEntity fromMap(TDTO tdto);

    Collection<TDTO> toMap(Collection<TEntity> tEntityCollection);
    Collection<TEntity> fromMap(Collection<TDTO> tdtoCollection);

}
