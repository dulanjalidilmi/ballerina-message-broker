
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
package io.ballerina.messaging.broker.core.selector;

import io.ballerina.messaging.broker.core.Metadata;
/**
 * Implementation of a boolean expression.This class is doing a less than comparison between left and right values
 *  provided and evaluate to a boolean value.
 */

public class LessThanExpression implements BooleanExpression {

    private final Expression<Metadata> left;
    private final Expression<Metadata> right;

    public LessThanExpression (Expression left , Expression right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean evaluate (Metadata metadata) {
        Object leftValue = left.evaluate(metadata);
        Object rightValue = right.evaluate(metadata);
        if (leftValue instanceof Number && rightValue instanceof Number) {
            Class lv = leftValue.getClass();
            if ((lv == Integer.class) || (lv == Long.class)) {
                if (rightValue instanceof Long) {
                    long l = ((Number) leftValue).longValue();
                    long l1 = ((Number) rightValue).longValue();
                    return l < l1;
                }
            }
            if ((leftValue instanceof Double) || (rightValue instanceof Double)) {
                Double l = ((Number) leftValue).doubleValue();
                Double l1 = ((Number) rightValue).doubleValue();
                return l < l1;
            }
        }
            return false;
    }
}


