package org.msx.software.edu.system.model.entity.util.master.staticmetamodel;


import org.msx.software.edu.system.model.entity.util.codes.GenericName;
import org.msx.software.edu.system.model.entity.util.master.Category;
import org.msx.software.edu.system.model.entity.util.master.CategoryElement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = GenericName.JPA_META_MODEL_ENTITY_PROCESSOR)
@StaticMetamodel(CategoryElement.class)
public class CategoryElementVolatile {

    public static volatile SingularAttribute<CategoryElement, String> code;
    public static volatile SingularAttribute<CategoryElement, String> value;
    public static volatile SingularAttribute<CategoryElement, Category> category;
}