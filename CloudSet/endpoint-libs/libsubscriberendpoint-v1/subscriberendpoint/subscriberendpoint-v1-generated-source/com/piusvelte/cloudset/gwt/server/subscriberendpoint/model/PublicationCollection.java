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
 * on 2013-06-03 at 02:17:26 UTC 
 * Modify at your own risk.
 */

package com.piusvelte.cloudset.gwt.server.subscriberendpoint.model;

/**
 * Model definition for PublicationCollection.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the . For a detailed explanation see:
 * <a href="http://code.google.com/p/google-api-java-client/wiki/Json">http://code.google.com/p/google-api-java-client/wiki/Json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class PublicationCollection extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<Publication> items;

  static {
    // hack to force ProGuard to consider Publication used, since otherwise it would be stripped out
    // see http://code.google.com/p/google-api-java-client/issues/detail?id=528
    com.google.api.client.util.Data.nullOf(Publication.class);
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<Publication> getItems() {
    return items;
  }

  /**
   * @param items items or {@code null} for none
   */
  public PublicationCollection setItems(java.util.List<Publication> items) {
    this.items = items;
    return this;
  }

  @Override
  public PublicationCollection set(String fieldName, Object value) {
    return (PublicationCollection) super.set(fieldName, value);
  }

  @Override
  public PublicationCollection clone() {
    return (PublicationCollection) super.clone();
  }

}
