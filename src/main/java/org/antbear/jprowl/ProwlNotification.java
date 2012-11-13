package org.antbear.jprowl;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;

public class ProwlNotification {

    @NotNull
    private List<String> apiKeys;

    @Null
    @Size(max=40)
    private String providerKey;

    @NotNull
    private ProwlPriority priority;

    @Null
    @Size(max=512)
    private String urlToAttach;

    @NotNull
    @Size(max=256)
    private String applicationName;

    @NotNull
    @Size(max=1024)
    private String subject;

    @NotNull
    @Size(max=100000)
    private String description;

    public List<String> getApiKeys() {
        return apiKeys;
    }

    public void setApiKeys(@NotNull final List<String> apiKeys) {
        this.apiKeys = apiKeys;
    }

    public void setApiKey(@NotNull final String apiKey) {
        this.apiKeys = ImmutableList.of(apiKey);
    }

    @Null
    public String getProviderKey() {
        return providerKey;
    }

    public void setProviderKey(@Null final String providerKey) {
        this.providerKey = providerKey;
    }

    @NotNull
    public ProwlPriority getPriority() {
        return priority;
    }

    public void setPriority(@NotNull final ProwlPriority priority) {
        this.priority = priority;
    }

    @Null
    public String getUrlToAttach() {
        return urlToAttach;
    }

    public void setUrlToAttach(@Null final String urlToAttach) {
        this.urlToAttach = urlToAttach;
    }

    @NotNull
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(@NotNull final String applicationName) {
        this.applicationName = applicationName;
    }

    @NotNull
    public String getSubject() {
        return subject;
    }

    public void setSubject(@NotNull final String subject) {
        this.subject = subject;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NotNull final String description) {
        this.description = description;
    }

    @NotNull
    public List<ProwlRequestParameter> toRequestParameterList() {
        final List<ProwlRequestParameter> parameters = Lists.newArrayList();

        final Joiner joiner = Joiner.on(",");
        parameters.add(new ProwlRequestParameter("apikey", joiner.join(this.apiKeys)));

        if (null != this.providerKey) {
            parameters.add(new ProwlRequestParameter("providerkey", this.providerKey));
        }

        parameters.add(new ProwlRequestParameter("priority", String.valueOf(this.priority)));

        if (null != this.urlToAttach) {
            parameters.add(new ProwlRequestParameter("url", this.urlToAttach));
        }

        parameters.add(new ProwlRequestParameter("application", this.applicationName));
        parameters.add(new ProwlRequestParameter("event", this.subject));
        parameters.add(new ProwlRequestParameter("description", this.description));

        return parameters;
    }

    @Override
    public String toString() {
        return "ProwlNotification{" +
                "apiKeys=" + apiKeys +
                ", providerKey='" + providerKey + '\'' +
                ", priority=" + priority +
                ", urlToAttach='" + urlToAttach + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
