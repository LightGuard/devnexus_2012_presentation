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

import javax.enterprise.inject.Typed;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.spi.activation.ClassDeactivator;
import org.apache.deltaspike.core.spi.activation.Deactivatable;
import org.apache.deltaspike.core.util.ProjectStageProducer;

@Typed()
public class DevelopmentExtensionDeactivator implements ClassDeactivator {
    @Override
    public Boolean isActivated(Class<? extends Deactivatable> targetClass) {
        if (targetClass.equals(AddGithubClassesExtension.class) &&
                ProjectStageProducer.getInstance().getProjectStage().equals(ProjectStage.Development)) {
            return false;
        }
        return true;
    }
}
