/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pivot.wtk;

import org.apache.pivot.util.ListenerList;
import org.apache.pivot.wtk.text.Document;

/**
 * Text pane listener interface.
 */
public interface TextPaneListener {
    /**
     * Text pane listeners.
     */
    public static class Listeners extends ListenerList<TextPaneListener> implements TextPaneListener {
        @Override
        public void documentChanged(TextPane textPane, Document previousText) {
            forEach(listener -> listener.documentChanged(textPane, previousText));
        }

        @Override
        public void editableChanged(TextPane textPane) {
            forEach(listener -> listener.editableChanged(textPane));
        }
    }

    /**
     * Text pane listener adapter.
     * @deprecated Since 2.1 and Java 8 the interface itself has default implementations.
     */
    @Deprecated
    public static class Adapter implements TextPaneListener {
        @Override
        public void documentChanged(TextPane textPane, Document previousDocument) {
            // empty block
        }

        @Override
        public void editableChanged(TextPane textPane) {
            // empty block
        }
    }

    /**
     * Called when a text pane's document has changed.
     *
     * @param textPane         The text pane that changed.
     * @param previousDocument What the document used to be.
     */
    default void documentChanged(TextPane textPane, Document previousDocument) {
    }

    /**
     * Called when a text pane's editable state has changed.
     *
     * @param textPane The source of this event.
     */
    default void editableChanged(TextPane textPane) {
    }
}
