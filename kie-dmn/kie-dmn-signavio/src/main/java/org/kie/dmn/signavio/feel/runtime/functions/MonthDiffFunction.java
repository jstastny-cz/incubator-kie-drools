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
package org.kie.dmn.signavio.feel.runtime.functions;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAccessor;

import org.kie.dmn.api.feel.runtime.events.FEELEvent.Severity;
import org.kie.dmn.feel.runtime.events.InvalidParametersEvent;
import org.kie.dmn.feel.runtime.functions.BaseFEELFunction;
import org.kie.dmn.feel.runtime.functions.BuiltInFunctions;
import org.kie.dmn.feel.runtime.functions.DateAndTimeFunction;
import org.kie.dmn.feel.runtime.functions.FEELFnResult;
import org.kie.dmn.feel.runtime.functions.ParameterName;
import org.kie.dmn.feel.util.EvalHelper;

public class MonthDiffFunction
        extends BaseFEELFunction {

    public MonthDiffFunction() {
        super( "monthDiff" );
    }

    public FEELFnResult<BigDecimal> invoke(@ParameterName("datetime1") TemporalAccessor datetime1, @ParameterName("datetime2") TemporalAccessor datetime2) {
        if ( datetime1 == null ) {
            return FEELFnResult.ofError( new InvalidParametersEvent( Severity.ERROR, "datetime1", "cannot be null" ) );
        }
        if ( datetime2 == null ) {
            return FEELFnResult.ofError( new InvalidParametersEvent( Severity.ERROR, "datetime2", "cannot be null" ) );
        }

        try {
            return FEELFnResult.ofResult( EvalHelper.getBigDecimalOrNull( Period.between( LocalDate.from( datetime1 ), LocalDate.from( datetime2 ) ).toTotalMonths() ) );
        } catch ( DateTimeException e ) {
            return FEELFnResult.ofError( new InvalidParametersEvent( Severity.ERROR, "datetime", "invalid 'date' or 'date and time' parameter", e ) );
        }
    }

    public FEELFnResult<BigDecimal> invoke(@ParameterName("datetime1") String datetime1, @ParameterName("datetime2") String datetime2) {
        if ( datetime1 == null ) {
            return FEELFnResult.ofError( new InvalidParametersEvent( Severity.ERROR, "datetime1", "cannot be null" ) );
        }
        if ( datetime2 == null ) {
            return FEELFnResult.ofError( new InvalidParametersEvent( Severity.ERROR, "datetime2", "cannot be null" ) );
        }

        try {
            TemporalAccessor dt1 =  BuiltInFunctions.getFunction( DateAndTimeFunction.class ).invoke( datetime1 ).getOrElseThrow(e-> new IllegalArgumentException("Invalid parameter datetime1", e.getSourceException()));
            TemporalAccessor dt2 =  BuiltInFunctions.getFunction( DateAndTimeFunction.class ).invoke( datetime2 ).getOrElseThrow(e-> new IllegalArgumentException("Invalid parameter datetime2", e.getSourceException()));
            return invoke( dt1, dt2 );
        } catch ( Exception e ) {
            return FEELFnResult.ofError( new InvalidParametersEvent( Severity.ERROR, "datetime", "invalid 'date' or 'date and time' parameter", e ) );
        }
    }

}
