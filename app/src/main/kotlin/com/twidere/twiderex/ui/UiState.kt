package com.twidere.twiderex.ui


/**
 * Immutable data class that allows for loading, data, and exception to be managed independently.
 *
 * This is useful for screens that want to show the last successful result while loading or a later
 * refresh has caused an error.
 */
data class UiState<T>(
    val loading: Boolean = false,
    val exception: Throwable? = null,
    val data: T? = null
) {
    /**
     * True if this contains an error
     */
    val hasError: Boolean
        get() = exception != null

    /**
     * True if this represents a first load
     */
    val initialLoad: Boolean
        get() = data == null && loading && !hasError
}
