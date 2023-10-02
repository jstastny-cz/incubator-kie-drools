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
package org.drools.games.adventures.model;

import org.kie.api.definition.type.Position;

public class Location {
    @Position(0)
    private Thing thing;

    @Position(1)
    private Thing target;

    public Location(Thing thing, Thing target) {
        this.thing = thing;
        this.target = target;
    }

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    public Thing getTarget() {
        return target;
    }

    public void setTarget(Thing target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Location location = (Location) o;

        if (!target.equals(location.target)) { return false; }
        if (!thing.equals(location.thing)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        int result = thing.hashCode();
        result = 31 * result + target.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
               "target=" + target +
               ", thing=" + thing +
               '}';
    }
}
