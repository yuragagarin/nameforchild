package ru.ernestoguevara.nameforchild.data.mappers

import ru.ernestoguevara.nameforchild.data.entities.NameEntity
import ru.ernestoguevara.nameforchild.data.entities.NameWithNameDescrsAndZodiacSignsEntity
import ru.ernestoguevara.nameforchild.entities.Name
import ru.ernestoguevara.nameforchild.entities.NameDescr
import ru.ernestoguevara.nameforchild.entities.ZodiacSign

class NameMapper {

    fun toDomain(src: Name): NameWithNameDescrsAndZodiacSignsEntity {
        return NameWithNameDescrsAndZodiacSignsEntity(
            name = NameEntity(
                src.value,
                src.meaning,
                src.source,
                src.nameDay,
                src.derivedName,
                src.talisman,
                src.compatible,
                src.sex
            ),
            nameDescrs = src.descrEntities.map { ru.ernestoguevara.nameforchild.data.entities.NameDescrEntity(it.id, it.text) },
            zodiacSigns = src.zodiacSigns.map { ru.ernestoguevara.nameforchild.data.entities.ZodiacSignEntity(it.zodiacSignId, it.value) }
        )
    }

    fun to(src: NameEntity): Name {
        return Name(
            id = src.nameId,
            value = src.value,
            meaning = src.meaning,
            source = src.source,
            nameDay = src.nameDay,
            derivedName = src.derivedName,
            talisman = src.talisman,
            compatible = src.compatible,
            sex = src.sex,
            descrEntities = ArrayList<NameDescr>(),
            zodiacSigns = ArrayList<ZodiacSign>(),
        )
    }

    fun to(src: NameWithNameDescrsAndZodiacSignsEntity): Name {
        return Name(
            id = src.name.nameId,
            value = src.name.value,
            meaning = src.name.meaning,
            source = src.name.source,
            nameDay = src.name.nameDay,
            derivedName = src.name.derivedName,
            talisman = src.name.talisman,
            compatible = src.name.compatible,
            sex = src.name.sex,
            descrEntities = src.nameDescrs.map { NameDescr(it.id, it.text) },
            zodiacSigns = src.zodiacSigns.map { ZodiacSign(it.zodiacSignId, it.value) }
        )
    }

}