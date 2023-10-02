/**
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
package org.kie.dmn.feel.runtime.functions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;
import org.kie.dmn.feel.runtime.events.InvalidParametersEvent;

public class MonthOfYearTest {

    private MonthOfYearFunction fut;

    @Before
    public void setUp() {
        fut = MonthOfYearFunction.INSTANCE;
    }

    @Test
    public void testMonthOfYearFunctionTemporalAccessor() {
        FunctionTestUtil.assertResult(fut.invoke(LocalDate.of(2019, 9, 17)), "September");
        FunctionTestUtil.assertResult(fut.invoke(LocalDateTime.of(2019, 9, 17, 0, 0, 0)), "September");
        FunctionTestUtil.assertResult(fut.invoke(OffsetDateTime.of(2019, 9, 17, 0, 0, 0, 0, ZoneOffset.UTC)), "September");
        FunctionTestUtil.assertResult(fut.invoke(ZonedDateTime.of(2019, 9, 17, 0, 0, 0, 0, ZoneOffset.UTC)), "September");
        FunctionTestUtil.assertResultError(fut.invoke(null), InvalidParametersEvent.class);
    }
}
