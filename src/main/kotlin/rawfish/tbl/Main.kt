package rawfish.tbl

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.hjson.JsonObject
import org.hjson.JsonValue
import org.hjson.Stringify
import java.io.File

/**
 * 遍历工作区，从工作区中定义的结构找到所有可能是荒野乱斗翻译键的结构，对每个语言输出结果。
 * 所有荒野乱斗翻译键都以"TID"开始。
 */
fun main() {
    var bTranslateMap: Map<Language, Map<String, String>> = languages.associateWith {
        csvReader().readAll(File(brawlstarsLocalizationDir, it.bFile)).associate { record ->
            record[0] to record[1]
        }
    }

    fun JsonObject.visitTidStruct(visitor: JsonObject.(name: String, value: String, replace: Map<String, String>) -> Unit) {
        if (isObject) {
            asObject().apply {
                forEach {
                    if (it.value.isString) {

                        var str = it.value.asString()
                        if (str.startsWith("TID")) {
                            // TID值
                            visitor(it.name, str, mapOf())
                            return@forEach
                        }
                    }
                    if (it.value.isArray) {
                        var arr = it.value.asArray()
                        if (arr[0].isString) {
                            var str = arr[0].asString()
                            if (str.startsWith("TID")) {
                                // TID结构
                                visitor(
                                    it.name, str, arr[1].asObject().associate { r ->
                                        r.name to r.value.asString()
                                    }
                                )
                                return@forEach
                            }
                        }
                    }
                    if (it.value.isObject) {
                        it.value.asObject().visitTidStruct(visitor)
                    }
                }
            }
        }
    }

    File(translateDefineDir).listFiles()?.forEach {
        val id = it.name.substringBefore(".");
        val suffix = it.name.substringAfter(".");
        if (suffix != "json") {
            return@forEach
        }

        val dir = File(translateOutDir, id)
        dir.mkdirs()
        languages.forEach { languages ->
            val file = File(dir, languages.tFile)
            val translate = bTranslateMap[languages]!!
            val define = JsonValue.readJSON(it.readText()).asObject()

            define.visitTidStruct { name, value, replace ->
                set(name, translate[value]?.run {
                    var v = this
                    replace.forEach { (old, new) ->
                        v = v.replace(old, new)
                    }
                    v
                } ?: "")

            }

            val content = define.toString(Stringify.HJSON)
            file.createNewFile()
            file.writeText(content)
        }

    }
}