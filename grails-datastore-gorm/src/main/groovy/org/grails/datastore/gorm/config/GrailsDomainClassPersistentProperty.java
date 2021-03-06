/* Copyright (C) 2011 SpringSource
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.grails.datastore.gorm.config;

import org.codehaus.groovy.grails.commons.GrailsDomainClassProperty;
import org.springframework.datastore.mapping.model.PersistentEntity;
import org.springframework.datastore.mapping.model.PersistentProperty;
import org.springframework.datastore.mapping.model.PropertyMapping;
import org.springframework.datastore.mapping.reflect.NameUtils;

/**
 * Bridges a {@link GrailsDomainClassProperty} to the {@link PersistentProperty} interface
 * 
 * @author Graeme Rocher
 * @since 1.0
 *
 */
public class GrailsDomainClassPersistentProperty implements PersistentProperty{

	private PersistentEntity owner;
	private GrailsDomainClassProperty property;

	
	public GrailsDomainClassPersistentProperty(PersistentEntity owner,
			GrailsDomainClassProperty property) {
		super();
		this.owner = owner;
		this.property = property;
	}

	@Override
	public String getName() {
		return property.getName();
	}

	@Override
	public String getCapitilizedName() {
		return NameUtils.capitalize(getName());
	}

	@Override
	public Class getType() {
		return property.getType();
	}

	@Override
	public PropertyMapping getMapping() {
		return null;
	}

	@Override
	public PersistentEntity getOwner() {
		return owner;
	}

	@Override
	public boolean isNullable() {
		return property.isOptional();
	}

}
