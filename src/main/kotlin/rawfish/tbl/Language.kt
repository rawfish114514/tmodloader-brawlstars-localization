package rawfish.tbl

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.File

enum class Language(
    val code: String,
    var bFile: String = "",
    extTranslate: Map<String, String> = mapOf()
) {
    English("en-US", "texts", extTranslateUs),
    German("de-DE", "de", extTranslateUs),
    Italian("it-IT", "it", extTranslateUs),
    French("fr-FR", "fr", extTranslateUs),
    Spanish("es-ES", "es", extTranslateUs),
    Russian("ru-RU", "ru", extTranslateUs),
    SimplifiedChinese("zh-Hans", "cn", extTranslateCn),
    BrazilianPortuguese("pt-BR", "pt", extTranslateUs),
    Polish("pl-PL", "pl", extTranslateUs),
    ;

    var tFile: String = ""
    val translate: Map<String, String>

    init {
        bFile += ".csv"
        tFile = code + "_Mods.brawlstars.Brawlers.hjson"
        val fileTranslate = csvReader().readAll(
            File(brawlstarsLocalizationDir, bFile).readText().replace("\u00a0", "")
        ).associate { record ->
            record[0] to record[1]
        }
        val t = mutableMapOf<String, String>()
        t.putAll(fileTranslate)
        t.putAll(extTranslate)
        translate = t
    }

    operator fun get(key: String) = translate[key] ?: key
}

val extTranslateCn = mapOf(
    "EXT_POSSESSIVE_CASE" to "%s的%s",
    "EXT_TIME" to "{0}秒"
)

val extTranslateUs = mapOf(
    "EXT_POSSESSIVE_CASE" to "%s's %s",
    "EXT_TIME" to "{0}s"
)
