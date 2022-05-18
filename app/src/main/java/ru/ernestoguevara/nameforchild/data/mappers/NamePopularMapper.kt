package ru.ernestoguevara.nameforchild.data.mappers

import ru.ernestoguevara.nameforchild.data.entities.NameEntity
import ru.ernestoguevara.nameforchild.data.entities.NamePopularCellDto
import ru.ernestoguevara.nameforchild.data.entities.NameWithNameDescrsAndZodiacSignsEntity
import ru.ernestoguevara.nameforchild.entities.Name
import ru.ernestoguevara.nameforchild.entities.NameDescr
import ru.ernestoguevara.nameforchild.entities.NamePopular
import ru.ernestoguevara.nameforchild.entities.ZodiacSign

class NamePopularMapper {

    fun to(src: NamePopularCellDto) : NamePopular {
        return NamePopular(0,src.year,src.month)
    }
}