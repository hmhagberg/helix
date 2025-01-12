package org.apache.helix.metaclient.impl.zk.factory;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.helix.metaclient.api.MetaClientInterface;
import org.apache.helix.metaclient.factories.MetaClientConfig;
import org.apache.helix.metaclient.factories.MetaClientFactory;
import org.apache.helix.metaclient.impl.zk.ZkMetaClient;

public class ZkMetaClientFactory extends MetaClientFactory {
  @Override
  public MetaClientInterface getMetaClient(MetaClientConfig config) {
    if (config == null) {
      throw new IllegalArgumentException("MetaClientConfig cannot be null.");
    }
    if (MetaClientConfig.StoreType.ZOOKEEPER.equals(config.getStoreType())
        && config instanceof ZkMetaClientConfig) {
      return new ZkMetaClient((ZkMetaClientConfig) config);
    }
    throw new IllegalArgumentException("Invalid MetaClientConfig type.");
  }
}
