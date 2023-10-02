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
package org.kie.efesto.runtimemanager.api.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class to represent a <b>original type/generated type</b> tupla
 */
public class EfestoOriginalTypeGeneratedType implements Serializable {

    private static final long serialVersionUID = 3887366581807183963L;
    private final String originalType;
    private final String generatedType;

    public EfestoOriginalTypeGeneratedType(String originalType, String generatedType) {
        this.originalType = originalType;
        this.generatedType = generatedType;
    }

    public String getOriginalType() {
        return originalType;
    }

    public String getGeneratedType() {
        return generatedType;
    }

    @Override
    public String toString() {
        return "EfestoOriginalTypeGeneratedType{" +
                "originalType='" + originalType + '\'' +
                ", generatedType='" + generatedType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EfestoOriginalTypeGeneratedType that = (EfestoOriginalTypeGeneratedType) o;
        return Objects.equals(originalType, that.originalType) &&
                Objects.equals(generatedType, that.generatedType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalType, generatedType);
    }
}