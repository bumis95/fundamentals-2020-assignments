package com.android.fundamentals.workshop03

import android.content.Context
import com.android.fundamentals.domain.location.Location
import com.android.fundamentals.domain.location.LocationRepository
import com.android.fundamentals.workshop02_03.NewLocationRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

class Ws03LocationsRepository(applicationContext: Context) : LocationRepository {

    private val random = Random(10)

    private val locationsDb = Ws03DataBase.create(applicationContext)

    override suspend fun getAllLocations(): List<Location> =
        withContext(Dispatchers.IO) {
            locationsDb.locationsDao.getAll().map { toLocation(it) }
        }

    override suspend fun addNewAndGetUpdated(): List<Location> =
        withContext(Dispatchers.IO) {
            val newLocationRequest = generateNewLocationRequest()
            locationsDb.locationsDao.insert(toEntity(newLocationRequest))
            getAllLocations()
        }

    override suspend fun deleteByIdAndGetUpdated(id: Long): List<Location> =
        withContext(Dispatchers.IO) {
            locationsDb.locationsDao.deleteById(id)
            getAllLocations()
        }

    private fun toEntity(location: NewLocationRequest) = Ws03LocationEntity(
        title = location.title,
        lat = location.latitude,
        lon = location.longitude
    )

    private fun toLocation(entity: Ws03LocationEntity) = Location(
        id = entity.id,
        title = "${entity.title}, id:${entity.id}",
        latitude = entity.lat,
        longitude = entity.lon
    )

    private suspend fun generateNewLocationRequest() = withContext(Dispatchers.Default) {
        delay(DELAY_MILLIS)
        NewLocationRequest(
            title = "Title ${random.nextInt()}",
            latitude = random.nextDouble(180.0),
            longitude = random.nextDouble(180.0)
        )
    }

    companion object {
        private const val DELAY_MILLIS: Long = 1_000
    }
}