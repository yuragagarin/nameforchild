package ru.ernestoguevara.nameforchild.presentation.service

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import ru.ernestoguevara.nameforchild.data.DataConfig
import ru.ernestoguevara.nameforchild.data.entities.NameEntity
import ru.ernestoguevara.nameforchild.data.entities.NameDescrEntity
import ru.ernestoguevara.nameforchild.data.entities.NameWithNameDescrsAndZodiacSignsEntity
import ru.ernestoguevara.nameforchild.data.entities.ZodiacSignEntity
import ru.ernestoguevara.nameforchild.data.repositories.ZodiacSignRepository
import ru.ernestoguevara.nameforchild.entities.NameSrcLink
import java.io.IOException
import java.util.*
import javax.inject.Inject


class DataProvider @Inject constructor(private val repoZodiacSign: ZodiacSignRepository) {

    //private val pathList = "https://detstrana.ru/service/names"

    fun loadCatalogs() {
        var zodiacSigins = repoZodiacSign?.getAll()

        if(zodiacSigins?.size == 0) {
            repoZodiacSign?.add(ZodiacSignEntity("Козерог"))
            repoZodiacSign?.add(ZodiacSignEntity("Водолей"))
            repoZodiacSign?.add(ZodiacSignEntity("Рыбы"))
            repoZodiacSign?.add(ZodiacSignEntity("Овен"))
            repoZodiacSign?.add(ZodiacSignEntity("Телец"))
            repoZodiacSign?.add(ZodiacSignEntity("Близнецы"))
            repoZodiacSign?.add(ZodiacSignEntity("Рак"))
            repoZodiacSign?.add(ZodiacSignEntity("Лев"))
            repoZodiacSign?.add(ZodiacSignEntity("Дева"))
            repoZodiacSign?.add(ZodiacSignEntity("Весы"))
            repoZodiacSign?.add(ZodiacSignEntity("Скорпион"))
            repoZodiacSign?.add(ZodiacSignEntity("Стрелец"))
        }
    }

    fun loadList(path: String, sex: String): List<NameSrcLink> {

        var res = ArrayList<NameSrcLink>()

        try {
            var doc = Jsoup.connect(path).get()
            var srcLinks = doc.select(".service_names_list_td_link a:lt(2)")
            srcLinks.forEach {
                res.add(NameSrcLink(it.text(), it.attr("href"), sex))
            }
        } catch (e: IOException) {
            throw IOException("Ошибка загрузки списка имён")
        }

        return res;

    }

    fun loadOne(item: NameSrcLink): /*NameWithNameDescrs?*/ NameWithNameDescrsAndZodiacSignsEntity {

        var res: NameWithNameDescrsAndZodiacSignsEntity?

        var doc = Jsoup.connect(DataConfig.BASE_PATH + item.url).get()

        val descrList = doc.select(".margin_top_24 p").filter { it.text() != "" }
            .map { r -> NameDescrEntity(r.text()) }

        var zodiacSignList = doc.select(".margin_top_12 .margin_top_12 div").map { r -> repoZodiacSign.getByValue(
            r.text()
        )
        }

        var name = NameEntity(
            item.name!!,
            doc.select(".margin_top_8 div:eq(1) span span").text(),
            doc.select(".margin_top_8 div:eq(0) span a").text(),
            retrieveParamByName(doc, "Именины"),
            retrieveParamByName(doc, "Производные имени"),
            retrieveParamByName(doc, "Талисман"),
            retrieveParamByName(doc, "Совместим с именем"),
            item.sex
        )

        res = NameWithNameDescrsAndZodiacSignsEntity(name, descrList, zodiacSignList)

        return res

    }

    fun retrieveParamByName(doc: Document, paramName: String) : String? {

        var fieldNames = doc.select(".padding_top_18 div:eq(0) span")
        var index = fieldNames.withIndex().filter{ (i, value) -> value.text().contains(paramName) }.map { (i, value) -> i }.firstOrNull()

        if (index == null)
            return null

        return doc.select("div.padding_top_18").get(index!!).select(".padding_top_4 span").text()

    }



}