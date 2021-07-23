package ru.otus.jdbc.mapper;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class EntitySQLMetaDataImpl implements EntitySQLMetaData {

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
        return String.format("%s WHERE %s = ?", getSelectAllSql(), metaData.getIdField().getName());
    }

    @Override
    public String getInsertSql() {
        return String.format("INSERT INTO %s (%s) VALUES (%s)", metaData.getName(), getFieldNameWithoutId(), getPlaceHolders(metaData.getFieldsWithoutId()));
    }

    @Override
    public String getUpdateSql() {
        return String.format("UPDATE %s SET %s = ? where %s = ?", metaData.getName(), getFieldNameWithoutId(), metaData.getIdField().getName());
    }

    private String getAllFieldsName() {
        return metaData.getAllFields().stream()
                .map(Field::getName)
                .collect(Collectors.joining(", "));
    }

    private String getFieldNameWithoutId() {
        return metaData.getFieldsWithoutId().stream().
                map(Field::getName)
                .collect(Collectors.joining(", "));
    }

    private String getPlaceHolders(List<Field> fieldList) {
        StringBuilder placeHolders = new StringBuilder();
        for (int i = 0; i < fieldList.size(); i++) {
            placeHolders.append("?,");
        }
        return placeHolders.substring(0, placeHolders.length() - 1);
    }
}
