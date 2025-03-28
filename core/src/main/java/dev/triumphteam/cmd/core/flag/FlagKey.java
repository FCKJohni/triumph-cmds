/**
 * MIT License
 *
 * Copyright (c) 2019-2021 Matt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dev.triumphteam.cmd.core.flag;

import dev.triumphteam.cmd.core.registry.RegistryKey;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class FlagKey extends RegistryKey {

    // Holds all registered keys, default and custom ones
    private static final Set<FlagKey> REGISTERED_KEYS = new HashSet<>();

    private FlagKey(@NotNull final String key) {
        super(key);
        REGISTERED_KEYS.add(this);
    }

    /**
     * Factory method for creating a {@link FlagKey}.
     *
     * @param key The value of the key, normally separated by <code>.</code>.
     * @return A new {@link FlagKey}.
     */
    @NotNull
    @Contract("_ -> new")
    public static FlagKey of(@NotNull final String key) {
        return new FlagKey(key);
    }

    /**
     * Gets an immutable {@link Set} with all the registered keys.
     *
     * @return The keys {@link Set}.
     */
    @NotNull
    public static Set<FlagKey> getRegisteredKeys() {
        return Collections.unmodifiableSet(REGISTERED_KEYS);
    }

    @Override
    public String toString() {
        return "FlagKey{super=" + super.toString() + "}";
    }
}
