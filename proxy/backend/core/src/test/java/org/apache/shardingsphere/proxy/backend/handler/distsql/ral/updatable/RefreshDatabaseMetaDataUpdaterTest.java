/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.proxy.backend.handler.distsql.ral.updatable;

import org.apache.shardingsphere.dialect.exception.syntax.database.UnknownDatabaseException;
import org.apache.shardingsphere.distsql.parser.statement.ral.updatable.RefreshDatabaseMetaDataStatement;
import org.apache.shardingsphere.mode.manager.ContextManager;
import org.apache.shardingsphere.proxy.backend.context.ProxyContext;
import org.apache.shardingsphere.proxy.backend.util.ProxyContextRestorer;
import org.junit.Test;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;

public final class RefreshDatabaseMetaDataUpdaterTest extends ProxyContextRestorer {
    
    @Test(expected = UnknownDatabaseException.class)
    public void assertExecuteWithNoDatabase() {
        ContextManager contextManager = mock(ContextManager.class, RETURNS_DEEP_STUBS);
        ProxyContext.init(contextManager);
        RefreshDatabaseMetaDataUpdater updater = new RefreshDatabaseMetaDataUpdater();
        updater.executeUpdate("foo", mock(RefreshDatabaseMetaDataStatement.class));
    }
}
