package de.greenrobot.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.internal.DaoConfig;

public class InternalUnitTestDaoAccess<T, K> {
    private final AbstractDao<T, K> dao;

    public InternalUnitTestDaoAccess(SQLiteDatabase sQLiteDatabase, Class<AbstractDao<T, K>> cls, IdentityScope<?, ?> identityScope) {
        new DaoConfig(sQLiteDatabase, cls).setIdentityScope(identityScope);
        this.dao = (AbstractDao) cls.getConstructor(new Class[]{DaoConfig.class}).newInstance(new Object[]{r0});
    }

    public AbstractDao<T, K> getDao() {
        return this.dao;
    }

    public K getKey(T t) {
        return this.dao.getKey(t);
    }

    public Property[] getProperties() {
        return this.dao.getProperties();
    }

    public boolean isEntityUpdateable() {
        return this.dao.isEntityUpdateable();
    }

    public T readEntity(Cursor cursor, int i) {
        return this.dao.readEntity(cursor, i);
    }

    public K readKey(Cursor cursor, int i) {
        return this.dao.readKey(cursor, i);
    }
}
