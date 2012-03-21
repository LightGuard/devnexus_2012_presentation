/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the &quot;License&quot;);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an &quot;AS IS&quot; BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.devnexus.demo.ui;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.github.api.v2.schema.User;
import com.github.api.v2.services.UserService;
import org.apache.deltaspike.core.api.provider.BeanProvider;

@FacesConverter(forClass = User.class, value = "userConverter")
public class UserConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // DeltaSpike utility method for use inside non CDI managed beans
        final UserService userService = BeanProvider.getContextualReference(UserService.class, false);

        final User u = userService.getUserByUsername(value);

        if (u == null) {
            throw new ConverterException("Unable to find a user with the given user name");
        }

        return u;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null)
            return ((User) value).getUsername();
        else
            return "";
    }
}
