package ru.otus.jdbc.mapper;

import java.lang.reflect.Field;
import java.util.stream.Collectors;

public class EntitySQLMetaDataImpl implements EntitySQLMetaData{

    private final EntityClassMetaData metaData;

    public EntitySQLMetaDataImpl(EntityClassMetaData metaData) {
        this.metaData = metaData;
    }

    @Override
    public String getSelectAllSql() {
        return String.format("SELECT %s FROM %s", getAllFieldsName(), metaData.getName());
    }

    @Override
    public String getSelectByIdSql() {
        return String.format("%s WHERE %s = ?",getSelectAllSql(), metaData.getIdField().getName());
    }

    @Override
    public String getInsertSql() {
        return null;
    }

    @Override
    public String getUpdateSql() {
        return null;
    }

    private String getAllFieldsName(){
        return metaData.getAllFields().stream()
                .map(Field::getName)
                .collect(Collectors.joining(", "));
    }
}
