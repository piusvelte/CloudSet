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
 * on 2013-05-27 at 19:56:37 UTC 
 * Modify at your own risk.
 */

package com.piusvelte.cloudset.gwt.server.deviceendpoint;

/**
 * Service definition for Deviceendpoint (v1).
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
 * This service uses {@link DeviceendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Deviceendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

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
  public static final String DEFAULT_SERVICE_PATH = "deviceendpoint/v1/";

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
  public Deviceendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Deviceendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * An accessor for creating requests from the DeviceEndpoint collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code Deviceendpoint deviceendpoint = new Deviceendpoint(...);}
   *   {@code Deviceendpoint.DeviceEndpoint.List request = deviceendpoint.deviceEndpoint().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public DeviceEndpoint deviceEndpoint() {
    return new DeviceEndpoint();
  }

  /**
   * The "deviceEndpoint" collection of methods.
   */
  public class DeviceEndpoint {

    /**
     * Create a request for the method "deviceEndpoint.add".
     *
     * This request holds the parameters needed by the the deviceendpoint server.  After setting any
     * optional parameters, call the {@link Add#execute()} method to invoke the remote operation.
     *
     * @param content the {@link com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device}
     * @return the request
     */
    public Add add(com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device content) throws java.io.IOException {
      Add result = new Add(content);
      initialize(result);
      return result;
    }

    public class Add extends DeviceendpointRequest<com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device> {

      private static final String REST_PATH = "add";

      /**
       * Create a request for the method "deviceEndpoint.add".
       *
       * This request holds the parameters needed by the the deviceendpoint server.  After setting any
       * optional parameters, call the {@link Add#execute()} method to invoke the remote operation. <p>
       * {@link Add#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param content the {@link com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device}
       * @since 1.13
       */
      protected Add(com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device content) {
        super(Deviceendpoint.this, "POST", REST_PATH, content, com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device.class);
      }

      @Override
      public Add setAlt(java.lang.String alt) {
        return (Add) super.setAlt(alt);
      }

      @Override
      public Add setFields(java.lang.String fields) {
        return (Add) super.setFields(fields);
      }

      @Override
      public Add setKey(java.lang.String key) {
        return (Add) super.setKey(key);
      }

      @Override
      public Add setOauthToken(java.lang.String oauthToken) {
        return (Add) super.setOauthToken(oauthToken);
      }

      @Override
      public Add setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (Add) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Add setQuotaUser(java.lang.String quotaUser) {
        return (Add) super.setQuotaUser(quotaUser);
      }

      @Override
      public Add setUserIp(java.lang.String userIp) {
        return (Add) super.setUserIp(userIp);
      }

      @Override
      public Add set(String parameterName, Object value) {
        return (Add) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "deviceEndpoint.addAction".
     *
     * This request holds the parameters needed by the the deviceendpoint server.  After setting any
     * optional parameters, call the {@link AddAction#execute()} method to invoke the remote operation.
     *
     * @param id
     * @param action
     * @return the request
     */
    public AddAction addAction(java.lang.String id, java.lang.String action) throws java.io.IOException {
      AddAction result = new AddAction(id, action);
      initialize(result);
      return result;
    }

    public class AddAction extends DeviceendpointRequest<com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device> {

      private static final String REST_PATH = "addAction/{id}/{action}";

      /**
       * Create a request for the method "deviceEndpoint.addAction".
       *
       * This request holds the parameters needed by the the deviceendpoint server.  After setting any
       * optional parameters, call the {@link AddAction#execute()} method to invoke the remote
       * operation. <p> {@link
       * AddAction#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param id
       * @param action
       * @since 1.13
       */
      protected AddAction(java.lang.String id, java.lang.String action) {
        super(Deviceendpoint.this, "POST", REST_PATH, null, com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device.class);
        this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
        this.action = com.google.api.client.util.Preconditions.checkNotNull(action, "Required parameter action must be specified.");
      }

      @Override
      public AddAction setAlt(java.lang.String alt) {
        return (AddAction) super.setAlt(alt);
      }

      @Override
      public AddAction setFields(java.lang.String fields) {
        return (AddAction) super.setFields(fields);
      }

      @Override
      public AddAction setKey(java.lang.String key) {
        return (AddAction) super.setKey(key);
      }

      @Override
      public AddAction setOauthToken(java.lang.String oauthToken) {
        return (AddAction) super.setOauthToken(oauthToken);
      }

      @Override
      public AddAction setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (AddAction) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public AddAction setQuotaUser(java.lang.String quotaUser) {
        return (AddAction) super.setQuotaUser(quotaUser);
      }

      @Override
      public AddAction setUserIp(java.lang.String userIp) {
        return (AddAction) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.lang.String id;

      /**

       */
      public java.lang.String getId() {
        return id;
      }

      public AddAction setId(java.lang.String id) {
        this.id = id;
        return this;
      }

      @com.google.api.client.util.Key
      private java.lang.String action;

      /**

       */
      public java.lang.String getAction() {
        return action;
      }

      public AddAction setAction(java.lang.String action) {
        this.action = action;
        return this;
      }

      @Override
      public AddAction set(String parameterName, Object value) {
        return (AddAction) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "deviceEndpoint.get".
     *
     * This request holds the parameters needed by the the deviceendpoint server.  After setting any
     * optional parameters, call the {@link Get#execute()} method to invoke the remote operation.
     *
     * @param id
     * @return the request
     */
    public Get get(java.lang.String id) throws java.io.IOException {
      Get result = new Get(id);
      initialize(result);
      return result;
    }

    public class Get extends DeviceendpointRequest<com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device> {

      private static final String REST_PATH = "device/{id}";

      /**
       * Create a request for the method "deviceEndpoint.get".
       *
       * This request holds the parameters needed by the the deviceendpoint server.  After setting any
       * optional parameters, call the {@link Get#execute()} method to invoke the remote operation. <p>
       * {@link Get#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param id
       * @since 1.13
       */
      protected Get(java.lang.String id) {
        super(Deviceendpoint.this, "GET", REST_PATH, null, com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device.class);
        this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public Get setAlt(java.lang.String alt) {
        return (Get) super.setAlt(alt);
      }

      @Override
      public Get setFields(java.lang.String fields) {
        return (Get) super.setFields(fields);
      }

      @Override
      public Get setKey(java.lang.String key) {
        return (Get) super.setKey(key);
      }

      @Override
      public Get setOauthToken(java.lang.String oauthToken) {
        return (Get) super.setOauthToken(oauthToken);
      }

      @Override
      public Get setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (Get) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Get setQuotaUser(java.lang.String quotaUser) {
        return (Get) super.setQuotaUser(quotaUser);
      }

      @Override
      public Get setUserIp(java.lang.String userIp) {
        return (Get) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.lang.String id;

      /**

       */
      public java.lang.String getId() {
        return id;
      }

      public Get setId(java.lang.String id) {
        this.id = id;
        return this;
      }

      @Override
      public Get set(String parameterName, Object value) {
        return (Get) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "deviceEndpoint.list".
     *
     * This request holds the parameters needed by the the deviceendpoint server.  After setting any
     * optional parameters, call the {@link List#execute()} method to invoke the remote operation.
     *
     * @return the request
     */
    public List list() throws java.io.IOException {
      List result = new List();
      initialize(result);
      return result;
    }

    public class List extends DeviceendpointRequest<com.piusvelte.cloudset.gwt.server.deviceendpoint.model.DeviceCollection> {

      private static final String REST_PATH = "device";

      /**
       * Create a request for the method "deviceEndpoint.list".
       *
       * This request holds the parameters needed by the the deviceendpoint server.  After setting any
       * optional parameters, call the {@link List#execute()} method to invoke the remote operation. <p>
       * {@link List#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @since 1.13
       */
      protected List() {
        super(Deviceendpoint.this, "GET", REST_PATH, null, com.piusvelte.cloudset.gwt.server.deviceendpoint.model.DeviceCollection.class);
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public List setAlt(java.lang.String alt) {
        return (List) super.setAlt(alt);
      }

      @Override
      public List setFields(java.lang.String fields) {
        return (List) super.setFields(fields);
      }

      @Override
      public List setKey(java.lang.String key) {
        return (List) super.setKey(key);
      }

      @Override
      public List setOauthToken(java.lang.String oauthToken) {
        return (List) super.setOauthToken(oauthToken);
      }

      @Override
      public List setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (List) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public List setQuotaUser(java.lang.String quotaUser) {
        return (List) super.setQuotaUser(quotaUser);
      }

      @Override
      public List setUserIp(java.lang.String userIp) {
        return (List) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.lang.String setting;

      /**

       */
      public java.lang.String getSetting() {
        return setting;
      }

      public List setSetting(java.lang.String setting) {
        this.setting = setting;
        return this;
      }

      @com.google.api.client.util.Key
      private java.lang.Integer limit;

      /**

       */
      public java.lang.Integer getLimit() {
        return limit;
      }

      public List setLimit(java.lang.Integer limit) {
        this.limit = limit;
        return this;
      }

      @Override
      public List set(String parameterName, Object value) {
        return (List) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "deviceEndpoint.patch".
     *
     * This request holds the parameters needed by the the deviceendpoint server.  After setting any
     * optional parameters, call the {@link Patch#execute()} method to invoke the remote operation.
     *
     * @param id
     * @param content the {@link com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device}
     * @return the request
     */
    public Patch patch(java.lang.String id, com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device content) throws java.io.IOException {
      Patch result = new Patch(id, content);
      initialize(result);
      return result;
    }

    public class Patch extends DeviceendpointRequest<com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device> {

      private static final String REST_PATH = "device";

      /**
       * Create a request for the method "deviceEndpoint.patch".
       *
       * This request holds the parameters needed by the the deviceendpoint server.  After setting any
       * optional parameters, call the {@link Patch#execute()} method to invoke the remote operation.
       * <p> {@link
       * Patch#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
       * be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param id
       * @param content the {@link com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device}
       * @since 1.13
       */
      protected Patch(java.lang.String id, com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device content) {
        super(Deviceendpoint.this, "PATCH", REST_PATH, content, com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device.class);
        this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      }

      @Override
      public Patch setAlt(java.lang.String alt) {
        return (Patch) super.setAlt(alt);
      }

      @Override
      public Patch setFields(java.lang.String fields) {
        return (Patch) super.setFields(fields);
      }

      @Override
      public Patch setKey(java.lang.String key) {
        return (Patch) super.setKey(key);
      }

      @Override
      public Patch setOauthToken(java.lang.String oauthToken) {
        return (Patch) super.setOauthToken(oauthToken);
      }

      @Override
      public Patch setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (Patch) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Patch setQuotaUser(java.lang.String quotaUser) {
        return (Patch) super.setQuotaUser(quotaUser);
      }

      @Override
      public Patch setUserIp(java.lang.String userIp) {
        return (Patch) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.lang.String id;

      /**

       */
      public java.lang.String getId() {
        return id;
      }

      public Patch setId(java.lang.String id) {
        this.id = id;
        return this;
      }

      @Override
      public Patch set(String parameterName, Object value) {
        return (Patch) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "deviceEndpoint.remove".
     *
     * This request holds the parameters needed by the the deviceendpoint server.  After setting any
     * optional parameters, call the {@link Remove#execute()} method to invoke the remote operation.
     *
     * @param id
     * @return the request
     */
    public Remove remove(java.lang.String id) throws java.io.IOException {
      Remove result = new Remove(id);
      initialize(result);
      return result;
    }

    public class Remove extends DeviceendpointRequest<com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device> {

      private static final String REST_PATH = "remove/{id}";

      /**
       * Create a request for the method "deviceEndpoint.remove".
       *
       * This request holds the parameters needed by the the deviceendpoint server.  After setting any
       * optional parameters, call the {@link Remove#execute()} method to invoke the remote operation.
       * <p> {@link
       * Remove#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
       * be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param id
       * @since 1.13
       */
      protected Remove(java.lang.String id) {
        super(Deviceendpoint.this, "DELETE", REST_PATH, null, com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device.class);
        this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      }

      @Override
      public Remove setAlt(java.lang.String alt) {
        return (Remove) super.setAlt(alt);
      }

      @Override
      public Remove setFields(java.lang.String fields) {
        return (Remove) super.setFields(fields);
      }

      @Override
      public Remove setKey(java.lang.String key) {
        return (Remove) super.setKey(key);
      }

      @Override
      public Remove setOauthToken(java.lang.String oauthToken) {
        return (Remove) super.setOauthToken(oauthToken);
      }

      @Override
      public Remove setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (Remove) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Remove setQuotaUser(java.lang.String quotaUser) {
        return (Remove) super.setQuotaUser(quotaUser);
      }

      @Override
      public Remove setUserIp(java.lang.String userIp) {
        return (Remove) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.lang.String id;

      /**

       */
      public java.lang.String getId() {
        return id;
      }

      public Remove setId(java.lang.String id) {
        this.id = id;
        return this;
      }

      @Override
      public Remove set(String parameterName, Object value) {
        return (Remove) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "deviceEndpoint.removeAction".
     *
     * This request holds the parameters needed by the the deviceendpoint server.  After setting any
     * optional parameters, call the {@link RemoveAction#execute()} method to invoke the remote
     * operation.
     *
     * @param id
     * @param action
     * @return the request
     */
    public RemoveAction removeAction(java.lang.String id, java.lang.String action) throws java.io.IOException {
      RemoveAction result = new RemoveAction(id, action);
      initialize(result);
      return result;
    }

    public class RemoveAction extends DeviceendpointRequest<com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device> {

      private static final String REST_PATH = "action/{id}/{action}";

      /**
       * Create a request for the method "deviceEndpoint.removeAction".
       *
       * This request holds the parameters needed by the the deviceendpoint server.  After setting any
       * optional parameters, call the {@link RemoveAction#execute()} method to invoke the remote
       * operation. <p> {@link
       * RemoveAction#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param id
       * @param action
       * @since 1.13
       */
      protected RemoveAction(java.lang.String id, java.lang.String action) {
        super(Deviceendpoint.this, "DELETE", REST_PATH, null, com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device.class);
        this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
        this.action = com.google.api.client.util.Preconditions.checkNotNull(action, "Required parameter action must be specified.");
      }

      @Override
      public RemoveAction setAlt(java.lang.String alt) {
        return (RemoveAction) super.setAlt(alt);
      }

      @Override
      public RemoveAction setFields(java.lang.String fields) {
        return (RemoveAction) super.setFields(fields);
      }

      @Override
      public RemoveAction setKey(java.lang.String key) {
        return (RemoveAction) super.setKey(key);
      }

      @Override
      public RemoveAction setOauthToken(java.lang.String oauthToken) {
        return (RemoveAction) super.setOauthToken(oauthToken);
      }

      @Override
      public RemoveAction setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (RemoveAction) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public RemoveAction setQuotaUser(java.lang.String quotaUser) {
        return (RemoveAction) super.setQuotaUser(quotaUser);
      }

      @Override
      public RemoveAction setUserIp(java.lang.String userIp) {
        return (RemoveAction) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.lang.String id;

      /**

       */
      public java.lang.String getId() {
        return id;
      }

      public RemoveAction setId(java.lang.String id) {
        this.id = id;
        return this;
      }

      @com.google.api.client.util.Key
      private java.lang.String action;

      /**

       */
      public java.lang.String getAction() {
        return action;
      }

      public RemoveAction setAction(java.lang.String action) {
        this.action = action;
        return this;
      }

      @Override
      public RemoveAction set(String parameterName, Object value) {
        return (RemoveAction) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "deviceEndpoint.update".
     *
     * This request holds the parameters needed by the the deviceendpoint server.  After setting any
     * optional parameters, call the {@link Update#execute()} method to invoke the remote operation.
     *
     * @param content the {@link com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device}
     * @return the request
     */
    public Update update(com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device content) throws java.io.IOException {
      Update result = new Update(content);
      initialize(result);
      return result;
    }

    public class Update extends DeviceendpointRequest<com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device> {

      private static final String REST_PATH = "device";

      /**
       * Create a request for the method "deviceEndpoint.update".
       *
       * This request holds the parameters needed by the the deviceendpoint server.  After setting any
       * optional parameters, call the {@link Update#execute()} method to invoke the remote operation.
       * <p> {@link
       * Update#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
       * be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param content the {@link com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device}
       * @since 1.13
       */
      protected Update(com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device content) {
        super(Deviceendpoint.this, "PUT", REST_PATH, content, com.piusvelte.cloudset.gwt.server.deviceendpoint.model.Device.class);
      }

      @Override
      public Update setAlt(java.lang.String alt) {
        return (Update) super.setAlt(alt);
      }

      @Override
      public Update setFields(java.lang.String fields) {
        return (Update) super.setFields(fields);
      }

      @Override
      public Update setKey(java.lang.String key) {
        return (Update) super.setKey(key);
      }

      @Override
      public Update setOauthToken(java.lang.String oauthToken) {
        return (Update) super.setOauthToken(oauthToken);
      }

      @Override
      public Update setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (Update) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Update setQuotaUser(java.lang.String quotaUser) {
        return (Update) super.setQuotaUser(quotaUser);
      }

      @Override
      public Update setUserIp(java.lang.String userIp) {
        return (Update) super.setUserIp(userIp);
      }

      @Override
      public Update set(String parameterName, Object value) {
        return (Update) super.set(parameterName, value);
      }
    }

  }

  /**
   * Builder for {@link Deviceendpoint}.
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

    /** Builds a new instance of {@link Deviceendpoint}. */
    @Override
    public Deviceendpoint build() {
      return new Deviceendpoint(this);
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
     * Set the {@link DeviceendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setDeviceendpointRequestInitializer(
        DeviceendpointRequestInitializer deviceendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(deviceendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
