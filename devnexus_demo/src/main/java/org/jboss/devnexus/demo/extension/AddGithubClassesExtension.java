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

package org.jboss.devnexus.demo.extension;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

import com.github.api.v2.services.UserService;
import com.github.api.v2.services.impl.UserServiceImpl;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.spi.activation.ClassDeactivator;
import org.apache.deltaspike.core.spi.activation.Deactivatable;
import org.apache.deltaspike.core.util.ProjectStageProducer;

public class AddGithubClassesExtension implements Extension, Deactivatable {
    public void beforeBeanDiscovery(@Observes BeforeBeanDiscovery event, BeanManager bm) {
        if (ProjectStage.Production.equals(ProjectStageProducer.getInstance().getProjectStage())) {
            AnnotatedType<?> at = bm.createAnnotatedType(UserServiceImpl.class);
            event.addAnnotatedType(at);
        }
    }

//    public <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> event) {
//        if (event.getAnnotatedType().getJavaClass().equals(UserServiceImpl.class)
//                && !ProjectStage.Production.equals(ProjectStageProducer.getInstance().getProjectStage())) {
//            event.veto();
//        }
//    }
}
