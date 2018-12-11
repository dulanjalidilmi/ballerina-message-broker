/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package io.ballerina.messaging.broker.common;

import java.util.Map;

/**
 * Interface used by event publishers.
 */
public interface EventSync {
    /**
     * Used to publish the triggered event data to the necessary medium.
     *
     * @param id ID to identify the Event Type
     * @param properties include properties of the Event
     */
    void publish(String id, Map<String, String> properties);

    /**
     * Used to activate the publisher.
     */
    void activate();

    /**
     * Used to deactivate the publisher.
     */
    void deactivate();
}
