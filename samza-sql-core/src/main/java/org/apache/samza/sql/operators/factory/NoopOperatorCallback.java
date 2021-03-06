/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.samza.sql.operators.factory;

import org.apache.samza.sql.api.data.Relation;
import org.apache.samza.sql.api.data.Tuple;
import org.apache.samza.sql.api.operators.OperatorCallback;
import org.apache.samza.task.MessageCollector;
import org.apache.samza.task.TaskCoordinator;


/**
 * This is a default NOOP operator callback object that does nothing before and after the process method
 */
public final class NoopOperatorCallback implements OperatorCallback {

  private static NoopOperatorCallback singletonInstance = null;

  @Override
  public Tuple beforeProcess(Tuple tuple, MessageCollector collector, TaskCoordinator coordinator) {
    return tuple;
  }

  @Override
  public Relation beforeProcess(Relation rel, MessageCollector collector, TaskCoordinator coordinator) {
    return rel;
  }

  @Override
  public Tuple afterProcess(Tuple tuple, MessageCollector collector, TaskCoordinator coordinator) {
    return tuple;
  }

  @Override
  public Relation afterProcess(Relation rel, MessageCollector collector, TaskCoordinator coordinator) {
    return rel;
  }

  private NoopOperatorCallback() {
  }

  public final static NoopOperatorCallback getInstance() {
    // CAUTION: this getInstance() is not thread-safe and hence only meant to be used in single-threaded container model.
    // Please revisit if this method is used in a multi-threaded environment later.
    if (singletonInstance == null) {
      singletonInstance = new NoopOperatorCallback();
    }
    return singletonInstance;
  }

}
