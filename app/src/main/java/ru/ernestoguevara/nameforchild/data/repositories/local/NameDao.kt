package ru.ernestoguevara.nameforchild.data.repositories.local


import androidx.room.*
import ru.ernestoguevara.nameforchild.data.entities.NameEntity
import ru.ernestoguevara.nameforchild.data.entities.NameDescrEntity
import ru.ernestoguevara.nameforchild.data.entities.NameWithNameDescrsAndZodiacSignsEntity
import ru.ernestoguevara.nameforchild.data.entities.NameZodiacSignCrossEntity

@Dao
interface NameDao {

    @Transaction
    @Query("select * from names where nameId = :value")
    fun getById(value:Long): NameWithNameDescrsAndZodiacSignsEntity

    @Transaction
    @Query("select * from names where value = :value")
    fun getByName(value: String): List<NameWithNameDescrsAndZodiacSignsEntity>

    @Transaction
    fun insert(item: NameWithNameDescrsAndZodiacSignsEntity) {
        var nameId = insert(item.name)
        item.nameDescrs.forEach {
            it.refNameId = nameId
            insert(it)
        }
        item.zodiacSigns.forEach {
            var newItem = NameZodiacSignCrossEntity(nameId,it.zodiacSignId)
            insert(newItem)
        }
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: NameZodiacSignCrossEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: NameEntity) : Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: NameDescrEntity)

    @Transaction
    @Query("select * from names")
    fun getAll() : List<NameWithNameDescrsAndZodiacSignsEntity>

    @Query("select * from names where upper(substr(value,1,1)) = :value order by value")
    fun getByFirstLetter(value: String) : List<NameEntity>

    @Query("select n.* from names n \n" +
            "join name_zodiac_sign_cross nzsc on n.nameId = nzsc.nameId\n" +
            "join zodiac_signs zs on zs.zodiacSignId = nzsc.zodiacSignId\n" +
            "where zs.value = :value\n" +
            "order by n.value")
    fun getByZodiacSign(value: String) : List<NameEntity>

    @Query("select * from names where source = :value order by value")
    fun getBySource(value: String) : List<NameEntity>

    @Delete
    fun delete(item: NameEntity)

}