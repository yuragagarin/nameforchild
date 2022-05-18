package ru.ernestoguevara.nameforchild.data.repositories

import ru.ernestoguevara.nameforchild.data.repositories.local.ZodiacSignDao
import ru.ernestoguevara.nameforchild.data.entities.ZodiacSignEntity
import javax.inject.Inject

class ZodiacSignRepository @Inject constructor(private val dao: ZodiacSignDao) {

    fun getAll() : List<ZodiacSignEntity> {
        return dao.getOrdByValue()
    }

    fun add(item: ZodiacSignEntity) {
        dao.insert(item)
    }

    fun getByValue(value: String) : ZodiacSignEntity {
        return dao.getByValue(value)
    }

}