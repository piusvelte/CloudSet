/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2013-05-23 17:46:09 UTC)
 * on 2013-05-28 at 17:42:54 UTC 
 * Modify at your own risk.
 */

package com.piusvelte.cloudset.gwt.server.publicationendpoint;

/**
 * Service definition for Publicationendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link PublicationendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Publicationendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION == 14,
        "You are currently running with version %s of google-api-client. " +
        "You need version 1.14 of google-api-client to run version " +
        "1.14.2-beta of the  library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://cloud-set.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "publicationendpoint/v1/publish/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Publicationendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Publicationendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * An accessor for creating requests from the PublicationEndpoint collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code Publicationendpoint publicationendpoint = new Publicationendpoint(...);}
   *   {@code Publicationendpoint.PublicationEndpoint.List request = publicationendpoint.publicationEndpoint().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public PublicationEndpoint publicationEndpoint() {
    return new PublicationEndpoint();
  }

  /**
   * The "publicationEndpoint" collection of methods.
   */
  public class PublicationEndpoint {

    /**
     * Create a request for the method "publicationEndpoint.publish".
     *
     * This request holds the parameters needed by the the publicationendpoint server.  After setting
     * any optional parameters, call the {@link Publish#execute()} method to invoke the remote
     * operation.
     *
     * @param publisher
     * @param action
     * @param value
     * @return the request
     */
    public Publish publish(java.lang.String publisher, java.lang.String action, java.lang.String value) throws java.io.IOException {
      Publish result = new Publish(publisher, action, value);
      initialize(result);
      return result;
    }

    public class Publish extends PublicationendpointRequest<Void> {

      private static final String REST_PATH = "{publisher}/{action}/{value}";

      /**
       * Create a request for the method "publicationEndpoint.publish".
       *
       * This request holds the parameters needed by the the publicationendpoint server.  After setting
       * any optional parameters, call the {@link Publish#execute()} method to invoke the remote
       * operation. <p> {@link
       * Publish#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
       * be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param publisher
       * @param action
       * @param value
       * @since 1.13
       */
      protected Publish(java.lang.String publisher, java.lang.String action, java.lang.String value) {
        super(Publicationendpoint.this, "POST", REST_PATH, null, Void.class);
        this.publisher = com.google.api.client.util.Preconditions.checkNotNull(publisher, "Required parameter publisher must be specified.");
        this.action = com.google.api.client.util.Preconditions.checkNotNull(action, "Required parameter action must be specified.");
        this.value = com.google.api.client.util.Preconditions.checkNotNull(value, "Required parameter value must be specified.");
      }

      @Override
      public Publish setAlt(java.lang.String alt) {
        return (Publish) super.setAlt(alt);
      }

      @Override
      public Publish setFields(java.lang.String fields) {
        return (Publish) super.setFields(fields);
      }

      @Override
      public Publish setKey(java.lang.String key) {
        return (Publish) super.setKey(key);
      }

      @Override
      public Publish setOauthToken(java.lang.String oauthToken) {
        return (Publish) super.setOauthToken(oauthToken);
      }

      @Override
      public Publish setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (Publish) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Publish setQuotaUser(java.lang.String quotaUser) {
        return (Publish) super.setQuotaUser(quotaUser);
      }

      @Override
      public Publish setUserIp(java.lang.String userIp) {
        return (Publish) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.lang.String publisher;

      /**

       */
      public java.lang.String getPublisher() {
        return publisher;
      }

      public Publish setPublisher(java.lang.String publisher) {
        this.publisher = publisher;
        return this;
      }

      @com.google.api.client.util.Key
      private java.lang.String action;

      /**

       */
      public java.lang.String getAction() {
        return action;
      }

      public Publish setAction(java.lang.String action) {
        this.action = action;
        return this;
      }

      @com.google.api.client.util.Key
      private java.lang.String value;

      /**

       */
      public java.lang.String getValue() {
        return value;
      }

      public Publish setValue(java.lang.String value) {
        this.value = value;
        return this;
      }

      @Override
      public Publish set(String parameterName, Object value) {
        return (Publish) super.set(parameterName, value);
      }
    }

  }

  /**
   * Builder for {@link Publicationendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Publicationendpoint}. */
    @Override
    public Publicationendpoint build() {
      return new Publicationendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link PublicationendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setPublicationendpointRequestInitializer(
        PublicationendpointRequestInitializer publicationendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(publicationendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
