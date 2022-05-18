package ru.ernestoguevara.nameforchild.data.repositories

import io.reactivex.Single
import ru.ernestoguevara.nameforchild.data.DataConfig
import ru.ernestoguevara.nameforchild.data.entities.NamePopularDto
import ru.ernestoguevara.nameforchild.data.repositories.local.NameDao
import ru.ernestoguevara.nameforchild.data.mappers.NameMapper
import ru.ernestoguevara.nameforchild.data.mappers.NamePopularMapper
import ru.ernestoguevara.nameforchild.data.repositories.remote.NamePopularApi
import ru.ernestoguevara.nameforchild.entities.Name
import ru.ernestoguevara.nameforchild.entities.NamePopular
import ru.ernestoguevara.nameforchild.repositories.NameRepository
import javax.inject.Inject

class NameRepositoryImpl @Inject constructor(
    private val dao: NameDao,
    private val namePopularApi: NamePopularApi,
    private val nameMapper: NameMapper,
    private val namePopularMapper: NamePopularMapper
) :
    NameRepository {
    override fun getByIdAsync(value: Long): Single<Name> {
        return Single.create {
            it.onSuccess(nameMapper.to(dao.getById(value)))
        }
    }

    override fun existsByName(value: String): Boolean {
        return dao.getByName(value).size > 0
    }

    override fun add(item: Name) {
        dao.insert(nameMapper.toDomain(item))
    }

    override fun getByLetterAsync(value: String): Single<List<Name>> {
        return Single.create { emitter ->
            emitter.onSuccess(dao.getByFirstLetter(value).map {
                nameMapper.to(it)
            })
        }
    }

    override fun getByZodiacSignAsync(value: String): Single<List<Name>> {
        return Single.create { emitter ->
            emitter.onSuccess(dao.getByZodiacSign(value).map {
                nameMapper.to(it)
            })
        }
    }

    override fun getBySourceAsync(value: String): Single<List<Name>> {
        return Single.create { emitter ->
            emitter.onSuccess(dao.getBySource(value).map {
                nameMapper.to(it)
            })
        }
    }

    override fun getNamePopularByNameAsync(value: String, sex: String): Single<List<NamePopular>> {
        return Single.create { emitter ->
            val hashMap = HashMap<String,String>().apply {
                put("\$filter","Cells/Name eq '$value'")
                put("api_key","${DataConfig.POPULAR_API_KEY}")
            }

            emitter.onSuccess(getNamePopularByNameForBoyOrGirlAsync(hashMap,sex).cells.map {
                namePopularMapper.to(it)
            })
        }
    }

    private fun getNamePopularByNameForBoyOrGirlAsync(src: HashMap<String,String>, sex: String) : NamePopularDto {
        if(sex == "m")
            return namePopularApi.getBoyNamePopular(src)
        else return namePopularApi.getGirlNamePopular(src)
    }
}