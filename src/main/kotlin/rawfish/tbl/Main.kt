package rawfish.tbl

import org.hjson.Stringify
import java.io.File

/**
 * 遍历工作区，从工作区中定义的结构找到所有可能是荒野乱斗翻译键的结构，对每个语言输出结果。
 * 所有荒野乱斗翻译键都以"TID"开始。
 */
fun main() {
    Language.entries.forEach { language ->
        brawlers.forEach { c ->
            c.constructors.first().call().run {
                val result = seri(language).toString(Stringify.HJSON)
                translateOutDirs.forEach { dir ->
                    File("${dir}/Brawlers/${brawlerID}/${language.tFile}").let {
                        it.parentFile.mkdirs()
                        it.createNewFile()
                        it.writeText(result)
                    }
                }
            }
        }
    }
}