package com.albedo.java.common.persistence.injector;

import com.albedo.java.common.persistence.injector.methods.FindRelationListLogic;
import com.albedo.java.common.persistence.injector.methods.FindRelationPageLogic;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 1.逻辑删除字段sql注入
 * 2.多对一关联对象查询sql注入
 *
 * @author somewhere
 * @return
 */
@Deprecated
public class EntityMetaSqlInjector extends DefaultSqlInjector {

	public final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
		List<AbstractMethod> methodList = super.getMethodList(mapperClass);
		methodList.addAll(Lists.newArrayList(new FindRelationListLogic(), new FindRelationPageLogic()));
		return methodList;
	}

}
