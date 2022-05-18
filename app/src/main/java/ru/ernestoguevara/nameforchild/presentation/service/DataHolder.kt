package ru.ernestoguevara.nameforchild.presentation.service

import ru.ernestoguevara.nameforchild.data.entities.NameWithNameDescrsAndZodiacSignsEntity
import ru.ernestoguevara.nameforchild.data.mappers.NameMapper
import ru.ernestoguevara.nameforchild.repositories.NameRepository
import javax.inject.Inject

class DataHolder @Inject constructor(private val repo: NameRepository, private val mapper: NameMapper) {

    fun exists(value: String): Boolean {
        return repo.existsByName(value);
    }

    fun add(item: NameWithNameDescrsAndZodiacSignsEntity) {
        repo.add(mapper.to(item))
    }

}