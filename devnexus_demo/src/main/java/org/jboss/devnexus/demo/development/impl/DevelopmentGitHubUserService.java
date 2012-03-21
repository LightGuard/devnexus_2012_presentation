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

package org.jboss.devnexus.demo.development.impl;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Organization;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;
import com.github.api.v2.services.UserService;
import com.github.api.v2.services.auth.Authentication;
import org.apache.deltaspike.core.api.exclude.Exclude;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;

@Exclude(exceptIfProjectStage = ProjectStage.Development.class)
public class DevelopmentGitHubUserService implements UserService {
    @Override
    public List<User> searchUsersByName(String name) {
        return Collections.emptyList();
    }

    @Override
    public User getUserByEmail(String email) {
        return new User();
    }

    @Override
    public User getUserByUsername(String userName) {
        if ("lightguard".equals(userName.toLowerCase())) {
            final User lightguard = new User();
            final Calendar createdAt = Calendar.getInstance();
            lightguard.setName("Jason Porter");
            lightguard.setUsername("LightGuard");
            lightguard.setCompany("Red Hat");

            return lightguard;
        } else {
            return null;
        }
    }

    @Override
    public User getCurrentUser() {
        return new User();
    }

    @Override
    public void updateUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<String> getUserFollowers(String userName) {
        return Collections.emptyList();
    }

    @Override
    public List<String> getUserFollowing(String userName) {
        return Collections.emptyList();
    }

    @Override
    public void followUser(String userName) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void unfollowUser(String userName) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Repository> getWatchedRepositories(String userName) {
        return Collections.emptyList();
    }

    @Override
    public List<Key> getKeys() {
        return Collections.emptyList();
    }

    @Override
    public void addKey(String title, String key) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeKey(String id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<String> getEmails() {
        return Collections.emptyList();
    }

    @Override
    public void addEmail(String email) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeEmail(String email) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Organization> getUserOrganizations(String userName) {
        return Collections.emptyList();
    }

    @Override
    public void setAuthentication(Authentication authentication) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setUserIpAddress(String userIpAddress) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setReferrer(String referrer) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setRequestHeaders(Map<String, String> requestHeaders) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, String> getRequestHeaders() {
        return Collections.emptyMap();
    }

    @Override
    public void addRequestHeader(String headerName, String headerValue) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeRequestHeader(String headerName) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
