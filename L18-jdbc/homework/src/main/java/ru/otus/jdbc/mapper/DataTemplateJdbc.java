package ru.otus.jdbc.mapper;

import ru.otus.core.repository.DataTemplate;
import ru.otus.core.repository.DataTemplateException;
import ru.otus.core.repository.executor.DbExecutor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Сохратяет объект в базу, читает объект из базы
 */
public class DataTemplateJdbc<T> implements DataTemplate<T> {

    private final DbExecutor dbExecutor;
    private final EntitySQLMetaData entitySQLMetaData;
    private final EntityClassMetaData entityClassMetaData;

    public DataTemplateJdbc(DbExecutor dbExecutor, EntitySQLMetaData entitySQLMetaData, EntityClassMetaData entityClassMetaData) {
        this.dbExecutor = dbExecutor;
        this.entitySQLMetaData = entitySQLMetaData;
        this.entityClassMetaData = entityClassMetaData;
    }

    @Override
    public Optional<T> findById(Connection connection, long id) {
        return dbExecutor.executeSelect(connection, entitySQLMetaData.getSelectByIdSql(), List.of(id), this::getObjectByResultSet);
    }

    @Override
    public List<T> findAll(Connection connection) {
        return dbExecutor.executeSelect(connection, entitySQLMetaData.getSelectAllSql(), Collections.emptyList(), this::getObjectsByResultSet)
                .orElseThrow(() -> new RuntimeException("Unexpected error"));
    }

    @Override
    public long insert(Connection connection, T client) {
        try {
            return dbExecutor.executeStatement(connection, entitySQLMetaData.getInsertSql(), Collections.singletonList(getFieldValue(client)));
        } catch (Exception e) {
            throw new DataTemplateException(e);
        }
    }

    @Override
    public void update(Connection connection, T object) {
        dbExecutor.executeStatement(connection, entitySQLMetaData.getUpdateSql(), Collections.singletonList(getFieldValue(object)));
    }

    private String getFieldValue(Object object) {
        List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
        for (Field fieldItem : fields) {
            fieldItem.setAccessible(true);
            Object fieldValue = null;
            try {
                fieldValue = fieldItem.get(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fieldValue != null) {
                return (String) fieldValue;
            }
        }
        return null;
    }

    private T createObject(ResultSet resultSet) throws InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Object instance = entityClassMetaData.getConstructor().newInstance();
        for (Field objectField : entityClassMetaData.getAllFields()) {
            var value = resultSet.getObject(objectField.getName());
            objectField.setAccessible(true);
            objectField.set(instance, value);
        }
        return (T) instance;
    }

    private T getObjectByResultSet(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return createObject(resultSet);
            }
            return null;
        } catch (SQLException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new DataTemplateException(e);
        }
    }

    private List<T> getObjectsByResultSet(ResultSet resultSet) {
        List<T> objectList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                objectList.add(createObject(resultSet));
            }
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return objectList;
    }
}
