package org.msx.software.edu.system.model.entity.util.master.staticmetamodel;

import org.msx.software.edu.system.model.entity.util.codes.GenericName;
import org.msx.software.edu.system.model.entity.util.master.BaseEntity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;

@Generated(value = GenericName.JPA_META_MODEL_ENTITY_PROCESSOR)
@StaticMetamodel(BaseEntity.class)
public class BasicEntityVolatile {

    public static volatile SingularAttribute<BaseEntity, Long> id;
    public static volatile SingularAttribute<BaseEntity, String> insertUser;
    public static volatile SingularAttribute<BaseEntity, String> updatetUser;
    public static volatile SingularAttribute<BaseEntity, Timestamp> insertDateTime;
    public static volatile SingularAttribute<BaseEntity, Timestamp> updateDateTime;
    public static volatile SingularAttribute<BaseEntity, Integer> version;
    public static volatile SingularAttribute<BaseEntity, Boolean> isActive;
}