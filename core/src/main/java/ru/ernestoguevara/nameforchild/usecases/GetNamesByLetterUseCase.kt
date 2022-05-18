package ru.ernestoguevara.nameforchild.usecases

import io.reactivex.Single
import ru.ernestoguevara.nameforchild.entities.Name
import ru.ernestoguevara.nameforchild.repositories.NameRepository

class GetNamesByLetterUseCase(private val nameRepository: NameRepository) {
    fun invoke(value: String): Single<List<Name>> = nameRepository.getByLetterAsync(value)
}