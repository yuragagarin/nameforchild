package ru.ernestoguevara.nameforchild.repositories

import io.reactivex.Single
import ru.ernestoguevara.nameforchild.entities.Name
import ru.ernestoguevara.nameforchild.entities.NamePopular

interface NameRepository {
    fun getByIdAsync(value: Long) : Single<Name>
    fun existsByName(value: String) : Boolean
    fun add(item: Name)
    fun getByLetterAsync(value: String) : Single<List<Name>>
    fun getByZodiacSignAsync(value: String) : Single<List<Name>>
    fun getBySourceAsync(value: String) : Single<List<Name>>
    fun getNamePopularByNameAsync(value: String, sex: String) : Single<List<NamePopular>>
}