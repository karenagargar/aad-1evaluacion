package edu.iesam.aad_1evaluacion.core.cache

import android.content.Context
import edu.iesam.aad_1evaluacion.R

interface AppCache {
    fun isExpired(key: String, ttl: Long): Boolean
    fun save(key: String)
}

class CacheTTL(private val context: Context) : AppCache {

    private val sharedPrefCache = context.getSharedPreferences(
        context.getString(R.string.local_data_cache),
        Context.MODE_PRIVATE
    )

    override fun isExpired(key: String, ttl: Long): Boolean {
        val timeSaved = sharedPrefCache.getLong(key, 0L)
        val now = System.currentTimeMillis()
        return (now - timeSaved > ttl)
    }

    override fun save(key: String) {
        sharedPrefCache.edit().putLong(key, System.currentTimeMillis()).apply()
    }
}