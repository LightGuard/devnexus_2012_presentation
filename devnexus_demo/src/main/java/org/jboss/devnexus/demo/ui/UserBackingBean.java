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

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.github.api.v2.schema.User;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.util.ProjectStageProducer;

@Model
public class UserBackingBean {

    private User user;

    public void findUserListener() {
        if (ProjectStage.Development.equals(ProjectStageProducer.getInstance().getProjectStage())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Using development user service."));
        } else if (ProjectStage.Production.equals(ProjectStageProducer.getInstance().getProjectStage())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Using production user service."));
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
